package com.utf.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import com.utf.constant.FrameworkConstant;
import com.utf.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<Map<String, String>> list = ExcelUtils.getExcelDetails(
            FrameworkConstant.getAutomationExerciseSheet());
        List<IMethodInstance> result = new ArrayList<>();

        for (int i = 0; i < methods.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                String testname = list.get(j).get("testname");
                String execute = list.get(j).get("execute");
                if (testname != null
                        && execute != null
                        && methods.get(i).getMethod().getMethodName()
                            .equalsIgnoreCase(testname)
                        && execute.equalsIgnoreCase("yes")) {
                    result.add(methods.get(i));
                }
            }
        }
        return result;
    }
}
package com.utf.utils;

import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;
import com.utf.constant.FrameworkConstant;
import java.lang.reflect.Method;

public final class DataProviderUtils {

	private DataProviderUtils() {
	}

	@DataProvider(parallel = false)
	public static Object[][] getData(Method method) throws Exception {
		String testMethodName = method.getName();

		List<Map<String, String>> list = ExcelUtils.getTestData(FrameworkConstant.getExcelFile(),
				FrameworkConstant.getAutomationExerciseSheet(), testMethodName);
		Object[][] data = new Object[list.size()][1];
		for (int i = 0; i < list.size(); i++) {
			data[i][0] = list.get(i);
		}
		return data;
	}
}
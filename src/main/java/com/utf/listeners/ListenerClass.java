package com.utf.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.utf.annotation.FrameworkAnnotation;
import com.utf.reports.ExtentLogger;
import com.utf.reports.ExtentManager;
import com.utf.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Use method name if description is empty
        String testName = result.getMethod().getDescription();
        if (testName == null || testName.isEmpty()) {
            testName = result.getMethod().getMethodName();
        }
        ExtentReport.createTest(testName);

        FrameworkAnnotation annotation = result.getMethod()
            .getConstructorOrMethod()
            .getMethod()
            .getAnnotation(FrameworkAnnotation.class);

        if (annotation != null) {
            ExtentReport.addAuthors(annotation.authors());
            ExtentReport.addCategories(annotation.categories());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            if (ExtentManager.getExtendTest() != null) {
                ExtentLogger.pass(result.getMethod().getMethodName()
                    + " is passed", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            if (ExtentManager.getExtendTest() != null) {
                ExtentLogger.fail(result.getMethod().getMethodName()
                    + " is failed", true);
                ExtentLogger.fail(result.getThrowable().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (ExtentManager.getExtendTest() != null) {
            ExtentLogger.skip(result.getMethod().getMethodName()
                + " is skipped");
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
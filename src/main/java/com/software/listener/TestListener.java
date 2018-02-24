package com.software.listener;

import lombok.extern.slf4j.Slf4j;
import org.testng.*;

import java.time.LocalDate;

// @Slf4j - logger
@Slf4j
public class TestListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod() && testResult.getStatus() == ITestResult.FAILURE) {
            takeScreenshot();
        }
    }

    private void takeScreenshot() {
       // String.format("Taking screen shot %s - %s", "data", LocalDate.now());
        log.info("Taking screen shot !!! {} - {}", "data", LocalDate.now());
    }

}

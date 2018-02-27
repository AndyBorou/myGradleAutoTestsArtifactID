package com.software.listener;

import com.software.dataWork.DataReader;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.testng.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.software.utils.ServiceLoaderUtils.load;
import static java.lang.ClassLoader.getSystemClassLoader;

import static org.apache.commons.io.FilenameUtils.getExtension;


// @Slf4j - logger
@Slf4j
public class TestListener implements IInvokedMethodListener, ISuiteListener {

    private static final List<DataReader> READERS = new ArrayList<>();

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

    @Override
    public void onStart(ISuite suite) {
        READERS.addAll(load(DataReader.class, getSystemClassLoader()));
    }

    @Override
    public void onFinish(ISuite suite) {
        READERS.clear();
    }

    public static DataReader readerOf(final String source){
        return StreamEx.of(READERS)
                .findFirst(dataReader -> dataReader.getDataType().equals(getExtension(source)))
                .orElseThrow(() -> new IllegalArgumentException("can read"));


    }
}

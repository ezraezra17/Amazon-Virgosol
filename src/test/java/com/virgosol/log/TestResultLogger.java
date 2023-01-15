package com.virgosol.log;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestResultLogger implements TestWatcher {
    Log log = new Log();

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
       String testName = context.getDisplayName();
       log.info(testName+ "DISABLED");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName= context.getDisplayName();
        log.info(testName + " PASSED");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

        String testName = context.getDisplayName();
        String testAbortedCause = cause.getMessage();
        log.info(testName+ " ABORTED with cause :"+ testAbortedCause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
       String testName = context.getDisplayName();
       String testFailCause = cause.getMessage();
       log.error(testName+ " FAILED with cause : "+testFailCause);
    }
}

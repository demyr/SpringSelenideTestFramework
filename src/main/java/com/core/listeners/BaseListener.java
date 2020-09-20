package com.core.listeners;


import org.testng.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class BaseListener extends TestListenerAdapter implements IInvokedMethodListener, IRetryAnalyzer {

    // how many times to retry each individual test, 0 means no retry
    // 1 means a test will be retried 1 time in case of a failure (2 runs total)
    private static final int MAX_RETRIES_PER_TEST = 1;

    private static final HashMap<Integer, Integer> retryMap = new HashMap<>();


    @Override
    public boolean retry(ITestResult tr) {
        if (tr.getThrowable() == null)
            return false;

        var id = getId(tr);
        int testRetriesLeft;

        if (!retryMap.containsKey(id))
            retryMap.put(id, MAX_RETRIES_PER_TEST);

        if ((testRetriesLeft = retryMap.get(id)) > 0) {
            retryMap.put(id, --testRetriesLeft);
            return true;
        } else
            return false;
    }

    @Override
    public synchronized void onFinish(ITestContext testContext) {
        super.onFinish(testContext);

        // List of test results which we will delete later
        var testsToBeRemoved = new ArrayList<>();

        // collect all id's from passed test
        var passedTestIds = testContext.getPassedTests()
                .getAllResults().stream().map(this::getId).collect(Collectors.toSet());

        var failedTestIds = new HashSet<>();
        for (var failedTest : testContext.getFailedTests().getAllResults()) {
            int failedTestId = getId(failedTest);

            // if we saw this test as a failed test before we mark as to be deleted
            // or delete this failed test if there is at least one passed version
            if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId)) {
                testsToBeRemoved.add(failedTest);
            } else {
                failedTestIds.add(failedTestId);
            }
        }

        // finally delete all tests that are marked
        testContext.getFailedTests().getAllResults().removeIf(testsToBeRemoved::contains);
    }

    private int getId(ITestResult result) {
        var id = result.getTestClass().getName().hashCode();
        id = 31 * id + result.getMethod().getMethodName().hashCode();
        id = 31 * id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
        return id;
    }
}

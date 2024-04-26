package base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.ArrayList;

public class RetryTest implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 1;

    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            Page.linksFromList = new ArrayList<>();
            Page.CarsWithUrl = new ArrayList<>();
            System.out.println("!!! RETRY TEST !!!");
            return true;
        }
        return false;
    }
}
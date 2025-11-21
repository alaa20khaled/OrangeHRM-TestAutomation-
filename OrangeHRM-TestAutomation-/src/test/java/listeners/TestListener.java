package listeners;

import Base.BaseTests;
import io.qameta.allure.*;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;

import java.awt.event.ItemListener;

public class TestListener extends BaseTests implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        ScreenshotUtil.takeScreenshot(driver, testName);
        System.out.println("Screenshot taken for: " + testName);
    }
}
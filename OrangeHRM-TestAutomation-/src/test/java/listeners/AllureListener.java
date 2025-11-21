package listeners;

import Base.BaseTests;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import java.awt.event.ItemListener;

public class AllureListener extends BaseTests implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
        saveScreenshot(driver);
    }
    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshot(org.openqa.selenium.WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

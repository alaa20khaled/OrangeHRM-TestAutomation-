package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver,String testName){
        try {
            File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String path="srceenshots"+testName+".png";
            File dest=new File(path);
            dest.getParentFile().mkdirs();  // create folder if not exists
            Files.copy(src.toPath(), dest.toPath());
            return path;
        } catch (Exception e) {
            return "Failed to capture screenshot!";
        }
    }
}

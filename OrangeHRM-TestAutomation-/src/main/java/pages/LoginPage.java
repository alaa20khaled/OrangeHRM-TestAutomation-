package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton   = By.xpath("//button[@type='submit']");
    private By errorPasswordResult=By.xpath("//p[text()='Invalid credentials']");
    private By SuccessfulLogin=By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]");
    private By wrongUserNameResult=By.xpath("//p[text()='Invalid credentials']");

    public void enterUserName(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public String errorMessageWrongPassword(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorPasswordResult)).getText();

    }
    public String isDashboardDisplayed(){

       return wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessfulLogin)).getText();

    }
    public String errorMessageWrongUserName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(wrongUserNameResult)).getText();
    }

}


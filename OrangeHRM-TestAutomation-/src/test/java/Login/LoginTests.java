package Login;

import Base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
    LoginPage loginPage;

    @Test
    public void TestValidLogin(){
    loginPage   =new LoginPage(driver);
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        //boolean isDashboardDisplay=driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
       // assertTrue(isDashboardDisplay,"Dashboard not displayed" );
        assertEquals(loginPage.isDashboardDisplayed(),"Dashboard","Dashboard not displayed" );
    }
    @Test
    public void TestLoginWithInValidPassword(){
        loginPage=new LoginPage(driver);
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin1");
        loginPage.clickLogin();

        assertEquals(loginPage.errorMessageWrongPassword(),"Invalid credentials"
                ,"error message not displayed for wrong password");

    }
    @Test
    public void TestLoginWithInValidUserName(){
        loginPage=new LoginPage(driver);
        loginPage.enterUserName("admn");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        assertEquals(loginPage.errorMessageWrongUserName(),"Invalid credentials"
                ,"error message not displayed for wrong userName");
    }
}




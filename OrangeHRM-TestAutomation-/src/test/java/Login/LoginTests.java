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
    }
    @Test
    public void TestLoginWithInValidPassword(){
        loginPage=new LoginPage(driver);
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("Admin123");
        loginPage.clickLogin();

    }
}




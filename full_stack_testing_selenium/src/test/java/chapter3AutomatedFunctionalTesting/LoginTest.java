package chapter3AutomatedFunctionalTesting;

import chapter3AutomatedFunctionalTesting.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// Selenium Test Exercise
public class LoginTest extends chapter3Setup {
    HomePage homePage;
    LoginPage loginPage;
    @BeforeClass
    public void beforeClass(){
        homePage = new HomePage(driver.get(), webDriverWait.get());
        loginPage = new LoginPage(driver.get(), webDriverWait.get());
    }

    @AfterMethod
    public void afterMethod(){
        try {
            homePage.goToLoginSignupPageUsingLogOutLink();
        }catch (Exception e){
            System.out.println(" User Is Already Logged out");
        }
        driver.get().get(URL);
    }

    @Test
    public void loginSuccess(){
        loginPage = homePage.goToLoginPageUsingLoginLink();
        homePage = loginPage.loginSuccessGoHome();
        // Check on the login status.
        Assert.assertEquals(homePage.getTheLogOutLinkText(), "Logout");
    }

    @Test
    public void loginFailed(){
        loginPage = homePage.goToLoginPageUsingLoginLink();
        String logInFailedText = loginPage.loginFailedShowFailedText();
        // Check the failed login status.
        Assert.assertEquals(logInFailedText, "Your email or password is incorrect!");
    }

}

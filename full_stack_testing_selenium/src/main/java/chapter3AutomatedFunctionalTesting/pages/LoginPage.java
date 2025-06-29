package chapter3AutomatedFunctionalTesting.pages;

import chapter3AutomatedFunctionalTesting.utilities.TestData;
import chapter3AutomatedFunctionalTesting.utilities.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    // WebDriver
    private final WebDriver driver;
    private final WebDriverWait webDriverWait;

    public LoginPage(WebDriver driver, WebDriverWait webDriverWait){
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    public HomePage loginSuccessGoHome(){
        // login with valid data
        loginWithEmailAndPassword(TestData.EMAIL_TEST, TestData.PASSWORD_TEST);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(WebElements.LOGOUT_LINK));

        // Go to homePage
        return new HomePage(driver, webDriverWait);
    }

    public String loginFailedShowFailedText(){
        // login with invalid data
        loginWithEmailAndPassword(TestData.INVALID_EMAIL_TEST, TestData.INVALID_PASSWORD_TEST);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(WebElements.LOGIN_FAILED_TEXT));

        // Check the text of the invalid login case
        return driver.findElement(WebElements.LOGIN_FAILED_TEXT).getText();
    }

    private void loginWithEmailAndPassword(String email, String password){
        // Wait until the login link appear ( explicit waiting)
        webDriverWait.until(ExpectedConditions.elementToBeClickable(WebElements.LOGIN_LINK));
        driver.findElement(WebElements.LOGIN_LINK).click();
        driver.findElement(WebElements.EMAIL).sendKeys(email);
        driver.findElement(WebElements.PASSWORD).sendKeys(password);
        driver.findElement(WebElements.LOGIN_BUTTON).click();
    }
}

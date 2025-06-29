package chapter3AutomatedFunctionalTesting.pages;

import chapter3AutomatedFunctionalTesting.utilities.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait webDriverWait;

    public HomePage(WebDriver driver, WebDriverWait webDriverWait){
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    public LoginPage goToLoginPageUsingLoginLink(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(WebElements.LOGIN_LINK));
        driver.findElement(WebElements.LOGIN_LINK).click();
        return new LoginPage(driver, webDriverWait);
    }

    public void goToLoginSignupPageUsingLogOutLink(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(WebElements.LOGOUT_LINK));
        driver.findElement(WebElements.LOGOUT_LINK).click();
    }

    public String getTheLogOutLinkText(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(WebElements.LOGOUT_LINK));
        return driver.findElement(WebElements.LOGOUT_LINK).getText();
    }
}

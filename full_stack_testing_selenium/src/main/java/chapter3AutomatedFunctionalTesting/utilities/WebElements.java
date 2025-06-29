package chapter3AutomatedFunctionalTesting.utilities;

import org.openqa.selenium.By;

public class WebElements {
    // Home
    public static final By LOGIN_LINK = By.partialLinkText("Login");
    public static final By LOGOUT_LINK = By.partialLinkText("Logout");

    // Login
    public static final By PASSWORD = By.xpath("//*[@data-qa=\"login-password\"]");
    public static final By EMAIL = By.xpath("//*[@data-qa=\"login-email\"]");
    public static final By LOGIN_BUTTON = By.xpath("//*[@data-qa=\"login-button\"]");
    public static final By LOGIN_FAILED_TEXT = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/p");
}

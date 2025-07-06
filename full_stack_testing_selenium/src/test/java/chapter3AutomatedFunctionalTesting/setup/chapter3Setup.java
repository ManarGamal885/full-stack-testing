package chapter3AutomatedFunctionalTesting.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class chapter3Setup {
    // Thread-safe WebDriver and WebDriverWait for parallel test execution
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ThreadLocal<WebDriverWait> webDriverWait = new ThreadLocal<>();

    // Target URL for test execution
    protected static final String URL = "https://www.automationexercise.com/";

    @BeforeClass
    public static void setup() {
        // Automatically resolves and downloads the correct ChromeDriver version
        // based on the installed Chrome browser on the machine
        WebDriverManager.chromedriver().clearResolutionCache().setup();

        // You can also use the following line of code to make the version of the driver
        // exactly match your installed Chrome version (if auto-resolution fails):
        // WebDriverManager.chromedriver().driverVersion("137.0.7151.104").setup();

        // Initialize ChromeDriver without manually specifying ChromeOptions
        driver.set(new ChromeDriver());

        // Set up WebDriverWait with a 10-second timeout
        webDriverWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(10)));

        // Navigate to the target URL
        driver.get().get(URL);
    }

    @AfterClass
    public static void tearDown() {
        // Clean up WebDriver and WebDriverWait instances
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            webDriverWait.remove();
        }
    }
}

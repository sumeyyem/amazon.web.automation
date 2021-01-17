package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final int DEFAULT_WAIT = 10;
    private static RemoteWebDriver driver;

    protected static void createDriver() {

        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static RemoteWebDriver getDriver() {
        return driver;
    }
}
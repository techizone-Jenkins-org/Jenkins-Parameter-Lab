package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {

    public static WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        String browser = System.getProperty("browserProperty", "chrome");
        System.out.println("Selected Browser by User is ===> " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            // Headless mode and other flags to fix Chrome startup on Linux/Jenkins
            options.addArguments("--headless=new");             // Headless mode (new headless mode recommended for Chrome 109+)
            options.addArguments("--no-sandbox");                // Bypass OS security model, required in many CI environments
            options.addArguments("--disable-dev-shm-usage");     // Overcome limited /dev/shm space issue
            options.addArguments("--disable-gpu");               // Applicable to Windows, but safe to add here too
            options.addArguments("--window-size=1920,1080");     // Optional: define window size

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();
            // Optional: run Firefox headless for CI environments
            options.setHeadless(true);

            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();

            EdgeOptions options = new EdgeOptions();
            // Edge headless options (if you want)
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

            driver = new EdgeDriver(options);

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}


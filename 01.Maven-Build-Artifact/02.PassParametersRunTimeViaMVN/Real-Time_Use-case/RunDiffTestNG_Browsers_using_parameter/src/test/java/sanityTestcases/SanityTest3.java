package sanityTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import setup.BrowserSetup;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SanityTest3 extends BrowserSetup {

    @Test
    public void openGoogleAndSearch() {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("TestNG Maven browser parameter");
        System.out.println("------------ Sanity Test cases 3 ---------------");
    }
}

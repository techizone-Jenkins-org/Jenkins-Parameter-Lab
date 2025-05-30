package regressionTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import setup.BrowserSetup;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegressionTest1 extends BrowserSetup {
	
	@Test
	public void m1() {		
		System.out.println("------------ Regression Test cases 1 ---------------");		
	}
}
package sanityTestcases;

import org.testng.annotations.Test;
import setup.BrowserSetup;
import org.openqa.selenium.By;

public class SanityTest1 extends BrowserSetup {

    @Test
    public void openGoogleAndSearch() {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("TestNG Maven browser parameter");
        System.out.println("------------ Sanity Test cases 1 ---------------");
    }
}

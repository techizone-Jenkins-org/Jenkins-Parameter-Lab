package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	
	@Test
	public void sanityTest() {
		
		//Changes from VS Code
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.linkedin.com");
		
		System.out.println(driver.getTitle());
		
		System.out.println("===> Sanity Automation completed");
		driver.quit();
		
	}
	
	@Test
	public void smokeTest() {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.linkedin.com");
		
		System.out.println(driver.getTitle());
		
		System.out.println("===> smoke Automation completed");
		driver.quit();
	}

	@Test
	public void regressionTest() {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.linkedin.com");
		
		System.out.println(driver.getTitle());
		
		System.out.println("===> regression Automation completed");
		driver.quit();
	}
}

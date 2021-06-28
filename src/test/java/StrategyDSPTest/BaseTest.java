package StrategyDSPTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setUpDriver() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}

	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}
}

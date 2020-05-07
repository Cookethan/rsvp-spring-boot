package cucumberTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefs {
	private WebDriver browser;
	private String searchString = "Blondie";
	
	
	@Test
	@Given("^the web browser is open on the google home page$")
	public void startFirefoxwithGoogle() throws Exception{
		WebDriverManager.firefoxdriver().setup();
		browser = new FirefoxDriver();
		browser.get("http://localhost/events");
//		String pageTitle = browser.getTitle();
//		System.out.print(pageTitle);
//		Boolean isPageTitle = pageTitle.equals("Google");
//		assertTrue(isPageTitle);
		browser.quit();
	}
}

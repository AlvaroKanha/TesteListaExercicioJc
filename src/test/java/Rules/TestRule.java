package Rules;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import pages.LoginPage;

public class TestRule {

	public TestRule() {
		PageFactory.initElements(driver, this);
	}

	private static WebDriver driver;
	private static String PATH_DRIVER = "src/test/resources/drivers/chromedriver.exe";
	private static String URL = "https://www.saucedemo.com/";

	//LoginPage login = new LoginPage();

	@Before
	public void initialConfigs() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}

	@Test
	public void teste() {
		//login.efetuarLogin();
	}

	@After
	public void finishTest() {
		driver.close();
		driver.quit();
	}

	public static WebDriver getDiver() {
		return driver;
	}

}
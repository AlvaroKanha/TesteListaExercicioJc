package Rules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//@RunWith(LoginPage.class)

public class TestRule {

	private static WebDriver driver;
	private static String PATH_DRIVER = "src/test/resources/drivers/chromedriver.exe";
	private static String URL = "https://www.saucedemo.com/";

	public static void initialConfigs() {

		if (driver == null) {
			// driver.getPageSource();
			System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			// driver.navigate().to(URL);
			driver.get(URL);
		}

	}

	public static void finishTest() {

		if (driver != null) {
			driver.close();
			driver.quit();
			// driver = null;
		}
	}

	public static WebDriver getDiver() {

		if (driver == null) {
			initialConfigs();
		}
		return driver;
	}

}

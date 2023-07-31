package Rules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRule {
	private static WebDriver driver;
	private static boolean driverInit = false;
	private static String PATH_DRIVER = "src/test/resources/drivers/chromedriver.exe";
	private static String URL = "https://www.saucedemo.com/";

	public static void initialConfigs() {
		System.out.println("Intial configs -----------------------------------------------");
		if (!driverInit) {
			// driver.getPageSource();
			System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			// driver.navigate().to(URL);
			driver.get(URL);
			driverInit = true;
		}
	}

	public static void finishTest() {
		System.out.println("Finish teste -----------------------------------------------");
		if (driverInit) {
			driver.close();
			driver.quit();
			driverInit = false;
		}
	}

	public static WebDriver getDiver() {
		System.out.println("get driver-----------------------------------------------");
		if (!driverInit) {
			initialConfigs();
		}
		return driver;
	}

}

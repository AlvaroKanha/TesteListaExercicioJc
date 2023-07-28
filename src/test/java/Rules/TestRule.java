package Rules;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;

//@RunWith(LoginPage.class)

public class TestRule {



	private static WebDriver driver;
	private static String PATH_DRIVER = "src/test/resources/drivers/chromedriver.exe";
	private static String URL = "https://www.saucedemo.com/";

	//public LoginPage login = new LoginPage();

	@Before
	public void initialConfigs() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.navigate().to(URL);
		driver.get(URL);
		
		//LoginPage login = new LoginPage();
	}

	/*@Test
	public void teste() {
		
		LoginPage login = new LoginPage();
		
		
		login.efetuarLogin();
		
		//WebElement userlogin =  driver.findElement(By.id("user-name"));
		///WebElement userPass = driver.findElement(By.xpath("//*[@id='password']"));
		//WebElement btnlogin = driver.findElement(By.xpath("//*[@id='login-button']"));
		
		//userlogin.sendKeys("standard_user");
		//userPass.sendKeys("secret_sauce");
		//btnlogin.click();
	}*/

	@After
	public void finishTest() {
		//driver.close();
		//driver.quit();
	}

	public static WebDriver getDiver() {
		return driver;
	}

}

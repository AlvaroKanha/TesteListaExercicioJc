package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;

import Rules.TestRule;
import pages.LoginPage;

//@RunWith(LoginPage.class)

public class RunnerTest {
	
	LoginPage login = new LoginPage();
	
	@BeforeClass
	public static void setUp() {
		TestRule.initialConfigs();
	}

	@AfterClass
	public static void setDown() {
		TestRule.finishTest();
	}	
	
	@Test
	public void validarLogin () {
		LoginPage login = new LoginPage();
		login.efetuarLogin();
	}
	
	
	
}

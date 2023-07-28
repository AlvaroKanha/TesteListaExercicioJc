package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Rules.TestRule;
import pages.LoginPage;

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
		login.efetuarLogin();
	}
}

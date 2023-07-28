package runner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;

import Rules.TestRule;
import pages.LoginPage;

//@RunWith(LoginPage.class)

public class RunnerTest {
	
	public static void main(String[] args) {
		
	}


	
	//LoginPage login = new LoginPage();
	
	
	@Test
	public void validarLogin () {
		LoginPage login = new LoginPage();
		login.efetuarLogin();
		
		
	}
	
	
	
}

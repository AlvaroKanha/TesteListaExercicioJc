package runner;

import org.junit.Test;

import pages.LoginPage;

public class RunnerTest {
	

	LoginPage login = new LoginPage();
	
	@Test
	public void validarLogin () {
		login.efetuarLogin();
		
	}
}

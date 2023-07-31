package runner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Rules.TestRule;
import pages.HomeProdutosPage;
import pages.LoginPage;


public class RunnerTest {

	LoginPage login = new LoginPage();
	HomeProdutosPage home = new HomeProdutosPage();

	//@BeforeClass
	public static void setUp() {
		TestRule.initialConfigs();
		/*if (TestRule.getDiver() == null) {
			TestRule.initialConfigs();
		}*/
	}
	
	/*@AfterClass
	public static void setDownn() {
		TestRule.finishTest();
	}*/



	@Before
	public void asdfad () {
		TestRule.initialConfigs();
		
		/*if (TestRule.getDiver() == null) {
			System.out.println("Passou if Before");
			TestRule.initialConfigs();
		}
		else {
			TestRule.finishTest();
			TestRule.initialConfigs();
			System.out.println("Passou else Before");
		}*/
	}
	
	@After
	public void setDown() {
		TestRule.finishTest();
	}
	
	@Test
	public void validarLogin() {

		login.efetuarLogin();
	}

	@Test
	public void adicionarCarrinho() {
		login.efetuarLogin();
		home.adicionarProdutoCarrinho();
	}
	
	@Test
	public void filtrarMenorParaMaior () {
		login.efetuarLogin();
		home.filtrarMenorParaMaior();
	}

}

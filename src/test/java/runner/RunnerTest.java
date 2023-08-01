package runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Rules.TestRule;
import pages.CheckoutPage;
import pages.HomeProdutosPage;
import pages.LoginPage;

public class RunnerTest {

	LoginPage login = new LoginPage();
	HomeProdutosPage home = new HomeProdutosPage();
	CheckoutPage checkout = new CheckoutPage();

	@Before
	public void asdfad() {
		TestRule.initialConfigs();

	}

	@After
	public void setDown() {
		TestRule.finishTest();
	}

	//@Test
	public void validarLogin() {
		login.efetuarLogin();
	}

	//@Test
	public void adicionarCarrinho() {
		login.efetuarLogin();
		home.adicionarProdutoCarrinho();
	}

	//@Test
	public void filtrarMenorParaMaior() {
		login.efetuarLogin();
		home.filtrarMenorParaMaior();
	}
	
	@Test
	public void quantidadeCarrinho() {
		checkout.validarQuantidadeDeItensNoCarrinho();
	}

}

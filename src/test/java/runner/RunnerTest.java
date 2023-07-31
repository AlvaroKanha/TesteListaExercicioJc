package runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Rules.TestRule;
import pages.HomeProdutosPage;
import pages.LoginPage;

public class RunnerTest {

	LoginPage login = new LoginPage();
	HomeProdutosPage home = new HomeProdutosPage();

	@Before
	public void asdfad() {
		System.out.println("Before -----------------------------------------------");
		TestRule.initialConfigs();

	}

	@After
	public void setDown() {
		System.out.println("after -----------------------------------------------");
		TestRule.finishTest();
	}

	@Test
	public void validarLogin() {
		System.out.println("Teste login -----------------------------------------------");
		login.efetuarLogin();
	}

	@Test
	public void adicionarCarrinho() {
		System.out.println("Valida carrinho -----------------------------------------------");
		login.efetuarLogin();
		home.adicionarProdutoCarrinho();
	}

	@Test
	public void filtrarMenorParaMaior() {
		System.out.println("Filtrar menor -----------------------------------------------");
		login.efetuarLogin();
		home.filtrarMenorParaMaior();
	}

}

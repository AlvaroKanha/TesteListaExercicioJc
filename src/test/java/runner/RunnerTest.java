package runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.devtools.v112.systeminfo.SystemInfo;

import Rules.TestRule;
import pages.CarrinhoPage;
import pages.CheckoutPage;
import pages.HomeProdutosPage;
import pages.LoginPage;

public class RunnerTest {

	LoginPage login = new LoginPage();
	HomeProdutosPage home = new HomeProdutosPage();
	CarrinhoPage carrinho = new CarrinhoPage();
	CheckoutPage checkout = new CheckoutPage();

	@Before
	public void inicioTest() {
		TestRule.initialConfigs();

	}

	@After
	public void fimTest() {
		TestRule.finishTest();
	}

	@Test
	public void LoginStandardUser() {
		System.out.println("Standard");
		login.efetuarLogin("standard");
	}

	// @Test
	public void adicionarUmProdutoNoCarrinho() {
		login.efetuarLogin("standard");
		home.adicionarProdutoCarrinho("1");
	}

	// @Test
	public void filtrarMenorParaMaior() {
		login.efetuarLogin("standard");
		home.filtrarMenorParaMaior();
	}

	// @Test
	public void validarTerceiroProdutoNoCarrinho() {
		login.efetuarLogin("standard");
		home.adicionarProdutoCarrinho("3");
		home.clicarCarrinhoDeCompras();
		carrinho.validarQuantidadeDeItensNoCarrinho("1");
		carrinho.removerProdutoCarrinho();
	}

	// @Test
	public void adicionarTodosProdutos() {
		login.efetuarLogin("standard");

		for (int i = 1; i <= 6; i++) {
			home.adicionarProdutoCarrinho(Integer.toString(i));
		}
		home.clicarCarrinhoDeCompras();
		carrinho.validarQuantidadeDeItensNoCarrinho("6");
	}

	// @Test
	public void adicionarProdutoERemoverSemIrAoCarrinho() {
		login.efetuarLogin("standard");
		home.adicionarProdutoCarrinho("1");
		home.removerProdutoCarrinho("1");
	}

	// @Test
	public void validarNomeProduto() {
		login.efetuarLogin("standard");
		home.buscaNomeProduto("Sauce Labs Fleece Jacket");

	}

	@Test
	public void realizarLoginLocked() {
		login.efetuarLogin("locked");
		login.validaMensagemErro();
	}

	//@Test
	public void checkoutProduto() {
		login.efetuarLogin("standard");
		home.adicionarProdutoCarrinho("1");
		home.clicarCarrinhoDeCompras();
		carrinho.clicarCheckout();
		checkout.preencherCamposCheckout();
		checkout.clicarContinueCheckout();
	}
}

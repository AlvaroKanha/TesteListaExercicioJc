package glue;

import org.junit.After;
import org.junit.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CarrinhoPage;
import pages.CheckoutPage;
import pages.CompleteOrderPage;
import pages.HomeProdutosPage;
import pages.LoginPage;
import pages.ReviewPage;
import rules.TestRule;

public class GlueCode {

	LoginPage login = new LoginPage();
	HomeProdutosPage home = new HomeProdutosPage();
	CarrinhoPage carrinho = new CarrinhoPage();
	CheckoutPage checkout = new CheckoutPage();
	ReviewPage review = new ReviewPage();
	CompleteOrderPage complete = new CompleteOrderPage();
	
	
	
	
	
	


	@Given("estou na tela de login")
	public void estou_na_tela_de_login() {
		TestRule.initialConfigs();
	    
	}
	@When("efetuar o login com usuario standard")
	public void efetuar_o_login_com_usuario_standard() {
		login.efetuarLogin("standard");
	    
	}
	@Then("visualizo a tela de produtos")
	public void visualizo_a_tela_de_produtos() {
	    home.validaLogin();
	    
	}



	
	
	
	
	
	
	
	
	

	@Before
	public void inicioTest() {
		TestRule.initialConfigs();

	}

	@After
	public void fimTest() {
		TestRule.finishTest();
	}

	//@Test
	public void LoginStandardUser() {
		System.out.println("Standard");
		login.efetuarLogin("standard");
	}

	//@Test
	public void adicionarUmProdutoNoCarrinho() {
		login.efetuarLogin("standard");
		home.adicionarProdutoCarrinho("1");
		carrinho.validarQuantidadeDeItensNoCarrinho("1");
	}

	//@Test
	public void filtrarMenorParaMaior() {
		login.efetuarLogin("standard");
		home.filtrarMenorParaMaior();
	}

	//@Test
	public void validarTerceiroProdutoNoCarrinho() {
		login.efetuarLogin("standard");
		home.adicionarProdutoCarrinho("3");
		home.clicarCarrinhoDeCompras();
		carrinho.validarQuantidadeDeItensNoCarrinho("1");
		carrinho.removerProdutoCarrinho();
	}

	//@Test
	public void adicionarTodosProdutos() {
		login.efetuarLogin("standard");
		for (int i = 1; i <= 6; i++) {
			home.adicionarProdutoCarrinho(Integer.toString(i));
		}
		home.clicarCarrinhoDeCompras();
		carrinho.validarQuantidadeDeItensNoCarrinho("6");
	}

	//@Test
	public void adicionarProdutoERemoverSemIrAoCarrinho() {
		login.efetuarLogin("standard");
		home.adicionarProdutoCarrinho("1");
		home.removerProdutoCarrinho("1");
	}

	//@Test
	public void validarNomeProduto() {
		login.efetuarLogin("standard");
		home.buscaNomeProduto("Sauce Labs Fleece Jacket");

	}

	//@Test
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
		review.validaProdutosEValores();
		review.clicarEmFinalizar();
		complete.verificaOrderComplete();
	}
	
	//@Test
	public void adicionarTresProdutosAleatorio() {
		login.efetuarLogin("standard");
		home.adicionarProdutoAleatorio(3);
		home.clicarCarrinhoDeCompras();
	}
}

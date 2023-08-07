package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.CheckoutElementsPage;

public class CheckoutPage extends CheckoutElementsPage {
	LoginPage login = new LoginPage();
	HomeProdutosPage home = new HomeProdutosPage();
	
	public void validarQuantidadeDeItensNoCarrinho () {
		login.efetuarLogin();
		home.adicionarProdutoCarrinho();
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		
		wait.until(ExpectedConditions.visibilityOf(tituloCarrinho));
		assertEquals("1", quantidadeProdutos.getText());
		
	}
	
}

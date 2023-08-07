package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Rules.TestRule;
import elements.CarrinhoElementsMap;

public class CarrinhoPage extends CarrinhoElementsMap {

	public CarrinhoPage() {
		PageFactory.initElements(TestRule.getDiver(), this);
	}

	public void validarQuantidadeDeItensNoCarrinho(String quantidade) {
		wait.until(ExpectedConditions.visibilityOf(tituloCarrinho));
		assertEquals(quantidade, cartQuantityProduct.getText());
	}
	
	public void removerProdutoCarrinho () {
		btnRemove.click();
		assertTrue(driver.findElement(By.xpath("//div[@class = \"removed_cart_item\"]")).isEnabled());
	}
	
	public void clicarCheckout() {
		BtnCheckout.click();
		wait.until(ExpectedConditions.invisibilityOf(BtnCheckout));
	}

}

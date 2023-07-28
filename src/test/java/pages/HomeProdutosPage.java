package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.HomeProdutosElementsMap;

public class HomeProdutosPage extends HomeProdutosElementsMap {

	public void adicionarProdutoCarrinho() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) productOne));
		productOne.click();
		
		assertEquals(1, cartOneProduct.getText());
	}

	public void filtrarMenorParaMaior() {
		wait.until(ExpectedConditions.elementToBeClickable(lohiFilter));
		lohiFilter.click();
	
		assertEquals("Price (low to high)", lohiFilter.getText());
	}

}

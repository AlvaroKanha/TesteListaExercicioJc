package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Rules.TestRule;
import elements.HomeProdutosElementsMap;

public class HomeProdutosPage extends HomeProdutosElementsMap {
	
	public HomeProdutosPage() {
		PageFactory.initElements(TestRule.getDiver(), this);
	}

	public void adicionarProdutoCarrinho() {
		wait.until(ExpectedConditions.elementToBeClickable(productOne));
		productOne.click();
		
		assertEquals("1", cartOneProduct.getText());
	}

	public void filtrarMenorParaMaior() {
		wait.until(ExpectedConditions.elementToBeClickable(lohiFilter));
		lohiFilter.click();
	
		assertEquals("Price (low to high)", lohiFilter.getText());
	}

}

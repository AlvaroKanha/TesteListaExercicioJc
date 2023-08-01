package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		String precoAnt = "0";
		String precoAtual;

		wait.until(ExpectedConditions.elementToBeClickable(lohiFilter));
		lohiFilter.click();

		for (int i = 1; i <= Integer.parseInt(driver.findElement(By.xpath("//div[@class=\"inventory_list\"]"))
				.getDomProperty("childElementCount")); i++) {

			precoAtual = driver
					.findElement(By
							.xpath("//div[@class=\"inventory_item\"][" + i + "]//div[@class=\"inventory_item_price\"]"))
					.getText();

			assertTrue(Double.parseDouble(precoAtual.replace("$", "")) >= Double.parseDouble(precoAnt.replace("$", "")));

			precoAnt = precoAtual;
		}

		assertEquals("Price (low to high)", lohiFilter.getText());
	}

}

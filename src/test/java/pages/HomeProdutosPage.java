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

	public void adicionarProdutoCarrinho(String produto) {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"inventory_item\"][" + produto
				+ "]//button[@class=\"btn btn_primary btn_small btn_inventory\"]")));

		driver.findElement(By.xpath("//div[@class=\"inventory_item\"][" + produto
				+ "]//button[@class=\"btn btn_primary btn_small btn_inventory\"]")).click();

		assertEquals("1", cartQuantityProduct.getText());
	}

	public void removerProdutoCarrinho(String produto) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"inventory_item\"][" + produto
				+ "]//button[@class=\"btn btn_secondary btn_small btn_inventory\"]")));

		driver.findElement(By.xpath("//div[@class='inventory_item'][" + produto
				+ "]//button[@class='btn btn_secondary btn_small btn_inventory']")).click();

		assertTrue(driver.findElement(By.xpath("//div[@class=\"inventory_item\"][" + produto
				+ "]//button[@class=\"btn btn_primary btn_small btn_inventory\"]")).isDisplayed());

	}

	public void clicarCarrinhoDeCompras() {
		cartQuantityProduct.click();
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

			assertTrue(
					Double.parseDouble(precoAtual.replace("$", "")) >= Double.parseDouble(precoAnt.replace("$", "")));

			precoAnt = precoAtual;
		}

		assertEquals("Price (low to high)", lohiFilter.getText());
	}

	public void buscaNomeProduto(String nome) {
		int i = 1;
		while (i <= Integer.parseInt(
				driver.findElement(By.xpath("//div[@class=\"inventory_list\"]")).getDomProperty("childElementCount"))
				&& !nome.equals(driver
						.findElement(By.xpath(
								"//div[@class=\"inventory_item\"][" + i + "]//div[@class=\"inventory_item_name\"]"))
						.getText()))
			i++;

		assertEquals(nome,
				driver.findElement(
						By.xpath("//div[@class=\"inventory_item\"][" + i + "]//div[@class=\"inventory_item_name\"]"))
						.getText());
	}

}

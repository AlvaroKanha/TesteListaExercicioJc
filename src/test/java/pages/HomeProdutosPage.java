package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.HomeProdutosElementsMap;
import elements.UtilsElements;
import rules.TestRule;

public class HomeProdutosPage extends HomeProdutosElementsMap {

	ArrayList<JSONObject> listaMassas = new ArrayList<JSONObject>();
	UtilsElements util = new UtilsElements();

	public HomeProdutosPage() {
		PageFactory.initElements(TestRule.getDiver(), this);
	}

	public void validaLogin() {
		wait.until(ExpectedConditions.visibilityOf(titleHomeProduct));
		assertTrue(titleHomeProduct.isDisplayed());
	}
		
	
	public void adicionarProdutoAleatorio(int num) {
		Integer[] lista = new Integer[num];
		Random random = new Random();
		int numeroAleatorio;

		if (num < Integer.parseInt(
				driver.findElement(By.xpath("//div[@class=\"inventory_list\"]")).getDomProperty("childElementCount"))) {

			int aux = 0;
			while (aux < num) {
				numeroAleatorio = random.nextInt(1,
						Integer.parseInt(driver.findElement(By.xpath("//div[@class=\"inventory_list\"]"))
								.getDomProperty("childElementCount")));
				if (!Arrays.asList(lista).contains(numeroAleatorio)) {
					lista[aux] = numeroAleatorio;
					aux++;
				}

			}

			for (int i = 0; i < lista.length; i++) {
				adicionarProdutoCarrinho(Integer.toString(lista[i]));
			}
		}
		util.setLista(lista);
	}

	public void adicionarProdutoCarrinho(String produto) {
		JSONObject massa = new JSONObject();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"inventory_item\"][" + produto
				+ "]//button[@class=\"btn btn_primary btn_small btn_inventory\"]")));

		massa.put("Nome",
				driver.findElement(By.xpath(
						"//div[@class=\"inventory_item\"][" + produto + "]//div[@class = 'inventory_item_name']"))
						.getText());
		massa.put("Descricao",
				driver.findElement(By.xpath(
						"//div[@class=\"inventory_item\"][" + produto + "]//div[@class = 'inventory_item_desc']"))
						.getText());
		massa.put("Preco",
				driver.findElement(By.xpath(
						"//div[@class=\"inventory_item\"][" + produto + "]//div[@class = 'inventory_item_price']"))
						.getText());

		driver.findElement(By.xpath("//div[@class=\"inventory_item\"][" + produto
				+ "]//button[@class=\"btn btn_primary btn_small btn_inventory\"]")).click();

		assertTrue(listaMassas.add(massa));
		util.setDetalheProduto(listaMassas);
	}

	public void imprimeListaMassa() {
		for (int i = 0; i < listaMassas.size(); i++)
			System.out.println(listaMassas.get(i));
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

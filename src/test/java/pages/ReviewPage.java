package pages;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Rules.TestRule;
import elements.ReviewElemensMap;

public class ReviewPage extends ReviewElemensMap {

	public ReviewPage() {
		PageFactory.initElements(TestRule.getDiver(), this);
	}

	public void validaProdutosEValores(JSONObject massa) {
		String aux;
		
		
		//implementar um for para mais produtos no carrinho de compras
		
		
		assertEquals(driver.findElement(By.xpath("//div[@class = 'cart_list'][1]//div[@class = 'inventory_item_name']"))
				.getText(), massa.get("Nome"));
		assertEquals(driver.findElement(By.xpath("//div[@class = 'cart_list'][1]//div[@class = 'inventory_item_desc']"))
				.getText(), massa.get("Descricao"));
		assertEquals(
				driver.findElement(By.xpath("//div[@class = 'cart_list'][1]//div[@class = 'inventory_item_price']"))
						.getText(),
				massa.get("Preco"));
		
		aux = subTotal.getText().toString().replace("Item total: $", "");
		Double subTotal = Double.parseDouble(aux);
		
		aux = taxa.getText().toString().toString().replace("Tax: $", "");
		Double taxa = Double.parseDouble(aux);
		
		aux = total.getText().toString().toString().replace("Total: $", "");
		Double total = Double.parseDouble(aux);	
		
		subTotal = subTotal + taxa;
		assertEquals(subTotal, total);
	}
	
	public void clicarEmFinalizar() {
		wait.until(ExpectedConditions.visibilityOf(btnFinalizar));
		btnFinalizar.click();
	}

}

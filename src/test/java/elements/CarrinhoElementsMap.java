package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarrinhoElementsMap extends UtilsElements {

	@FindBy(xpath = "//div[@class = 'cart_quantity']")
	protected WebElement quantidadeProdutos;
	
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
	protected WebElement tituloCarrinho;
	
	@FindBy (xpath = "//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]")
	protected WebElement btnRemove;
	
	@FindBy(xpath = "//span[@class = 'shopping_cart_badge']")
	protected WebElement cartQuantityProduct;
	
	@FindBy(xpath = "//*[@id=\"checkout\"]")
	protected WebElement BtnCheckout;
	
	
}

package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutElementsPage extends UtilsElements {

	@FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]")
	protected WebElement quantidadeProdutos;
	
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
	protected WebElement tituloCarrinho;
	
	
}

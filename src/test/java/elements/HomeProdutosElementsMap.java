package elements;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeProdutosElementsMap extends UtilsElements {

	
	@FindBy(xpath = "//span[@class = 'title']")
	protected WebElement titleHomeProduct;
	
	@FindBy(xpath = "//span[@class = 'shopping_cart_badge'][contains(text() ,'1')]")
	protected WebElement cartOneProduct;
	
	@FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-backpack']")
	protected WebElement productOne;
	
	@FindBy(xpath = "//option[@value = 'lohi']")
	protected WebElement lohiFilter;
	
	@FindBy(xpath = "//span[@class = 'active_option']")
	protected WebElement activatedFilter;
}

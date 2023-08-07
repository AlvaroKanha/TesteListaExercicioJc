package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutElementsMap extends UtilsElements {
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
	protected WebElement checkoutPage;
	
	@FindBy(xpath = "//*[@id=\"first-name\"]")
	protected WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"last-name\"]")
	protected WebElement lastName;
	
	@FindBy(xpath = "//*[@id=\"postal-code\"]")
	protected WebElement postalCode;
	
	@FindBy(xpath = "//*[@id=\"continue\"]")
	protected WebElement btnContinue;
}

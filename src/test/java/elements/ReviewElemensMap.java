package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewElemensMap extends UtilsElements {

	@FindBy(xpath = "//span[@class = 'title'][contains(text(), 'Checkout: Overview')]")
	protected WebElement reviewTitle;

	@FindBy(xpath = "//div[@class = 'summary_subtotal_label']")
	protected WebElement subTotal;

	@FindBy(xpath = "//div[@class = 'summary_tax_label']")
	protected WebElement taxa;

	@FindBy(xpath = "//div[@class = 'summary_info_label summary_total_label']")
	protected WebElement total;
	
	@FindBy(xpath = "//*[@id=\"finish\"]")
	protected WebElement btnFinalizar;

}

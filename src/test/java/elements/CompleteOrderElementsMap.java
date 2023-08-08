package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompleteOrderElementsMap extends UtilsElements {
	
	@FindBy(xpath = "//h2[@class = 'complete-header']")
	protected WebElement txtOrdemFinalizada;

}

package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Rules.TestRule;
import elements.CheckoutElementsMap;

public class CheckoutPage extends CheckoutElementsMap{
	
	public CheckoutPage() {
		PageFactory.initElements(TestRule.getDiver(), this);
	}
	
	public void preencherCamposCheckout() {
		//wait.until(ExpectedConditions.elementToBeSelected(firstName));
		firstName.sendKeys("Abacaxi");
		lastName.sendKeys("Assado");
		postalCode.sendKeys("01010-010");
		
		assertEquals(null, "Abacaxi", firstName.getDomProperty("defaultValue"));
	}

	public void clicarContinueCheckout () {
		wait.until(ExpectedConditions.visibilityOf(btnContinue));
		btnContinue.click();
	}
	
}

package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Rules.TestRule;
import elements.CompleteOrderElementsMap;

public class CompleteOrderPage extends CompleteOrderElementsMap {

	public CompleteOrderPage() {
		PageFactory.initElements(TestRule.getDiver(), this);
	}

	public void verificaOrderComplete() {
		wait.until(ExpectedConditions.visibilityOf(txtOrdemFinalizada));
		assertEquals("Thank you for your order!", txtOrdemFinalizada.getText());
	}

}

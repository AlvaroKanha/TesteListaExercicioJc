package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Rules.TestRule;
import elements.HomeProdutosElementsMap;
import elements.LoginElementsMap;

public class LoginPage extends LoginElementsMap {
	HomeProdutosElementsMap home = new HomeProdutosElementsMap();

	public LoginPage() {
		PageFactory.initElements(TestRule.getDiver(), this);
	}

	public void efetuarLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		// System.out.println(standardUser.getText());
		// wait.until(ExpectedConditions.visibilityOfElementLocated((By) standardUser));
		userName.sendKeys("standard_user");
		userPassword.sendKeys("secret_sauce");
		// wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(titleHomeProduct));

		assertEquals("Products", titleHomeProduct.getText());

	}

}

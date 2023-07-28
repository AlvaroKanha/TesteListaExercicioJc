package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.LoginElementsMap;

public class LoginPage extends LoginElementsMap {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void efetuarLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));

		// userName.sendKeys(standardUser.getText());
		// userPassword.sendKeys(password.getText());

		userName.sendKeys("standard_user");
		userPassword.sendKeys("secret_sauce");
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
	}

}

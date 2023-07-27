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
		System.out.println(standardUser.getText());
			
		userName.sendKeys(standardUser.getText());
		userPassword.sendKeys(password.getText());
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
	}

}

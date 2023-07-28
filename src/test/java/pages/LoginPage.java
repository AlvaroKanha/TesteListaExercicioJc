package pages;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.HomeProdutosElementsMap;
import elements.LoginElementsMap;
import runner.RunnerTest;

@RunWith(LoginPage.class)


public class LoginPage extends LoginElementsMap {

	//LoginPage login = new LoginPage();
	
	HomeProdutosElementsMap home = new HomeProdutosElementsMap();
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void efetuarLogin() {
		//wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		//System.out.println(standardUser.getText());
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) standardUser));
		userName.sendKeys("standard_user");
		userPassword.sendKeys("secret_sauce");
		//wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) titleHomeProduct));
		
		assertEquals("Products", titleHomeProduct.getText());
		
	}

}

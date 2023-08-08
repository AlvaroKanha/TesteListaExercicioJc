package pages;

import static org.junit.Assert.assertTrue;

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

	public void efetuarLogin(String userLogin) {
		String userWeb;
		String[] listUserWeb;

		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));

		userWeb = userType.getText();
		listUserWeb = userWeb.split("\n");

		userWeb = encontrarUsuario(listUserWeb, userLogin);
		
		if (!userWeb.equals("NotUser")) {

			userName.sendKeys(userWeb);
			userPassword.sendKeys("secret_sauce");

			wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
			btnLogin.click();
		}
	}
		
	public void validaMensagemErro() {
			assertTrue(loginError.getText().contains("been locked out"));
	}

	public String encontrarUsuario(String[] lista, String user) {
		for (String i : lista) {
			if (i.contains(user))return i;
		}
		return "NotUser";
	}
}

package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginElementsMap extends UtilsElements {

	@FindBy(xpath = "//*[@id='user-name']")
	protected WebElement userName;

	@FindBy(xpath = "//*[@id=\"password\"]")
	protected WebElement userPassword;

	@FindBy(xpath = "//*[@id='login-button']")
	protected WebElement btnLogin;

	@FindBy(xpath = "//*[@id=\"login_credentials\"]/text()[1]")
	protected WebElement standardUser;

	@FindBy(xpath = "//*[@id=\"login_credentials\"]/text()[2]")
	protected WebElement lockedUser;

	@FindBy(xpath = "//div[contains(text() ,'secret')]")
	protected WebElement password;

	// Verificar se n�o tem como validar pela outra classe
	@FindBy(xpath = "//span[@class = 'title']")
	protected WebElement titleHomeProduct;

}

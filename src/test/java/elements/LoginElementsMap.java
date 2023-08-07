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

	@FindBy(xpath = "//*[@id=\"login_credentials\"]")
	protected WebElement userType;

	@FindBy(xpath = "//*[@id=\"login_credentials\"]/text()[2]")
	protected WebElement lockedUser;

	@FindBy(xpath = "//div[contains(text() ,'secret')]")
	protected WebElement password;
	
	@FindBy(xpath = "//h3[@data-test = 'error']")
	protected WebElement loginError;

	// Verificar se n�o tem como validar pela outra classe
	//@FindBy(xpath = "//span[@class = 'title']")
	//protected WebElement titleHomeProduct;
		

}

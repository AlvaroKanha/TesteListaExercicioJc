package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElementsMap extends UtilsElements {
	
	public LoginElementsMap() {
		PageFactory.initElements(driver, this);
	}

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
	
	
	//Verificar se não tem como validar pela outra classe
	@FindBy(xpath = "//span[@class = 'title']")
	protected WebElement titleHomeProduct;
	
}

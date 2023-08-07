package elements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rules.TestRule;

public class UtilsElements {

	protected WebDriver driver = TestRule.getDiver();
	protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public boolean validaElementoInexistente(WebElement elemento) {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(elemento));
			return true;
		} catch (Exception e) {
			return false;
		}
	}


}

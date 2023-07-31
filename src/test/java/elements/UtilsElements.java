package elements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rules.TestRule;

public class UtilsElements {

	protected WebDriver driver = TestRule.getDiver();
	protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

}

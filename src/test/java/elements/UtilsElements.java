package elements;

import java.time.Duration;
import java.util.ArrayList;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rules.TestRule;

public class UtilsElements {

	protected WebDriver driver = TestRule.getDiver();
	protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	private ArrayList<JSONObject> detalheProduto = new ArrayList <JSONObject>();
	private Integer[] lista;
	
	public Integer[] getLista() {
		return lista;
	}

	public void setLista(Integer[] lista) {
		this.lista = lista;
	}

	public ArrayList<JSONObject> getDetalheProduto() {
		return detalheProduto;
	}

	public void setDetalheProduto(ArrayList<JSONObject> detalheProduto) {
		this.detalheProduto = detalheProduto;
	}
	
	public boolean validaElementoInexistente(WebElement elemento) {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(elemento));
			return false;
		} catch (Exception e) {
			return true;
		}
	}
}
	
package ucom.qa.hp.utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils{

	//Highlighting the element
	public static void highLightElement(WebDriver driver,WebElement element) {
		((JavascriptExecutor) driver).
		executeScript("arguments[0]." +
				"setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		((JavascriptExecutor) driver).
		executeScript("arguments[0]." +
				"setAttribute('style', 'border: 2px solid black;');", element);
	}

	//drawing border for the element
	public static  void drawBorder(WebDriver driver,WebElement element){
		((JavascriptExecutor) driver).
		executeScript("arguments[0].style.border='3px solid red'", element);
	}

	//generate alert
	public static void generateAlert(WebDriver driver,String message){
		((JavascriptExecutor) driver).executeScript("alert('"+message+"')");
	}

	//click Element
	public static void clickElementByJS(WebDriver driver,WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
	}
	
	//Refresh Browser
	public static void refreshBrowserByJS(WebDriver driver,WebElement element){
		((JavascriptExecutor) driver).executeScript("history.go(0)");
	}

	//Get Title
	public static String getPageTitleByJS(WebDriver driver,WebElement element){
		return (String)((JavascriptExecutor) driver).executeScript("return document.title");
	}

	//Get Page innerText
	public static String getPageinnerTextByJS(WebDriver driver,WebElement element){
		return (String)((JavascriptExecutor) driver).executeScript("return document.title");
	}

	//Scroll Page Down
	public static void scrollPageDown(WebDriver driver){
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,1000");
	}

	//Scroll in to view
	public static void scrollInToView(WebDriver driver,WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	//Sendkeys through Java Script
	public static void jsSendKeys(WebDriver driver,String text,WebElement element){
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("arguments[0].value='"+text+"';", element);
	}
	
	public static Boolean highLightElementWithoutFail(WebDriver driver,WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
		}catch(Throwable t) {			
		}
		try {
			((JavascriptExecutor) driver).
			executeScript("arguments[0]." +
					"setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			((JavascriptExecutor) driver).
			executeScript("arguments[0]." +
					"setAttribute('style', 'border: 0px black;');", element);
		}catch(Throwable t) {
			return true;
		}
		return false;
	}

}

package ucom.qa.hp.utils;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.Scenario;

public class TestUtils {

	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICIT_WAIT = 100;
	public static String parentWindow;

	public static void deleteScreenShots() {

		File index = new File(System.getProperty("user.dir") + "/Screenshots/");
		String[] entries = index.list();
		for (String s : entries) {
			File currentFile = new File(index.getPath(), s);
			currentFile.delete();
		}
	}

	public static String takeScreenShotAtEndOfTest(WebDriver driver, String testname) {

		File filesrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String screenshotpath = currentDir + "/Screenshots/" + testname + "__" + System.currentTimeMillis() + ".png";

		try {
			FileUtils.copyFile(filesrc, new File(screenshotpath));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotpath;
	}

	public static void waitForElement(WebDriver driver, final WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				if (element.isDisplayed()) {
					return true;
				} else {
					return false;
				}
			}
		});
	}

	public static void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public static void getTextAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public static void sendKeysAlert(WebDriver driver, String keys) {
		driver.switchTo().alert().sendKeys(keys);
	}

	public static void switchToFrameByElement(WebDriver driver, WebElement iframeElement) {
		driver.switchTo().frame(iframeElement);
	}

	public static void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public static void switchToFrameByID(WebDriver driver, String iframeID) {
		driver.switchTo().frame(iframeID);
	}

	public static void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static String getText(WebDriver driver, String id) {
		return driver.findElement(By.id(id)).getText();
	}

	public static void clickTab(WebDriver driver, String tabname) {

		driver.findElement(By.xpath("//div[contains(text(),'" + tabname + "')]")).click();

	}

	public static void switchToWindow(WebDriver driver) {
		parentWindow = driver.getWindowHandle();
		Set<String> winHandles = driver.getWindowHandles();
		for (String windowHandle : winHandles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
			}
		}
	}

	public static void switchToParentWindow(WebDriver driver) {
		Set<String> winHandles = driver.getWindowHandles();
		if (winHandles.size() == 1) {
			for (String windowHandle : winHandles)
				driver.switchTo().window(windowHandle);
		}
	}

	public static void enterTextInElement(WebDriver driver, WebElement element, String text) {
		((JavascriptExecutor) driver).executeScript("arguments[1].value = arguments[0]; ", text, element);
	}

	public static void autoSelectTextDropdown(WebDriver driver) {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ARROW_DOWN).click().build().perform();
	}

	public static void tabKey(WebDriver driver) {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.TAB).click().build().perform();
	}

	public static void click(WebDriver driver, WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click().build().perform();
	}

	public static void escapeKey(WebDriver driver) {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ESCAPE).click().build().perform();
	}

	public static void enterKey(WebDriver driver) {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ENTER).click().build().perform();
	}

	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void checkButtonStatusDisabled(WebElement wel) {
		Assert.assertEquals(false, wel.isEnabled());
	}

	public static void checkButtonStatusEnabled(WebElement wel) {
		Assert.assertEquals(true, wel.isEnabled());
	}

	public static Boolean waitForElementWithoutFail(WebDriver driver, final WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					if (element.isDisplayed()) {
						return true;
					} else {
						return false;
					}
				}
			});
		} catch (Throwable t) {
			return true;
		}
		return false;
	}

	public static WebElement webElementWithXpath(WebDriver driver, String xpath, String replaceMe1)
			throws InterruptedException {
		String xpathEle = xpath.replace("replaceMe1", replaceMe1);
		WebElement element = driver.findElement(By.xpath(xpathEle));
		return element;
	}

	public static List<WebElement> webElementsWithXpath(WebDriver driver, String xpath, String replaceMe1)
			throws InterruptedException {
		String xpathEle = xpath.replace("replaceMe1", replaceMe1);
		List<WebElement> elements = driver.findElements(By.xpath(xpathEle));
		return elements;
	}

	public static void goBackToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public static void pageTitle(WebDriver driver, String actualtitle) {
		String title = driver.getTitle();
		Assert.assertEquals(title, actualtitle);
	}

	public static void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

}

package ucom.qa.hp.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommonUtils {

	public WebDriver driver;

	public CommonUtils(WebDriver dvr) {
		driver = dvr;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	private WebElement acceptCookies;

	@FindBy(xpath = "//div[@id='menuitemOne_tab']")
	WebElement headerExplore;

	@FindBy(xpath = "//div[@id='menuitemTwo_tab']")
	WebElement headerShop;

	@FindBy(xpath = "//div[@id='menuitemThree_tab']")
	WebElement headerSupport;
	
	@FindBy(xpath = "//a[@id='Sign-in'] | //a[@id='sign-in']")
	private WebElement signInButton;

	public void acceptCookies() {
	 	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
			TestUtils.waitForElement(driver, acceptCookies);
			JavaScriptUtils.highLightElement(driver, acceptCookies);
			Assert.assertTrue(acceptCookies.isDisplayed());
			acceptCookies.click();		
	}

	public void validateHeader() {

			TestUtils.waitForElement(driver, headerExplore);
			JavaScriptUtils.highLightElement(driver, headerExplore);
			Assert.assertTrue(headerExplore.isDisplayed());

			JavaScriptUtils.highLightElement(driver, headerShop);
			Assert.assertTrue(headerExplore.isDisplayed());

			JavaScriptUtils.highLightElement(driver, headerSupport);
			Assert.assertTrue(headerExplore.isDisplayed());
	}
	
	public void clickSignIn() {
		TestUtils.waitForElement(driver, signInButton);
		JavaScriptUtils.highLightElement(driver, signInButton);
		signInButton.click();
	}

}

package com.qa.hp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.qa.hp.basepage.BasePage;

import ucom.qa.hp.utils.JavaScriptUtils;
import ucom.qa.hp.utils.TestUtils;

public class ContactLandingPage extends BasePage {

	public ContactLandingPage(WebDriver dvr) {
		driver = dvr;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}

	@FindBy(xpath = "//a[text()='Get started before signing in']")
	private WebElement getStartedLink;

	@FindBy(xpath = "//h3[text()='Quick links']")
	private WebElement quickLinkText;

	@FindBy(xpath = "//h1[contains(text(),'Hi')]")
	private WebElement getUserName;

	@FindBy(xpath = "//div[contains(@class,'swiper-pagination-banner')]/span")
	private List<WebElement> carouselBanner;

	@FindBy(xpath = "//div[h3[text()='Quick links']]/div/div//a")
	private List<WebElement> allLinks;

	public void getStartedLink() {
		JavaScriptUtils.highLightElement(driver, getStartedLink);
		String actText = getStartedLink.getText();
		Assert.assertEquals(actText, "Get started before signing in");
		System.out.println("User is on the contact Landing page");
	}

	public void getStartedLinkClick() throws InterruptedException {
		getStartedLink.click();
		TestUtils.sleep(3000);
	}

	public void quickLinksText() {
		TestUtils.waitForElement(driver, quickLinkText);
		JavaScriptUtils.highLightElement(driver, quickLinkText);
		String actText = quickLinkText.getText();
		Assert.assertEquals(actText, "Quick links");
	}

	public void quickLinksTiles() {
		for (int i = 0; i < allLinks.size(); i++) {
			TestUtils.waitForElement(driver, allLinks.get(i));
			JavaScriptUtils.scrollInToView(driver, allLinks.get(i));
			JavaScriptUtils.highLightElement(driver, allLinks.get(i));
			allLinks.get(i).click();
			TestUtils.sleep(2000);
			TestUtils.goBackToPreviousPage(driver);
			TestUtils.sleep(2000);
		}
	}

	public void verifyLoggedinUser(String expectedUserName) {
		TestUtils.waitForElement(driver, getUserName);
		JavaScriptUtils.highLightElement(driver, getUserName);
		String strUserName = getUserName.getText();
		String loggedinUserName = strUserName.substring(3, 17);
		System.out.println("actualuserName" + loggedinUserName);
		Assert.assertEquals(expectedUserName, loggedinUserName);
	}

	public void validateCarouselBanner() {
		if (carouselBanner.size() > 0)
			System.out.println("carousel banner is present");
		Assert.assertTrue(carouselBanner.size() > 0);
		for (int i = 0; i < carouselBanner.size(); i++) {
			TestUtils.waitForElement(driver, carouselBanner.get(i));
			JavaScriptUtils.scrollInToView(driver, carouselBanner.get(i));
			JavaScriptUtils.highLightElement(driver, carouselBanner.get(i));
		}
	}

}

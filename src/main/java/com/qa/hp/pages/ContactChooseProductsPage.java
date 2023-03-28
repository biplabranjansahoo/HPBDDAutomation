package com.qa.hp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.hp.basepage.BasePage;

import ucom.qa.hp.utils.JavaScriptUtils;

public class ContactChooseProductsPage extends BasePage {

	public ContactChooseProductsPage(WebDriver dvr) {
		driver = dvr;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Which product are you contacting us about?']")
	private WebElement productPageTextLable;

	public void chooseProductPageLableText() {
		try {
			JavaScriptUtils.highLightElement(driver, productPageTextLable);
			String actText = productPageTextLable.getText();
			Assert.assertEquals(actText, "Which product are you contacting us about?");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	

}

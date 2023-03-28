package com.qa.hp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.hp.basepage.BasePage;
import ucom.qa.hp.utils.JavaScriptUtils;
import ucom.qa.hp.utils.TestUtils;

public class HPIDLoginPage extends BasePage {

	public HPIDLoginPage(WebDriver dvr) {
		driver = dvr;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement userNameTextBox;

	@FindBy(name = "next")
	private WebElement nextButton;

	@FindBy(id = "password")
	private WebElement passwordTextBox;

	@FindBy(id = "sign-in")
	private WebElement signInButton;

	public void signIn(String userName, String password) {
			TestUtils.waitForElement(driver, userNameTextBox);
			userNameTextBox.sendKeys(userName);
			TestUtils.waitForElement(driver, nextButton);
			JavaScriptUtils.highLightElement(driver, nextButton);
			nextButton.click();
			TestUtils.waitForElement(driver, passwordTextBox);
			passwordTextBox.sendKeys(password);
			TestUtils.waitForElement(driver, signInButton);
			JavaScriptUtils.highLightElement(driver, signInButton);
			signInButton.click();
	}

}

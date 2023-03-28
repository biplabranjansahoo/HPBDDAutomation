package stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.qa.hp.basepage.BasePage;
import com.qa.hp.pages.ContactChooseProductsPage;
import com.qa.hp.pages.ContactLandingPage;
import com.qa.hp.pages.HPIDLoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ucom.qa.hp.utils.CommonUtils;
import ucom.qa.hp.utils.TestUtils;

public class ContactLandingHome extends BasePage {

	BasePage page;
	public WebDriver driver;
	ContactLandingPage cpage;
	ContactChooseProductsPage ccpage;
	CommonUtils utils;
	HPIDLoginPage hpLogin;

	public ContactLandingHome() {
		page = new BasePage();
		driver = page.inilitize();
		driver.get(prop.getProperty("url") + "/contact");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		cpage = new ContactLandingPage(driver);
		ccpage = new ContactChooseProductsPage(driver);
		utils = new CommonUtils(driver);
		hpLogin = new HPIDLoginPage(driver);
	}

	@And("user accepts cookies")
	public void accept_cookies() throws InterruptedException {
		utils.acceptCookies();
	}

	@And("user checks for the headers presence")
	public void headers_presence() throws InterruptedException {
		utils.validateHeader();
	}

	@Given("^user is on the contact landing page$")
	public void contact_landing_page() throws InterruptedException {
		cpage.getStartedLink();
	}

	@When("^user clicks on the the get started before signing in link$")
	public void clicks_get_started_link() throws InterruptedException {
		cpage.getStartedLinkClick();
	}

	@Then("^user is taken to choose products page$")
	public void choose_products_page() {
		ccpage.chooseProductPageLableText();
	}

	@Then("Quick link section is visible irrespective of user state")
	public void quick_link_section_is_visible_irrespective_of_user_state() {
		cpage.quickLinksText();
		cpage.quickLinksTiles();
	}

	@When("^user clicks on Signin button$")
	public void clicksOnSignin() {
		utils.clickSignIn();
	}

	@And("^user enters valid login credentials$")
	public void user_Signin() {
		hpLogin.signIn(prop.getProperty("username"), prop.getProperty("password"));
	}

	@And("^verify the contact logged in landing page is displayed$")
	public void verifySignedInUser() {
		cpage.verifyLoggedinUser("TestAutomation");
	}
	
	@Then("^carousel banner is present$")
	public void carousel_banner_present() {
		cpage.validateCarouselBanner();
	}

	@After(order = 1)
	public void takeScraenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			String name = scenario.getName();
			TestUtils.takeScreenShotAtEndOfTest(driver, name);
		}
	}

	@After(order = 0)
	public void tearDown() {
		driver.close();

	}

}

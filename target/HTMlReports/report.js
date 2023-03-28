$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/contactHome.feature");
formatter.feature({
  "name": "feature to test contact home page",
  "description": "  /*\n  * - Test URL \t: http://uat.support.hp.com/cc-lc/contact\n  * - Scenario 1 : Check get Started before signing in link function\n  * - Scenario 2 : Check the Quick links\n  * - \n  */",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user is on the contact landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.contact_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user accepts cookies",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.accept_cookies()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user checks for the headers presence",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.headers_presence()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check get Started before signing in link function",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "user clicks on the the get started before signing in link",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.clicks_get_started_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is taken to choose products page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.choose_products_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user is on the contact landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.contact_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user accepts cookies",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.accept_cookies()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user checks for the headers presence",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.headers_presence()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check the Quick links",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "Quick link section is visible irrespective of user state",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.quick_link_section_is_visible_irrespective_of_user_state()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user is on the contact landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.contact_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user accepts cookies",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.accept_cookies()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user checks for the headers presence",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.headers_presence()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Signin to HP Account",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "user clicks on Signin button",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.clicksOnSignin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters valid login credentials",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.user_Signin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the contact logged in landing page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.verifySignedInUser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user is on the contact landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.contact_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user accepts cookies",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.accept_cookies()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user checks for the headers presence",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.headers_presence()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate Carousel images are loading fine",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "carousel banner is present",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitions.ContactLandingHome.carousel_banner_present()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
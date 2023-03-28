Feature: feature to test contact home page
    
  /*
  * - Test URL 	: http://uat.support.hp.com/cc-lc/contact
  * - Scenario 1 : Check get Started before signing in link function
  * - Scenario 2 : Check the Quick links
  * - 
  */
  
  Background: 
  Given user is on the contact landing page
  And user accepts cookies
  And user checks for the headers presence

	@regression
  Scenario: Check get Started before signing in link function
  	Then user clicks on the the get started before signing in link
  	Then user is taken to choose products page
 		
	@regression
 	Scenario: Check the Quick links
 		Then Quick link section is visible irrespective of user state
 		
 	@regression
 	Scenario: Signin to HP Account
 		When user clicks on Signin button
 		And user enters valid login credentials
 		Then verify the contact logged in landing page is displayed
 	
 	@regression
 	Scenario: Validate Carousel images are loading fine
 		Then carousel banner is present
 		
  

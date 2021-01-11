Feature: Register Page
@tag
Scenario: Verify for registered user
		Given user is on quikr home page
		Then user is on login or register popup
  		When user enters valid <userid> <name> <email> <password>
  		Then user is logged in
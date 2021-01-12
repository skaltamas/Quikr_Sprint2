Feature: Register Page
@tag
Scenario Outline: Verify for registered user
		Given user is on quikr home page
		When user is on login or register popup
  	And user enters <registerid> <name> <email> <pwd>
  	Then user is registered
  	
Examples:
  |registerid|name|email|pwd|
  |7977722545|Jyotsna|jyotsnapangrekar123@gmail.com|pass@1234|
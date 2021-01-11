#Author: Altamas Shaikh

@tag
Feature: Login

 Scenario: Verify login popup
  Given user is on quikr home page
  When user clicks on login or register
  Then login popup is displayed

 Scenario Outline: Verify login with invalid credentials
  Given user is on login popup
  When user enters invalid <userid> <password>
  Then user is not logged in
  
  Examples:
  |userid|password|
  |skaltamas123@gmail.com|clever2016|

 Scenario Outline: Verify login with valid credentials
  Given user is on login popup
  When user enters valid <useridd> <passwordd>
  Then user is logged in
  
  Examples:
  |useridd|passwordd|
  |skaltamas123@gmail.com|pass123|
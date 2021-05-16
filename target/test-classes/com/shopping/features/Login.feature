#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: MyStore Login page details

Scenario: My Store Login title verification
Given User is on Login page
When User gets page title
And Title should be "Login - My Store"

Scenario: Verify user is able to Login My store
Given User is on Login page
When User enters the username as "rajesh.vadlamudi999@gmail.com"
When User enters the password as "Mystore"
And User clicks on Login button
Then User gets page title
And Title of the home page should be "My account - My Store"










@All
Feature: My Account page details

Background:
Given User login into Shopping site
|username|password|
|rajesh.vadlamudi999@gmail.com|Mystore|



Scenario: MyAccount details page title
Given User is on MyAccount details page
When User gets page title
When Title of the home page should be "My account - My Store"


Scenario: My Account details page options for selection
Given User is on MyAccount details page
When Account section "MY ACCOUNT" is available
Then Options should be available
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
And options count should be 6


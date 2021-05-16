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
When Account section is available
Then Options should be available
|Order history and details|
|My credit slips|
|My addresses|
|My personal information|
|My wishlists|
And options count should be 5


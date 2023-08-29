Feature: Fuctionality Register

Scenario: User should be able to create account by entering in mandatory fields
Given User navigates to register page
When user enters below details
|firstname|Mayur|
|lastname|Bhalerao|
|email|nikche.bhalerao@gmail.com|
|telephone|28828282828|
|password|39865|
|confirmpassword|39865|
And clicks on privacy policy checkbox
And clicks on continue button
Then new account should get created

Scenario: User should be to create account by entering in all fields
Given User navigates to register page
When user enters below details
|firstname|Kiran|
|lastname|Saswadkar|
|email|akche.saswadkar@gmail.com|
|telephone|992929992|
|password|89387|
|confirmpassword|89387|
And clicks on yes radio button
And clicks on privacy policy checkbox
And clicks on continue button
Then new account should get created 

Scenario: User should not be able to create acc without entering any detail
Given User navigates to register page
When clicks on privacy policy checkbox
And clicks on continue button
Then user should get warning msg
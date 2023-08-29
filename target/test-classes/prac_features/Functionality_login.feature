Feature: login functionality

Scenario Outline: User should login with valid credentials
Given User navigates to login page
When user enters valid email <email> and password <password>
And clicks on login button
Then user should logged in
Examples:
|email         |password  |
|kenjale.akshayc@gmail.com|123456|
|bhaleraomayur@gmail.com  |93090 |
|saswadkarkiran@gmail.com |888333|

Scenario: User should not logged in with invalid email
Given User navigates to login page
When user enters invalid email "akakak@gmail.com" and password "123456"
And clicks on login button
Then User should get warning msg

Scenario: User should not logged in with invalid password
Given User navigates to login page
When user enters valid email "kenjale.akshayc@gmail.com" and invalid password "928929"
And clicks on login button
Then User should get warning msg

Scenario: User should not logged in with invalid credentials
Given User navigates to login page
When user enters invalid email "akakakak@gmail.com" and invalid password "aoakj"
And clicks on login button
Then User should get warning msg







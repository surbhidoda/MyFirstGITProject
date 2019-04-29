Feature: Login functionality
@RegressionTest
Scenario: Test Successfull Login

Given User is on home page
When user enters username and password
|username|password|
|surbhi.doda@gmail.com|Success@2019|
And clicks login  button
Then login is successful


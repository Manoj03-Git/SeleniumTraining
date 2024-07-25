Feature: To validate the Login Functionality of facebooke application

Scenario: To validate Login With Valid username and valid password
Given To launch the Browser and Maximize the window
When To launch the URL of the facebook Application
And To pass Valid username in email field
And To pass valid Password in password field
And To click the login button
And To check Whether the page Navigate to home page or Not
Then To Close the Browser  

Scenario Outline: To Validate the positive and negative combination of login functionality
Given User has To launch the browser and mazimize the window
When User has To hit the facebook url 
And  User has To pass the data "<emaildatas>" in email field
And  User has To pass the data "<passworddatas>" in password field
And User has To click login button
Then  User has To close the browser

Examples:
|emaildatas               |passworddatas|
|seleniuminmakes@gmail.com|Inmakes      |
|abc@gmail.com            |0015151      |
|inmakes@gmail.com        |selenium     |
|frameworks@gmail.com     |cucumber     |
|manualtestin@gmail.com   |626262       |
|apitesting@gmail.com     |restassured  |
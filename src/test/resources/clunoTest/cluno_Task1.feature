Feature: Addition Test Cases

@test1
Scenario Outline: Testcase 3 : Damage should be uploaded only after all the fields are filled
Given Navigate to Cluno url 
When User enters "<partNum>" and miss to enter either damage type or image
Then click upload button 
And User should observe error message
And Quit the browser

Examples: 
			|partNum|
			|7|

@test1
Scenario Outline: Testcase 4 : Selecting multiple damage options for one vehicle partners
Given Navigate to Cluno url
When User selects any exterior damage "<part>"
Then User should be able enter the data by selecting multiple damage options
And click close button
And User should validate the Damage type and image uploaded
And User should navigate to home page and close the browser
And Quit the browser

Examples: 
			|part|
			|22|
			|10|
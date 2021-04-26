Feature: Cluno Testcases

@test
Scenario: Testcase 1 : Add Interior Damages
Given Navigate to Cluno url
When User navigates to Cluno Homepage and clicks on Add Damage under Interior
Then User should Navigate to Add damage page 
And User should add damage for rear view mirror
And User should add damage for back seat tear
And User clicks on close button and navigates to homepage
And User should add damage to dent on driver's side door
And User should click back to navigate to home page 
And User should add damage to scratch on driver's side door
And User should click back to navigate to home page
And User should add damage to scratch on driver's side front rim
And User should click back to navigate to home page
When User clicks on Check and Submit
Then User should click yes on confirmation pop-up
And User should be able to submit the report


@test
Scenario: Testcase 2 : Edit error report
When User clicks on entry in eighteen
Then User should update damage and clicks back button
When User clicks on entry in eighteen again
Then User removes the damage added and clicks back button
When User clicks on entry in twenty one
Then User updates the damage and clicks back button
When User clicks on Check and Submit
Then User should click no on confirmation pop-up
And User should be able to submit the report
And Quit the browser




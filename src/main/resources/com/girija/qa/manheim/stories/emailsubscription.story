Story: Verify email subscription module

Meta:
@page home
@module email


Narrative: 

In order to be reminded of upcoming shoe releases 
As a user of the Shoe Store
I want to be able to submit my email address

Scenario: email subscription Happy path

Given I am on shoestore-manheim
When I enter valid e-mail in an area to submit email address and submit  
Then I should get <Thanks! We will notify you of our new shoes at this email: users email> message  
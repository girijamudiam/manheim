Story: Display upcoming shoe releases by month

Meta:
@page shoeresults
@module shoeresults


Narrative: 

In order to view upcoming shoes being released every month 
As a user of the Shoe store 
I want to be able to visit a link for each month and see the shoes being released

Scenario: Display Shoes for each month

Given I am on shoestore-manheim
When I select a month for shoe release  
Then month should display a small Blurb of each shoe
Then Month should display an image each shoe being released
Then shoe should have a suggested price pricing

Examples: 
|month    |blurb                                                                                                   |image                         |price|
|January  |0=Jimmy Choo Jimmy Choo Pumps Shoes;1=Brian Atwood 'Tribeca Laser' Sandal;4=Sandal Jimmy Choo Jimmy Choo|0=_7548482.jpg;4=_7383352.jpg|1=$1,695.00;4=$1,495.00     |
|May      |0=BRIAN ATWOOD Brian Atwood Sandals/Slides Shoes;1=LANVIN Lanvin Sandals/Slides Shoes Adjustable strap  |0=_7397732.jpg;1=_7351975.jpg |0=$1,995.00;1=$1,590.00     |
|December |               |     |     |

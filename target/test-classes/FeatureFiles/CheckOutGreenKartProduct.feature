Feature: Search and Place Order from GreenKart

@GreenKart
Scenario Outline: CheckOut Product


Given User is on Greenkart Landing Page
When User searched with shortname "<ShortName>" and extracted product name
And Added "3" itmes of selected product to cart
Then User proceeds to Checkout 
And User validate "<ShortName>" in checkout page
And User validate item quantity "3" in checkout page
And User has ability to enter promocode and place order

Examples:

| ShortName |
| Tom       |
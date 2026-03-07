Feature: Search and Place Order from GreenKart

@GreenKart
Scenario Outline: Search Experience in both Home and Offers Page


Given User is on Greenkart Landing Page
When User searched with shortname "<ShortName>" and extracted product name
Then User click on Top Deals
Then User searched for same shortname "<ShortName>" in offers page 
And Check product exists

Examples:

| ShortName |
| Tom       |
| Beet      |
Feature: Purchase Order on Ecomm Site

#Background:
#  Given User Landed on Ecommerce Page

@OrderSubmit
Scenario Outline: Submitting Order

  Given User logged in to application
    | Username | <Username> |
    | Password | <Password> |  
    
  Then "Login Successfully" message displayed on login page

  When User added product to cart
    | Products  | <Products> |
    

  And User Verify Cart Products and CheckOut
    | Products  | <Products> |
    

  And User Place Order

  Then "THANKYOU FOR THE ORDER1." message displayed on confirmation page

Examples:
| Username      | Password  | Products    |
| Gpd@gmail.com | Kolkata@1 | ZARA,ADIDAS |

@ErrorValidation @OrderSubmit 
Scenario Outline: Login Error Validation

  Given User logged in to application
    | Username | <Username> |
    | Password | <Password> |

  Then "Incorrect email or password." message displayed on login page

Examples:
| Username      | Password  |
| Gpd@gmail.com | Kolkata@2 |



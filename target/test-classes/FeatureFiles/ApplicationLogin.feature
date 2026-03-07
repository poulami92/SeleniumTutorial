Feature: Application Login

Background: 
#Given setup database entries
And User launch browser
And Hit banking home page url


@AppLogin
Scenario Outline: Admin page default login

Given User is on NetBanking landing page
When User logged in to banking application with "<Username>" and password "<Password>"
Then Home Page is displayed
And Cards are displayed

Examples:

| Username | Password |
| admin    | 1234     |
| user     | 5678     |

@AppLogin @PracticeLogin
Scenario: User Page Sign Up

Given User is on Practice landing page
When User Signup into application
| FirstName | LastName | Email          | PhoneNo    |
| Rahul     | Shetty   | ahha@gmail.com | 9933476778 |
Then Home Page is displayed
And Cards are displayed

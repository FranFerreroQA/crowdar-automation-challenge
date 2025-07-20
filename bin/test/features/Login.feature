@login 
Feature: Login

    Login to Swag Labs

    Background:
        Given the user navigates to Swag Labs login page

    Scenario: 1 (Happy path) - Sign in with valid credentials
        When he enters username standard_user and password secret_sauce
        And clicks the login button
        Then the user should have access to the Products Page

    Scenario Outline: 2 (Negative) - Do not sign in with invalid credentials
        When he enters username <username> and password <password>
        And clicks the login button
        Then an error message should be displayed
        And the user should not have access to the website
    
        Examples:
        | username        | password      |
        | standard_user   | secretsauce   |
        | standarduser    | secret_sauce  |
        | standard_user   | secretsauc    |

    Scenario: 3 (Negative) - Do not sign in with a locked-out user / Intentional failure test
        When he enters username locked_out_user and password secret_sauce
        And clicks the login button
        Then an informative message should be displayed
        And the user should not have access to the website

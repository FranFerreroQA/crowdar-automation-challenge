@products 
Feature: Products

    View and purchase products inventory

    Scenario: Background
        Given the user has successfully logged in to Swag Labs
        And is on the Products Page

    Scenario: 1 (Happy Path) - The user buys some products
        Given the user adds some items to the shopping cart
        When he proceeds to checkout
        And he completes the billing information
        Then he should see the purchase overview and be able to complete the payment
        And a thank-you message should be displayed, allowing the user to continue shopping
    
    Scenario Outline: 2 (Positive) - The user selects sorting options for the inventory / Intentional failure test
        Given The inventory is sorted by name from A to Z by default
        When the user selects to sort products by <sortBy>
        Then the products inventory should be reordered
    
        Examples:
        | sortBy              |
        | Name (Z to A)       |
        | Name (A to Z)       |
        | Price (low to high) |
        | Price (high to low) |

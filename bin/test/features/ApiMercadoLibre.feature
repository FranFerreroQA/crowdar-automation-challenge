@apiml
Feature: API Mercado Libre

    API interactions with Mercado Libre

    Scenario: Retrieve departments list
        When I request the departments from Mercado Libre
        Then the response should contain a list of departments

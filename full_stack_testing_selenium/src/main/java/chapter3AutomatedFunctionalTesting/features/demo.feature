Feature: Get available products

  Background:
    * url 'https://api.example.com'

  Scenario: Get all available products
    Given path '/products'
    When method GET
    Then status 200
    And match response contains { id: '#number', name: '#string', category: '#string' }

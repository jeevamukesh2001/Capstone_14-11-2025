Feature: Cart Page
@Cart
Scenario Outline: View the added product in the cart page
    Given the user launch the "<browser>" browser
    When the user accept the cookies in the browser
    When the user click the options in menu
    When the user verifies the page title
    When the user selects a product
    
    When the user chooses color and size
    When the user adds the product to the cart
    
    When the user views the cart
    Then the cart should display the name of the selected product
    Then the cart should display the price of the selected product
    When the user clicks on the checkout button
 
Examples:
    | browser |
    | Chrome  |
    | Edge    |
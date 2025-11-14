Feature: Add the Product

Scenario Outline: Add the Product in the cart
    Given the user launch the "<browser>" browser
    When the user accept the cookies in the browser
    When the user click the options in menu
    When the user verifies the page title
    When the user selects a product
    When the user chooses color and size
    When the user adds the product to the cart

Examples:
    | browser |
    | Chrome  |
    | Edge    |
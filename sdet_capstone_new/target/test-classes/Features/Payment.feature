Feature: Payment process for ordering the produuct
@Payment
  Scenario Outline: place the order
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
    Then the user should be redirected to the checkout page
    
    When the user enters shipping details
    When the user proceeds with the payment
    
    When the user select the payment method
    When the user click the place order button
    Then the order will be placed successfully

    Examples:
      | browser |
      | Chrome  |
      | Edge    |
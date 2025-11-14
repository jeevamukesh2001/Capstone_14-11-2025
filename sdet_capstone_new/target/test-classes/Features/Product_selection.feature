Feature: Product Selection
@Productselect
  Scenario: Select a product in the selection page
  Given the user launch the "<browser>" browser
  When the user accept the cookies in the browser
  When the user click the options in menu
  When the user verifies the page title
  When the user selects a product
  
  Examples:
  |browser|
  |Chrome |
  |Edge   |
    

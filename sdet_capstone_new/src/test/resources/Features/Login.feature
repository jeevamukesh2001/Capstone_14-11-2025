Feature: E-commerce Login
@Login
  Scenario Outline: Login with credentials
  Given the user launches the "<browser>" browser
  When the user accept the cookies
  When the user click the profile icon
  When the user click the login button
  When the user click login with email and password option
  When the user enter the "<username>"
  When the user enter the particular user "<password>"
  When the user clicks the login button
  When the user again click the profile icon
  Then the login result should be "<expectedResult>"

  Examples:
    | browser | username               | password      | expectedResult        |
    | Chrome  | jeevamukesh2@gmail.com | Jeeva@2001    | Hello, Jeeva          |
    | Edge    | jeevamukesh2@gmail.com | Jeeva@2001    | Hello, Jeeva          |
    
    
    
     #| browser | username               | password      | expectedResult |
    #| Chrome  | jeevamukesh2@gmail.com | Jeeva@2001    | Jeeva          |
    #| Edge    | jeevamukesh2@gmail.com | Jeeva@2001    | Jeeva          |
#        | Chrome  | jeeva@gmail.com        | jeeva_2001    | error          |
#    | Edge    | jeeva@gmail.com        | jeeva_2001    | error          |
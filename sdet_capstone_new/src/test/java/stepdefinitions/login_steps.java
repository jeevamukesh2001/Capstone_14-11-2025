package stepdefinitions;

import io.cucumber.java.en.*;

import org.apache.log4j.Logger;
import org.testng.Assert;
import pages.Homepage;
import pages.Loginpage;
import utilities.CommonMethods;

public class login_steps extends CommonMethods {

    Logger log = Logger.getLogger(login_steps.class);
    Homepage homepage;
    Loginpage login;

    @Given("the user launches the {string} browser")
    public void the_user_launches_the_browser(String browser) {
        launchBrowser(browser);
        homepage = new Homepage(dr);
        login = new Loginpage(dr);
        log.info("Browser launched: " + browser);
    }

    @When("the user accept the cookies")
    public void the_user_accept_the_cookies() {
        homepage.cookies();
        log.info("Cookies accepted");
    }

    @When("the user click the profile icon")
    public void the_user_click_the_profile_icon() {
        login.clickProfile();
        log.info("Profile icon clicked");
    }

    @When("the user click the login button")
    public void the_user_click_the_login_button() {
        login.loginclick();
        log.info("Login button clicked");
    }

    @When("the user click login with email and password option")
    public void the_user_click_login_with_email_and_password_option() throws InterruptedException {
        login.credentialslink();
        log.info("Email/Password option clicked");
    }

    @When("the user enter the {string}")
    public void the_user_enter_the_username(String value) {
            login.enterUsername(value);
            log.info("Entered username: " + value);
    }
    
    @When("the user enter the particular user {string}")
    public void the_user_enter_the_particular_user_password(String value) {
            login.enterPassword(value);
            log.info("Entered password");
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        login.submitlogin();
        log.info("Login submitted");
    }
    
    @When("the user again click the profile icon")
    public void the_user_again_click_the_profile_icon2() {
        login.profile2();
        log.info("Profile icon clicked");
    }

    @Then("the login result should be {string}")
    public void the_login_result_should_be(String expectedResult) {
        login.account();
        Assert.assertEquals(login.user(), expectedResult);
    }
}
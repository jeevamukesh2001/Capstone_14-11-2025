package stepdefinitions;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Checkout;
import utilities.CommonMethods;
import utilities.configreader;

public class checkout_steps extends CommonMethods {

    Checkout checkoutPage;
	configreader config = new configreader();
	Logger log = Logger.getLogger(checkout_steps.class);
    @Then("the user should be redirected to the checkout page")
    public void the_user_should_be_redirected_to_the_checkout_page() {
        checkoutPage = new Checkout(dr);
        String title = checkoutPage.gettitle();
        log.info("Checkout Page Title: " + title);
    }

    @When("the user enters shipping details")
    public void the_user_enters_shipping_details() {
    	String first = config.getProperty("fn");
        String last = config.getProperty("ln");
        String pincode = config.getProperty("pin");
        String address1 = config.getProperty("address1");
        String address2 = config.getProperty("address2");
        String city = config.getProperty("cityname");
        String email = config.getProperty("email");
        String phone = config.getProperty("phoneno");
        checkoutPage.shipping(first, last, pincode, address1, address2, city, email, phone);
        log.info("Entered Shipping details");
    }

    @When("the user proceeds with the payment")
    public void the_user_proceeds_with_the_payment() {
        checkoutPage.paymentprocess();
        log.info("Click continue to payment");
    }
}
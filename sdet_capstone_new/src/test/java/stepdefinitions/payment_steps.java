package stepdefinitions;

import io.cucumber.java.en.When;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Then;
import pages.Payment;
import utilities.CommonMethods;

public class payment_steps extends CommonMethods {

    Payment paymentPage;
    Logger log = Logger.getLogger(payment_steps.class);

    @When("the user select the payment method")
    public void the_user_select_the_payment_method() {
        paymentPage = new Payment(dr);
        paymentPage.paymentoption();
        log.info("Payment method selected");
    }

    @When("the user click the place order button")
    public void the_user_click_the_place_order_button() {
        paymentPage.orderproduct();
        log.info("Place order button clicked");
    }

    @Then("the order will be placed successfully")
    public void the_order_will_be_placed_successfully() {
    	closeBrowser();
        log.info("Order is placed");
    }
}
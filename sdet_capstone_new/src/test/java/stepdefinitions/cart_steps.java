package stepdefinitions;

import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pages.Cartpage;
import pages.Product_add;
import utilities.CommonMethods;

public class cart_steps extends CommonMethods {

    Logger log = Logger.getLogger(cart_steps.class);
    Product_add productAddPage;
    Cartpage cart;

    @When("the user views the cart")
    public void the_user_views_the_cart() throws InterruptedException {
    	productAddPage = new Product_add(dr);
    	cart = new Cartpage(dr);
        productAddPage.viewcart();
    }

    @Then("the cart should display the name of the selected product")
    public void the_cart_should_display_the_name_of_the_selected_product() {
        String productname = cart.getproductname();
        Assert.assertEquals(productname, "Ascenso Sneakers");
        log.info("Product name verified");
    }
    
    @Then("the cart should display the price of the selected product")
    public void the_cart_should_display_the_price_of_the_selected_product() {
        String productprice = cart.getproductprice();
        Assert.assertEquals(productprice, "₹5,199");
        log.info("Product price verified");
    }
    
    @When("the user clicks on the checkout button")
    public void the_user_clicks_on_the_checkout_button() {
    	cart.clickcheckout();
    	log.info("Click checkout button");
    }
}
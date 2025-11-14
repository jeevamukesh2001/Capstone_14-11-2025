package stepdefinitions;

import org.apache.log4j.Logger;

import io.cucumber.java.en.When;
import pages.Product_add;
import utilities.CommonMethods;

public class product_add_steps extends CommonMethods {

    Product_add productAddPage;
    Logger log = Logger.getLogger(product_add_steps.class);

    @When("the user chooses color and size")
    public void the_user_chooses_color_and_size() {
        productAddPage = new Product_add(dr);
        productAddPage.chooseproductsize();
        log.info("Color and size selected successfully");
    }

    @When("the user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() {
        productAddPage.addtocart();
        log.info("Product added to cart successfully");
    }
}
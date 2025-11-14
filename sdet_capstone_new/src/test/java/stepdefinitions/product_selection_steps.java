package stepdefinitions;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import pages.Homepage;
import pages.Product_selection;
import utilities.CommonMethods;

public class product_selection_steps extends CommonMethods {
    Homepage home;
    Product_selection productPage;
    Logger log = Logger.getLogger(product_selection_steps.class);
    @Given("the user launch the {string} browser")
    public void the_user_launches_the_browser(String browser) {
		launchBrowser(browser);
		home = new Homepage(dr); 
    }

    @When("the user accept the cookies in the browser")
    public void the_user_accept_the_cookies() {
        home.cookies();
        log.info("Cookies accepted");
    }

    @When("the user click the options in menu")
    public void the_user_click_the_options_in_menu() {
        productPage = new Product_selection(dr);
        productPage.chooseproductcategory();
    }

    @When("the user verifies the page title")
    public void the_user_verifies_the_page_title() {
        String title = productPage.gettitle();
        log.info("Page Title: " + title);
    }

    @When("the user selects a product")
    public void the_user_selects_a_product() {
        productPage.chooseproduct();
        log.info("Product Selected from the Product page");
    }
}
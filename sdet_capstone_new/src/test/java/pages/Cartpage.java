package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import utilities.CommonMethods;

public class Cartpage extends CommonMethods {
	
	@FindBy(xpath = "//h1[contains(text(),\"My Shopping Cart\")]")
	WebElement cart;
	
    @FindBy(xpath = "//h4[contains(text(),\"Grand total\")]")
    WebElement Total;

    @FindBy(xpath = "//a[@data-test-id=\"cart-summary-checkout\"]")
    WebElement checkoutbutton;
    
    @FindBy(xpath = "//div//h3[contains(text(),\"Ascenso Sneakers\")]")
    WebElement productname;
    
    @FindBy(xpath = "//div//span[contains(text(),\"₹5,199\")]")
    WebElement productprice;

    Logger log = Logger.getLogger(Cartpage.class);
    protected WebDriver dr;

    public Cartpage(WebDriver dr) {
    	this.dr=dr;
        PageFactory.initElements(dr, this);
        PropertyConfigurator.configure("src\\test\\resources\\log4j.properties");
    }
    
    public String getproductname() {
    	fluentwait(dr,productname,10,"visibility");
    	return productname.getText().trim();
    }
    
    public String getproductprice() {
    	fluentwait(dr,productprice,10,"visibility");
    	return productprice.getText().trim();
    }

    public void clickcheckout() {
    	scrollIntoView(Total);
    	explicitwait(dr,checkoutbutton,10,"visibility");
    	checkoutbutton.click();
    }
}
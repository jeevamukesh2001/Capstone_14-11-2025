package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;

public class Payment extends CommonMethods {
    protected WebDriverWait wait;
    Logger log = Logger.getLogger(Payment.class);
    
    @FindBy(xpath = "//div[@data-test-id=\"payment-method-option\"]")
    private WebElement paymentoption;
    
    @FindBy(xpath = "//button[@data-test-id=\"place-order\"]")
    private WebElement placeorder;
    
    @FindBy(xpath = "//div[@id=\"razorpay-checkout-v2-container\"]")
    private WebElement gateway;
    
    protected WebDriver dr;

    public Payment(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
        PropertyConfigurator.configure("src\\test\\resources\\log4j.properties");
    }
    
    public void paymentoption() {
    	fluentwait(dr,paymentoption,10,"clickable");
    	paymentoption.click();
    }
    
    public void orderproduct() {
    	explicitwait(dr,placeorder,10,"visibility");
    	explicitwait(dr,placeorder,10,"clickable");
    	placeorder.click();
    }
}
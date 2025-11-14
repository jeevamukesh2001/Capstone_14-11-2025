package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;

public class Checkout extends CommonMethods {
    protected WebDriverWait wait;
    Logger log = Logger.getLogger(Checkout.class);
    
    @FindBy(xpath="//h1[contains(text(),\"Checkout\")]")
    private WebElement checkouttext;

    @FindBy(xpath="//fieldset[@data-test-id=\"shipping-address-fields\"]")
    private WebElement form;

    @FindBy(id = "shipping-address-first-name")
    private WebElement fn;

    @FindBy(id = "shipping-address-last-name")
    private WebElement ln;

    @FindBy(id = "shipping-address-postal-code")
    private WebElement pincode;

    @FindBy(id = "shipping-address-address1")
    private WebElement address1;
    
    @FindBy(id = "shipping-address-address2")
    private WebElement address2;

    @FindBy(id = "shipping-address-city")
    private WebElement city;

    @FindBy(id = "shipping-address-state-code")
    private WebElement state;
    
    @FindBy(id = "email")
    private WebElement email;
    
    @FindBy(id = "phone-number")
    private WebElement phone;
    
    @FindBy(xpath = "//legend[contains(text(),\"Enter a Billing Address\")]")
    private WebElement billing;
    
    @FindBy(xpath = "//button[@data-test-id=\"continue-to-payment\"]")
    private WebElement payment;
    
    protected WebDriver dr;

    public Checkout(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
        PropertyConfigurator.configure("src\\test\\resources\\log4j.properties");
    }
    
    public String gettitle() {
    	fluentwait(dr,checkouttext,10,"visibility");
    	return checkouttext.getText();
    }

    public void shipping(String first, String last, String pin, String resaddress1, String resaddress2, String ccity, String emailid, String phoneno) {
        scrollIntoView(form);
        fn.clear();
        fn.sendKeys(first);
        ln.clear();
        ln.sendKeys(last);
        pincode.clear();
        pincode.sendKeys(pin);
        address1.clear();
        address1.sendKeys(resaddress1);
        address2.clear();
        address2.sendKeys(resaddress2);
        city.clear();
        city.sendKeys(ccity);
        scrollIntoView(state);
        email.sendKeys(emailid);
        phone.sendKeys(phoneno);
    }
    
    public void paymentprocess() {
        scrollIntoView(billing);
    	payment.click();
    }
}
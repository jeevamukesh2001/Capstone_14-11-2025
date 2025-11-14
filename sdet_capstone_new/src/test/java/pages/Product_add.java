package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;

public class Product_add extends CommonMethods {
    protected WebDriverWait wait;
    Logger log = Logger.getLogger(Product_add.class);
    
    @FindBy(xpath = "//label[@data-color=01]")
    private WebElement color; 
    
    @FindBy(xpath = "//div[@id=\"size-picker\"]//label[2]")
    private WebElement size;
    
    @FindBy(xpath = "//span[@data-uds-child=\"text-label\"]")
    private WebElement addwish;
    
    @FindBy(xpath = "//button[@data-test-id=\"add-to-cart-button\"]")
    private WebElement addcart;
    
    @FindBy(xpath = "//div[@data-test-id=\"minicart-actions\"]")
    private WebElement viewcart;
    
    protected WebDriver dr;

    public Product_add(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
        PropertyConfigurator.configure("src\\test\\resources\\log4j.properties");
    }
    
    public void chooseproductsize() {
    	explicitwait(dr,color,10,"visibility");
    	click(color);
    	explicitwait(dr,size,20,"visibility");
    	click(size);
    }
    
    public void addtocart() {
    	fluentwait(dr,addwish,10,"visibility");
    	scrollIntoView(addwish);
    	click(addcart);
    }
    
    public void viewcart() {
    	fluentwait(dr,viewcart,10,"visibility");
    	viewcart.click();
    }

}
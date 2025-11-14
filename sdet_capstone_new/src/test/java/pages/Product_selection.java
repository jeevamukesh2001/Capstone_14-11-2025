package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;

public class Product_selection extends CommonMethods {
    protected WebDriverWait wait;
    Logger log = Logger.getLogger(Product_selection.class);
    
    @FindBy(linkText = "New")
    private WebElement newproducts;

    @FindBy(xpath = "//ul[@aria-label=\"New Arrivals\"]//a[contains(text(),\"Men's New Arrivals\")]")
    private WebElement men;
    
    @FindBy(xpath = "//h1[@data-test-id=\"product-results\"]")
    private WebElement menspage;
    
    @FindBy(xpath = "//h3[contains(text(),\"Ascenso Sneakers\")]")
    private WebElement product;
    
    protected WebDriver dr;

    public Product_selection(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
        PropertyConfigurator.configure("src\\test\\resources\\log4j.properties");
    }
    
    public void chooseproductcategory() {
    	Actions act=new Actions(dr);
    	act.moveToElement(newproducts).perform();
    	explicitwait(dr,men,10,"clickable");
    	men.click();
    }
    
    public String gettitle() {
    	explicitwait(dr,menspage,10,"visibility");
    	String text = menspage.getText();
    	return text;
    }
    
    public void chooseproduct() {
    	fluentwait(dr,product,10,"visibility");
    	Actions act = new Actions(dr);
    	act.moveToElement(product).perform();
    	click(product);
    }

}
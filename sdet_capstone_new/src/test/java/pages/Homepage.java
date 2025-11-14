package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;

public class Homepage extends CommonMethods {
    protected WebDriverWait wait;
    Logger log = Logger.getLogger(Homepage.class);
    
    @FindBy(xpath = "//div[contains(text(),\"Allow\")]")
    private WebElement cookies;
    
    protected WebDriver dr;
   
    public Homepage(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
        PropertyConfigurator.configure("src/test/resources/log4j.properties");
    }
    
    public void cookies() {
    	cookies.click();
    }

}
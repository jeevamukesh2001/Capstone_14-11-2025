package pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;

public class Loginpage extends CommonMethods {
    Logger log = Logger.getLogger(Loginpage.class);

    @FindBy(xpath = "//button[@data-uds-child='popover-trigger']")
    private WebElement profile;

    @FindBy(xpath = "//div[@data-uds-child='popover-body']")
    private WebElement box1;

    @FindBy(xpath = "//button[@data-test-id='login-button']")
    private WebElement loginbutton;

    @FindBy(xpath = "//button[@data-test-id='otp-login-with-email-password']")
    private WebElement emailpass;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement pass;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginapp;

    @FindBy(xpath = "//p[contains(text(),'Enter your email and password to log in')]")
    private WebElement form;

    @FindBy(xpath = "//p[@data-test-id=\"login-form-error-content\"]")
    private WebElement error;
    
    @FindBy(id="sf-connect2-companion")
    WebElement iframe;
    
    @FindBy(xpath = "//button[@aria-label='Close']")
    WebElement close;
    
    @FindBy(xpath = "//div[@data-test-id=\"quicklinks-popout-body\"]//a[contains(text(),\"My Account\")]")
    WebElement myac;
    
    @FindBy(xpath = "//div[@data-uds-child=\"stack\"]//h1[@data-test-id=\"account-greeting\"]")
    WebElement user;

    protected WebDriver dr;

    public Loginpage(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
        PropertyConfigurator.configure("src\\test\\resources\\log4j.properties");
    }
    
    public void overlay() {
        try {
        	WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
            log.info("Switched to iframe.");
            wait.until(ExpectedConditions.elementToBeClickable(close)).click();
            log.info("Overlay closed.");
          	dr.switchTo().defaultContent();
        } catch (NoSuchElementException e) {
            log.info("No overlay iframe found.");
        } catch (TimeoutException e) {
            log.error("Iframe or close button not found within timeout.");
        }
    }

    public void clickProfile() {
    	profile.click();
    	log.info("Profile button clicked.");
    }
    
    public void loginclick() {
        Actions act = new Actions(dr);
        act.moveToElement(box1).perform();
        scrollIntoView(loginbutton);
        loginbutton.click();
        log.info("Login button clicked.");
    }

    public void credentialslink() {
        overlay();
        emailpass.click();
        log.info("Email/Password option clicked.");
    }

    public void enterUsername(String emailId) {
        email.sendKeys(emailId);
    }

    public void enterPassword(String password) {
        pass.sendKeys(password);
    }

    public void submitlogin() {
        scrollIntoView(loginapp);
        explicitwait(dr,loginapp,20,"clickable");
        loginapp.click();
        log.info("Login submitted.");
        explicitwait(dr,profile,10,"visibility");
    }
    
    public void profile2() {
    	Actions act = new Actions(dr);
    	act.moveToElement(profile).perform();
        explicitwait(dr, profile, 100, "clickable");
        profile.click();
        log.info("Profile icon clicked after login.");
    }

    public String getErrorMessage() {
        scrollIntoView(form);
        fluentwait(dr, error, 5, "visibility");
        String errorMsg = error.getText().trim();
        log.info("Error message: " + errorMsg);
        return errorMsg;
    }
    
    public void account() {
        profile2(); // Click profile icon again
        wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        explicitwait(dr,myac,10,"clickable");
        myac.click();
        log.info("My Account clicked successfully.");
    }
    
    public String user() {
        wait = new WebDriverWait(dr, Duration.ofSeconds(30));
        WebElement greeting = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id=\"puma-skip-here\"]/div[1]/div[2]/div/div[1]/div/div/h1")
        ));
        return greeting.getText().trim();
    }
}
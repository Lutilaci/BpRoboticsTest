package page;

import config.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

// Can I have a review pls?

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    final String BASE_URL = "https://icy-mushroom-0411fdf0f.1.azurestaticapps.net/";
    final String ADMIN_USER_NAME = "MainAdmin";
    final String PARTNER_USER_NAME = "RepairMan";
    final String CUSTOMER_USER_NAME = "ILoveRefrigerators";
    final String PASSWORD = "1234";

    @FindBy(css = "div:nth-of-type(2) > .form-control") WebElement passwordField;
    @FindBy(css = "div:nth-of-type(1) > .form-control") WebElement userNameField;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/form/button") WebElement loginButton;

    public BasePage(){
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void login(String userType){
        openUrl( "login");
        waitForWebElementToBePresent(userNameField);

        switch (userType){
            case "admin":
                userNameField.sendKeys("ADMIN_USER_NAME");
                break;
            case "partner":
                userNameField.sendKeys("PARTNER_USER_NAME");
                break;
            case "customer":
                userNameField.sendKeys("CUSTOMER_USER_NAME");
                break;
        }

        passwordField.sendKeys(PASSWORD);
        loginButton.click();
    }

    public void openUrl(String url){
        driver.get(BASE_URL + url);
    }

    public void waitForWebElementToBePresent(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));}

    public void waitForElementToSendText(WebElement webElement, String text){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(text);}

    public void waitForElementToClick(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();}

    public static void clickButton(WebElement webElement){webElement.click();}

    public static String nullToEmptyString(String string) {
        return Objects.requireNonNullElse(string, "");
    }

//    public static boolean validatePermissions(){
//
//    }

}
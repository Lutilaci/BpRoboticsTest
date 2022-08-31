package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends BasePage{

    @FindBy (css = ".btn.btn-primary") public WebElement plusButton;
    @FindBy (id = "users") public WebElement selectUser;
    @FindBy (css = "input#formBasicText") public WebElement companyNameField;
    @FindBy (css = "div:nth-of-type(3) > input#formBasicText") public WebElement VATNumberField;
    @FindBy (css = "div:nth-of-type(4) > input#formBasicText") public WebElement billingZipCodeField;
    @FindBy (css = "div:nth-of-type(5) > input#formBasicText") public WebElement billingCountryField;
    @FindBy (css = "div:nth-of-type(6) > input#formBasicText") public WebElement billingCityField;
    @FindBy (css = "div:nth-of-type(7) > input#formBasicText") public WebElement billingAddressField;
    @FindBy (css = "div:nth-of-type(8) > input#formBasicText") public WebElement shippingZipCodeField;
    @FindBy (css = "div:nth-of-type(9) > input#formBasicText") public WebElement shippingCountryField;
    @FindBy (css = "div:nth-of-type(10) > input#formBasicText") public WebElement shippingCityField;
    @FindBy (css = "div:nth-of-type(11) > input#formBasicText") public WebElement shippingAddressField;
    @FindBy (css = ".card-body") public WebElement customerTable;


    public void selectUser(String user){
        waitForWebElementToBePresent(selectUser);
        Select selectUsr = new Select(selectUser);
        selectUsr.selectByValue(user);
    }
}

package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CustomerPage extends BasePage{
    Random random;
    List<String> customerNames = Arrays.asList("Test Customer", "Greg Customer", "Luti Customer", "Krisz Customer", "Noki Customer");
    public String companyName = "Customer Test Ltd.";
    public String VATNumber = "0";
    public String ZipCode = "1111";
    public String country = "Tahiti";
    public String city = "Pornóapáti";
    public String address = "Hátsó u 69.";

    @FindBy (css = ".btn.btn-primary") public WebElement plusButton;
    @FindBy (xpath = "/html//select[@id='users']") public WebElement selectUser;
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
    @FindBy (css = "select#users") public WebElement customerTestUser;
    @FindBy (xpath = "/html//div[@id='root']/div[@class='App']//table[@class='table table-striped']/tbody/tr[last()]/td[2]/a") public WebElement lastRowOfCustomerTable;
    @FindBy (css = "[class='MuiCardContent-root css-1qw96cp']") public WebElement customerValidationTable;
    @FindBy (css = "[class='MuiTypography-root MuiTypography-h3 MuiTypography-gutterBottom css-6s8q25']") public WebElement companyNameValidation;
    @FindBy (css = "[class='MuiTypography-root MuiTypography-h6 MuiTypography-gutterBottom css-4an0mh']") public WebElement VATNumberValidation;
    @FindBy (css = "[class] [class='MuiTypography-root MuiTypography-h6 css-1anx036']:nth-child(4)") public WebElement billingZipValidation;
    @FindBy (css = "[class] [class='MuiTypography-root MuiTypography-h6 css-1anx036']:nth-child(5)") public WebElement billingCountryValidation;
    @FindBy (css = "[class] [class='MuiTypography-root MuiTypography-h6 css-1anx036']:nth-child(6)") public WebElement billingCityValidation;
    @FindBy (css = "[class] [class='MuiTypography-root MuiTypography-h6 css-1anx036']:nth-child(7)") public WebElement billingAddressValidation;

    @FindBy (css = "[class] [class='MuiTypography-root MuiTypography-h6 css-1anx036']:nth-child(9)") public WebElement shippingZipValidation;
    @FindBy (css = "[class] [class='MuiTypography-root MuiTypography-h6 css-1anx036']:nth-child(10)") public WebElement shippingCountryValidation;
    @FindBy (css = "[class] [class='MuiTypography-root MuiTypography-h6 css-1anx036']:nth-child(11)") public WebElement shippingCityValidation;
    @FindBy (css = "[class] [class='MuiTypography-root MuiTypography-h6 css-1anx036']:nth-child(12)") public WebElement shippingAddressValidation;

    public CustomerPage(){
        random = new Random();
    }
    public void selectUser(String user){
        waitForWebElementToBePresent(selectUser);
        Select userSelect = new Select(selectUser);
        waitForWebElementToBePresent(customerTestUser);
        userSelect.selectByVisibleText(user);
    }

    public String getRandomCustomerName(){
        return customerNames.get((random.nextInt(customerNames.size())));
    }
}

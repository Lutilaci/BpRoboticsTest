package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.CustomerPage;

import static config.DriverSingleton.quit;

public class CustomerTest {
    static CustomerPage customerPage;

    @BeforeAll
    public static void setUp() {
        customerPage = new CustomerPage();
        customerPage.login("admin");
    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

    @Test
    public void addNewCustomer(){
        customerPage.openUrl("customers");
        customerPage.plusButton.click();
        customerPage.waitForWebElementToBePresent(customerPage.customerTable);
        customerPage.selectUser("38");
        customerPage.companyNameField.sendKeys("Customer Test Ltd.");
        customerPage.VATNumberField.sendKeys("000000000");
        customerPage.billingZipCodeField.sendKeys("1111");
        customerPage.billingCountryField.sendKeys("Tahiti");
        customerPage.billingCityField.sendKeys("Pornóapáti");
        customerPage.billingAddressField.sendKeys("Hátsó u 69.");
        customerPage.shippingZipCodeField.sendKeys("1111");
        customerPage.shippingCountryField.sendKeys("Tahiti");
        customerPage.shippingCityField.sendKeys("Pornóapáti");
        customerPage.shippingAddressField.sendKeys("Hátsó u 69.");

        customerPage.shippingAddressField.submit();

        // Validate

        // Restore
    }
}



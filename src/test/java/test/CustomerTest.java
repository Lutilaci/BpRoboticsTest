package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.CustomerPage;
import page.UsersPage;

import static config.DriverSingleton.quit;

public class CustomerTest {
    static CustomerPage customerPage;
    static UsersPage usersPage;
    static String customerName;


    @BeforeAll
    public static void setUp() {
        customerPage = new CustomerPage();
        usersPage = new UsersPage();
        customerPage.login("admin");
        customerName = customerPage.getRandomCustomerName();
        usersPage.createUser(customerName, "12345678", "Test", "Test", "Customer");

    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

    @Test
    public void addNewCustomer(){
        customerPage.openUrl("customers");
        customerPage.plusButton.click();
        customerPage.isElementPresent(customerPage.selectUser);
        customerPage.selectUser("Test Test");
        customerPage.companyNameField.sendKeys(customerPage.companyName);
        customerPage.VATNumberField.sendKeys(customerPage.VATNumber);
        customerPage.billingZipCodeField.sendKeys(customerPage.ZipCode);
        customerPage.billingCountryField.sendKeys(customerPage.country);
        customerPage.billingCityField.sendKeys(customerPage.city);
        customerPage.billingAddressField.sendKeys(customerPage.address);
        customerPage.shippingZipCodeField.sendKeys(customerPage.ZipCode);
        customerPage.shippingCountryField.sendKeys(customerPage.country);
        customerPage.shippingCityField.sendKeys(customerPage.city);
        customerPage.shippingAddressField.sendKeys(customerPage.address);
        customerPage.shippingAddressField.submit();

        // Validate
        customerPage.openUrl("customers");
        customerPage.lastRowOfCustomerTable.click();
        customerPage.isElementPresent(customerPage.customerValidationTable);
        Assertions.assertEquals(customerPage.companyName, customerPage.getElementText(customerPage.companyNameValidation));
        Assertions.assertEquals("VAT Number: " + customerPage.VATNumber, customerPage.getElementText(customerPage.VATNumberValidation));
        Assertions.assertEquals("Billing ZIP: " + customerPage.ZipCode, customerPage.getElementText(customerPage.billingZipValidation));
        Assertions.assertEquals("Billing Country: " + customerPage.country, customerPage.getElementText(customerPage.billingCountryValidation));
        Assertions.assertEquals("Billing City: " + customerPage.city, customerPage.getElementText(customerPage.billingCityValidation));
        Assertions.assertEquals("Billing Address: " + customerPage.address, customerPage.getElementText(customerPage.billingAddressValidation));

        Assertions.assertEquals("Shipping ZIP: " + customerPage.ZipCode, customerPage.getElementText(customerPage.shippingZipValidation));
        Assertions.assertEquals("Shipping Country: " + customerPage.country, customerPage.getElementText(customerPage.shippingCountryValidation));
        Assertions.assertEquals("Shipping City: " + customerPage.city, customerPage.getElementText(customerPage.shippingCityValidation));
        Assertions.assertEquals("Shipping Address: " + customerPage.address, customerPage.getElementText(customerPage.shippingAddressValidation));


    }
}



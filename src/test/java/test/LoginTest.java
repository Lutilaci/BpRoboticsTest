package test;

import org.asynchttpclient.util.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import page.BasePage;
import page.LoginPage;
import page.StartPage;

import java.util.Arrays;
import java.util.List;

import static config.DriverSingleton.*;
import static test.LogoutTest.startPage;

public class LoginTest {
    static LoginPage loginPage;

    List<String> adminPermissions = Arrays.asList("Customers", "Orders", "Services", "Devices", "Partners", "Products", "Logout");
    List<String> partnerPermissions = Arrays.asList("Customers", "Services", "Products", "Logout");
    List<String> customerPermissions = Arrays.asList("Profile", "Orders", "Devices", "Products", "Logout");

    @BeforeAll
    public static void setUp() {
        loginPage = new LoginPage();
    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

    @Test
    public void loginAsAdmin() throws InterruptedException {
        loginPage.login("admin");
        loginPage.waitForWebElementToBePresent(startPage.logoutButton);
        loginPage.checkPermission(adminPermissions);
    }

    @Test
    public void loginAsCustomer() throws InterruptedException {
        loginPage.login("customer");
        loginPage.waitForWebElementToBePresent(startPage.logoutButton);
        loginPage.checkPermission(customerPermissions);
    }

    @Test
    public void loginAsPartner() throws InterruptedException {
        loginPage.login("partner");
        loginPage.waitForWebElementToBePresent(startPage.logoutButton);
        loginPage.checkPermission(partnerPermissions);
    }
}

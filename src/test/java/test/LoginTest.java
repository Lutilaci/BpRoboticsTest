package test;

import org.junit.jupiter.api.*;
import page.LoginPage;
import page.StartPage;

import java.util.Arrays;
import java.util.List;

import static config.DriverSingleton.*;

public class LoginTest {
    static LoginPage loginPage;
    static StartPage startPage;

    List<String> adminPermissions = Arrays.asList("Customers", "Orders", "Services", "Devices", "Partners", "Products", "Logout");
    List<String> partnerPermissions = Arrays.asList("Customers", "Services", "Products", "Logout");
    List<String> customerPermissions = Arrays.asList("Profile", "Orders", "Devices", "Products", "Logout");

    @BeforeAll
    public static void setUp() {
        startPage = new StartPage();
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

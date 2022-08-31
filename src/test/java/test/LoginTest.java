package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import page.BasePage;
import page.LoginPage;
import page.StartPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static config.DriverSingleton.*;

public class LoginTest extends BasePage {
    static LoginPage loginPage;
    static StartPage startPage;

    List<String> adminPermissions = Arrays.asList("Customers", "Orders", "Services", "Devices", "Partners", "Products", "Logout");
//    List<String> partnerPermissions = Arrays.asList("Customers", "Orders", "Services", "Devices", "Partners", "Products", "Logout");
    List<String> customerPermissions = Arrays.asList("Profile", "Orders", "Devices", "Products", "Logout");

    @BeforeAll
    public static void setUp() {
        loginPage = new LoginPage();
        startPage = new StartPage();
    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

    @Test
    public void loginAsAdmin(){
        loginPage.login("admin");
        waitForWebElementToBePresent(startPage.logoutButton);
    }

    @Test
    public void loginAsCustomer(){
        loginPage.login("customer");
        waitForWebElementToBePresent(startPage.logoutButton);

    }

    @Test
    public void loginAsPartner(){
        loginPage.login("partner");
        waitForWebElementToBePresent(startPage.logoutButton);

    }


}

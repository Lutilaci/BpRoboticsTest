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

public class LoginTest {
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
        loginPage.waitForWebElementToBePresent(startPage.logoutButton);
        for (String adminPermission : adminPermissions) {
            switch (adminPermission) {
                case "Customers":
                    startPage.isElementPresent(startPage.customersButton);
                    break;
                case "Orders":
                    startPage.isElementPresent(startPage.ordersButton);
                    break;
                case "Services":
                    startPage.isElementPresent(startPage.servicesButton);
                    break;
                case "Devices":
                    startPage.isElementPresent(startPage.devicesButton);
                    break;
                case "Partners":
                    startPage.isElementPresent(startPage.partnersButton);
                    break;
                case "Products":
                    startPage.isElementPresent(startPage.productsButton);
                    break;
                case "Logout":
                    startPage.isElementPresent(startPage.logoutButton);
                    break;
            }
        }
    }

    @Test
    public void loginAsCustomer(){
        loginPage.login("customer");
        startPage.waitForWebElementToBePresent(startPage.logoutButton);

    }

    @Test
    public void loginAsPartner(){
        loginPage.login("partner");
        startPage.waitForWebElementToBePresent(startPage.logoutButton);

    }


}

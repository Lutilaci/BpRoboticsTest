package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.StartPage;

import java.util.Arrays;
import java.util.List;

import static config.DriverSingleton.quit;

public class LogoutTest {
    static StartPage startPage;
    static LoginPage loginPage;

    List<String> logoutPermissions = Arrays.asList("Products", "Login");

    @BeforeAll
    public static void setUp(){
        startPage = new StartPage();
        loginPage = new LoginPage();
        loginPage.login("admin");
    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

    @Test
    public void logoutTest(){
        startPage.logoutButton.click();
        loginPage.checkPermission(logoutPermissions);
    }
}

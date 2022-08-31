package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.UsersPage;

import static config.DriverSingleton.quit;

public class UserTest {
    static UsersPage usersPage;

    @BeforeAll
    public static void setUp(){
        usersPage = new UsersPage();
        usersPage.login("admin");
    }

    @AfterAll
    public static void tearDown(){
        quit();
    }

    @Test
    public void createNewUserSuccessful(){
        String username = "test";
        String password = "12345678";
        String firstName = "tester";
        String lastName = "bot";
        String role = "Admin";
        usersPage.openUrl("users");
        usersPage.navigateToAddUser();
        usersPage.createUser(username,password,firstName,lastName,role);
        usersPage.logout();
        usersPage.loginNewUser(username,password);
        Assertions.assertTrue(usersPage.loggedIn());
        usersPage.openUrl("users");
        usersPage.deleteLastUser();
    }

    @Test void deleteUserSuccessful() throws InterruptedException {
        String username = "test";
        String password = "12345678";
        String firstName = "tester";
        String lastName = "bot";
        String role = "Admin";
        usersPage.openUrl("users");
        usersPage.navigateToAddUser();
        usersPage.createUser(username,password,firstName,lastName,role);
        Thread.sleep(10000);
        usersPage.userIsPresent(username);
        usersPage.deleteLastUser();

        usersPage.logout();
        usersPage.loginNewUser(username,password);
        Assertions.assertFalse(usersPage.loggedIn());

    }
}

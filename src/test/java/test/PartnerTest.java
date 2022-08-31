package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.PartnerPage;
import page.UsersPage;

import static config.DriverSingleton.quit;

public class PartnerTest {
    static PartnerPage partnerPage;
    static UsersPage usersPage;

    @BeforeAll
    public static void setUp() {
        partnerPage = new PartnerPage();
        usersPage = new UsersPage();

        partnerPage.login("admin");
        // Add new user
        usersPage.createUser(partnerPage.randomName(), "12345678", "Test", "User", "Partner");

    }

    @AfterAll
    public static void tearDown() {
        usersPage.deleteLastUser();
        quit();
    }

    @Test
    public void addNewPartner(){
        partnerPage.openUrl("partners");
        partnerPage.waitForWebElementToBePresent(partnerPage.addPartnerButton);
        partnerPage.addPartnerButton.click();
    }
}




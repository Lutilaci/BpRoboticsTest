package test;

import org.junit.jupiter.api.*;
import page.PartnerPage;
import page.UsersPage;

import static config.DriverSingleton.quit;

public class PartnerTest {
    static PartnerPage partnerPage;
    static UsersPage usersPage;
    static String username;

    @BeforeAll
    public static void setUp() {
        partnerPage = new PartnerPage();
        usersPage = new UsersPage();
        username = partnerPage.randomName();

        partnerPage.login("admin");
    }

    @BeforeEach
    public void createUser(){
        usersPage.createUser(username, "12345678", "Test", "User", "Partner");

    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

    @Test
    public void addNewPartner(){
        partnerPage.openUrl("partners");
        partnerPage.waitForElementToClick(partnerPage.newButton);
        partnerPage.addPartner("Test User");

        // Validate
        Assertions.assertEquals(username, partnerPage.getElementText(partnerPage.companyValidator));

        // Restore
        partnerPage.waitForElementToClick(partnerPage.deletePartnerButton);
//        partnerPage.waitUntilNotVisible(partnerPage.lastRow);
    }
}




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


    @AfterAll
    public static void tearDown() {
        quit();
    }

    @Test
    public void addNewPartner(){
//        usersPage.createUser(username, "12345678", "Test", "User", "Partner");

        partnerPage.openUrl("partners");
        partnerPage.waitForElementToClick(partnerPage.newButton);
        partnerPage.addPartner("Test User");

        // Validate
        Assertions.assertEquals(username, partnerPage.getElementText(partnerPage.companyValidator));

        // Restore
        partnerPage.waitForElementToClick(partnerPage.deletePartnerButton);
    }

    @Test
    public void editPartner(){
        partnerPage.editPartner(partnerPage.companyName, partnerPage.phoneNumber);

        // Validate
        Assertions.assertEquals(partnerPage.companyName, partnerPage.getElementText(partnerPage.editedCompanyName));
        Assertions.assertEquals(partnerPage.phoneNumber, partnerPage.getElementText(partnerPage.editedPhoneNumber));

        // Restore
        partnerPage.editPartner("WeFixIt", "+36694201337");
        Assertions.assertEquals("WeFixIt", partnerPage.getElementText(partnerPage.editedCompanyName));
        Assertions.assertEquals("+36694201337", partnerPage.getElementText(partnerPage.editedPhoneNumber));
    }

    @Test
    public void deletePartner(){
        partnerPage.openUrl("partners");
        partnerPage.waitForElementToClick(partnerPage.deletePartnerButton);
        partnerPage.waitUntilNotVisible(partnerPage.secondConnectedUser);

        // Restore
        partnerPage.openUrl("partners");
        partnerPage.waitForElementToClick(partnerPage.newButton);
        partnerPage.addPartner("Test User");
    }
}




package test;

import org.junit.jupiter.api.*;
import page.ServicePage;

import static config.DriverSingleton.quit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest {
    static ServicePage servicePage;

    @BeforeAll
    public static void setUp(){
        servicePage = new ServicePage();
        servicePage.login("admin");
        servicePage.addNewService("Repair", "WeFixIt");
    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

    @Test
    @Order(1)
    void firstTest() {
        servicePage.login("partner");
        servicePage.openUrl("services");
        servicePage.waitForElementToClick(servicePage.startButton);

        // Validate
        servicePage.waitUntilTextToBePresentInElement(servicePage.serviceStatus, "InProgress");
        Assertions.assertEquals("InProgress", servicePage.getElementText(servicePage.serviceStatus));
    }

    @Test
    @Order(2)
    void secondTest() {
        servicePage.login("partner");
        servicePage.openUrl("services");
        servicePage.waitForElementToClick(servicePage.finishButton);

        // Validate
        servicePage.waitUntilTextToBePresentInElement(servicePage.serviceStatus, "Done");
        Assertions.assertEquals("Done", servicePage.getElementText(servicePage.serviceStatus));
    }

    @Test
    public void changeIdSuccessful(){
        String newSerial = "1337";
        servicePage.openUrl("services");
        servicePage.updateFirstServiceSerial(newSerial);
        // need to refresh the page again
        servicePage.openUrl("services");
        Assertions.assertEquals(newSerial, servicePage.getFirstServiceSerial());
    }
}

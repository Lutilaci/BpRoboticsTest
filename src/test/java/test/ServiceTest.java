package test;

import org.junit.jupiter.api.*;
import page.DevicesPage;
import page.ServicePage;

import static config.DriverSingleton.quit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest {
    static ServicePage servicePage;
    static DevicesPage devicesPage;

    @BeforeAll
    public static void setUp(){
        servicePage = new ServicePage();
        devicesPage = new DevicesPage();
        servicePage.login("admin");
    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

    @Test
    @Order(1)
    void firstTest() {
        servicePage.addNewService("Repair", "WeFixIt");
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

    @Test
    public void addNewServiceSuccessful() {
        String type = "Repair";
        String partner = "WeFixIt";
        devicesPage.openUrl("devices");
        devicesPage.addService(type,partner);
        servicePage.openUrl("services");
        Assertions.assertTrue(servicePage.isLastService(type,partner));
    }
}
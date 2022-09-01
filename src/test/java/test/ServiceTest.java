package test;

import org.junit.jupiter.api.*;
import page.ServicePage;

import static config.DriverSingleton.getDriver;
import static config.DriverSingleton.quit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest {
    static ServicePage servicePage;

    @BeforeAll
    public static void setUp(){
        servicePage = new ServicePage();
        servicePage.login("admin");
    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("first");
    }

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("second");
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

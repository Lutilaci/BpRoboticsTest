package test;

import org.junit.jupiter.api.*;

import page.OrderPage;

import static config.DriverSingleton.quit;

public class OrderTest {
    static OrderPage orderPage;

    @BeforeAll
    public static void setUp(){
        orderPage = new OrderPage();
        orderPage.login("admin");
    }


    @AfterAll
    public static void tearDown(){
        quit();
    }

    @Test
    public void createOrderSuccessful() {
        String customer = "Four Seasons";
        String product = "Smart Oven";
        orderPage.openUrl("orders");
        orderPage.openAddOrder();
        orderPage.selectCustomer(customer);
        orderPage.addProduct(product);
        orderPage.createOrder();
        Assertions.assertEquals(customer, orderPage.getLastRowCustomer());
        Assertions.assertEquals(product+": 1", orderPage.getLastRowProduct());
    }
}

package test;

import org.junit.jupiter.api.*;

import page.OrdersPage;

import static config.DriverSingleton.quit;

public class OrderTest {
    static OrdersPage ordersPage;

    @BeforeAll
    public static void setUp(){
        ordersPage = new OrdersPage();
        ordersPage.login("admin");
    }


    @AfterAll
    public static void tearDown(){
        quit();
    }

    @Test
    public void createOrderSuccessful() {
        String customer = "Four Seasons";
        String product = "Smart Oven";
        ordersPage.openUrl("orders");
        ordersPage.openAddOrder();
        ordersPage.selectCustomer(customer);
        ordersPage.addProduct(product);
        ordersPage.createOrder();
        Assertions.assertEquals(customer, ordersPage.getLastRowCustomer());
        Assertions.assertEquals(product+": 1", ordersPage.getLastRowProduct());
    }
}

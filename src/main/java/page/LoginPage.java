package page;

import java.util.List;

public class LoginPage extends BasePage{
    public StartPage startPage;

    public LoginPage(){
        startPage = new StartPage();
    }

    public void checkPermission (List<String> permissions){
        for (String permission : permissions) {
            switch (permission) {
                case "Customers":
                    isElementPresent(startPage.customersButton);
                    System.out.println("customer present");
                    break;
                case "Orders":
                    isElementPresent(startPage.ordersButton);
                    System.out.println("orders present");
                    break;
                case "Services":
                    isElementPresent(startPage.servicesButton);
                    System.out.println("services present");
                    break;
                case "Devices":
                    isElementPresent(startPage.devicesButton);
                    System.out.println("devices present");
                    break;
                case "Partners":
                    isElementPresent(startPage.partnersButton);
                    System.out.println("partners present");
                    break;
                case "Products":
                    isElementPresent(startPage.productsButton);
                    System.out.println("products present");
                    break;
                case "Logout":
                    isElementPresent(startPage.logoutButton);
                    System.out.println("logout present");
                    break;
                case "Users":
                    isElementPresent(startPage.usersButton);
                    System.out.println("users present");
                    break;
                case "Profile":
                    isElementPresent(startPage.profileButton);
                    System.out.println("profile present");
                    break;
            }
        }
    }
}

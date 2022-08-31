package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy (xpath = "//div[@id='responsive-navbar-nav']//a[@href='/customers']") public WebElement customersButton;
    @FindBy (linkText = "Orders") public WebElement ordersButton;
    @FindBy (linkText = "Services") public WebElement servicesButton;
    @FindBy (linkText = "Devices") public WebElement devicesButton;
    @FindBy (linkText = "Partners") public WebElement partnersButton;
    @FindBy (linkText = "Products") public WebElement productsButton;
    @FindBy (linkText = "Users") public WebElement usersButton;
    @FindBy (css = "#responsive-navbar-nav > div > a.active.nav-link") public WebElement logoutButton;
    @FindBy (css = ".navbar-nav") public WebElement navbar;

    public StartPage(){}
}

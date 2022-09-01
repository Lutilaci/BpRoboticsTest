package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/button") WebElement createNewOrderButton;
    @FindBy(id = "customers") WebElement customerSelect;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/form/div/button") WebElement addProduct;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/form/button") WebElement createOrder;
    @FindBy(id = "products") WebElement productSelect;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/table/tbody/tr[last()]/td[2]") WebElement lastRowCompany;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/table/tbody/tr[last()]/td[4]") WebElement lastRowProduct;

    public OrdersPage() {
    }

    public void openAddOrder(){
        waitForElementToClick(createNewOrderButton);
    }

    public void selectCustomer(String customer){
        waitForWebElementToBePresent(customerSelect);
        Select selectCustomer = new Select(customerSelect);
        selectCustomer.selectByVisibleText(customer);
    }

    public void addProduct(String product){
        waitForElementToClick(addProduct);
        Select selectProduct = new Select(productSelect);
        selectProduct.selectByVisibleText(product);
    }

    public void createOrder(){
        createOrder.click();
    }

    public String getLastRowCustomer(){
        wait.until(ExpectedConditions.visibilityOf(lastRowCompany));
        return lastRowCompany.getText();
    }
    public String getLastRowProduct(){
        return lastRowProduct.getText();
    }
}
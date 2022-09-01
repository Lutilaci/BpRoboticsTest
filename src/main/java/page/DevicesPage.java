package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DevicesPage extends BasePage{

    @FindBy(css = "#root > div > div > div.card > div > table > tbody > tr:nth-child(1) > td:nth-child(8) > svg")
    WebElement firstDownArrow;

    @FindBy(css = "#root > div > div > div.card > div > table > tbody > tr:nth-child(2) > td > button > svg")
    WebElement plusServiceButton;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[1]/select")
    WebElement selectType;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[2]/select")
    WebElement selectPartner;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/button")
    WebElement addServiceButton;

    public DevicesPage(){}

    public void addService(String type, String partner){
        waitForElementToClick(firstDownArrow);
        waitForElementToClick(plusServiceButton);
        wait.until(ExpectedConditions.visibilityOf(selectType));
        Select typeSelect = new Select(selectType);
        Select partnerSelect = new Select(selectPartner);
        typeSelect.selectByVisibleText(type);
        partnerSelect.selectByVisibleText(partner);
        addServiceButton.click();
    }
}

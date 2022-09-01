package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

public class ServicePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/table/tbody/tr[1]/td[8]/button") WebElement detailsFirstButton;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[3]/button[1]") WebElement updateSerialButton;
    @FindBy(xpath = "/html/body/div[3]/div/div/form/div[1]/input") WebElement inputField;
    @FindBy(xpath = "/html/body/div[3]/div/div/form/div[2]/button[1]") WebElement updateSerialUpdateButton;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]") WebElement serviceDetailsDiv;
    @FindBy (xpath = "/html//div[@id='root']/div[@class='App']//table[@class='table']/tbody/tr[last()]/td[6]") public WebElement startButton;
    @FindBy (xpath = "/html//div[@id='root']/div[@class='App']//table[@class='table']/tbody/tr[last()]/td[7]") public WebElement finishButton;
    @FindBy (css = "tbody tr:nth-of-type(2) td:nth-of-type(8)") public WebElement arrowButton;
    @FindBy (css = ".btn-primary") public WebElement newButton;
    @FindBy (css = ".modal-content") public WebElement modal;
    @FindBy (css = "div:nth-of-type(1) > .form-select") public WebElement serviceTypeSelector;
    @FindBy (xpath = "//body/div[@role='dialog']//div[@class='modal-content']//form/div[2]/select[@class='form-select']") public WebElement partnerSelector;
    @FindBy (css = "form > button[value='Create user']") public WebElement addServiceButton;
    @FindBy (xpath = "/html//div[@id='root']/div[@class='App']//table[@class='table']/tbody/tr[last()]/td[5]") public WebElement serviceStatus;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/table/tbody/tr[last()]/td[1]")
    WebElement lastPartnerName;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/table/tbody/tr[last()]/td[4]")
    WebElement lastServiceType;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/table/tbody/tr[1]/td[8]/svg")
    WebElement firstRowArrow;

    public ServicePage (){}

    public void updateFirstServiceSerial(String newSerial){
        waitForElementToClick(detailsFirstButton);
        waitForElementToClick(updateSerialButton);
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        inputField.clear();
        inputField.sendKeys(newSerial);
        updateSerialUpdateButton.click();
    }

    public String getFirstServiceSerial(){
        waitForElementToClick(detailsFirstButton);
        String details = serviceDetailsDiv.getText();
        String serial = details.substring(details.indexOf("Serial:") +8 , details.length());
        return serial;
    }

    public void addNewService(String serviceType, String partner){
        openUrl("devices");
        arrowButton.click();
        waitForElementToClick(newButton);
        isElementPresent(modal);
        Select selectType = new Select(serviceTypeSelector);
        selectType.selectByVisibleText(serviceType);
        Select selectPartner = new Select(partnerSelector);
        selectPartner.selectByVisibleText(partner);
    }

    public boolean isLastService(String serviceType, String partner){
        wait.until(ExpectedConditions.visibilityOf(lastPartnerName));
        return lastPartnerName.getText().equals(partner) && lastServiceType.getText().equals(serviceType);
    }
}

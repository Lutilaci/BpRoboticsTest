package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ServicePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/table/tbody/tr[1]/td[8]/button")
    WebElement detailsFirstButton;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[3]/button[1]")
    WebElement updateSerialButton;

    @FindBy(xpath = "/html/body/div[3]/div/div/form/div[1]/input")
    WebElement inputField;

    @FindBy(xpath = "/html/body/div[3]/div/div/form/div[2]/button[1]")
    WebElement updateSerialUpdateButton;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]")
    WebElement serviceDetailsDiv;

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
}

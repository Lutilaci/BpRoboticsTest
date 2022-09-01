package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PartnerPage extends BasePage{

    Random random;
    static List<String> randomNames = Arrays.asList("Greg Ltd", "Luti Kft", "Krisz Bt");
    String randomName = null;

    @FindBy (css = "thead .btn-primary") public WebElement newButton;
    @FindBy (css = ".btn-primary") public WebElement addPartnerButton;
    @FindBy (css = "select#users") public WebElement userSelector;
    @FindBy (css = ".form [class='mb-3']:nth-of-type(2) #formBasicText") public WebElement companyNameField;
    @FindBy (css = "div:nth-of-type(3) > input#formBasicText") public WebElement phoneNumberFiled;
    @FindBy (xpath = "/html//div[@id='root']/div[@class='App']/div//table[@class='table table-striped']//tr[last()]//td[2]") public WebElement companyValidator;
    @FindBy (xpath = "/html//div[@id='root']/div[@class='App']/div//table[@class='table table-striped']/tbody/tr[last()]/td[5]/button[2]") public WebElement deletePartnerButton;
    @FindBy (xpath = "/html//div[@id='root']/div[@class='App']/div//table[@class='table table-striped']/tbody/tr[last()]") public WebElement lastRow;


    public PartnerPage(){
        random = new Random();
    }

    public String randomName(){
        randomName = randomNames.get(random.nextInt(3));
        return randomName;
    }

    public void addPartner(String partner){
        Select selectUser = new Select(userSelector);
        selectUser.selectByVisibleText(partner);
        companyNameField.sendKeys(randomName);
        phoneNumberFiled.sendKeys("555-555555");
        addPartnerButton.submit();
    }
}

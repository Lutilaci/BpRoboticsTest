package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/button")
    WebElement addUserButton;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[1]/input")
    WebElement usernameField;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[2]/input")
    WebElement passwordField;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[3]/input")
    WebElement firstNameField;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[4]/input")
    WebElement lastNameField;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[5]/select")
    WebElement roleSelect;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/button")
    WebElement createUserButton;

    public UsersPage() {
    }

    public void navigateToAddUser(){
        waitForElementToClick(addUserButton);
    }

}

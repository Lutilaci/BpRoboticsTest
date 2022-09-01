package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class UsersPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/button") WebElement addUserButton;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[1]/input") WebElement usernameField;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[2]/input") WebElement passwordField;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[3]/input") WebElement firstNameField;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[4]/input") WebElement lastNameField;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[5]/select") WebElement roleSelect;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/button") WebElement createUserButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/table/tbody/tr[last()]/td[5]/button") WebElement lastDeleteUserButton;

    public UsersPage() {
    }

    public void navigateToAddUser(){
        waitForElementToClick(addUserButton);
    }

    public void createUser(String username, String password, String fName, String lName, String role){
        openUrl("users");
        navigateToAddUser();
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        firstNameField.sendKeys(fName);
        lastNameField.sendKeys(lName);
        Select select = new Select(roleSelect);
        select.selectByVisibleText(role);
        createUserButton.click();
    }

    public void deleteLastUser(){
        waitForElementToClick(lastDeleteUserButton);
    }

    public boolean userIsPresent(String anchorText){
        WebElement userAnchor = driver.findElement(By.linkText(anchorText));
        waitForWebElementToBePresent(userAnchor);
        return userAnchor.isDisplayed();
    }
}

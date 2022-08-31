package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PartnerPage extends BasePage{

    Random random;
    static List<String> randomNames = Arrays.asList("Greg", "Luti", "Krisz");
    String randomName = null;

    @FindBy (css = "thead .btn-primary") public WebElement addPartnerButton;


    public PartnerPage(){
        random = new Random();
    }

    public String randomName(){
        randomName = randomNames.get(random.nextInt(3));
        return randomName;
    }

    public String getRandomName() {
        return randomName;
    }

    public void addPartner(String partner){

    }
}

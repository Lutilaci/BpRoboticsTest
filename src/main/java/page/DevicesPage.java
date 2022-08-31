package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DevicesPage extends BasePage{

    @FindBy (css = "tr:nth-of-type(2) > td:nth-of-type(8) > svg[role='img']") public WebElement downArrow;

    public DevicesPage(){};
}

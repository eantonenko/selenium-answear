package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDostavkaPage extends ParentPage {

    @FindBy(xpath = ".//h3[text()='Выберите способ доставки']")
    private WebElement dostavkaText;

    public OrderDostavkaPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isDostavkaTextPresent() {
        return actionsWithWebElements.isElementPresent(dostavkaText);
    }
}

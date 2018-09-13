package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderAdressPage extends ParentPage {

    @FindBy(xpath = ".//a[@id='checkoutBasketBtn']")
    private WebElement dropdownCreateOrder;
    @FindBy(xpath = ".//input[@ id='c24']//..//i[@class='cb']")
    private WebElement checkboxAccept;
    @FindBy(xpath = ".//input[@ id='c24']/../../label[@class='option checked']")
    private WebElement checkedAcceptedCheckbox;
    @FindBy(xpath = ".//input[@id='toCash']")
    private WebElement buttonCash;
    @FindBy(xpath = ".//h2[text()='Данные Клиента']")
    private WebElement dannueClientaText;

    public OrderAdressPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isCreateOrderDropdownPresent() {
        return actionsWithWebElements.isElementPresent(dropdownCreateOrder);
    }

   // public boolean acceptCheckboxIsSelected(){
   //     boolean isSelected = checkboxAccept.isSelected();
   //     return isSelected;
   // }

    /**
     * Check that state of checkbox is checked
     * @return checked
     */
    public  boolean isAcceptedCheckboxPressed(){
        return checkedAcceptedCheckbox.isDisplayed();
    }

    public void clickOnToCashButton() {
        actionsWithWebElements.clickOnWebElement(buttonCash);
    }

    public boolean isDannueClientaTextPresent() {
        return actionsWithWebElements.isElementPresent(dannueClientaText);
    }
}

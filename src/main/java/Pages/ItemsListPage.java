package Pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsListPage extends ParentPage {
    @FindBy(xpath = ".//a[@id='gridSwitch']")
    WebElement dropdownFilters;
    @FindBy(xpath = ".//div[@id='grid']/div[1]")
    WebElement itemName;
    @FindBy (xpath = ".//a[@id='popupNewsletterClose']")
    WebElement buttonClose;



    public ItemsListPage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean isFiltersDropDownPresent() {
        return actionsWithWebElements.isElementPresent(dropdownFilters);
    }

    /**
     * Click on any first item from list
     */
    public void clickOnItemName() {
        actionsWithWebElements.clickOnWebElement(itemName);
    }

    /**
     * Close popup on Items List
     */
    public void clickOnClosePopup() {
        try {
            buttonClose.click();
            Thread.sleep(100);
        } catch (Exception e){
            logger.info("Popup is not displayed");
        }
    }


}

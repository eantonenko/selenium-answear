package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemDetailsPage extends ParentPage {

    @FindBy(xpath = ".//h1[text()='Trussardi Jeans - Кроссовки ']")
    WebElement itemBreadcrumb;
    @FindBy(xpath = ".//h1[text()='adidas Originals - Кроссовки']")
    WebElement isItemBreadcrumbIzbranoe;
    @FindBy(xpath = ".//h1[text()='Reebok - Футболка ']")
    WebElement isItemBreadcrumbOrder;
    @FindBy(xpath = ".//select[@id='selectSize']")
    WebElement sizeDropDown;
    @FindBy(xpath = ".//a[@id='cartaddButton']")
    WebElement buttonToCart;
    @FindBy(xpath = ".//div[@class='shift shiftLeft active']//a[@class='show' and @href='/korzina-1.html']")
    WebElement buttonCreateOrder;
    @FindBy(xpath = ".//select[@id='selectSize']")
    WebElement dropDownOptions;
    @FindBy(xpath = ".//a[@id='safeaddButton']")
    WebElement linkIzbranoe;
    @FindBy(xpath = ".//div[@class='green']")
    WebElement infoTextGreen;
    @FindBy(xpath = ".//a[@href='/izbrannoye.html']")
    WebElement buttonIzbranoe;


    public ItemDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean isItemBreadcrumbPresent() {
        return actionsWithWebElements.isElementPresent(itemBreadcrumb);
    }

    public boolean isItemBreadcrumbPresentIzbranoe() {
        return actionsWithWebElements.isElementPresent(isItemBreadcrumbIzbranoe);
    }

    public boolean isItemBreadcrumbPresentOrder() {
        return actionsWithWebElements.isElementPresent(isItemBreadcrumbOrder);
    }

    public void selectItemSizeinDropDown(String dropdDownSizeValue) {
        actionsWithWebElements.selectItemInDropDownByValue(sizeDropDown, dropdDownSizeValue);
    }

    public void clickOnToCartButton() {
        actionsWithWebElements.clickOnWebElement(buttonToCart);
    }

    public boolean isCreateOrderButtonPresent() {
        return actionsWithWebElements.isElementPresent(buttonCreateOrder);
    }

    public void clickOnCreateOrderButton() {
        actionsWithWebElements.clickOnWebElement(buttonCreateOrder);
    }


    /**
     * Select available value from dropdown, value not null, not empty, not zero, not "-1"
     * @return value
     */
    public String getDropDownValue() {
        List<WebElement> elements = dropDownOptions.findElements(By.xpath(".//option"));
        for (WebElement element : elements) {
            String value = element.getAttribute("value");
            if (value != null && !value.equals("") && !value.equals("0") && !value.equals("-1")) {
                return value;
            }
        }
        return "0";
    }

    /**
     * Add item to Izbranoe via link
     * @throws InterruptedException
     */
    public void clickOnIzbranoeLink() throws InterruptedException {
        actionsWithWebElements.clickOnWebElement(linkIzbranoe);
        Thread.sleep(1000);
    }

    public boolean isInfoTextGreenPresent() {
        return actionsWithWebElements.isElementPresent(infoTextGreen);
    }

    /**
     * Click on Izbranoe link from header
     */
    public void cliclOnIzbranoeButton() {
        actionsWithWebElements.clickOnWebElement(buttonIzbranoe);
    }
}

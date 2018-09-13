package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CartPage extends ParentPage {

    @FindBy(xpath = ".//li[@class='current']//a[@ href='#']")
    WebElement cartBreadcrumb;
    @FindBy(xpath = ".//div[@class='row clearfix'][1]")
    WebElement addedItem;
    @FindBy(xpath = ".//form[@id='cartList']")
    WebElement listElementsInCart;
    @FindBy(xpath = ".//a[@href='/kasa-1/adres.html']")
    private WebElement buttonCreateOrder;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Check breadcrumb on Cart page
     * @return - true or false
     */
    public boolean isCartBreadcrumbPresent() {
        return actionsWithWebElements.isElementPresent(cartBreadcrumb);
    }

//    public boolean isItemPresent(String dropDownValue) {
//        return actionsWithWebElements.isElementPresent(addedItem);
//    }

    /**
     * Compare that added item in cart the same as was selected from items list
     * @param id
     * @return
     */
    public boolean checkItemsFromCartList(String id) {
        List<WebElement> elements = listElementsInCart.findElements(By.xpath(".//a[@class='btnRemove']"));
        for (WebElement element : elements) {
            String value = element.getAttribute("data-vid");
            if (value != null && value.equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Click on Create Order button
     */
    public void clickOnCreateOrderButton() {
        actionsWithWebElements.clickOnWebElement(buttonCreateOrder);
    }
}

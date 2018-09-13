package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IzbranoePage extends ParentPage {

    @FindBy(xpath = ".//div[@id='grid']")
    WebElement listElementsInIzbranoe;
    @FindBy(xpath =".//h1[text()='Избранное']")
    WebElement breadcrumbIzbranoe;


    public IzbranoePage(WebDriver webDriver) {
        super(webDriver);
    }


    /**
     * Compare that added to Izbranoe item the same as was added from details item page
     * @param id
     * @return true or false
     */

    public boolean checkItemsFromIzbranoeList(String id) {
        List<WebElement> elements = listElementsInIzbranoe.findElements(By.xpath(".//input[@class='safeCheckbox']"));
        for (WebElement element : elements) {
            String value = element.getAttribute("value");
            if (value != null && value.equals(id)) {
                return true;
            }
        }
        return false ;
    }

    /**
     * Check displayed breadcrumb
     * @return
     */
    public boolean isIzbranoeBreadcrumbPresent() {
        return actionsWithWebElements.isElementPresent(breadcrumbIzbranoe);
    }
}

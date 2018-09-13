package Pages;

import enums.CheckBoxState;
import libs.ActionsWithWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    ActionsWithWebElements actionsWithWebElements;


    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionsWithWebElements = new ActionsWithWebElements(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Scroll to element that not visible on screen
     *
     * @param xpath
     * @throws InterruptedException
     */
    public void scrollToElement(String xpath) throws InterruptedException {
        WebElement element = webDriver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-200);", element);
        Thread.sleep(500);
    }

    /**
     * Select/Unselect checkbox
     *
     * @param xpath
     * @param checkBoxState
     * @throws InterruptedException
     */

    public void selectCheckbox(String xpath, CheckBoxState checkBoxState) throws InterruptedException {
        WebElement element = webDriver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-200);", element);
        Thread.sleep(500);
        actionsWithWebElements.setStateToCheckbox(xpath, checkBoxState);
    }

}






   /* Enter text into input field by xpath

   public void enterTextInToInputField (String xpath, String text) throws InterruptedException {
       WebElement element = webDriver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);"+"window.scrollBy(0,-200);",element);
     Thread.sleep(500);
       actionsWithWebElements.enterTextInToInput(xpath, text);
   }
   */



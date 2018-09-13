package libs;

import enums.CheckBoxState;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithWebElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Enter data into input field by WebElement
     * @param input
     * @param text
     */

    public void enterTextInToInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed to input ");
        } catch (Exception e) {
            logger.error("Cannot work with input");
            Assert.fail("Cannot work with input");
        }


    }

    /**
     * Enter data into input field by xpath
     * @param xpath
     * @param text
     */

    public void enterTextInToInput(String xpath, String text) {
        WebElement input = webDriver.findElement(By.xpath(xpath));
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed to input ");
        } catch (Exception e) {
            logger.error("Cannot work with input");
            Assert.fail("Cannot work with input");
        }


    }

    /**
     * Click on Element with wait
     * @param element
     */
    public void clickOnWebElement(WebElement element) {
        try {
            Thread.sleep(2000);
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }

    /**
     * Check if Element Present
     * @param element
     * @return
     */

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed() && element.isEnabled();

        } catch (Exception e) {
            return false;

        }
    }

    /**
     * Select item from dropdown by Text
     * @param elementDD
     * @param textForSelect
     */
    public void selectItemInDropDownByVisibleText(WebElement elementDD, String textForSelect) {
        try {
            Select optionsFromDD = new Select(elementDD);
            optionsFromDD.selectByVisibleText(textForSelect);
            logger.info(textForSelect + " was selected in DD");

        } catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }

    }

    /**
     * Select item from dropdown by Value in dropdown
     * @param elementDD
     * @param valueInDD
     */
    public void selectItemInDropDownByValue(WebElement elementDD, String valueInDD) {
        try {
            Select optionsFromDD = new Select(elementDD);
            optionsFromDD.selectByValue(valueInDD);
            logger.info(valueInDD + " was select in DD");

        } catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }

    }

    /**
     * Set state to Checkbox - Checked or Unchecked
     * @param xpath
     * @param checkBoxState
     */
    public void setStateToCheckbox (String xpath, CheckBoxState checkBoxState) {
        WebElement element = webDriver.findElement(By.xpath(xpath));
        boolean selected = element.isSelected();

        if (selected && checkBoxState == CheckBoxState.CHECKED){
            logger.info("Element is checked");
        }else if (selected && checkBoxState == CheckBoxState.UNCHECKED){
            clickOnWebElement(element);
        }else if (!selected && checkBoxState == CheckBoxState.CHECKED){
            clickOnWebElement(element);
        }else if (!selected && checkBoxState == CheckBoxState.UNCHECKED){
            logger.info("Element is unchecked");
        }
    }

}

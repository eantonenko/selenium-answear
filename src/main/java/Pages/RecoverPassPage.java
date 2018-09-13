package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecoverPassPage extends ParentPage {

    @FindBy(xpath = ".//input[@name='reminder[email]']")
    WebElement inputEmail;
    @FindBy(xpath = ".//input[@class='gold btnRight']")
    WebElement buttonSent;

    public RecoverPassPage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean isEmailForgotPresent() {
        return actionsWithWebElements.isElementPresent(inputEmail);
    }

    public void enterEmailInToEmailForgot(String email) {
        actionsWithWebElements.enterTextInToInput(inputEmail,email);
    }

    public void clickOnSentButton() {
        actionsWithWebElements.clickOnWebElement(buttonSent);
    }
}

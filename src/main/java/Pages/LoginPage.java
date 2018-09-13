package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {


    @FindBy(xpath = ".//input[@id='l1']")
    WebElement inputEmail;
    @FindBy(xpath = ".//input[@id='l2']")
    WebElement inputPass;
    @FindBy(xpath = ".//button[@id='loginFormSubmit']")
    WebElement buttonVoiti;
    @FindBy(xpath = ".//a[@href='/profil/nye_pomnyu_parol.html']")
    WebElement linkForgotPass;
    @FindBy(xpath = ".//dl[@class='messageInfo clearfix']//dd[text()=('Электронное письмо выслано')]")
    WebElement infoTest;
    @FindBy(xpath = ".//a[@ class='btn black']")
    WebElement buttonCreateAccount;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isEmailInputFieldPresent() {
        return actionsWithWebElements.isElementPresent(inputEmail);

    }

    public void enterEmailIntoInputEmail(String email) {

        actionsWithWebElements.enterTextInToInput(inputEmail, email);
    }

    public void enterPassIntoInputPass(String pass) {
        actionsWithWebElements.enterTextInToInput(inputPass, pass);

    }

    public void cliclOnButtonVoiti() {
        actionsWithWebElements.clickOnWebElement(buttonVoiti);
    }

    public void clickOnForgotPassLink() {
        actionsWithWebElements.clickOnWebElement(linkForgotPass);

    }

    public boolean isSentMessagePresent() {
        return actionsWithWebElements.isElementPresent(infoTest);
    }

    public void clickOnButtonCreateAccount() {
        actionsWithWebElements.clickOnWebElement(buttonCreateAccount);
    }


    /**
     * Login with email and pass
     * @param login
     * @param pass
     */
    public void loginUser(String login, String pass) {
        enterEmailIntoInputEmail(login);
        enterPassIntoInputPass(pass);
        cliclOnButtonVoiti();
    }
}
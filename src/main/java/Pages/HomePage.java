package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//ul[@id='mainPanel']//li[@id='panelLogin']//a[@ href='/profil/vojti.html']")
    WebElement voiti;
    @FindBy(xpath = ".//ul[@id='mainPanel']//li[@id='panelAccount']//a[@ href='/profil/izmyenit.html']")
    WebElement accaunt;
    @FindBy(xpath = ".//dl[@class='messageInfo clearfix']//dd[text()=('Вы вошли в свой аккаунт')]")
    WebElement infoText;
    @FindBy(xpath = ".//ul[@id='mainPanel']//li[@id='panelSearch']//a[@ href='']")
    WebElement searchLink;
    @FindBy(xpath = ".//input[@id='searchInput']")
    WebElement inputSearch;
    @FindBy(xpath = ".//a[@id='btnSearch']")
    WebElement buttonSearch;



    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isVoitiPresent() {
        return actionsWithWebElements.isElementPresent(voiti);

    }

    public void clickOnVoitiLink (){

        actionsWithWebElements.clickOnWebElement(voiti);
    }

    public void openHomePage() {
        try {
            webDriver.get("https://answear.ua");
            logger.info("Home page was opened");
        } catch (Exception e) {
            logger.error("Can not open URL");
            Assert.fail("Can not open URL");

        }
    }

    public boolean isAccauntPresent() {
        return actionsWithWebElements.isElementPresent(accaunt);

    }

    public boolean isInfoTextPresent() {
        return actionsWithWebElements.isElementPresent(infoText);
    }


    public void clickOnSearchLink() {
        actionsWithWebElements.clickOnWebElement(searchLink);
    }

    /**
     * Enter text for search
     * @param nameItem
     */
    public void enterNameItemIntoInputSearch(String nameItem) {
        actionsWithWebElements.enterTextInToInput(inputSearch,nameItem);
    }

    public void clickOnSearchButton() {
        actionsWithWebElements.clickOnWebElement(buttonSearch);
    }
}

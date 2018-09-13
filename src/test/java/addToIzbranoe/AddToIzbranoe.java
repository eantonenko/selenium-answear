package addToIzbranoe;

import org.junit.Test;
import parentTest.ParentTest;

public class AddToIzbranoe extends ParentTest {

    @Test
    public  void addToIzbranoeItem() throws InterruptedException {

        homePage.openHomePage();
        checkAcceptanceCriteria("Voiti avatar is not present", homePage.isVoitiPresent(), true);
        homePage.clickOnVoitiLink();
        checkAcceptanceCriteria("Email input field is not present", loginPage.isEmailInputFieldPresent(), true);
        loginPage.loginUser("anna1anna@gmail.com","qwerty");
        checkAcceptanceCriteria("Accaunt avatar is not present", homePage.isAccauntPresent(), true);
        checkAcceptanceCriteria("Info message is present", homePage.isInfoTextPresent(), true);
        homePage.clickOnSearchLink();
        homePage.enterNameItemIntoInputSearch("adidas originals кроссовки");
        homePage.clickOnSearchButton();
        checkAcceptanceCriteria("Filters dropdown is not present", itemsListPage.isFiltersDropDownPresent(), true);
        itemsListPage.clickOnClosePopup();
        itemsListPage.clickOnItemName();
        checkAcceptanceCriteria("Item breadcrumb is not present", itemDetailsPage.isItemBreadcrumbPresentIzbranoe(), true);
        itemsListPage.clickOnClosePopup();
        String dropDownValue = itemDetailsPage.getDropDownValue();
        itemDetailsPage.selectItemSizeinDropDown(dropDownValue);
        itemsListPage.clickOnClosePopup();
        itemDetailsPage.clickOnIzbranoeLink();
        checkAcceptanceCriteria("Info text is not preent", itemDetailsPage.isInfoTextGreenPresent(),true);
        itemDetailsPage.cliclOnIzbranoeButton();
        checkAcceptanceCriteria("Izbranoe Breadcrumb is not present", izbranoePage.isIzbranoeBreadcrumbPresent(), true);
        checkAcceptanceCriteria("Image is not present", izbranoePage.checkItemsFromIzbranoeList(dropDownValue), true);


    }
}
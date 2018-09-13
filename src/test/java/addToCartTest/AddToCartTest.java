package addToCartTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddToCartTest extends ParentTest {
    @Test
    public void addToCartItem() {
        homePage.openHomePage();
        checkAcceptanceCriteria("Voiti avatar is not present", homePage.isVoitiPresent(), true);
        homePage.clickOnVoitiLink();
        checkAcceptanceCriteria("Email input field is not present", loginPage.isEmailInputFieldPresent(), true);
//        loginPage.enterEmailIntoInputEmail("anna1anna@gmail.com");
//        loginPage.enterPassIntoInputPass("qwerty");
//        loginPage.cliclOnButtonVoiti();
        loginPage.loginUser("anna1anna@gmail.com","qwerty");
        checkAcceptanceCriteria("Accaunt avatar is not present", homePage.isAccauntPresent(), true);
        checkAcceptanceCriteria("Info message is present", homePage.isInfoTextPresent(), true);
        homePage.clickOnSearchLink();
        homePage.enterNameItemIntoInputSearch("trussardi jeans кроссовки");
        homePage.clickOnSearchButton();
        checkAcceptanceCriteria("Filters dropdown is not present", itemsListPage.isFiltersDropDownPresent(), true);
        itemsListPage.clickOnClosePopup();
        itemsListPage.clickOnItemName();
        checkAcceptanceCriteria("Item breadcrumb is not present", itemDetailsPage.isItemBreadcrumbPresent(), true);
        itemsListPage.clickOnClosePopup();
        String dropDownValue = itemDetailsPage.getDropDownValue();
        itemDetailsPage.selectItemSizeinDropDown(dropDownValue);
        itemsListPage.clickOnClosePopup();
        itemDetailsPage.clickOnToCartButton();
        checkAcceptanceCriteria("Create Button is not present", itemDetailsPage.isCreateOrderButtonPresent(), true);
        itemDetailsPage.clickOnCreateOrderButton();
        checkAcceptanceCriteria("Cart Breadcrumb is not present", cartPage.isCartBreadcrumbPresent(), true);
        checkAcceptanceCriteria("Image is not present", cartPage.checkItemsFromCartList(dropDownValue), true);
    }
}
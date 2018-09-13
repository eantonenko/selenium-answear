package orderItemTest;

import enums.CheckBoxState;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class OrderItemTest extends ParentTest {

    @Test
    public void createOrderItemTest() throws InterruptedException {

        String buttonCreateOrder = (".//a[@href='/kasa-1/adres.html']");
        String acceptCheckboxXpath = (".//input[@ id='c24']//..//i[@class='cb']");

        homePage.openHomePage();
        checkAcceptanceCriteria("Voiti avatar is not present", homePage.isVoitiPresent(), true);
        homePage.clickOnVoitiLink();
        checkAcceptanceCriteria("Email input field is not present", loginPage.isEmailInputFieldPresent(), true);
        loginPage.loginUser("anna1anna@gmail.com", "qwerty");
        checkAcceptanceCriteria("Accaunt avatar is not present", homePage.isAccauntPresent(), true);
        checkAcceptanceCriteria("Info message is present", homePage.isInfoTextPresent(), true);
        homePage.clickOnSearchLink();
        homePage.enterNameItemIntoInputSearch("reebok футболка");
        homePage.clickOnSearchButton();
        checkAcceptanceCriteria("Filters dropdown is not present", itemsListPage.isFiltersDropDownPresent(), true);
        itemsListPage.clickOnClosePopup();
        itemsListPage.clickOnItemName();
        checkAcceptanceCriteria("Item breadcrumb is not present", itemDetailsPage.isItemBreadcrumbPresentOrder(), true);
        itemsListPage.clickOnClosePopup();
        String dropDownValue = itemDetailsPage.getDropDownValue();
        itemDetailsPage.selectItemSizeinDropDown(dropDownValue);
        itemsListPage.clickOnClosePopup();
        itemDetailsPage.clickOnToCartButton();
        checkAcceptanceCriteria("Create Button is not present", itemDetailsPage.isCreateOrderButtonPresent(), true);
        itemDetailsPage.clickOnCreateOrderButton();
        checkAcceptanceCriteria("Cart Breadcrumb is not present", cartPage.isCartBreadcrumbPresent(), true);
        checkAcceptanceCriteria("Image is not present", cartPage.checkItemsFromCartList(dropDownValue), true);
        parentPage.scrollToElement(buttonCreateOrder);
        cartPage.clickOnCreateOrderButton();
        checkAcceptanceCriteria("Create Order dropdown is not present", orderAdressPage.isCreateOrderDropdownPresent(),true);
        checkAcceptanceCriteria("Dannue clienta text is not present",orderAdressPage.isDannueClientaTextPresent(),true);
        parentPage.selectCheckbox(acceptCheckboxXpath, CheckBoxState.CHECKED);
        boolean isSelected = orderAdressPage.isAcceptedCheckboxPressed();
        Assert.assertTrue(isSelected);
        orderAdressPage.clickOnToCashButton();
        checkAcceptanceCriteria("Sposob dostavki text is not present", orderDostavkaPage.isDostavkaTextPresent(),true);
    }
}

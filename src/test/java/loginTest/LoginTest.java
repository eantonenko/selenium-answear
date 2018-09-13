package loginTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest{
    @Test
    public void validLogin (){
       homePage.openHomePage();
       checkAcceptanceCriteria("Voiti avatar is not present", homePage.isVoitiPresent(), true
        );
        homePage.clickOnVoitiLink();
       checkAcceptanceCriteria("Email input field is not present",loginPage.isEmailInputFieldPresent(), true);
       loginPage.enterEmailIntoInputEmail("anna1anna@gmail.com");
       loginPage.enterPassIntoInputPass("qwerty");
       loginPage.cliclOnButtonVoiti();
       checkAcceptanceCriteria("Accaunt avatar is not present", homePage.isAccauntPresent(),true);
       checkAcceptanceCriteria("Info message is present", homePage.isInfoTextPresent(),true);
    }

    @Test
    public void invalidLogin (){
        homePage.openHomePage();
        checkAcceptanceCriteria("Voiti avatar is not present", homePage.isVoitiPresent(), true
        );
        homePage.clickOnVoitiLink();
        checkAcceptanceCriteria("Email input field is not present",loginPage.isEmailInputFieldPresent(), true);
        loginPage.enterEmailIntoInputEmail("anna1anna@gmail.com");
        loginPage.enterPassIntoInputPass("qwerty1");
        loginPage.cliclOnButtonVoiti();
        Assert.assertTrue("Email input field is not present", loginPage.isEmailInputFieldPresent());

    }

}

package forgotPassTest;

import org.junit.Test;
import parentTest.ParentTest;

public class FotgotPassTest extends ParentTest {
    @Test
    public void RecoverPass (){
        homePage.openHomePage();
        checkAcceptanceCriteria("Voiti avatar is not present", homePage.isVoitiPresent(), true
        );
        homePage.clickOnVoitiLink();
        checkAcceptanceCriteria("Email input field is not present",loginPage.isEmailInputFieldPresent(), true);
        loginPage.clickOnForgotPassLink();
        checkAcceptanceCriteria("EmailForgot input is not present", recoverPassPage.isEmailForgotPresent(),true);
        recoverPassPage.enterEmailInToEmailForgot("OM12345@gmail.com");
        recoverPassPage.clickOnSentButton();
        checkAcceptanceCriteria("Email input field is not present",loginPage.isEmailInputFieldPresent(), true);
        checkAcceptanceCriteria("Sent message is not present",loginPage.isSentMessagePresent(), true);
    }
}

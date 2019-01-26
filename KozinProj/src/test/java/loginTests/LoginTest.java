package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    @Test
    public void validLogIn() {
        loginPage.openPage();
        loginPage.enterLogin("admin_test");
        loginPage.enterPass("admin_test");
        loginPage.clickOnSubmitButton();
        loginPage.clickOnSubmitEnter();

        checkAC("Avatar is not present", homePage.isAvatarPresent(), true);
    }

    @Test
    public void invalidLogIn() {
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("90");
        loginPage.clickOnSubmitButton();
        loginPage.clickOnSubmitEnter();
        checkAC("Submit button is not present", homePage.isSubmitButtonPresent(), true);
        checkAC("Avatar is present", homePage.isAvatarPresent(), false);
    }
}


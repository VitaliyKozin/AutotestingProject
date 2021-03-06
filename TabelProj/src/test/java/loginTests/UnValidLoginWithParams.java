package loginTests;

import org.junit.Test;    ///junit - средство управления  тестами
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)  //этот класс нужно запустить с разными параметрами

 /*
 * Тест с разными параметрами
 */
public class UnValidLoginWithParams extends ParentTest {
    String login, pass;

    public UnValidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    /**
     * блок который будет генерить разные параметры
     */
    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{   //Набор данных
                {"Login","909090"},
                {"Student", "906090"}
        });

    }

    @Test
    public void inValidLogin() {
        loginPage.openPage();
        loginPage.enterLogin(login);
        loginPage.enterPass(pass);
        loginPage.clickOnSubmitButton();

        checkAC("Avatar wasn't expected", homePage.isAvatarPresent(), false);

    }
}

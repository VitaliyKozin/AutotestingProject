package loginTests;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class UnvalidLoginWithParamsWithExcel extends ParentTest {

    String login , pass;

    public UnvalidLoginWithParamsWithExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    public static Collection testData () throws IOException {
//        return Arrays.asList(new Object[][] {
//                {"Login", "909090"},
//                {"Student", "906090"}
//        });
        InputStream spreadSheet = new FileInputStream(configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(spreadSheet, "InvalidLogOn").getData();
    }

    @Test

    public void invalidLoginWithParams () {
        loginPage.openPage();
        loginPage.enterLogin(login);
        loginPage.enterPass(pass);
        loginPage.clickOnSubmitButton();

        checkAC("Avatar wasn't expected", homePage.isAvatarPresent(), false );

    }
}

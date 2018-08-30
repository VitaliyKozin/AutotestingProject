package suites;

import loginTests.LoginTestWithOutPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTestWithOutPageObject.class
        }
)

public class LoginSuite {
}

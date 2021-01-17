package scenario.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import scenario.base.BaseTest;
import scenario.page.LoginPage;
import scenario.util.Configuration;

public class LoginTest extends BaseTest {

    protected static final Configuration config = Configuration.getInstance();

    @Test
    public void login() {

        LoginPage lp = new LoginPage(getDriver());

        boolean isDeliverToExist = lp.clickNavSignInButton()
                .typeEmail(config.getUserEmail())
                .clickContinueButton()
                .typePassword(config.getUserPassword())
                .clickSignInButton()
                .isDeliverZoneExist();

        Assert.assertTrue(isDeliverToExist);
    }
}

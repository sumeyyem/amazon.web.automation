package scenario.base;

import factory.DriverFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import scenario.util.Configuration;

public class BaseTest extends DriverFactory {

    protected static final Configuration config = Configuration.getInstance();

    @BeforeSuite(alwaysRun = true)
    public void setUp(ITestContext context) {

        createDriver();
        getDriver().get(config.getBaseUrl());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(ITestContext context) {

        getDriver().quit();
    }
}

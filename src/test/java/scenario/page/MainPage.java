package scenario.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import scenario.base.BasePage;

public class MainPage extends BasePage {

    private static final By DELIVER_TO = By.cssSelector("[id='glow-ingress-line2']");

    public MainPage(RemoteWebDriver driver) {

        super(driver);
    }

    public boolean isDeliverZoneExist() {

        return isElementExist(DELIVER_TO);
    }
}

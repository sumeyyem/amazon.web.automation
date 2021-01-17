package scenario.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import scenario.base.BasePage;

public class LoginPage extends BasePage {

    private static final By NAV_SIGN_IN_BUTTON = By.cssSelector("[data-nav-ref='nav_ya_signin']");
    private static final By EMAIL_INPUT = By.cssSelector("[id='ap_email']");
    private static final By CONTINUE_BUTTON = By.cssSelector("[id='continue']");
    private static final By PASSWORD_INPUT = By.cssSelector("[id='ap_password']");
    private static final By SIGN_IN_BUTTON = By.cssSelector("[id='signInSubmit']");

    public LoginPage(RemoteWebDriver driver) {

        super(driver);
    }

    public LoginPage clickNavSignInButton() {

        clickElement(NAV_SIGN_IN_BUTTON);
        return this;
    }

    public LoginPage typeEmail(String email) {

        fillInputField(EMAIL_INPUT, email, false);
        return this;
    }

    public LoginPage clickContinueButton() {

        clickElement(CONTINUE_BUTTON);
        return this;
    }

    public LoginPage typePassword(String password) {

        fillInputField(PASSWORD_INPUT, password, false);
        return this;
    }

    public MainPage clickSignInButton() {

        clickElement(SIGN_IN_BUTTON);
        return new MainPage(driver);
    }
}

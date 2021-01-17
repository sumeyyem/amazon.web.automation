package scenario.base;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected static final int DEFAULT_WAIT = 5;
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;

    public BasePage(RemoteWebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_WAIT);
    }

    /**
     * Use this method to find element by By
     *
     * @return A MobileElement, or an empty if nothing matches
     */
    protected WebElement findElement(By by, int... index) {

        waitUntilElementAppears(by);
        return index.length == 0
                ? driver.findElement(by)
                : driver.findElements(by).get(index[0]);
    }

    /**
     * Use this method to find elements by By
     *
     * @return A list of MobileElements, or an empty if nothing matches
     */
    protected List<WebElement> findElements(By by) {

        return driver.findElements(by);
    }

    /**
     * Use this method click to element
     */
    protected void clickElement(By by, int... index) {

        waitUntilElementClickable(by);

        WebElement element = index.length == 0
                ? findElement(by)
                : findElement(by, index[0]);

        highlightElement(element);
        element.click();
    }

    /**
     * Use this method to simulate typing into an element if it is enable.
     * Send enter if pressEnter is true, do nothing otherwise.
     * Note : Before sending operation, element is cleared.
     */
    protected void fillInputField(By by, String text, boolean pressEnter) {

        waitUntilElementClickable(by);
        WebElement element = findElement(by);

        highlightElement(element);
        clearElementField(by);
        element.sendKeys(text);

        if (pressEnter) element.sendKeys(Keys.ENTER);
    }

    /**
     * Use this method to clear element
     */
    protected void clearElementField(By by) {

        WebElement element = findElement(by);
        element.click();
        element.clear();
    }

    /**
     * Get the visible (i.e. not hidden by CSS) innerText of this element.
     *
     * @return The innerText of this element.
     */
    protected String getTextOfElement(By by, int... index) {

        return index.length == 0
                ? findElement(by).getText()
                : findElement(by, index[0]).getText();
    }

    /**
     * @return The attribute value of this element.
     */
    protected String getAttributeOfElement(By by, String attributeName) {

        return findElement(by).getAttribute(attributeName);
    }

    /**
     * Wait until element appears
     */
    protected void waitUntilElementAppears(By by) { wait.until(ExpectedConditions.visibilityOfElementLocated(by)); }

    /**
     * Wait until element disappears
     */
    protected void waitUntilElementDisappears(By by) { wait.until(ExpectedConditions.invisibilityOfElementLocated(by)); }

    /**
     * Wait until element to be clickable
     */
    protected void waitUntilElementClickable(By by) {
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * @return True if element exists, false otherwise.
     */
    protected boolean isElementExist(By by) {

        try {

            waitUntilElementAppears(by);
            return findElements(by).size() == 1;
        } catch (TimeoutException e) {

            return false;
        }
    }

    /**
     * Highlight element for visual effect
     */
    protected void highlightElement(WebElement element) {

        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                "color: red; border: 1px dashed red;");
    }
}

package scenario.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import scenario.base.BasePage;

public class OrderPage extends BasePage {

    private static final By SEARCH_INPUT = By.cssSelector("[id='twotabsearchtextbox']");
    private static final By SEARCH_BUTTON = By.cssSelector("[id='nav-search-submit-button']");
    private static final By FOUR_AND_UP_STAR_BUTTON = By.cssSelector("[class='a-icon a-icon-star-medium a-star-medium-4']");
    private static final By LOW_PRICE_INPUT = By.cssSelector("[id='low-price']");
    private static final By HIGH_PRICE_INPUT = By.cssSelector("[id='high-price']");
    private static final By FIRST_PRODUCT_ON_THE_LIST = By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]");
    private static final By SEE_ALL_BUYING_OPTION_BUTTON = By.cssSelector("[id='buybox-see-all-buying-choices-announce']");
    private static final By ADD_TO_CART_BUTTON = By.xpath("(//*[@class='a-button a-button-primary aod-atc-generic-btn-desktop'])[2]");
    private static final By CART_BUTTON = By.cssSelector("[id='nav-cart']");
    private static final By COUNTRY_DROPDOWN = By.cssSelector("[class='a-button-text a-declarative']");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("[data-feature-id='proceed-to-checkout-action']");
    private static final By FULL_NAME_INPUT = By.cssSelector("[id='address-ui-widgets-enterAddressFullName']");
    private static final By ADDRESS_INPUT = By.cssSelector("[id='address-ui-widgets-enterAddressLine1']");
    private static final By CITY_INPUT = By.cssSelector("[id='address-ui-widgets-enterAddressCity']");
    private static final By REGION_INPUT = By.cssSelector("[id='address-ui-widgets-enterAddressStateOrRegion']");
    private static final By ZIP_CODE_INPUT = By.cssSelector("[id='address-ui-widgets-enterAddressPostalCode']");
    private static final By PHONE_NUMBER_INPUT = By.cssSelector("[id='address-ui-widgets-enterAddressPhoneNumber']");
    private static final By USE_THIS_ADDRESS_BUTTON = By.xpath("//*[@id='address-ui-widgets-form-submit-button-announce']/..");
    private static final By USE_THIS_ADDRESS_BUTTON2 = By.cssSelector("[class='a-declarative a-button-text checkout-continue-link']");
    private static final By CONTINUE_BUTTON = By.xpath("(//*[@value='Continue'])[1]");
    private static final By CONTINUE_BUTTON2 = By.xpath("(//*[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent'])[1]");
    private static final By GO_BUTTON = By.xpath("//*[@id='a-autoid-1-announce']/..");
    private static final By REMOVE_ADDRESS_BUTTON = By.cssSelector("[data-action='checkout-delete-address']");
    private static final By PLACE_YOUR_ORDER = By.xpath("(//*[@class='a-button-text place-your-order-button'])[1]");

    public OrderPage(RemoteWebDriver driver) {

        super(driver);
    }

    public OrderPage typeGoodsNameInSearchInput(String goodsName) {

        fillInputField(SEARCH_INPUT, goodsName, false);
        return this;
    }

    public OrderPage clickSearchButton() {

        clickElement(SEARCH_BUTTON);
        return this;
    }

    public OrderPage clickFourAndUpStarButton() {

        clickElement(FOUR_AND_UP_STAR_BUTTON);
        return this;
    }

    public OrderPage typeLowPrice(String price) {

        fillInputField(LOW_PRICE_INPUT, price, false);
        return this;
    }

    public OrderPage typeHighPrice(String price) {

        fillInputField(HIGH_PRICE_INPUT, price, false);
        return this;
    }

    public OrderPage clickGoButton() {

        clickElement(GO_BUTTON);
        return this;
    }

    public OrderPage selectBrand(String brandName) {

        String xpath = "//*[@aria-label='" + brandName + "']/*";
        clickElement(By.xpath(xpath));
        return this;
    }

    public OrderPage selectSeller(String sellerName) {

        String xpath = "//*[@aria-label='" + sellerName + "']/*";
        clickElement(By.xpath(xpath));
        return this;
    }

    public OrderPage clickFirstProductOnTheList() {

        clickElement(FIRST_PRODUCT_ON_THE_LIST);
        return this;
    }

    public OrderPage clickSeeAllBuyingOptionButton() {

        clickElement(SEE_ALL_BUYING_OPTION_BUTTON);
        return this;
    }

    public OrderPage clickAddToCartButton() {

        clickElement(ADD_TO_CART_BUTTON);
        return this;
    }

    public OrderPage clickCartButton() {

        clickElement(CART_BUTTON);
        return this;
    }

    public OrderPage clickProceedToCheckOutButton() {

        clickElement(PROCEED_TO_CHECKOUT_BUTTON);
        return this;
    }

    public OrderPage clickRemoveAddressButton() {

        if (isElementExist(REMOVE_ADDRESS_BUTTON)) clickElement(REMOVE_ADDRESS_BUTTON);
        return this;
    }

    public OrderPage selectCountry(String countryName) throws InterruptedException {

        String xpath = "(//*[text()='" + countryName + "'])[2]";
        clickElement(COUNTRY_DROPDOWN);
        clickElement(By.xpath(xpath));
        return this;
    }

    public OrderPage enterFullName(String fullName) {

        fillInputField(FULL_NAME_INPUT, fullName, false);
        return this;
    }

    public OrderPage enterAddress(String address) {

        fillInputField(ADDRESS_INPUT, address, false);
        return this;
    }

    public OrderPage enterCity(String cityName) {

        fillInputField(CITY_INPUT, cityName, false);
        return this;
    }

    public OrderPage enterRegion(String regionName) {

        fillInputField(REGION_INPUT, regionName, false);
        return this;
    }

    public OrderPage enterZipCode(String zipCode) {

        fillInputField(ZIP_CODE_INPUT, zipCode, false);
        return this;
    }

    public OrderPage enterPhone(String phoneNumber) {

        fillInputField(PHONE_NUMBER_INPUT, phoneNumber, false);
        return this;
    }

    public OrderPage clickUseThisAddressButton() {

        clickElement(USE_THIS_ADDRESS_BUTTON);
        return this;
    }

    public OrderPage clickUseThisAddressButton2() {

        clickElement(USE_THIS_ADDRESS_BUTTON2);
        return this;
    }

    public OrderPage clickContinueButton() {

        if (isElementExist(CONTINUE_BUTTON)) clickElement(CONTINUE_BUTTON);
        else clickElement(CONTINUE_BUTTON2);

        return this;
    }

    public OrderPage waitUntilGivenTime(int second) throws InterruptedException {

        Thread.sleep(second * 1000);
        return this;
    }

    public boolean isPlaceYourOrderButton() {

        return isElementExist(PLACE_YOUR_ORDER);
    }
}

package scenario.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import scenario.base.BaseTest;
import scenario.page.OrderPage;

import static key.Keys.*;

public class OrderTest extends BaseTest {

    private static OrderPage op;

    @BeforeClass
    public void before() {

        op = new OrderPage(getDriver());
    }

    @Test
    public void orderPlayStation4Test() throws InterruptedException {

        op.typeGoodsNameInSearchInput(PLAYSTATION4)
                .clickSearchButton()
                .clickFourAndUpStarButton()
                .selectBrand(PLAYSTATION)
                .waitUntilGivenTime(3)
                .typeLowPrice(FOUR_HUNDRED)
                .typeHighPrice(FIVE_HUNDRED_FIFTY)
                .clickGoButton()
                .waitUntilGivenTime(3)
                .selectSeller(RAYENHOLM_ELECTRONICS)
                .waitUntilGivenTime(3)
                .clickFirstProductOnTheList()
                .clickBuyNowButton()
                .clickRemoveAddressButton()
                .waitUntilGivenTime(3)
                .selectCountry(TURKEY)
                .waitUntilGivenTime(3)
                .enterFullName(SUMEYYE_KARAKUS)
                .enterAddress(ADDRESS)
                .enterCity(ISTANBUL)
                .enterRegion(KARTAL)
                .enterZipCode(ZIP_CODE)
                .enterPhone(PHONE_NUMBER)
                .waitUntilGivenTime(3)
                .clickUseThisAddressButton()
                .clickContinueButton()
                .clickUseThisAddressButton2();

        Assert.assertTrue(op.isPlaceYourOrderButton());
    }
}

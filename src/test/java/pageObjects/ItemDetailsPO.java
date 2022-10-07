package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;

public class ItemDetailsPO extends BasePO {
    public ItemDetailsPO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADICIONAR À CESTA']")
    MobileElement addItemToCest;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='COMPRAR AGORA']")
    MobileElement buyNowButtonOfModalItemDetails;

    private void clickOnAddItemOnCest() {
        AppiumUtils.waitAndClick(addItemToCest, driver);
    }

    private void clickOnBuyNowOnModalOfItemDetail() {
        AppiumUtils.waitAndClick(buyNowButtonOfModalItemDetails, driver);
    }

    public void addItemToCest() {
        clickOnAddItemOnCest();
        clickOnBuyNowOnModalOfItemDetail();
    }
}

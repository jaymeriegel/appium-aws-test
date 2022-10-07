package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;

public class OrderPO extends BasePO {
    public OrderPO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='ACOMPANHAR PEDIDO']")
    MobileElement trackingOrderButton;

    private void clickOnTrackingOrderButton() {
        AppiumUtils.waitAndClick(trackingOrderButton, driver);
    }

    public boolean validSuccessOrder() {
        return trackingOrderButton.isDisplayed();
    }
}

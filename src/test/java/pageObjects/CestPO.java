package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;

public class CestPO extends BasePO {
    public CestPO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ENTREGA']")
    MobileElement goToShippingButton;

    public void clickOnGoToShipping() {
        AppiumUtils.waitAndClick(goToShippingButton, driver);
    }
}

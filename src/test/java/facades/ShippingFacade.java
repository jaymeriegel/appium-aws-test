package facades;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ShippingFacade extends PageFacades {
    public ShippingFacade(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void addFastShippingByCest() {
        getCestPO().clickOnGoToShipping();
        getShippingPO().clickOnFastShippingButtonForFirstPackage();
    }
}

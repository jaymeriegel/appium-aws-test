package facades;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PaymentFacade extends PageFacades {
    public PaymentFacade(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void addCashPaymentByShipping() {
        getShippingPO().clickOnGoToPaymentButton();
        getPaymentPO().addCashPayment("100000");
    }
}

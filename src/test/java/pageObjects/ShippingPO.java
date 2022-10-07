package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;

public class ShippingPO extends BasePO {

    public ShippingPO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Entrega Programada']")
    MobileElement scheduledShippingButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Entrega Rápida']")
    MobileElement fastShippingButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PAGAMENTO']")
    MobileElement goToPaymentButton;

    private void clickOnFastShippingButtonOnFirstPackage() {
        AppiumUtils.waitAndClick(fastShippingButton, driver);
    }

    private void clickOnScheduledShippingButtonOnFirstPackage() {
        AppiumUtils.waitAndClick(scheduledShippingButton, driver);
    }

    public void clickOnGoToPaymentButton() {
        AppiumUtils.waitAndClick(goToPaymentButton, driver);
    }

    public void clickOnFastShippingButtonForFirstPackage() {
        AppiumUtils.staticWait(3000);
        AppiumUtils.verticalScroll(driver);
        scrollToElement(fastShippingButton);

        clickOnFastShippingButtonOnFirstPackage();
    }
}

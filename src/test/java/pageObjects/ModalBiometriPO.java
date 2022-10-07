package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;

public class ModalBiometriPO extends BasePO {
    public ModalBiometriPO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Não quero']")
    MobileElement naoQueroButton;

    public void clickOnNaoQueroButton() {
        AppiumUtils.waitAndClick(naoQueroButton, driver);
    }
}

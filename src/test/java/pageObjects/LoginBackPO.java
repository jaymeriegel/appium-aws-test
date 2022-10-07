package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;

public class LoginBackPO extends BasePO {

    public LoginBackPO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ENTRAR']")
    MobileElement entrarButton;

    public void clickOnEntrar() {
        AppiumUtils.staticWait(2000);
        AppiumUtils.waitAndClick(entrarButton, driver);
    }
}

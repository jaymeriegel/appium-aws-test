package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;

public class MenuPO extends BasePO {
    public MenuPO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ENTRAR']")
    MobileElement entrarButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SAIR']")
    MobileElement sairButton;

    public void clickOnEntrar() {
        AppiumUtils.waitAndClick(entrarButton, driver);
    }

    public void clickOnSair() {
        AppiumUtils.waitAndClick(sairButton, driver);
    }
}

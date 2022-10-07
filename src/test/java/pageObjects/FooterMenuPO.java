package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;

public class FooterMenuPO extends BasePO {
    public FooterMenuPO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uDB80\uDF5C']")
    MobileElement menuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    MobileElement homeButton;

    public void clickOnMenu() {
        AppiumUtils.waitAndClick(menuButton, driver);
    }

    public void clickOnHome() {
        AppiumUtils.waitAndClick(homeButton, driver);
    }
}

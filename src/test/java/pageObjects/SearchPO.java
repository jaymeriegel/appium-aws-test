package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumUtils;

public class SearchPO extends BasePO {

    public SearchPO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void clickOnFirstItem() {
        int x = 22;
        int y = 518;

        AppiumUtils.staticWait(5000);
        AppiumUtils.clickOnPoint(x, y, driver);
    }
}

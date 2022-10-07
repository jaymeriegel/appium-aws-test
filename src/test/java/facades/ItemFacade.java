package facades;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ItemFacade extends PageFacades {
    public ItemFacade(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void addItemByHome(String panvelCode) {
        getHomeScreenPO().searchBySearchBar(panvelCode);
        getSearchScreenPO().clickOnFirstItem();
        getItemDetailsPO().addItemToCest();
    }
}

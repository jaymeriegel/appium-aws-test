package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;

public class HomePO extends BasePO {
    public HomePO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='O que você procura?']")
    MobileElement searchBar;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Buscar na Panvel']")
    MobileElement searchBarToType;

    public void searchBySearchBar(String text) {
        clickOnSearchBar();
        typeOnSearchBar(text);
        AppiumUtils.clickEnterOnKeyBoard(driver);
    }

    private void typeOnSearchBar(String text) {
        AppiumUtils.waitAndSendKeys(searchBarToType, driver, text);
    }

    private void clickOnSearchBar() {
        AppiumUtils.waitAndClick(searchBar, driver);
    }
}

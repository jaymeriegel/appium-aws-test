package pageObjects.pageObjectFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageObjects.*;

public class POFactory {
    public static BasePO makePO(POEnums page, AppiumDriver<MobileElement> driver) {
        switch (page) {
            case FOOTER_MENU:
                return new FooterMenuPO(driver);
            case HOME:
                return new HomePO(driver);
            case ITEM_DETAILS:
                return new ItemDetailsPO(driver);
            case LOGIN_BACK:
                return new LoginBackPO(driver);
            case LOGIN:
                return new LoginPO(driver);
            case MENU:
                return new MenuPO(driver);
            case MODAL_BIOMETRI:
                return new ModalBiometriPO(driver);
            case SEARCH:
                return new SearchPO(driver);
            case CEST:
                return new CestPO(driver);
            case SHIPPING:
                return new ShippingPO(driver);
            case PAYMENT:
                return new PaymentPO(driver);
            case ORDER:
                return new OrderPO(driver);
        }
        return null;
    }
}

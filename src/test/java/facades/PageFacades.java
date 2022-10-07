package facades;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageObjects.*;
import pageObjects.pageObjectFactory.POEnums;
import pageObjects.pageObjectFactory.POFactory;

public class PageFacades {
    private static AppiumDriver<MobileElement> driverOn = null;
    private FooterMenuPO footerMenu;
    private MenuPO menuSceenPO;
    private LoginBackPO loginBackScreenPO;
    private LoginPO loginScreenPO;
    private ModalBiometriPO modalBiometriPO;
    private HomePO homeScreenPO;
    private SearchPO searchScreenPO;
    private ItemDetailsPO itemDetailsPO;
    private CestPO cestPO;
    private ShippingPO shippingPO;
    private PaymentPO paymentPO;
    private OrderPO orderPO;
    private static LoginFacade loginFacade;
    private static ItemFacade itemFacade;
    private static ShippingFacade shippingFacade;
    private static PaymentFacade paymentFacade;
    private static OrderFacade orderFacade;

    public PageFacades(AppiumDriver<MobileElement> driver) {
        driverOn = driver;
    }

    protected FooterMenuPO getFooterMenuPO() {
        return (footerMenu == null) ?
                footerMenu = (FooterMenuPO) POFactory.makePO(POEnums.FOOTER_MENU, driverOn) : footerMenu;
    }

    protected HomePO getHomeScreenPO() {
        return (homeScreenPO == null) ?
                homeScreenPO = (HomePO) POFactory.makePO(POEnums.HOME, driverOn) : homeScreenPO;
    }

    protected MenuPO getMenuScreenPO() {
        return (menuSceenPO == null) ?
                menuSceenPO = (MenuPO) POFactory.makePO(POEnums.MENU, driverOn) : menuSceenPO;
    }

    protected LoginBackPO getLoginBackScreenPO() {
        return (loginBackScreenPO == null) ?
                loginBackScreenPO = (LoginBackPO) POFactory.makePO(POEnums.LOGIN_BACK, driverOn) : loginBackScreenPO;
    }

    protected LoginPO getLoginScreenPO() {
        return (loginScreenPO == null) ?
                loginScreenPO = (LoginPO) POFactory.makePO(POEnums.LOGIN, driverOn) : loginScreenPO;
    }

    protected ModalBiometriPO getModalBiometriPO() {
        return (modalBiometriPO == null) ?
                modalBiometriPO = (ModalBiometriPO) POFactory.makePO(POEnums.MODAL_BIOMETRI, driverOn) : modalBiometriPO;
    }

    protected SearchPO getSearchScreenPO() {
        return (searchScreenPO == null) ?
                searchScreenPO = (SearchPO) POFactory.makePO(POEnums.SEARCH, driverOn) : searchScreenPO;
    }

    protected ItemDetailsPO getItemDetailsPO() {
        return (itemDetailsPO == null) ?
                itemDetailsPO = (ItemDetailsPO) POFactory.makePO(POEnums.ITEM_DETAILS, driverOn) : itemDetailsPO;
    }

    protected CestPO getCestPO() {
        return (cestPO == null) ?
                cestPO = (CestPO) POFactory.makePO(POEnums.CEST, driverOn) : cestPO;
    }

    protected ShippingPO getShippingPO() {
        return (shippingPO == null) ?
                shippingPO = (ShippingPO) POFactory.makePO(POEnums.SHIPPING, driverOn) : shippingPO;
    }

    protected PaymentPO getPaymentPO() {
        return (paymentPO == null) ?
                paymentPO = (PaymentPO) POFactory.makePO(POEnums.PAYMENT, driverOn) : paymentPO;
    }

    protected OrderPO getOrderPO() {
        return (orderPO == null) ?
                orderPO = (OrderPO) POFactory.makePO(POEnums.ORDER, driverOn) : orderPO;
    }

    public static LoginFacade getLoginFacade() {
        return (loginFacade == null) ?
            new LoginFacade(driverOn) : loginFacade;
    }

    public static ItemFacade getItemFacade() {
        return (itemFacade == null) ?
                new ItemFacade(driverOn) : itemFacade;
    }

    public static PaymentFacade getPaymentFacade() {
        return (paymentFacade == null) ?
                new PaymentFacade(driverOn) : paymentFacade;
    }

    public static ShippingFacade getShippingFacade() {
        return (shippingFacade == null) ?
                new ShippingFacade(driverOn) : shippingFacade;
    }

    public static OrderFacade getOrderFacade() {
        return (orderFacade == null) ?
                new OrderFacade(driverOn) : orderFacade;
    }
}

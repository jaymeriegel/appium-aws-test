package facades;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.enums.KeysOfParameters;

import java.util.Map;

public class OrderFacade extends PageFacades {
    private String username;
    private String password;
    private String panvelCode;
    public OrderFacade(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void finishOrderByPaymentWithCash(Map<String, String> parameters) {
        setParametersToTest(parameters);
        goToPayment();

        getPaymentFacade().addCashPaymentByShipping();
    }

    private void goToPayment() {
        getLoginFacade().loginAndGoHome(username, password);
        getItemFacade().addItemByHome(panvelCode);
        getShippingFacade().addFastShippingByCest();
    }

    private void setParametersToTest(Map<String, String> parameters) {
        username = parameters.get(KeysOfParameters.USERNAME.value);
        password = parameters.get(KeysOfParameters.PASSWORD.value);
        panvelCode = parameters.get(KeysOfParameters.ITEM_ID.value);
    }
}

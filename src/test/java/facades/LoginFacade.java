package facades;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginFacade extends PageFacades {
    public LoginFacade(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void loginAndLogout(String username, String password) {
        onHomeToLoginScreen();
        getLoginScreenPO().login(username, password);
        getMenuScreenPO().clickOnSair();
    }

    public void loginAndGoHome(String username, String password) {
        onHomeToLoginScreen();
        getLoginScreenPO().login(username, password);
        getModalBiometriPO().clickOnNaoQueroButton();
        getFooterMenuPO().clickOnHome();
    }

    public void login(String username, String password) {
        onHomeToLoginScreen();
        getLoginScreenPO().login(username, password);
    }

    public void validMsgInvalidLogin() {
        getLoginScreenPO().validMsgInvalidLogin();
    }

    public void validMsgInvalidUsernameLogin() {
        getLoginScreenPO().validMsgInvalidUsernameLogin();
    }

    private void onHomeToLoginScreen() {
        getFooterMenuPO().clickOnMenu();
        getMenuScreenPO().clickOnEntrar();
        getLoginBackScreenPO().clickOnEntrar();
    }
}

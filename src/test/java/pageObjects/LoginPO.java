package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPO extends BasePO {
    public LoginPO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ENTRAR']")
    MobileElement entrarButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Seu e-mail ou CPF']")
    MobileElement usernameTextInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Sua senha']")
    MobileElement passwordTextInput;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login ou senha inválidos']")
    MobileElement invalidLoginText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Invalid username']")
    MobileElement invalidLoginUsernameText;

    public void clickOnEntrar() {
        AppiumUtils.waitAndClick(entrarButton, driver);
    }

    public void setUsername(String username) {
        AppiumUtils.waitAndSendKeys(usernameTextInput, driver, username);
    }

    public void setPassword(String password) {
        AppiumUtils.waitAndSendKeys(passwordTextInput, driver, password);
    }

    public void login(String username, String password) {
        AppiumUtils.waitForElementToBeVisible(usernameTextInput, driver);
        setUsername(username);
        setPassword(password);
        clickOnEntrar();
    }

    public void validMsgInvalidLogin() {
        AppiumUtils.waitForElementToBeVisible(invalidLoginText, driver, 5000);
        assertTrue(invalidLoginText.isDisplayed());
    }

    public void validMsgInvalidUsernameLogin() {
        AppiumUtils.waitForElementToBeVisible(invalidLoginUsernameText, driver, 5000);
        assertTrue(invalidLoginUsernameText.isDisplayed());
    }
}

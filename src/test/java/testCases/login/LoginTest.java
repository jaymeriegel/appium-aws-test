package testCases.login;

import dataProvider.enums.UsersEnum;
import facades.PageFacades;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testCases.BaseTest;

public class LoginTest extends BaseTest {
    @BeforeTest
    @Override
    public void setUpPage() {}

    @Test(description = "Testa login com sucesso")
    public void loginSuccess() {
        userToTest = UsersEnum.VALID_USER.getUser();
        PageFacades.getLoginFacade().
                loginAndLogout(userToTest.getUsername(), userToTest.getPassword());
    }

    @Test(description = "Testa login senha invalida")
    public void loginPasswordNotValid() {
        userToTest = UsersEnum.VALID_USER_WITH_WRONG_PASSWORD.getUser();
        PageFacades.getLoginFacade()
                .login(userToTest.getUsername(), userToTest.getPassword());
        PageFacades.getLoginFacade()
                .validMsgInvalidLogin();
    }

    @Test(description = "Testa login usuario invalido")
    public void loginUserNotValid() {
        userToTest = UsersEnum.INVALID_USER.getUser();
        PageFacades.getLoginFacade()
                .login(userToTest.getUsername(), userToTest.getPassword());
        PageFacades.getLoginFacade()
                .validMsgInvalidUsernameLogin();
    }
}
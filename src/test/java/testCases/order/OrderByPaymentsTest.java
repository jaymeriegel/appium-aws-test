package testCases.order;

import dataProvider.enums.ItemsEnum;
import dataProvider.enums.UsersEnum;
import facades.PageFacades;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testCases.BaseTest;
import utils.enums.KeysOfParameters;

import java.util.Map;

public class OrderByPaymentsTest extends BaseTest {
    @BeforeTest
    @Override
    public void setUpPage() {}

    @Test(description = "Testa fechar pedido com Dinheiro")
    public void orderSuccessWithCash() {
        userToTest = UsersEnum.VALID_USER.getUser();
        itemToTest = ItemsEnum.NORMAL.getPanvelCode();
        Map<String, String> parameters = Map.of(
                KeysOfParameters.USERNAME.value, userToTest.getUsername(),
                KeysOfParameters.PASSWORD.value, userToTest.getPassword(),
                KeysOfParameters.ITEM_ID.value, itemToTest
        );

        PageFacades.getOrderFacade().finishOrderByPaymentWithCash(parameters);
    }
}

package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;

public class PaymentPO extends BasePO {
    public PaymentPO(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PAGUE NA ENTREGA']")
    MobileElement paymentOnDeliveryTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pague com Dinheiro']")
    MobileElement paymentWithCashRadioButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CONCLUIR PEDIDO']")
    MobileElement orderConcludeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CONCLUIR PEDIDO']")
    MobileElement modalConcludeButton;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='R$ 0,00']")
    MobileElement amountOfPaymentTextInput;

    private void clickOnPaymentOnDeliveryTab() {
        AppiumUtils.waitAndClick(paymentOnDeliveryTab, driver);
    }

    private void clickOnPaymentWithCashRadioButton() {
        AppiumUtils.waitAndClick(paymentWithCashRadioButton, driver);
    }

    private void setAmountOfPayment(String amount) {
        AppiumUtils.waitAndClick(amountOfPaymentTextInput, driver);
        AppiumUtils.waitAndSendKeys(amountOfPaymentTextInput, driver, amount);
        AppiumUtils.clickEnterOnKeyBoard(driver);
    }

    public void clickOnOrderConcludeButton() {
        AppiumUtils.waitAndClick(orderConcludeButton, driver);
    }

    public void clickOnModalConcludeButton() {
        AppiumUtils.staticWait(500);
        AppiumUtils.waitAndClick(modalConcludeButton, driver);
    }

    public void addCashPayment(String amountOfCashToPay) {
        clickOnPaymentOnDeliveryTab();
        clickOnPaymentWithCashRadioButton();
        setAmountOfPayment(amountOfCashToPay);
    }
}

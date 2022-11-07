package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class TransferPage {
    private final SelenideElement sumSelector = $("[data-test-id='amount'] input");
    private final SelenideElement fromSelector = $x("//*[@data-test-id='from']//input");
    private final SelenideElement buttonSelector = $x("//*[@data-test-id='action-transfer']");
    private final SelenideElement errorNotification =$("[data-test-id='error-notification']");


    public DashboardPage makeTransfer(DataHelper.CardInfo cardInfo, int info ) {
        sumSelector.val(String.valueOf(info));
        fromSelector.val(cardInfo.getCardNumber());
        buttonSelector.click();
        return new DashboardPage();
    }

    public void ErrorNotification(){
        errorNotification.shouldBe(Condition.visible);
    }


}

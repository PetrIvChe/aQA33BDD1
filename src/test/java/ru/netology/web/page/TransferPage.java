package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class TransferPage {
    private final SelenideElement cancelSelector = $("[data-test-id='action-cancel']");
    private final SelenideElement sumSelector = $("[data-test-id='amount'] input");
    private final SelenideElement fromSelector = $x("//*[@data-test-id='from']//input");
    private final SelenideElement buttonSelector = $x("//*[@data-test-id='action-transfer']");


    public DashboardPage makeTransfer(DataHelper.CardInfo cardInfo, int info2 ) {
        sumSelector.val(String.valueOf(info2));
        fromSelector.val(cardInfo.getCardNumber());
        buttonSelector.click();
        return new DashboardPage();
    }


}

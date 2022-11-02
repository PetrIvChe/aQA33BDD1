package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    //нужно два элемента пополнить первую карту
    //                   пополнить вторую карту
    private static  final ElementsCollection cardsSelector = $$(".list__item div");
    private static final SelenideElement firstCardSelector = $("//div[@data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private static final SelenideElement secondCardSelector = $x("//div[@data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private static final SelenideElement headingSelector = $("[data-test-id='dashboard']");
    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";

    public DashboardPage(){

    }

    public TransferPage cardToTransfer(DataHelper.CardInfo info) {
        cardsSelector.findBy(text(info.getCardNumber().substring(12, 16))).$("button").click();
        return new TransferPage();

    }

    public static int getFirstCardBalance() {
        val text = cardsSelector.first().text();
        return extractBalanceOfCard(text);
    }

    public static int getSecondCardBalance() {
        val text = cardsSelector.last().text();
        return extractBalanceOfCard(String.valueOf(text));
    }

    private static int extractBalanceOfCard(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public TransferPage firstCard() {
        firstCardSelector.click();
        return new TransferPage();
    }

    public TransferPage secondCard() {
        secondCardSelector.click();
        return new TransferPage();
    }

}








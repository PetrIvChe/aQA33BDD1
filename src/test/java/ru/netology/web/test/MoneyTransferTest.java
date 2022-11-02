package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import static com.codeborne.selenide.Selenide.*;


class MoneyTransferTest {

    @Test
    void shouldTransferMoneyFromSecondToTheFirstCard5000() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var firstCardNumber = DataHelper.getFirstCardNumber();
        var secondCardNumber = DataHelper.getSecondCardNumber();
        int amount = 5000;
        var expectedBalanceOfFirstCard = DashboardPage.getFirstCardBalance() + amount;
        var expectedBalanceOfSecondCard = DashboardPage.getSecondCardBalance() - amount;

        var transferPage = dashboardPage.cardToTransfer(firstCardNumber);
        transferPage.makeTransfer(secondCardNumber, amount);

        var actualBalanceOfFirstCard = DashboardPage.getFirstCardBalance();
        var actualBalanceOfSecondCard = DashboardPage.getSecondCardBalance();
        Assertions.assertEquals(expectedBalanceOfFirstCard, actualBalanceOfFirstCard);
        Assertions.assertEquals(expectedBalanceOfSecondCard, actualBalanceOfSecondCard);
    }

    @Test
    void shouldTransferMoneyFromFirstToTheSecondCard5000() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var firstCardNumber = DataHelper.getFirstCardNumber();
        var secondCardNumber = DataHelper.getSecondCardNumber();
        int amount = 5000;
        var expectedBalanceOfFirstCard = DashboardPage.getFirstCardBalance() - amount;
        var expectedBalanceOfSecondCard = DashboardPage.getSecondCardBalance() + amount;

        var transferPage = dashboardPage.cardToTransfer(secondCardNumber);
        transferPage.makeTransfer(firstCardNumber, amount);

        var actualBalanceOfFirstCard = DashboardPage.getFirstCardBalance();
        var actualBalanceOfSecondCard = DashboardPage.getSecondCardBalance();
        Assertions.assertEquals(expectedBalanceOfFirstCard, actualBalanceOfFirstCard);
        Assertions.assertEquals(expectedBalanceOfSecondCard, actualBalanceOfSecondCard);
    }

    @Test
    void shouldTransferMoneyFromSecondToTheFirstCard10000() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var firstCardNumber = DataHelper.getFirstCardNumber();
        var secondCardNumber = DataHelper.getSecondCardNumber();
        int amount = 10000;
        var expectedBalanceOfFirstCard = DashboardPage.getFirstCardBalance() + amount;
        var expectedBalanceOfSecondCard = DashboardPage.getSecondCardBalance() - amount;

        var transferPage = dashboardPage.cardToTransfer(firstCardNumber);
        transferPage.makeTransfer(secondCardNumber, amount);

        var actualBalanceOfFirstCard = DashboardPage.getFirstCardBalance();
        var actualBalanceOfSecondCard = DashboardPage.getSecondCardBalance();
        Assertions.assertEquals(expectedBalanceOfFirstCard, actualBalanceOfFirstCard);
        Assertions.assertEquals(expectedBalanceOfSecondCard, actualBalanceOfSecondCard);
    }

    @Test
    void shouldTransferMoneyFromSecondToTheFirstCard10000Again() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var firstCardNumber = DataHelper.getFirstCardNumber();
        var secondCardNumber = DataHelper.getSecondCardNumber();
        int amount = 10000;
        var expectedBalanceOfFirstCard = DashboardPage.getFirstCardBalance() + amount;
        var expectedBalanceOfSecondCard = DashboardPage.getSecondCardBalance() - amount;

        var transferPage = dashboardPage.cardToTransfer(firstCardNumber);
        transferPage.makeTransfer(secondCardNumber, amount);

        var actualBalanceOfFirstCard = DashboardPage.getFirstCardBalance();
        var actualBalanceOfSecondCard = DashboardPage.getSecondCardBalance();
        Assertions.assertEquals(expectedBalanceOfFirstCard, actualBalanceOfFirstCard);
        Assertions.assertEquals(expectedBalanceOfSecondCard, actualBalanceOfSecondCard);
    }
// Негативный тест перевод денег с карты имеющей отрицательный баланс
    @Test
    void shouldTransferMoneyFromFirstToTheSecondCard50000() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var firstCardNumber = DataHelper.getFirstCardNumber();
        var secondCardNumber = DataHelper.getSecondCardNumber();
        int amount = 50000;
        var expectedBalanceOfFirstCard = DashboardPage.getFirstCardBalance() - amount;
        var expectedBalanceOfSecondCard = DashboardPage.getSecondCardBalance() + amount;

        var transferPage = dashboardPage.cardToTransfer(secondCardNumber);
        transferPage.makeTransfer(firstCardNumber, amount);

        var actualBalanceOfFirstCard = DashboardPage.getFirstCardBalance();
        var actualBalanceOfSecondCard = DashboardPage.getSecondCardBalance();
        Assertions.assertEquals(expectedBalanceOfFirstCard, actualBalanceOfFirstCard);
        Assertions.assertEquals(expectedBalanceOfSecondCard, actualBalanceOfSecondCard);
    }
}









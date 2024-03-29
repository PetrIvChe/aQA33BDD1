package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    // Генерирует конструктор, геттеры и методы equals, hashcode toString
    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {

        return new VerificationCode("12345");
    }

    @Value
    public static class CardInfo {
        private String cardNumber;
    }

    public static CardInfo getFirstCardNumber() {

        return new CardInfo("5559000000000001");
    }

    public static CardInfo getSecondCardNumber() {

        return new CardInfo("5559000000000002");
    }

    public static CardInfo getSecondCardNumberWrong() {

        return new CardInfo("5559000000000000");
    }
}

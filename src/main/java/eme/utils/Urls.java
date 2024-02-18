package eme.utils;

public class Urls {

    private Urls() {}

    private static final String BASE_URL = "https://discord.com/api/v10";
    private static final String GATEWAY_URL = "wss://gateway.discord.gg/?v=10&encoding=json";

    public static String getChannelsUrl() {
        return BASE_URL + "/channels";
    }

    public static String getLoginUrl() {
        return BASE_URL + "/auth/login";
    }

    public static String get2FAUrl() {
        return BASE_URL + "/auth/mfa/totp";
    }

    public static String getGatewayUrl() {
        return GATEWAY_URL;
    }
}

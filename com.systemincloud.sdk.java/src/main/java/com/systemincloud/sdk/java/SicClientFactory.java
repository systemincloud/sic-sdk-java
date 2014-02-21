package com.systemincloud.sdk.java;

public class SicClientFactory {
    public static SicClient createClient(String accountNumber, String systemName, String systemKey) {
        return new SicClientImpl(accountNumber, systemName, systemKey);
    }
}

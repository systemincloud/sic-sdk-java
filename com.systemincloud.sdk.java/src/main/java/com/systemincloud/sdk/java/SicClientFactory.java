package com.systemincloud.sdk.java;

public class SicClientFactory {
    
    private static final String dns = "https://connector.systemincloud.com";
    
    public static String getDns() { return dns; }
    
    public static SicClient createClient(String accountNumber, String systemName, String systemKey) {
        return new SicClientImpl(accountNumber, systemName, systemKey);
    }
}

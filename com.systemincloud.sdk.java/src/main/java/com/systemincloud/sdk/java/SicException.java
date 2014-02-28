package com.systemincloud.sdk.java;

public class SicException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SicException(String cause) {
        super(cause);
    }
}

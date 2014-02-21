package com.systemincloud.sdk.java;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.systemincloud.sdk.java.msg.Credentials;
import com.systemincloud.sdk.java.msg.TestConnectionReq;
import com.systemincloud.sdk.java.msg.TestConnectionRsp;

public class SicClientImpl implements SicClient {

    protected static final String PATH = "api";
    
    protected Credentials credentials;
    
    protected WebTarget    service;
    
    public SicClientImpl(String accountNumber, String systemName, String systemKey) {
        this.credentials = new Credentials(accountNumber, systemName, systemKey);
    }

    @Override public TestConnectionRsp testConnection() { return service.path(PATH).path(TestConnectionReq.class.toString().toLowerCase()).request(MediaType.APPLICATION_JSON)
                                                                        .post(Entity.entity(new TestConnectionReq(credentials), MediaType.APPLICATION_JSON), TestConnectionRsp.class); }

}

package com.systemincloud.sdk.java;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.systemincloud.sdk.java.msg.Credentials;
import com.systemincloud.sdk.java.msg.TestConnectionReq;
import com.systemincloud.sdk.java.msg.TestConnectionRsp;

public class SicClientImpl implements SicClient {

    protected static final String PATH = "api";
    
    protected Credentials credentials;
    
    protected WebTarget service;
    
    protected boolean testPassed;
    public    boolean isTestPassed() {return testPassed; }
    
    public SicClientImpl(String accountNumber, String systemName, String systemKey) {
        this.credentials = new Credentials(accountNumber, systemName, systemKey);
        this.service = initRestClient();
        this.testPassed = testConnection().getStatus();
    }

    private WebTarget initRestClient() {
        ClientConfig config = new ClientConfig();
        config.register(MultiPartFeature.class);
        Client client = ClientBuilder.newBuilder()
                                     .withConfig(config)
                                     .build();
        return client.target("https://connector.systemincloud.com");
    }

    @Override public TestConnectionRsp testConnection() {
        TestConnectionRsp ret;
        try {
            ret = service.path(PATH).path("test-connection").request(MediaType.APPLICATION_JSON)
                                                            .post(Entity.entity(new TestConnectionReq(credentials), MediaType.APPLICATION_JSON), TestConnectionRsp.class);
        } catch(Exception e) { ret = new TestConnectionRsp(false, e.getMessage()); }
        return ret;
    }
}

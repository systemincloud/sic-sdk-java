package com.systemincloud.sdk.java;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.systemincloud.sdk.java.msg.Credentials;
import com.systemincloud.sdk.java.msg.GetMachinesReq;
import com.systemincloud.sdk.java.msg.GetMachinesRsp;
import com.systemincloud.sdk.java.msg.MachineInfo;
import com.systemincloud.sdk.java.msg.NewMachineReq;
import com.systemincloud.sdk.java.msg.NewMachineRsp;
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
            ret = service.path(PATH).path("testConnection").request(MediaType.APPLICATION_JSON)
                                                           .post(Entity.entity(new TestConnectionReq(credentials), MediaType.APPLICATION_JSON), TestConnectionRsp.class);
        } catch(Exception e) { ret = new TestConnectionRsp(false, e.getMessage()); }
        return ret;
    }

    @Override public List<MachineInfo> getMachines() {
        return service.path(PATH).path("getMachines").request(MediaType.APPLICATION_JSON)
                                                     .post(Entity.entity(new GetMachinesReq(credentials), MediaType.APPLICATION_JSON), GetMachinesRsp.class).getMachines();
    }

    @Override public void newMachine(Region region, MachineType machineType) { newMachine(region.getName(), machineType.getName()); }

    @Override public void newMachine(String region, String machineType) {
        NewMachineRsp response = service.path(PATH).path("newMachine").request(MediaType.APPLICATION_JSON)
                                                                      .post(Entity.entity(new NewMachineReq(credentials, region, machineType), MediaType.APPLICATION_JSON), NewMachineRsp.class);
        if(!response.getStatus()) throw new SicException(response.getCause());
    }
}

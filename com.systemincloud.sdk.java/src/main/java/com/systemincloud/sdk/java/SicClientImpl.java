package com.systemincloud.sdk.java;

import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.systemincloud.sdk.java.msg.Credentials;
import com.systemincloud.sdk.java.msg.DeleteMachineReq;
import com.systemincloud.sdk.java.msg.DeleteMachineRsp;
import com.systemincloud.sdk.java.msg.GetMachinesReq;
import com.systemincloud.sdk.java.msg.GetMachinesRsp;
import com.systemincloud.sdk.java.msg.GetModelInfoReq;
import com.systemincloud.sdk.java.msg.GetModelInfoRsp;
import com.systemincloud.sdk.java.msg.InstanceInfo;
import com.systemincloud.sdk.java.msg.MachineInfo;
import com.systemincloud.sdk.java.msg.ModelInfo;
import com.systemincloud.sdk.java.msg.NewInstanceReq;
import com.systemincloud.sdk.java.msg.NewInstanceRsp;
import com.systemincloud.sdk.java.msg.NewMachineReq;
import com.systemincloud.sdk.java.msg.NewMachineRsp;
import com.systemincloud.sdk.java.msg.TestConnectionReq;
import com.systemincloud.sdk.java.msg.TestConnectionRsp;

public class SicClientImpl implements SicClient {

    protected static final String PATH = "api";
    
    protected Credentials credentials;
    
    protected WebTarget service;
    
    protected boolean serviceAvailable;
    protected boolean testPassed;
    
    @Override public boolean isServiceAvailable() { return serviceAvailable; }
    @Override public boolean isTestPassed()       { return testPassed; }
    
    public SicClientImpl(String accountNumber, String systemName, String systemKey) {
        this.credentials = new Credentials(accountNumber, systemName, systemKey);
        this.service = initRestClient();
        this.testPassed = testConnection().getStatus();
    }

    protected WebTarget initRestClient() {
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
        } catch(Exception e) {
            this.serviceAvailable = false;
            ret = new TestConnectionRsp(false, e.getMessage());
            return ret;
        }
        this.serviceAvailable = true;
        return ret;
    }

    @Override public List<MachineInfo> getMachines() {
        GetMachinesRsp response = service.path(PATH).path("getMachines").request(MediaType.APPLICATION_JSON)
                                                                        .post(Entity.entity(new GetMachinesReq(credentials), MediaType.APPLICATION_JSON), GetMachinesRsp.class);
        if(!response.getStatus()) throw new SicException(response.getCause());
        else return response.getMachines();
    }

    @Override public MachineInfo newMachine(Region region, MachineType machineType) { return newMachine(region.getName(), machineType.getName()); }

    @Override public MachineInfo newMachine(String region, String machineType) {
        NewMachineRsp response = service.path(PATH).path("newMachine").request(MediaType.APPLICATION_JSON)
                                                                      .post(Entity.entity(new NewMachineReq(credentials, region, machineType), MediaType.APPLICATION_JSON), NewMachineRsp.class);
        if(!response.getStatus()) throw new SicException(response.getCause());
        else return response.getMachine();
    }

    @Override public void deleteMachine(String machineId) {
        DeleteMachineRsp response = service.path(PATH).path("deleteMachine").request(MediaType.APPLICATION_JSON)
                                                      .post(Entity.entity(new DeleteMachineReq(credentials, machineId), MediaType.APPLICATION_JSON), DeleteMachineRsp.class);
        if(!response.getStatus()) throw new SicException(response.getCause());
    }
    
    @Override public ModelInfo getModelInfo() {
        GetModelInfoRsp response = service.path(PATH).path("getModelInfo").request(MediaType.APPLICATION_JSON)
                                                                          .post(Entity.entity(new GetModelInfoReq(credentials), MediaType.APPLICATION_JSON), GetModelInfoRsp.class);
        if(!response.getStatus()) throw new SicException(response.getCause());
        else return response.getModelInfo();
    }
    
    @Override public InstanceInfo newInstance(String machineId, Map<String, String> parameters) {
        NewInstanceRsp response = service.path(PATH).path("newInstance").request(MediaType.APPLICATION_JSON)
                                                                        .post(Entity.entity(new NewInstanceReq(credentials, machineId, parameters), MediaType.APPLICATION_JSON), NewInstanceRsp.class);
        if(!response.getStatus()) throw new SicException(response.getCause());
        else return response.getInstance();
    }
}

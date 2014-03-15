package com.systemincloud.sdk.java;

import java.util.List;
import java.util.Map;

import com.systemincloud.sdk.java.msg.InstanceInfo;
import com.systemincloud.sdk.java.msg.MachineInfo;
import com.systemincloud.sdk.java.msg.ModelInfo;
import com.systemincloud.sdk.java.msg.TestConnectionRsp;

public interface SicClient {
    TestConnectionRsp  testConnection();
    boolean            isServiceAvailable();
    boolean            isTestPassed();
    List<MachineInfo>  getMachines();
    MachineInfo        newMachine(Region region, MachineType machineType);
    MachineInfo        newMachine(String region, String machineType);
    void               deleteMachine(String machineId);
    ModelInfo          getModelInfo();
    List<InstanceInfo> getInstances();
    InstanceInfo       newInstance(String machineId, Map<String, String> parameters);
    void               deleteInstance(String instanceId);
}

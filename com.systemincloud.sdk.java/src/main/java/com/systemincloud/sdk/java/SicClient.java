package com.systemincloud.sdk.java;

import java.util.List;

import com.systemincloud.sdk.java.msg.MachineInfo;
import com.systemincloud.sdk.java.msg.TestConnectionRsp;

public interface SicClient {
    TestConnectionRsp testConnection();
    boolean           isServiceAvailable();
    boolean           isTestPassed();
    List<MachineInfo> getMachines();
    void              newMachine(Region region, MachineType machineType);
    void              newMachine(String region, String machineType);
    void              deleteMachine(String machineId);
}

package com.systemincloud.sdk.java;

import java.util.List;

import com.systemincloud.sdk.java.msg.MachineInfo;
import com.systemincloud.sdk.java.msg.TestConnectionRsp;

public interface SicClient {
    TestConnectionRsp testConnection();
    boolean           isTestPassed();
    List<MachineInfo> getMachines();
}

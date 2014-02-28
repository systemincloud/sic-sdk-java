package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeleteMachineReq extends Request {
    
    @XmlElement private String machineId;
    
    public DeleteMachineReq() { }
    
    public DeleteMachineReq(Credentials credentials, String machineId) {
        super(credentials);
        this.machineId = machineId;
    }
    
    public String getMachineId() { return machineId; }
}

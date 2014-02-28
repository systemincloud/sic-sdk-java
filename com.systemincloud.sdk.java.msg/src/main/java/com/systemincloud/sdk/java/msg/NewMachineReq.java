package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewMachineReq extends Request {
    
    @XmlElement private String region;
    @XmlElement private String machineType;
    
    public NewMachineReq() { }
    
    public NewMachineReq(Credentials credentials, String region, String machineType) {
        super(credentials);
        this.region = region;
        this.machineType = machineType;
    }
}

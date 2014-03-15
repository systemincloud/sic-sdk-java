package com.systemincloud.sdk.java.msg;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewInstanceReq extends Request {
    
    @XmlElement private String machineId;
    @XmlElement private Map<String, String> parameters;
    
    public NewInstanceReq() { }
    
    public NewInstanceReq(Credentials credentials, String machineId, Map<String, String> parameters) {
        super(credentials);
        this.machineId = machineId;
        this.parameters = parameters;
    }
    
    public String              getMachineId()  { return machineId; }
    public Map<String, String> getParameters() { return parameters; }
}

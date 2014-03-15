package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeleteInstanceReq extends Request {
    
    @XmlElement private String instanceId;
    
    public DeleteInstanceReq() { }
    
    public DeleteInstanceReq(Credentials credentials, String instanceId) {
        super(credentials);
        this.instanceId = instanceId;
    }
    
    public String getInstnaceId() { return instanceId; }
}

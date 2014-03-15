package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewInstanceRsp extends Response {
    
    @XmlElement InstanceInfo instance;
    
    public NewInstanceRsp() { }
    
    public NewInstanceRsp(InstanceInfo instance) {
        this.instance = instance;
    }

    public NewInstanceRsp(boolean status, String cause) {
        super(status, cause);
    }

    public InstanceInfo getInstance()                      { return instance; }
    public void         setInstance(InstanceInfo instance) { this.instance = instance; }
}

package com.systemincloud.sdk.java.msg;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetInstancesRsp extends Response {
    
    @XmlElement private List<InstanceInfo> instances = new ArrayList<>();
    
    public GetInstancesRsp() { }

    public GetInstancesRsp(boolean status, String cause) {
        super(status, cause);
    }

    public List<InstanceInfo> getInstances()                             { return instances; }
    public void               setInstances(List<InstanceInfo> instances) { this.instances = instances; }
}

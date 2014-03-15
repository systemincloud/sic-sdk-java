package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InstanceInfo {

    @XmlElement private String instanceId;
    @XmlElement private String creationTime;
    @XmlElement private String machineId;
    @XmlElement private String modelUploaded;
    
    public InstanceInfo() { }

    public String getInstanceId()                          { return instanceId; }
    public void   setInstanceId(String instanceId)         { this.instanceId = instanceId; }
    public String getCreationTime()                        { return creationTime; }
    public void   setCreationTime(String creationTime)     { this.creationTime = creationTime; }
    public String getMachineId()                           { return machineId; }
    public void   setMachineId(String machineId)           { this.machineId = machineId; }
    public String getModelUploaded()                       { return modelUploaded; }
    public void   setModelUploaded(String modelUploaded)   { this.modelUploaded = modelUploaded; }
}

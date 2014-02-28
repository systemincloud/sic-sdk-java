package com.systemincloud.sdk.java.msg;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewMachineRsp extends Response {
    
    @XmlElement private List<MachineInfo> machines = new ArrayList<>();
    
    public NewMachineRsp() { }

    public NewMachineRsp(boolean status, String cause) {
        super(status, cause);
    }

    public List<MachineInfo> getMachines()                           { return machines; }
    public void              setMachines(List<MachineInfo> machines) { this.machines = machines; }
}

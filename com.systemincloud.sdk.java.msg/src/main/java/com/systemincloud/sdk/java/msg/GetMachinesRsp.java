package com.systemincloud.sdk.java.msg;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetMachinesRsp extends Response {
    
    @XmlElement private List<MachineInfo> machines = new ArrayList<>();
    
    public GetMachinesRsp() { }

    public GetMachinesRsp(boolean status, String cause) {
        super(status, cause);
    }

    public List<MachineInfo> getMachines()                           { return machines; }
    public void              setMachines(List<MachineInfo> machines) { this.machines = machines; }
}

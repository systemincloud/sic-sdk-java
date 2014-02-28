package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewMachineRsp extends Response {
    
    @XmlElement MachineInfo machine;
    
    public NewMachineRsp() { }
    
    public NewMachineRsp(MachineInfo machine) {
        this.machine = machine;
    }

    public NewMachineRsp(boolean status, String cause) {
        super(status, cause);
    }

    public MachineInfo getMachine()                    { return machine; }
    public void        setMachine(MachineInfo machine) { this.machine = machine; }
}

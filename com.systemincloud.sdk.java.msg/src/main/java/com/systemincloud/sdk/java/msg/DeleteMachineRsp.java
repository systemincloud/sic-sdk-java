package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeleteMachineRsp extends Response {
    
    public DeleteMachineRsp() { }

    public DeleteMachineRsp(boolean status, String cause) {
        super(status, cause);
    }
}

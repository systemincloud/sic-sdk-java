package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetMachinesReq extends Request {
    
    public GetMachinesReq() { }
    
    public GetMachinesReq(Credentials credentials) {
        super(credentials);
    }
}

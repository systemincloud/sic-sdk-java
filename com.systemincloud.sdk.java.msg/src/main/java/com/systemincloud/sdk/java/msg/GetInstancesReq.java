package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetInstancesReq extends Request {
    
    public GetInstancesReq() { }
    
    public GetInstancesReq(Credentials credentials) {
        super(credentials);
    }
}

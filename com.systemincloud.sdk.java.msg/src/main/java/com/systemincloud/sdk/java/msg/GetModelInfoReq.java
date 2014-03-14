package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetModelInfoReq extends Request {
    
    public GetModelInfoReq() { }
    
    public GetModelInfoReq(Credentials credentials) {
        super(credentials);
    }
}

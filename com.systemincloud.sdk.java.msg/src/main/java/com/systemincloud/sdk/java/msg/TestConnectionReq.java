package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestConnectionReq extends Request {
    
    public TestConnectionReq() { }
    
    public TestConnectionReq(Credentials credentials) {
        super(credentials);
    }
}

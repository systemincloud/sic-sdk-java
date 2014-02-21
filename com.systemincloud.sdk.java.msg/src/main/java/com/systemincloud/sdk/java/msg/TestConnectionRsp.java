package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestConnectionRsp extends Response {
    
    public TestConnectionRsp() { }

    public TestConnectionRsp(boolean status, String cause) {
        super(status, cause);
    }
}

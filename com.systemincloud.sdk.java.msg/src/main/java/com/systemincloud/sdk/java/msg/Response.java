package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlElement;

public class Response {

    @XmlElement private boolean status;
    @XmlElement private String  cause;
    
    public boolean getStatus() { return status; }
    public String  getCause()  { return cause; }
    
    public Response() {
        this.status = true;
    }
    
    public Response(boolean status, String cause) {
        this.status = status;
        this.cause = cause;
    }
}

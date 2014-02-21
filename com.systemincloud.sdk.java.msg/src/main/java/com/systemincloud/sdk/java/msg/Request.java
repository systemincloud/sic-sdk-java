package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlElementRef;

public class Request {

    @XmlElementRef private Credentials credentials;
    
    public Credentials getCredentials() { return credentials; }
    
    public Request() { }
    
    protected Request(Credentials credentials) {
        this.credentials = credentials;
    }
    
}

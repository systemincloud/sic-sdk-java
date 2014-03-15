package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeleteInstanceRsp extends Response {
    
    public DeleteInstanceRsp() { }

    public DeleteInstanceRsp(boolean status, String cause) {
        super(status, cause);
    }
}

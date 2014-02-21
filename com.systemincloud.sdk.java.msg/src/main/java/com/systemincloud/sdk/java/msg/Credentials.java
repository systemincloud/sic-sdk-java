package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class Credentials {

    @XmlElement private String accountNumber;
    @XmlElement    private String systemName;
    @XmlElement    private String systemKey;
    
    public  String getAccountNumber() { return accountNumber; }
    public  String getSystemName()    { return systemName; }
    public  String getSystemKey()     { return systemKey; }
    
    public Credentials() { }
    
    public Credentials(String accountNumber, String systemName, String systemKey) {
        this.accountNumber = accountNumber;
        this.systemName    = systemName;
        this.systemKey     = systemKey;
    }

}

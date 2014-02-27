package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MachineInfo {

    @XmlElement private String machineId;
    @XmlElement private String provider;
    @XmlElement private String region;
    @XmlElement private String machineType;
    @XmlElement private String publicDns;
    @XmlElement private String status;
    @XmlElement private int    averageCpu;
    @XmlElement private int    maxCpu;
    @XmlElement private int    averageRam;
    @XmlElement private int    maxRam;
    
    public MachineInfo() { }
    
    public String getMachineId()                     { return machineId; }
    public void   setMachineId(String machineId)     { this.machineId = machineId; }
    public String getProvider()                      { return provider; }
    public void   setProvider(String provider)       { this.provider = provider; }
    public String getRegion()                        { return region; }
    public void   setRegion(String region)           {   this.region = region; }
    public String getMachineType()                   { return machineType; }
    public void   setMachineType(String machineType) {   this.machineType = machineType; }
    public String getPublicDns()                     { return publicDns; }  
    public void   setPublicDns(String publicDns)     {  this.publicDns = publicDns; }
    public String getStatus()                        { return status; } 
    public void   setStatus(String status)           {   this.status = status; }
    public int    getAverageCpu()                    { return averageCpu; } 
    public void   setAverageCpu(int averageCpu)      {   this.averageCpu = averageCpu; }
    public int    getMaxCpu()                        { return maxCpu; } 
    public void   setMaxCpu(int maxCpu)              {   this.maxCpu = maxCpu; }
    public int    getAverageRam()                    { return averageRam; } 
    public void   setAverageRam(int averageRam)      {   this.averageRam = averageRam; }
    public int    getMaxRam()                        { return maxRam; } 
    public void   setMaxRam(int maxRam)              {   this.maxRam = maxRam; }
}

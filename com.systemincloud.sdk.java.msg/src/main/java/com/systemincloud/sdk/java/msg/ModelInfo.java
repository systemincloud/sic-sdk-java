package com.systemincloud.sdk.java.msg;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModelInfo {

    @XmlElement private String       fileName;
    @XmlElement private String       modelerVersion;
    @XmlElement private String       uploadTime;
    @XmlElement private List<String> parameters;
    
    public ModelInfo() { }
    
    public String       getFileName()                            { return fileName; }
    public void         setFileName(String fileName)             {   this.fileName = fileName; }
    public String       getModelerVersion()                      { return modelerVersion; }
    public void         setModelerVersion(String modelerVersion) {   this.modelerVersion = modelerVersion; }
    public String       getUploadTime()                          { return uploadTime; }
    public void         setUplodTime(String uploadTime)          {   this.uploadTime = uploadTime; }
    public List<String> getParameters()                          { return parameters; }
    public void         setParameters(List<String> parameters)   {   this.parameters = parameters; }
}

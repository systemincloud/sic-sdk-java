package com.systemincloud.sdk.java.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetModelInfoRsp extends Response {
    
    @XmlElement private ModelInfo modelInfo;;
    
    public GetModelInfoRsp() { }

    public GetModelInfoRsp(boolean status, String cause) {
        super(status, cause);
    }

    public ModelInfo getModelInfo()                    { return modelInfo; }
    public void      setModelInfo(ModelInfo modelInfo) { this.modelInfo = modelInfo; }
}

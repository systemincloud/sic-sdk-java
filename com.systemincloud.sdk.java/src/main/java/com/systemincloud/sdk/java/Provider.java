package com.systemincloud.sdk.java;

public enum Provider {
    DEFAULT("default"),
    
    AWS  ("Amazon Web Services"), 
    AZURE("Windows Azure"), 
    GCE  ("Google Cloud Engine");
 
    private String fullName;
    
    Provider(String fullName) {
        this.fullName = fullName;
    }
    
    public String getFullName() { return fullName; }
    
    public static Provider getByFullName(String fullName) {
        for(Provider p : Provider.values())
            if(p.getFullName().equals(fullName)) return p;
        return null;
    }
}

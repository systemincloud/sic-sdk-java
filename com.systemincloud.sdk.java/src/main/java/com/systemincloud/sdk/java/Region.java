package com.systemincloud.sdk.java;

import java.util.LinkedList;
import java.util.List;

public enum Region {
    DEFAULT("default"),
    
    // AWS
    AWS_US_EAST_1("us-east-1"),
    AWS_US_WEST_1("us-west-1"),
    AWS_US_WEST_2("us-west-2"),
    AWS_EU_WEST_1("eu-west-1"),
    AWS_AP_SOUTHEAST_1("ap-southeast-1"),
    AWS_AP_SOUTHEAST_2("ap-southeast-2"),
    AWS_AP_NORTHEAST_2("ap-northeast-1"),
    AWS_SA_EAST_1("sa-east-1"),
    
    // AZURE
    AZURE_US_EAST("US East"),
    AZURE_US_WEST("US West"),  
    AZURE_US_NORTH_CENTRAL("US North Central"),  
    AZURE_US_SOUTH_CNETRAL("US South Central"),
    AZURE_EUROPE_NORTH("Europe North"),
    AZURE_EUROPE_WEST("Europe West"),   
    AZURE_ASIA_PACIFIC_EAST("Asia Pacific East"),     
    AZURE_ASIA_PACIFIC_SOUTHEAST("Asia Pacific Southeast"),
    AZURE_JAPAN_EAST("Japan East"),
    AZURE_JAPAN_WEST("Japan West"),
        
    // GCE
    GCE_EUROPE_WEST1("europe-west1"),
    GCE_US_CENTRAL1("us-central1");
    
    private String name;
    
    Region(String name) {
        this.name = name;
    }
    
    public String getName() { return name; }
    
    public static Region getByName(String name) {
        for(Region r : Region.values())
            if(r.getName().equals(name)) return r;
        return null;
    }
    
    public static List<Region> getForProvider(Provider provider) {
        List<Region> regions = new LinkedList<>();
        for(Region r : Region.values())
            if(r.toString().startsWith(provider.toString())) regions.add(r);
        return regions;
    }
}

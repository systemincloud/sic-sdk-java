package com.systemincloud.sdk.java.msg;

import java.util.LinkedList;
import java.util.List;

public enum MachineType {
    DEFAULT("default"),
    
    // AWS
    AWS_M3_MEDIUM("m3.medium"),
    AWS_M3_LARGE("m3.large"),
    AWS_M3_XLARGE("m3.xlarge"),
    AWS_M3_2XLARGE("m3.2xlarge"),
    AWS_M1_SMALL("m1.small"),
    AWS_M1_MEDIUM("m1.medium"),
    AWS_M1_LARGE("m1.large"),
    AWS_M1_XLARGE("m1.xlarge"),
    AWS_C3_LARGE("c3.large"),
    AWS_C3_XLARGE("c3.xlarge"),
    AWS_C3_2XLARGE("c3.2xlarge"),
    AWS_C3_4XLARGE("c3.4xlarge"),
    AWS_C3_8XLARGE("c3.8xlarge"),
    AWS_C1_MEDIUM("c1.medium"),
    AWS_C1_XLARGE("c1.xlarge"),
    AWS_CC2_8XLARGE("cc2.8xlarge"),
    AWS_G2_2XLARGE("g2.2xlarge"),
    AWS_CG1_4XLARGE("cg1.4xlarge"),
    AWS_M2_XLARGE("m2.xlarge"),
    AWS_M2_2XLARGE("m2.2xlarge"),
    AWS_M2_4XLARGE("m2.4xlarge"),
    AWS_CR1_8XLARGE("cr1.8xlarge"),
    AWS_I2_XLARGE("i2.xlarge"),
    AWS_I2_2XLARGE("i2.2xlarge"),
    AWS_I2_4XLARGE("i2.4xlarge"),
    AWS_I2_8XLARGE("i2.8xlarge"),
    AWS_HS1_8XLARGE("hs1.8xlarge"),
    AWS_HI1_4XLARGE("hi1.4xlarge"),
    AWS_T1_MICRO("t1.micro"),

    // AZURE
    AZURE_EXTRA_SMALL("Extra Small"),
    AZURE_SMALL("Small"),
    AZURE_MEDIUM("Medium"),
    AZURE_LARGE("Large"),
    AZURE_EXTRA_LARGE("Extra Large"),
    AZURE_A5("A5"),
    AZURE_A6("A6"),
    AZURE_A7("A7"),
    
    // GCE
    GCE_N1_STANDARD_1("n1-standard-1"),
    GCE_N1_STANDARD_2("n1-standard-2"),
    GCE_N1_STANDARD_4("n1-standard-4"),
    GCE_N1_STANDARD_8("n1-standard-8"),
    GCE_N1_STANDARD_16("n1-standard-16"),
    GCE_N1_HIGHMEM_2("n1-highmem-2"),
    GCE_N1_HIGHMEM_4("n1-highmem-4"),
    GCE_N1_HIGHMEM_8("n1-highmem-8"),
    GCE_N1_HIGHMEM_16("n1-highmem-16"),
    GCE_HIGHCPU_2("n1-highcpu-2"),
    GCE_HIGHCPU_4("n1-highcpu-4"),
    GCE_HIGHCPU_8("n1-highcpu-8"),
    GCE_HIGHCPU_16("n1-highcpu-16"),
    GCE_F1_MICRO("f1-micro"),
    GCE_G1_SMALL("g1-small");
    
    private String name;
    
    MachineType(String name) {
        this.name = name;
    }
    
    public String getName() { return name; }
    
    public static MachineType getByName(String name) {
        for(MachineType mt : MachineType.values())
            if(mt.getName().equals(name)) return mt;
        return null;
    }
    
    public static List<MachineType> getForProvider(Provider provider) {
        List<MachineType> machineTypes = new LinkedList<>();
        for(MachineType mt : MachineType.values())
            if(mt.toString().startsWith(provider.toString())) machineTypes.add(mt);
        return machineTypes;
    }
}

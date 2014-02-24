package com.systemincloud.sdk.java.msg;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;

import javax.xml.bind.JAXBException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestConnectionTest extends TestCommon {
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        setup(TestConnectionReq.class);
    }

    @Test
    public void test() throws JAXBException {
        Credentials credentials = new Credentials("dummyAccount", "dummySystem", "dummyKey");
        TestConnectionReq request = new TestConnectionReq(credentials);
        StringWriter sw = new StringWriter();
        jsonMarshaller.marshal(request, sw);
        assertEquals("{"
                      + "\"@type\":\"testConnectionReq\","
                      + "\"credentials\":"
                                        + "{" 
                                           + "\"accountNumber\":\"dummyAccount\","
                                           + "\"systemName\":\"dummySystem\","
                                           + "\"systemKey\":\"dummyKey\""
                                        + "}"
                   + "}", sw.toString());
    }

}

package com.systemincloud.sdk.java.msg;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class TestCommon {

	protected static Marshaller   jsonMarshaller;
	protected static Unmarshaller jsonUnmarshaller;
	
	protected static <T> void setup(Class<T> class1) throws Exception {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(JAXBContextProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        properties.put(JAXBContextProperties.JSON_ATTRIBUTE_PREFIX, "@");
		JAXBContext ctx = JAXBContext.newInstance(new Class[] { class1 }, properties);
		jsonMarshaller = ctx.createMarshaller();
		jsonUnmarshaller = ctx.createUnmarshaller();
	}
}

package com.systemincloud.sdk.java.msg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.eclipse.persistence.oxm.annotations.XmlVariableNode;

public class MapAdapter extends    XmlAdapter<MapAdapter.AdaptedMap, Map<String, String>> {

    public static class AdaptedMap {
        @XmlVariableNode("key")
        public List<AdaptedEntry> entry = new ArrayList<AdaptedEntry>();
    }

    public static class AdaptedEntry {
        @XmlTransient
        public String key;

        @XmlValue
        public String value;

    }

    @Override
    public AdaptedMap marshal(Map<String, String> arg0) throws Exception {
        AdaptedMap myMapType = new AdaptedMap();
        for (Entry<String, String> entry : arg0.entrySet()) {
            AdaptedEntry myMapEntryType = new AdaptedEntry();
            myMapEntryType.key = entry.getKey();
            myMapEntryType.value = entry.getValue();
            myMapType.entry.add(myMapEntryType);
        }
        return myMapType;
    }

    @Override
    public Map<String, String> unmarshal(AdaptedMap arg0) throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (AdaptedEntry myEntryType : arg0.entry) {
            hashMap.put(myEntryType.key, myEntryType.value);
        }
        return hashMap;
    }

}

@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(value=MapAdapter.class, type=Map.class)
})
package com.systemincloud.sdk.java.msg;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

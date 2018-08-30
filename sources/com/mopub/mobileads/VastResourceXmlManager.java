package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class VastResourceXmlManager {
    public static final String CREATIVE_TYPE = "creativeType";
    public static final String HTML_RESOURCE = "HTMLResource";
    public static final String IFRAME_RESOURCE = "IFrameResource";
    public static final String STATIC_RESOURCE = "StaticResource";
    @NonNull
    private final Node a;

    VastResourceXmlManager(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.a = node;
    }

    @Nullable
    String a() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.a, STATIC_RESOURCE));
    }

    @Nullable
    String b() {
        String attributeValue = XmlUtils.getAttributeValue(XmlUtils.getFirstMatchingChildNode(this.a, STATIC_RESOURCE), CREATIVE_TYPE);
        return attributeValue != null ? attributeValue.toLowerCase() : null;
    }

    @Nullable
    String c() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.a, IFRAME_RESOURCE));
    }

    @Nullable
    String d() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.a, HTML_RESOURCE));
    }
}

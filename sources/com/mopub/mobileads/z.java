package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

class z {
    @NonNull
    private final Node a;

    z(@NonNull Node node) {
        Preconditions.checkNotNull(node, "mediaNode cannot be null");
        this.a = node;
    }

    @Nullable
    Integer a() {
        return XmlUtils.getAttributeValueAsInt(this.a, VastIconXmlManager.WIDTH);
    }

    @Nullable
    Integer b() {
        return XmlUtils.getAttributeValueAsInt(this.a, VastIconXmlManager.HEIGHT);
    }

    @Nullable
    String c() {
        return XmlUtils.getAttributeValue(this.a, "type");
    }

    @Nullable
    String d() {
        return XmlUtils.getNodeValue(this.a);
    }
}

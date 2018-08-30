package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

class s {
    @NonNull
    private final Node a;

    s(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.a = node;
    }

    @Nullable
    w a() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "InLine");
        return firstMatchingChildNode != null ? new w(firstMatchingChildNode) : null;
    }

    @Nullable
    ae b() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "Wrapper");
        return firstMatchingChildNode != null ? new ae(firstMatchingChildNode) : null;
    }

    @Nullable
    String c() {
        return XmlUtils.getAttributeValue(this.a, "sequence");
    }
}

package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;

class u {
    @NonNull
    private final Node a;
    @NonNull
    private final VastResourceXmlManager b;

    u(@NonNull Node node) {
        Preconditions.checkNotNull(node, "companionNode cannot be null");
        this.a = node;
        this.b = new VastResourceXmlManager(node);
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
        return XmlUtils.getAttributeValue(this.a, "adSlotID");
    }

    @NonNull
    VastResourceXmlManager d() {
        return this.b;
    }

    @Nullable
    String e() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.a, "CompanionClickThrough"));
    }

    @NonNull
    List<VastTracker> f() {
        List<VastTracker> arrayList = new ArrayList();
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.a, "CompanionClickTracking");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node nodeValue : matchingChildNodes) {
            Object nodeValue2 = XmlUtils.getNodeValue(nodeValue);
            if (!TextUtils.isEmpty(nodeValue2)) {
                arrayList.add(new VastTracker(nodeValue2));
            }
        }
        return arrayList;
    }

    @NonNull
    List<VastTracker> g() {
        List<VastTracker> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "TrackingEvents");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "Tracking", "event", Collections.singletonList("creativeView"))) {
            arrayList.add(new VastTracker(XmlUtils.getNodeValue(firstMatchingChildNode2)));
        }
        return arrayList;
    }

    boolean h() {
        return (TextUtils.isEmpty(this.b.a()) && TextUtils.isEmpty(this.b.d()) && TextUtils.isEmpty(this.b.c())) ? false : true;
    }
}

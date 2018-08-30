package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

abstract class t {
    @NonNull
    protected final Node a;

    t(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.a = node;
    }

    @NonNull
    List<VastTracker> a() {
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.a, "Impression");
        List<VastTracker> arrayList = new ArrayList();
        for (Node nodeValue : matchingChildNodes) {
            Object nodeValue2 = XmlUtils.getNodeValue(nodeValue);
            if (!TextUtils.isEmpty(nodeValue2)) {
                arrayList.add(new VastTracker(nodeValue2));
            }
        }
        return arrayList;
    }

    @NonNull
    List<VastTracker> b() {
        List<VastTracker> arrayList = new ArrayList();
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.a, "Error");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node nodeValue : matchingChildNodes) {
            Object nodeValue2 = XmlUtils.getNodeValue(nodeValue);
            if (!TextUtils.isEmpty(nodeValue2)) {
                arrayList.add(new VastTracker(nodeValue2, true));
            }
        }
        return arrayList;
    }

    @NonNull
    List<x> c() {
        List<x> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "Creatives");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Creative");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : matchingChildNodes) {
            firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode2, "Linear");
            if (firstMatchingChildNode2 != null) {
                arrayList.add(new x(firstMatchingChildNode2));
            }
        }
        return arrayList;
    }

    @NonNull
    List<u> d() {
        List<u> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "Creatives");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Creative");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : matchingChildNodes) {
            firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode2, "CompanionAds");
            if (firstMatchingChildNode2 != null) {
                matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "Companion");
                if (matchingChildNodes != null) {
                    for (Node firstMatchingChildNode22 : matchingChildNodes) {
                        arrayList.add(new u(firstMatchingChildNode22));
                    }
                }
            }
        }
        return arrayList;
    }

    @Nullable
    VastExtensionParentXmlManager e() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "Extensions");
        return firstMatchingChildNode == null ? null : new VastExtensionParentXmlManager(firstMatchingChildNode);
    }
}

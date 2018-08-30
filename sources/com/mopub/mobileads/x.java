package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;

class x {
    public static final String ICON = "Icon";
    public static final String ICONS = "Icons";
    @NonNull
    private final Node a;

    x(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.a = node;
    }

    @NonNull
    private List<VastTracker> a(@NonNull String str) {
        List<String> b = b(str);
        List<VastTracker> arrayList = new ArrayList(b.size());
        for (String vastTracker : b) {
            arrayList.add(new VastTracker(vastTracker));
        }
        return arrayList;
    }

    private void a(@NonNull List<VastFractionalProgressTracker> list, @NonNull List<String> list2, float f) {
        Preconditions.checkNotNull(list, "trackers cannot be null");
        Preconditions.checkNotNull(list2, "urls cannot be null");
        for (String vastFractionalProgressTracker : list2) {
            list.add(new VastFractionalProgressTracker(vastFractionalProgressTracker, f));
        }
    }

    @NonNull
    private List<String> b(@NonNull String str) {
        Preconditions.checkNotNull(str);
        List<String> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "TrackingEvents");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "Tracking", "event", Collections.singletonList(str))) {
            String nodeValue = XmlUtils.getNodeValue(firstMatchingChildNode2);
            if (nodeValue != null) {
                arrayList.add(nodeValue);
            }
        }
        return arrayList;
    }

    @NonNull
    List<VastFractionalProgressTracker> a() {
        List<VastFractionalProgressTracker> arrayList = new ArrayList();
        a(arrayList, b("firstQuartile"), 0.25f);
        a(arrayList, b("midpoint"), 0.5f);
        a(arrayList, b("thirdQuartile"), 0.75f);
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "TrackingEvents");
        if (firstMatchingChildNode != null) {
            for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "Tracking", "event", Collections.singletonList("progress"))) {
                String attributeValue = XmlUtils.getAttributeValue(firstMatchingChildNode2, VastIconXmlManager.OFFSET);
                if (attributeValue != null) {
                    attributeValue = attributeValue.trim();
                    if (Strings.isPercentageTracker(attributeValue)) {
                        try {
                            arrayList.add(new VastFractionalProgressTracker(XmlUtils.getNodeValue(firstMatchingChildNode2), Float.parseFloat(attributeValue.replace("%", "")) / 100.0f));
                        } catch (NumberFormatException e) {
                            MoPubLog.d(String.format("Failed to parse VAST progress tracker %s", new Object[]{attributeValue}));
                        }
                    }
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @NonNull
    List<VastAbsoluteProgressTracker> b() {
        String nodeValue;
        List<VastAbsoluteProgressTracker> arrayList = new ArrayList();
        for (String nodeValue2 : b("start")) {
            arrayList.add(new VastAbsoluteProgressTracker(nodeValue2, 2000));
        }
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "TrackingEvents");
        if (firstMatchingChildNode != null) {
            for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("progress"))) {
                String attributeValue = XmlUtils.getAttributeValue(node, VastIconXmlManager.OFFSET);
                if (attributeValue != null) {
                    attributeValue = attributeValue.trim();
                    if (Strings.isAbsoluteTracker(attributeValue)) {
                        nodeValue2 = XmlUtils.getNodeValue(node);
                        try {
                            Integer parseAbsoluteOffset = Strings.parseAbsoluteOffset(attributeValue);
                            if (parseAbsoluteOffset != null) {
                                arrayList.add(new VastAbsoluteProgressTracker(nodeValue2, parseAbsoluteOffset.intValue()));
                            }
                        } catch (NumberFormatException e) {
                            MoPubLog.d(String.format("Failed to parse VAST progress tracker %s", new Object[]{attributeValue}));
                        }
                    }
                }
            }
            for (Node node2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("creativeView"))) {
                arrayList.add(new VastAbsoluteProgressTracker(XmlUtils.getNodeValue(node2), 0));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @NonNull
    List<VastTracker> c() {
        return a("complete");
    }

    @NonNull
    List<VastTracker> d() {
        List<String> b = b("pause");
        List<VastTracker> arrayList = new ArrayList();
        for (String vastTracker : b) {
            arrayList.add(new VastTracker(vastTracker, true));
        }
        return arrayList;
    }

    @NonNull
    List<VastTracker> e() {
        List<String> b = b("resume");
        List<VastTracker> arrayList = new ArrayList();
        for (String vastTracker : b) {
            arrayList.add(new VastTracker(vastTracker, true));
        }
        return arrayList;
    }

    @NonNull
    List<VastTracker> f() {
        List<VastTracker> a = a("close");
        a.addAll(a("closeLinear"));
        return a;
    }

    @NonNull
    List<VastTracker> g() {
        return a("skip");
    }

    @Nullable
    String h() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "VideoClicks");
        return firstMatchingChildNode == null ? null : XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode, "ClickThrough"));
    }

    @NonNull
    List<VastTracker> i() {
        List<VastTracker> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "VideoClicks");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "ClickTracking")) {
            String nodeValue = XmlUtils.getNodeValue(firstMatchingChildNode2);
            if (nodeValue != null) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }

    @Nullable
    String j() {
        String attributeValue = XmlUtils.getAttributeValue(this.a, "skipoffset");
        return (attributeValue == null || attributeValue.trim().isEmpty()) ? null : attributeValue.trim();
    }

    @NonNull
    List<z> k() {
        List<z> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, "MediaFiles");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "MediaFile")) {
            arrayList.add(new z(firstMatchingChildNode2));
        }
        return arrayList;
    }

    @NonNull
    List<VastIconXmlManager> l() {
        List<VastIconXmlManager> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, ICONS);
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, ICON)) {
            arrayList.add(new VastIconXmlManager(firstMatchingChildNode2));
        }
        return arrayList;
    }
}

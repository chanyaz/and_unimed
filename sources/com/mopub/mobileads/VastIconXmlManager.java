package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class VastIconXmlManager {
    public static final String DURATION = "duration";
    public static final String HEIGHT = "height";
    public static final String ICON_CLICKS = "IconClicks";
    public static final String ICON_CLICK_THROUGH = "IconClickThrough";
    public static final String ICON_CLICK_TRACKING = "IconClickTracking";
    public static final String ICON_VIEW_TRACKING = "IconViewTracking";
    public static final String OFFSET = "offset";
    public static final String WIDTH = "width";
    @NonNull
    private final Node a;
    @NonNull
    private final VastResourceXmlManager b;

    VastIconXmlManager(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.a = node;
        this.b = new VastResourceXmlManager(node);
    }

    @Nullable
    Integer a() {
        return XmlUtils.getAttributeValueAsInt(this.a, WIDTH);
    }

    @Nullable
    Integer b() {
        return XmlUtils.getAttributeValueAsInt(this.a, HEIGHT);
    }

    @Nullable
    Integer c() {
        Integer num = null;
        try {
            return Strings.parseAbsoluteOffset(r1);
        } catch (NumberFormatException e) {
            MoPubLog.d(String.format("Invalid VAST icon offset format: %s:", new Object[]{XmlUtils.getAttributeValue(this.a, OFFSET)}));
            return num;
        }
    }

    @Nullable
    Integer d() {
        Integer num = null;
        try {
            return Strings.parseAbsoluteOffset(r1);
        } catch (NumberFormatException e) {
            MoPubLog.d(String.format("Invalid VAST icon duration format: %s:", new Object[]{XmlUtils.getAttributeValue(this.a, DURATION)}));
            return num;
        }
    }

    @NonNull
    VastResourceXmlManager e() {
        return this.b;
    }

    @NonNull
    List<VastTracker> f() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, ICON_CLICKS);
        List<VastTracker> arrayList = new ArrayList();
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, ICON_CLICK_TRACKING)) {
            String nodeValue = XmlUtils.getNodeValue(firstMatchingChildNode2);
            if (nodeValue != null) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }

    @Nullable
    String g() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, ICON_CLICKS);
        return firstMatchingChildNode == null ? null : XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode, ICON_CLICK_THROUGH));
    }

    @NonNull
    List<VastTracker> h() {
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.a, ICON_VIEW_TRACKING);
        List<VastTracker> arrayList = new ArrayList();
        for (Node nodeValue : matchingChildNodes) {
            String nodeValue2 = XmlUtils.getNodeValue(nodeValue);
            if (nodeValue2 != null) {
                arrayList.add(new VastTracker(nodeValue2));
            }
        }
        return arrayList;
    }
}

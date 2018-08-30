package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class VastExtensionXmlManager {
    public static final String TYPE = "type";
    public static final String VIDEO_VIEWABILITY_TRACKER = "MoPubViewabilityTracker";
    private final Node a;

    public VastExtensionXmlManager(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.a = node;
    }

    @Nullable
    VideoViewabilityTracker a() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.a, VIDEO_VIEWABILITY_TRACKER);
        if (firstMatchingChildNode == null) {
            return null;
        }
        VideoViewabilityTrackerXmlManager videoViewabilityTrackerXmlManager = new VideoViewabilityTrackerXmlManager(firstMatchingChildNode);
        Integer a = videoViewabilityTrackerXmlManager.a();
        Integer b = videoViewabilityTrackerXmlManager.b();
        Object c = videoViewabilityTrackerXmlManager.c();
        return (a == null || b == null || TextUtils.isEmpty(c)) ? null : new VideoViewabilityTracker(a.intValue(), b.intValue(), c);
    }

    @Nullable
    String b() {
        return XmlUtils.getAttributeValue(this.a, "type");
    }
}

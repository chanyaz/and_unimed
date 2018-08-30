package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class VideoViewabilityTrackerXmlManager {
    public static final String PERCENT_VIEWABLE = "percentViewable";
    public static final String VIEWABLE_PLAYTIME = "viewablePlaytime";
    private final Node a;

    VideoViewabilityTrackerXmlManager(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.a = node;
    }

    @Nullable
    Integer a() {
        Object attributeValue = XmlUtils.getAttributeValue(this.a, VIEWABLE_PLAYTIME);
        if (attributeValue == null) {
            return null;
        }
        Integer parseAbsoluteOffset;
        if (Strings.isAbsoluteTracker(attributeValue)) {
            try {
                parseAbsoluteOffset = Strings.parseAbsoluteOffset(attributeValue);
            } catch (NumberFormatException e) {
                MoPubLog.d(String.format("Invalid VAST viewablePlaytime format for \"HH:MM:SS[.mmm]\": %s:", new Object[]{attributeValue}));
                parseAbsoluteOffset = null;
            }
        } else {
            try {
                parseAbsoluteOffset = Integer.valueOf((int) (Float.parseFloat(attributeValue) * 1000.0f));
            } catch (NumberFormatException e2) {
                MoPubLog.d(String.format("Invalid VAST viewablePlaytime format for \"SS[.mmm]\": %s:", new Object[]{attributeValue}));
                parseAbsoluteOffset = null;
            }
        }
        return (parseAbsoluteOffset == null || parseAbsoluteOffset.intValue() < 0) ? null : parseAbsoluteOffset;
    }

    @Nullable
    Integer b() {
        Object attributeValue = XmlUtils.getAttributeValue(this.a, PERCENT_VIEWABLE);
        if (attributeValue == null) {
            return null;
        }
        Integer valueOf;
        try {
            valueOf = Integer.valueOf((int) Float.parseFloat(attributeValue.replace("%", "")));
        } catch (NumberFormatException e) {
            MoPubLog.d(String.format("Invalid VAST percentViewable format for \"d{1,3}%%\": %s:", new Object[]{attributeValue}));
            valueOf = null;
        }
        return (valueOf == null || valueOf.intValue() < 0 || valueOf.intValue() > 100) ? null : valueOf;
    }

    @Nullable
    String c() {
        return XmlUtils.getNodeValue(this.a);
    }
}

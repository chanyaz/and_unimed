package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.util.DeviceUtils.ForceOrientation;
import com.mopub.mobileads.util.XmlUtils;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

class af {
    @Nullable
    private Document a;

    af() {
    }

    @NonNull
    List<s> a() {
        List<s> arrayList = new ArrayList();
        if (this.a == null) {
            return arrayList;
        }
        NodeList elementsByTagName = this.a.getElementsByTagName("Ad");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            arrayList.add(new s(elementsByTagName.item(i)));
        }
        return arrayList;
    }

    void a(@NonNull String str) {
        Preconditions.checkNotNull(str, "xmlString cannot be null");
        String str2 = "<MPMoVideoXMLDocRoot>" + str.replaceFirst("<\\?.*\\?>", "") + "</MPMoVideoXMLDocRoot>";
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setCoalescing(true);
        this.a = newInstance.newDocumentBuilder().parse(new InputSource(new StringReader(str2)));
    }

    @Nullable
    VastTracker b() {
        if (this.a == null) {
            return null;
        }
        Object firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.a, "Error");
        return !TextUtils.isEmpty(firstMatchingStringData) ? new VastTracker(firstMatchingStringData) : null;
    }

    @NonNull
    List<VastTracker> c() {
        List<String> stringDataAsList = XmlUtils.getStringDataAsList(this.a, "MP_TRACKING_URL");
        List<VastTracker> arrayList = new ArrayList(stringDataAsList.size());
        for (String vastTracker : stringDataAsList) {
            arrayList.add(new VastTracker(vastTracker));
        }
        return arrayList;
    }

    @Nullable
    String d() {
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.a, "MoPubCtaText");
        return (firstMatchingStringData == null || firstMatchingStringData.length() > 15) ? null : firstMatchingStringData;
    }

    @Nullable
    String e() {
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.a, "MoPubSkipText");
        return (firstMatchingStringData == null || firstMatchingStringData.length() > 8) ? null : firstMatchingStringData;
    }

    @Nullable
    String f() {
        return XmlUtils.getFirstMatchingStringData(this.a, "MoPubCloseIcon");
    }

    @NonNull
    ForceOrientation g() {
        return ForceOrientation.getForceOrientation(XmlUtils.getFirstMatchingStringData(this.a, "MoPubForceOrientation"));
    }
}

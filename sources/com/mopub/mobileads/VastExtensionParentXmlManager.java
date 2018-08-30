package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class VastExtensionParentXmlManager {
    @NonNull
    private final Node a;

    VastExtensionParentXmlManager(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        this.a = node;
    }

    @NonNull
    List<VastExtensionXmlManager> a() {
        List<VastExtensionXmlManager> arrayList = new ArrayList();
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.a, "Extension");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node vastExtensionXmlManager : matchingChildNodes) {
            arrayList.add(new VastExtensionXmlManager(vastExtensionXmlManager));
        }
        return arrayList;
    }
}

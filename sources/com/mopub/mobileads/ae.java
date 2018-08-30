package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

class ae extends t {
    ae(@NonNull Node node) {
        super(node);
        Preconditions.checkNotNull(node);
    }

    @Nullable
    String f() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.a, "VASTAdTagURI"));
    }
}

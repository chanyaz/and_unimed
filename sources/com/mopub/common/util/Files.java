package com.mopub.common.util;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.File;

public class Files {
    public static File createDirectory(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        return ((file.exists() && file.isDirectory()) || (file.mkdirs() && file.isDirectory())) ? file : null;
    }

    public static int intLength(File file) {
        if (file == null) {
            return 0;
        }
        long length = file.length();
        return length < 2147483647L ? (int) length : MoPubClientPositioning.NO_REPEAT;
    }
}

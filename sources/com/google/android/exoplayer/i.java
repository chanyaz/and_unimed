package com.google.android.exoplayer;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

final class i implements MediaCodecListCompat {
    private i() {
    }

    public int getCodecCount() {
        return MediaCodecList.getCodecCount();
    }

    public MediaCodecInfo getCodecInfoAt(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    public boolean isSecurePlaybackSupported(String str, CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }

    public boolean secureDecodersExplicit() {
        return false;
    }
}

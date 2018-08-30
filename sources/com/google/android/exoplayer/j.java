package com.google.android.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

@TargetApi(21)
final class j implements MediaCodecListCompat {
    private final int a;
    private MediaCodecInfo[] b;

    public j(boolean z) {
        this.a = z ? 1 : 0;
    }

    private void a() {
        if (this.b == null) {
            this.b = new MediaCodecList(this.a).getCodecInfos();
        }
    }

    public int getCodecCount() {
        a();
        return this.b.length;
    }

    public MediaCodecInfo getCodecInfoAt(int i) {
        a();
        return this.b[i];
    }

    public boolean isSecurePlaybackSupported(String str, CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public boolean secureDecodersExplicit() {
        return true;
    }
}

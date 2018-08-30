package com.mopub.mraid;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import com.mopub.mraid.MraidNativeCommandHandler.AnonymousClass1;

class e implements MediaScannerConnectionClient {
    private final String a;
    private final String b;
    private MediaScannerConnection c;

    private e(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    /* synthetic */ e(String str, String str2, AnonymousClass1 anonymousClass1) {
        this(str, str2);
    }

    private void a(MediaScannerConnection mediaScannerConnection) {
        this.c = mediaScannerConnection;
    }

    public void onMediaScannerConnected() {
        if (this.c != null) {
            this.c.scanFile(this.a, this.b);
        }
    }

    public void onScanCompleted(String str, Uri uri) {
        if (this.c != null) {
            this.c.disconnect();
        }
    }
}

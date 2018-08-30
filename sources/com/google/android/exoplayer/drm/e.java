package com.google.android.exoplayer.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;

@SuppressLint({"HandlerLeak"})
class e extends Handler {
    final /* synthetic */ StreamingDrmSessionManager a;

    public e(StreamingDrmSessionManager streamingDrmSessionManager, Looper looper) {
        this.a = streamingDrmSessionManager;
        super(looper);
    }

    public void handleMessage(android.os.Message r4) {
        /*
        r3 = this;
        r0 = r4.what;	 Catch:{ Exception -> 0x000b }
        switch(r0) {
            case 0: goto L_0x001a;
            case 1: goto L_0x002b;
            default: goto L_0x0005;
        };	 Catch:{ Exception -> 0x000b }
    L_0x0005:
        r0 = new java.lang.RuntimeException;	 Catch:{ Exception -> 0x000b }
        r0.<init>();	 Catch:{ Exception -> 0x000b }
        throw r0;	 Catch:{ Exception -> 0x000b }
    L_0x000b:
        r0 = move-exception;
    L_0x000c:
        r1 = r3.a;
        r1 = r1.e;
        r2 = r4.what;
        r0 = r1.obtainMessage(r2, r0);
        r0.sendToTarget();
        return;
    L_0x001a:
        r0 = r3.a;	 Catch:{ Exception -> 0x000b }
        r1 = r0.d;	 Catch:{ Exception -> 0x000b }
        r0 = r3.a;	 Catch:{ Exception -> 0x000b }
        r2 = r0.f;	 Catch:{ Exception -> 0x000b }
        r0 = r4.obj;	 Catch:{ Exception -> 0x000b }
        r0 = (android.media.MediaDrm.ProvisionRequest) r0;	 Catch:{ Exception -> 0x000b }
        r0 = r1.executeProvisionRequest(r2, r0);	 Catch:{ Exception -> 0x000b }
        goto L_0x000c;
    L_0x002b:
        r0 = r3.a;	 Catch:{ Exception -> 0x000b }
        r1 = r0.d;	 Catch:{ Exception -> 0x000b }
        r0 = r3.a;	 Catch:{ Exception -> 0x000b }
        r2 = r0.f;	 Catch:{ Exception -> 0x000b }
        r0 = r4.obj;	 Catch:{ Exception -> 0x000b }
        r0 = (android.media.MediaDrm.KeyRequest) r0;	 Catch:{ Exception -> 0x000b }
        r0 = r1.executeKeyRequest(r2, r0);	 Catch:{ Exception -> 0x000b }
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer.drm.e.handleMessage(android.os.Message):void");
    }
}

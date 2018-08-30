package android.support.v4.media;

import android.os.Handler;
import android.os.Messenger;
import java.lang.ref.WeakReference;

class c extends Handler {
    private final WeakReference<MediaBrowserServiceCallbackImpl> a;
    private WeakReference<Messenger> b;

    c(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
        this.a = new WeakReference(mediaBrowserServiceCallbackImpl);
    }

    void a(Messenger messenger) {
        this.b = new WeakReference(messenger);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0074  */
    public void handleMessage(android.os.Message r8) {
        /*
        r7 = this;
        r6 = 1;
        r0 = r7.b;
        if (r0 == 0) goto L_0x0015;
    L_0x0005:
        r0 = r7.b;
        r0 = r0.get();
        if (r0 == 0) goto L_0x0015;
    L_0x000d:
        r0 = r7.a;
        r0 = r0.get();
        if (r0 != 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r3 = r8.getData();
        r0 = android.support.v4.media.session.MediaSessionCompat.class;
        r0 = r0.getClassLoader();
        r3.setClassLoader(r0);
        r0 = r7.a;
        r0 = r0.get();
        r0 = (android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl) r0;
        r1 = r7.b;
        r1 = r1.get();
        r1 = (android.os.Messenger) r1;
        r2 = r8.what;	 Catch:{ BadParcelableException -> 0x0068 }
        switch(r2) {
            case 1: goto L_0x0078;
            case 2: goto L_0x0090;
            case 3: goto L_0x0094;
            default: goto L_0x0038;
        };	 Catch:{ BadParcelableException -> 0x0068 }
    L_0x0038:
        r2 = "MediaBrowserCompat";
        r3 = new java.lang.StringBuilder;	 Catch:{ BadParcelableException -> 0x0068 }
        r3.<init>();	 Catch:{ BadParcelableException -> 0x0068 }
        r4 = "Unhandled message: ";
        r3 = r3.append(r4);	 Catch:{ BadParcelableException -> 0x0068 }
        r3 = r3.append(r8);	 Catch:{ BadParcelableException -> 0x0068 }
        r4 = "\n  Client version: ";
        r3 = r3.append(r4);	 Catch:{ BadParcelableException -> 0x0068 }
        r4 = 1;
        r3 = r3.append(r4);	 Catch:{ BadParcelableException -> 0x0068 }
        r4 = "\n  Service version: ";
        r3 = r3.append(r4);	 Catch:{ BadParcelableException -> 0x0068 }
        r4 = r8.arg1;	 Catch:{ BadParcelableException -> 0x0068 }
        r3 = r3.append(r4);	 Catch:{ BadParcelableException -> 0x0068 }
        r3 = r3.toString();	 Catch:{ BadParcelableException -> 0x0068 }
        android.util.Log.w(r2, r3);	 Catch:{ BadParcelableException -> 0x0068 }
        goto L_0x0015;
    L_0x0068:
        r2 = move-exception;
        r2 = "MediaBrowserCompat";
        r3 = "Could not unparcel the data.";
        android.util.Log.e(r2, r3);
        r2 = r8.what;
        if (r2 != r6) goto L_0x0015;
    L_0x0074:
        r0.onConnectionFailed(r1);
        goto L_0x0015;
    L_0x0078:
        r2 = "data_media_item_id";
        r4 = r3.getString(r2);	 Catch:{ BadParcelableException -> 0x0068 }
        r2 = "data_media_session_token";
        r2 = r3.getParcelable(r2);	 Catch:{ BadParcelableException -> 0x0068 }
        r2 = (android.support.v4.media.session.MediaSessionCompat.Token) r2;	 Catch:{ BadParcelableException -> 0x0068 }
        r5 = "data_root_hints";
        r3 = r3.getBundle(r5);	 Catch:{ BadParcelableException -> 0x0068 }
        r0.onServiceConnected(r1, r4, r2, r3);	 Catch:{ BadParcelableException -> 0x0068 }
        goto L_0x0015;
    L_0x0090:
        r0.onConnectionFailed(r1);	 Catch:{ BadParcelableException -> 0x0068 }
        goto L_0x0015;
    L_0x0094:
        r2 = "data_media_item_id";
        r2 = r3.getString(r2);	 Catch:{ BadParcelableException -> 0x0068 }
        r4 = "data_media_item_list";
        r4 = r3.getParcelableArrayList(r4);	 Catch:{ BadParcelableException -> 0x0068 }
        r5 = "data_options";
        r3 = r3.getBundle(r5);	 Catch:{ BadParcelableException -> 0x0068 }
        r0.onLoadChildren(r1, r2, r4, r3);	 Catch:{ BadParcelableException -> 0x0068 }
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.c.handleMessage(android.os.Message):void");
    }
}

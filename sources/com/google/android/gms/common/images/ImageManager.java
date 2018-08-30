package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.internal.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    private static final Object a = new Object();
    private static HashSet<Uri> b = new HashSet();
    private final Context c;
    private final Handler d;
    private final ExecutorService e;
    private final a f;
    private final c g;
    private final Map<d, ImageReceiver> h;
    private final Map<Uri, ImageReceiver> i;
    private final Map<Uri, Long> j;

    @KeepName
    final class ImageReceiver extends ResultReceiver {
        private final Uri a;
        private final ArrayList<d> b;
        private final /* synthetic */ ImageManager c;

        public final void onReceiveResult(int i, Bundle bundle) {
            this.c.e.execute(new b(this.c, this.a, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }
}

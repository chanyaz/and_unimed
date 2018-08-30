package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;

class d {
    @VisibleForTesting
    static final d h = new d();
    @Nullable
    View a;
    @Nullable
    MediaLayout b;
    @Nullable
    TextView c;
    @Nullable
    TextView d;
    @Nullable
    ImageView e;
    @Nullable
    TextView f;
    @Nullable
    ImageView g;

    private d() {
    }

    @NonNull
    static d a(@NonNull View view, @NonNull MediaViewBinder mediaViewBinder) {
        d dVar = new d();
        dVar.a = view;
        try {
            dVar.c = (TextView) view.findViewById(mediaViewBinder.c);
            dVar.d = (TextView) view.findViewById(mediaViewBinder.d);
            dVar.f = (TextView) view.findViewById(mediaViewBinder.e);
            dVar.b = (MediaLayout) view.findViewById(mediaViewBinder.b);
            dVar.e = (ImageView) view.findViewById(mediaViewBinder.f);
            dVar.g = (ImageView) view.findViewById(mediaViewBinder.g);
            return dVar;
        } catch (Throwable e) {
            MoPubLog.w("Could not cast from id in MediaViewBinder to expected View type", e);
            return h;
        }
    }
}

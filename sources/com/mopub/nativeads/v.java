package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;

class v {
    @VisibleForTesting
    static final v h = new v();
    @Nullable
    View a;
    @Nullable
    TextView b;
    @Nullable
    TextView c;
    @Nullable
    TextView d;
    @Nullable
    ImageView e;
    @Nullable
    ImageView f;
    @Nullable
    ImageView g;

    private v() {
    }

    @NonNull
    static v a(@NonNull View view, @NonNull ViewBinder viewBinder) {
        v vVar = new v();
        vVar.a = view;
        try {
            vVar.b = (TextView) view.findViewById(viewBinder.b);
            vVar.c = (TextView) view.findViewById(viewBinder.c);
            vVar.d = (TextView) view.findViewById(viewBinder.d);
            vVar.e = (ImageView) view.findViewById(viewBinder.e);
            vVar.f = (ImageView) view.findViewById(viewBinder.f);
            vVar.g = (ImageView) view.findViewById(viewBinder.g);
            return vVar;
        } catch (Throwable e) {
            MoPubLog.w("Could not cast from id in ViewBinder to expected View type", e);
            return h;
        }
    }
}

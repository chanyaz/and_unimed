package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public abstract class BaseNativeAd {
    @NonNull
    private final Set<String> a = new HashSet();
    @NonNull
    private final Set<String> b = new HashSet();
    @Nullable
    private NativeEventListener c;

    public interface NativeEventListener {
        void onAdClicked();

        void onAdImpressed();
    }

    protected BaseNativeAd() {
    }

    protected final void a() {
        if (this.c != null) {
            this.c.onAdImpressed();
        }
    }

    protected final void a(Object obj) {
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    addImpressionTracker(jSONArray.getString(i));
                } catch (JSONException e) {
                    MoPubLog.d("Unable to parse impression trackers.");
                }
            }
            return;
        }
        throw new ClassCastException("Expected impression trackers of type JSONArray.");
    }

    public final void addClickTracker(@NonNull String str) {
        if (NoThrow.checkNotNull(str, "clickTracker url is not allowed to be null")) {
            this.b.add(str);
        }
    }

    public final void addImpressionTracker(@NonNull String str) {
        if (NoThrow.checkNotNull(str, "impressionTracker url is not allowed to be null")) {
            this.a.add(str);
        }
    }

    protected final void b() {
        if (this.c != null) {
            this.c.onAdClicked();
        }
    }

    protected final void b(Object obj) {
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    addClickTracker(jSONArray.getString(i));
                } catch (JSONException e) {
                    MoPubLog.d("Unable to parse click trackers.");
                }
            }
            return;
        }
        throw new ClassCastException("Expected click trackers of type JSONArray.");
    }

    @NonNull
    Set<String> c() {
        return new HashSet(this.a);
    }

    public abstract void clear(@NonNull View view);

    @NonNull
    Set<String> d() {
        return new HashSet(this.b);
    }

    public abstract void destroy();

    public abstract void prepare(@NonNull View view);

    public void setNativeEventListener(@Nullable NativeEventListener nativeEventListener) {
        this.c = nativeEventListener;
    }
}

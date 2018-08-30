package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.event.BaseEvent.Name;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.TrackingRequest;
import java.util.EnumSet;
import java.util.Iterator;

public class UrlHandler {
    private static final ResultActions a = new ResultActions() {
        public void urlHandlingFailed(@NonNull String str, @NonNull UrlAction urlAction) {
        }

        public void urlHandlingSucceeded(@NonNull String str, @NonNull UrlAction urlAction) {
        }
    };
    private static final MoPubSchemeListener b = new MoPubSchemeListener() {
        public void onClose() {
        }

        public void onFailLoad() {
        }

        public void onFinishLoad() {
        }
    };
    @NonNull
    private EnumSet<UrlAction> c;
    @NonNull
    private ResultActions d;
    @NonNull
    private MoPubSchemeListener e;
    @Nullable
    private String f;
    private boolean g;
    private boolean h;
    private boolean i;

    public interface ResultActions {
        void urlHandlingFailed(@NonNull String str, @NonNull UrlAction urlAction);

        void urlHandlingSucceeded(@NonNull String str, @NonNull UrlAction urlAction);
    }

    public interface MoPubSchemeListener {
        void onClose();

        void onFailLoad();

        void onFinishLoad();
    }

    public class Builder {
        @NonNull
        private EnumSet<UrlAction> a = EnumSet.of(UrlAction.NOOP);
        @NonNull
        private ResultActions b = UrlHandler.a;
        @NonNull
        private MoPubSchemeListener c = UrlHandler.b;
        private boolean d = false;
        @Nullable
        private String e;

        public UrlHandler build() {
            return new UrlHandler(this.a, this.b, this.c, this.d, this.e, null);
        }

        public Builder withDspCreativeId(@Nullable String str) {
            this.e = str;
            return this;
        }

        public Builder withMoPubSchemeListener(@NonNull MoPubSchemeListener moPubSchemeListener) {
            this.c = moPubSchemeListener;
            return this;
        }

        public Builder withResultActions(@NonNull ResultActions resultActions) {
            this.b = resultActions;
            return this;
        }

        public Builder withSupportedUrlActions(@NonNull UrlAction urlAction, @Nullable UrlAction... urlActionArr) {
            this.a = EnumSet.of(urlAction, urlActionArr);
            return this;
        }

        public Builder withSupportedUrlActions(@NonNull EnumSet<UrlAction> enumSet) {
            this.a = EnumSet.copyOf(enumSet);
            return this;
        }

        public Builder withoutMoPubBrowser() {
            this.d = true;
            return this;
        }
    }

    private UrlHandler(@NonNull EnumSet<UrlAction> enumSet, @NonNull ResultActions resultActions, @NonNull MoPubSchemeListener moPubSchemeListener, boolean z, @Nullable String str) {
        this.c = EnumSet.copyOf(enumSet);
        this.d = resultActions;
        this.e = moPubSchemeListener;
        this.g = z;
        this.f = str;
        this.h = false;
        this.i = false;
    }

    /* synthetic */ UrlHandler(EnumSet enumSet, ResultActions resultActions, MoPubSchemeListener moPubSchemeListener, boolean z, String str, AnonymousClass1 anonymousClass1) {
        this(enumSet, resultActions, moPubSchemeListener, z, str);
    }

    private void a(@Nullable String str, @Nullable UrlAction urlAction, @NonNull String str2, @Nullable Throwable th) {
        Preconditions.checkNotNull(str2);
        if (urlAction == null) {
            urlAction = UrlAction.NOOP;
        }
        MoPubLog.d(str2, th);
        this.d.urlHandlingFailed(str, urlAction);
    }

    @NonNull
    MoPubSchemeListener a() {
        return this.e;
    }

    boolean b() {
        return this.g;
    }

    public boolean handleResolvedUrl(@NonNull Context context, @NonNull String str, boolean z, @Nullable Iterable<String> iterable) {
        if (TextUtils.isEmpty(str)) {
            a(str, null, "Attempted to handle empty url.", null);
            return false;
        }
        UrlAction urlAction = UrlAction.NOOP;
        Uri parse = Uri.parse(str);
        Iterator it = this.c.iterator();
        while (true) {
            UrlAction urlAction2 = urlAction;
            if (it.hasNext()) {
                urlAction = (UrlAction) it.next();
                if (urlAction.shouldTryHandlingUrl(parse)) {
                    try {
                        urlAction.handleUrl(this, context, parse, z, this.f);
                        if (!(this.h || this.i || UrlAction.IGNORE_ABOUT_SCHEME.equals(urlAction) || UrlAction.HANDLE_MOPUB_SCHEME.equals(urlAction))) {
                            TrackingRequest.makeTrackingHttpRequest((Iterable) iterable, context, Name.CLICK_REQUEST);
                            this.d.urlHandlingSucceeded(parse.toString(), urlAction);
                            this.h = true;
                        }
                        return true;
                    } catch (Throwable e) {
                        MoPubLog.d(e.getMessage(), e);
                    }
                } else {
                    urlAction = urlAction2;
                }
            } else {
                a(str, urlAction2, "Link ignored. Unable to handle url: " + str, null);
                return false;
            }
        }
    }

    public void handleUrl(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        handleUrl(context, str, true);
    }

    public void handleUrl(@NonNull Context context, @NonNull String str, boolean z) {
        Preconditions.checkNotNull(context);
        handleUrl(context, str, z, null);
    }

    public void handleUrl(@NonNull Context context, @NonNull String str, boolean z, @Nullable Iterable<String> iterable) {
        Preconditions.checkNotNull(context);
        if (TextUtils.isEmpty(str)) {
            a(str, null, "Attempted to handle empty url.", null);
            return;
        }
        final Context context2 = context;
        final boolean z2 = z;
        final Iterable<String> iterable2 = iterable;
        final String str2 = str;
        UrlResolutionTask.getResolvedUrl(str, new UrlResolutionListener() {
            public void onFailure(@NonNull String str, @Nullable Throwable th) {
                UrlHandler.this.i = false;
                UrlHandler.this.a(str2, null, str, th);
            }

            public void onSuccess(@NonNull String str) {
                UrlHandler.this.i = false;
                UrlHandler.this.handleResolvedUrl(context2, str, z2, iterable2);
            }
        });
        this.i = true;
    }
}

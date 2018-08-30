package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.VisibleForTesting;

public class NativeClickHandler {
    @NonNull
    private final Context a;
    @Nullable
    private final String b;
    private boolean c;

    public NativeClickHandler(@NonNull Context context) {
        this(context, null);
    }

    public NativeClickHandler(@NonNull Context context, @Nullable String str) {
        Preconditions.checkNotNull(context);
        this.a = context.getApplicationContext();
        this.b = str;
    }

    private void a(@NonNull View view, @Nullable OnClickListener onClickListener) {
        view.setOnClickListener(onClickListener);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), onClickListener);
            }
        }
    }

    @VisibleForTesting
    void a(@NonNull String str, @Nullable final View view, @NonNull final u uVar) {
        if (NoThrow.checkNotNull(str, "Cannot open a null click destination url")) {
            Preconditions.checkNotNull(uVar);
            if (!this.c) {
                this.c = true;
                if (view != null) {
                    uVar.a(view);
                }
                Builder builder = new Builder();
                if (!TextUtils.isEmpty(this.b)) {
                    builder.withDspCreativeId(this.b);
                }
                builder.withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new ResultActions() {
                    private void a() {
                        if (view != null) {
                            uVar.a();
                        }
                    }

                    public void urlHandlingFailed(@NonNull String str, @NonNull UrlAction urlAction) {
                        a();
                        NativeClickHandler.this.c = false;
                    }

                    public void urlHandlingSucceeded(@NonNull String str, @NonNull UrlAction urlAction) {
                        a();
                        NativeClickHandler.this.c = false;
                    }
                }).build().handleUrl(this.a, str);
            }
        }
    }

    public void clearOnClickListener(@NonNull View view) {
        if (NoThrow.checkNotNull(view, "Cannot clear click listener from a null view")) {
            a(view, (OnClickListener) null);
        }
    }

    public void openClickDestinationUrl(@NonNull String str, @Nullable View view) {
        a(str, view, new u(this.a));
    }

    public void setOnClickListener(@NonNull View view, @NonNull final ClickInterface clickInterface) {
        if (NoThrow.checkNotNull(view, "Cannot set click listener on a null view") && NoThrow.checkNotNull(clickInterface, "Cannot set click listener with a null ClickInterface")) {
            a(view, new OnClickListener() {
                public void onClick(View view) {
                    clickInterface.handleClick(view);
                }
            });
        }
    }
}

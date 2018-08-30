package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;

class o extends AdUrlGenerator {
    @Nullable
    private String e;
    @Nullable
    private String f;

    o(Context context) {
        super(context);
    }

    private void c() {
        if (!TextUtils.isEmpty(this.f)) {
            b("MAGIC_NO", this.f);
        }
    }

    private void d() {
        if (!TextUtils.isEmpty(this.e)) {
            b("assets", this.e);
        }
    }

    @NonNull
    o a(int i) {
        this.f = String.valueOf(i);
        return this;
    }

    @NonNull
    o a(@Nullable RequestParameters requestParameters) {
        if (requestParameters != null) {
            this.c = requestParameters.getKeywords();
            this.d = requestParameters.getLocation();
            this.e = requestParameters.getDesiredAssets();
        }
        return this;
    }

    protected void b(String str) {
        b("nsv", str);
    }

    public String generateUrlString(String str) {
        a(str, Constants.AD_HANDLER);
        a(ClientMetadata.getInstance(this.a));
        d();
        c();
        return a();
    }

    @NonNull
    public o withAdUnitId(String str) {
        this.b = str;
        return this;
    }
}

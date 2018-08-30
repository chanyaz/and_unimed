package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;

class s extends BaseUrlGenerator {
    @NonNull
    private final Context a;
    @NonNull
    private String b;

    public s(@NonNull Context context) {
        this.a = context;
    }

    private void a(@NonNull String str) {
        b("id", str);
    }

    private void b(@NonNull String str) {
        b("nsv", str);
    }

    public String generateUrlString(@NonNull String str) {
        a(str, Constants.POSITIONING_HANDLER);
        a(this.b);
        k("1");
        ClientMetadata instance = ClientMetadata.getInstance(this.a);
        b(instance.getSdkVersion());
        a(instance.getDeviceManufacturer(), instance.getDeviceModel(), instance.getDeviceProduct());
        l(instance.getAppVersion());
        b();
        return a();
    }

    @NonNull
    public s withAdUnitId(@NonNull String str) {
        this.b = str;
        return this;
    }
}

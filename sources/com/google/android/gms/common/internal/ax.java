package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.n;
import javax.annotation.Nullable;

public class ax {
    private final Resources a;
    private final String b = this.a.getResourcePackageName(n.common_google_play_services_unknown_issue);

    public ax(Context context) {
        ar.a((Object) context);
        this.a = context.getResources();
    }

    @Nullable
    public String a(String str) {
        int identifier = this.a.getIdentifier(str, "string", this.b);
        return identifier == 0 ? null : this.a.getString(identifier);
    }
}

package com.google.android.gms.common.data;

import android.content.Context;

public interface TextFilterable {
    public static final StringFilter a = new e();
    public static final StringFilter b = new f();
    public static final StringFilter c = new g();

    public interface StringFilter {
        boolean matches(String str, String str2);
    }

    void setFilterTerm(Context context, StringFilter stringFilter, String str);

    void setFilterTerm(Context context, String str);
}

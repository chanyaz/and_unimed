package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;

public class qo extends apk<String> {
    private final Object a = new Object();
    private zzz<String> b;

    public qo(int i, String str, zzz<String> zzz, zzy zzy) {
        super(i, str, zzy);
        this.b = zzz;
    }

    protected final auj<String> a(any any) {
        Object str;
        try {
            byte[] bArr = any.b;
            String str2 = "ISO-8859-1";
            String str3 = (String) any.c.get("Content-Type");
            if (str3 != null) {
                String[] split = str3.split(";");
                for (int i = 1; i < split.length; i++) {
                    String[] split2 = split[i].trim().split("=");
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        str3 = split2[1];
                        break;
                    }
                }
            }
            str3 = str2;
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException e) {
            str = new String(any.b);
        }
        return auj.a(str, ly.a(any));
    }

    protected void a(String str) {
        zzz zzz;
        synchronized (this.a) {
            zzz = this.b;
        }
        if (zzz != null) {
            zzz.zzb(str);
        }
    }
}

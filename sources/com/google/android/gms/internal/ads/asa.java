package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@zzadh
final class asa {
    final zzjj a;
    final String b;
    final int c;

    asa(arw arw) {
        this(arw.a(), arw.c(), arw.b());
    }

    @VisibleForTesting
    private asa(zzjj zzjj, String str, int i) {
        this.a = zzjj;
        this.b = str;
        this.c = i;
    }

    static asa a(String str) {
        Throwable e;
        String[] split = str.split("\u0000");
        if (split.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            String str2 = new String(Base64.decode(split[0], 0), "UTF-8");
            int parseInt = Integer.parseInt(split[1]);
            byte[] decode = Base64.decode(split[2], 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            asa asa = new asa((zzjj) zzjj.CREATOR.createFromParcel(obtain), str2, parseInt);
            obtain.recycle();
            return asa;
        } catch (IllegalStateException e2) {
            e = e2;
            try {
                au.i().a(e, "QueueSeed.decode");
                throw new IOException("Malformed QueueSeed encoding.", e);
            } catch (Throwable th) {
                obtain.recycle();
            }
        } catch (IllegalArgumentException e3) {
            e = e3;
            au.i().a(e, "QueueSeed.decode");
            throw new IOException("Malformed QueueSeed encoding.", e);
        } catch (ParseException e4) {
            e = e4;
            au.i().a(e, "QueueSeed.decode");
            throw new IOException("Malformed QueueSeed encoding.", e);
        }
    }

    final String a() {
        Parcel obtain = Parcel.obtain();
        String encodeToString;
        try {
            encodeToString = Base64.encodeToString(this.b.getBytes("UTF-8"), 0);
            String num = Integer.toString(this.c);
            this.a.writeToParcel(obtain, 0);
            String encodeToString2 = Base64.encodeToString(obtain.marshall(), 0);
            encodeToString = new StringBuilder(((String.valueOf(encodeToString).length() + 2) + String.valueOf(num).length()) + String.valueOf(encodeToString2).length()).append(encodeToString).append("\u0000").append(num).append("\u0000").append(encodeToString2).toString();
            return encodeToString;
        } catch (UnsupportedEncodingException e) {
            encodeToString = "QueueSeed encode failed because UTF-8 is not available.";
            kk.c(encodeToString);
            return "";
        } finally {
            obtain.recycle();
        }
    }
}

package com.appnext.base.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

@SuppressLint({"CommitPrefEdits"})
public class i {
    private static final String TAG = "LibrarySettings";
    public static final String jY = "_lastupdate";
    public static final String jZ = "_lastcollectedtime";
    public static final String ka = "_cycles";
    public static final String kb = "_hash";
    public static final String kc = "google_ads_id";
    public static final String kd = "_sent_once";
    public static final String ke = "generated";
    public static final String kf = "db_init";
    public static final String kg = "apps_category_saved";
    public static final String kh = "moments_sdk_version";
    public static final String ki = "lat";
    public static final String kj = "usloc_status";
    public static final String kk = "lib_shared_preferences";
    @SuppressLint({"StaticFieldLeak"})
    private static final i kl = new i();
    private SharedPreferences jX;
    private Context mContext = d.getContext();

    private i() {
        if (this.mContext != null) {
            this.jX = this.mContext.getSharedPreferences(kk, 0);
        }
    }

    public static i cE() {
        return kl;
    }

    public void clear() {
        this.jX.edit().clear().apply();
    }

    public boolean getBoolean(String str, boolean z) {
        return this.jX != null ? this.jX.getBoolean(str, z) : z;
    }

    public int getInt(String str, int i) {
        return this.jX != null ? this.jX.getInt(str, i) : i;
    }

    public long getLong(String str, long j) {
        return this.jX != null ? this.jX.getLong(str, j) : j;
    }

    public String getString(String str, String str2) {
        return this.jX != null ? this.jX.getString(str, str2) : str2;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return this.jX != null ? this.jX.getStringSet(str, set) : set;
    }

    public void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.jX = this.mContext.getSharedPreferences(kk, 0);
        }
    }

    public void putBoolean(String str, boolean z) {
        if (this.jX != null) {
            this.jX.edit().putBoolean(str, z).apply();
        }
    }

    public void putInt(String str, int i) {
        if (this.jX != null) {
            this.jX.edit().putInt(str, i).apply();
        }
    }

    public void putLong(String str, long j) {
        if (this.jX != null) {
            this.jX.edit().putLong(str, j).apply();
        }
    }

    public void putString(String str, String str2) {
        if (this.jX != null) {
            this.jX.edit().putString(str, str2).apply();
        }
    }

    public void putStringSet(String str, Set<String> set) {
        if (this.jX != null) {
            this.jX.edit().remove(str);
            this.jX.edit().putStringSet(str, set).apply();
        }
    }
}

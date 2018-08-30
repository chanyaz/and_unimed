package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@Class(creator = "GoogleSignInAccountCreator")
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new a();
    @VisibleForTesting
    public static Clock a = f.a();
    @VersionField(id = 1)
    private final int b;
    @Field(getter = "getId", id = 2)
    private String c;
    @Field(getter = "getIdToken", id = 3)
    private String d;
    @Field(getter = "getEmail", id = 4)
    private String e;
    @Field(getter = "getDisplayName", id = 5)
    private String f;
    @Field(getter = "getPhotoUrl", id = 6)
    private Uri g;
    @Field(getter = "getServerAuthCode", id = 7)
    private String h;
    @Field(getter = "getExpirationTimeSecs", id = 8)
    private long i;
    @Field(getter = "getObfuscatedIdentifier", id = 9)
    private String j;
    @Field(id = 10)
    private List<Scope> k;
    @Field(getter = "getGivenName", id = 11)
    private String l;
    @Field(getter = "getFamilyName", id = 12)
    private String m;
    private Set<Scope> n = new HashSet();

    @Constructor
    GoogleSignInAccount(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3, @Param(id = 5) String str4, @Param(id = 6) Uri uri, @Param(id = 7) String str5, @Param(id = 8) long j, @Param(id = 9) String str6, @Param(id = 10) List<Scope> list, @Param(id = 11) String str7, @Param(id = 12) String str8) {
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = uri;
        this.h = str5;
        this.i = j;
        this.j = str6;
        this.k = list;
        this.l = str7;
        this.m = str8;
    }

    @Nullable
    public static GoogleSignInAccount a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).b(jSONObject.optString("serverAuthCode", null));
    }

    public static GoogleSignInAccount a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l, @NonNull String str7, @NonNull Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(a.currentTimeMillis() / 1000);
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), ar.a(str7), new ArrayList((Collection) ar.a((Object) set)), str5, str6);
    }

    @Nullable
    public String a() {
        return this.c;
    }

    public GoogleSignInAccount b(String str) {
        this.h = str;
        return this;
    }

    @Nullable
    public String b() {
        return this.d;
    }

    @Nullable
    public String c() {
        return this.e;
    }

    @Nullable
    public Account d() {
        return this.e == null ? null : new Account(this.e, "com.google");
    }

    @Nullable
    public String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.k().equals(k()) && googleSignInAccount.l().equals(l());
    }

    @Nullable
    public String f() {
        return this.l;
    }

    @Nullable
    public String g() {
        return this.m;
    }

    @Nullable
    public Uri h() {
        return this.g;
    }

    public int hashCode() {
        return ((k().hashCode() + 527) * 31) + l().hashCode();
    }

    @Nullable
    public String i() {
        return this.h;
    }

    public long j() {
        return this.i;
    }

    @NonNull
    public String k() {
        return this.j;
    }

    @NonNull
    public Set<Scope> l() {
        Set<Scope> hashSet = new HashSet(this.k);
        hashSet.addAll(this.n);
        return hashSet;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.b);
        a.a(parcel, 2, a(), false);
        a.a(parcel, 3, b(), false);
        a.a(parcel, 4, c(), false);
        a.a(parcel, 5, e(), false);
        a.a(parcel, 6, h(), i, false);
        a.a(parcel, 7, i(), false);
        a.a(parcel, 8, j());
        a.a(parcel, 9, k(), false);
        a.c(parcel, 10, this.k, false);
        a.a(parcel, 11, f(), false);
        a.a(parcel, 12, g(), false);
        a.a(parcel, a);
    }
}

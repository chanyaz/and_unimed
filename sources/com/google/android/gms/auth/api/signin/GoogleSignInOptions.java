package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.b;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Class(creator = "GoogleSignInOptionsCreator")
public class GoogleSignInOptions extends AbstractSafeParcelable implements Optional, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new c();
    @VisibleForTesting
    public static final Scope a = new Scope("profile");
    @VisibleForTesting
    public static final Scope b = new Scope("email");
    @VisibleForTesting
    public static final Scope c = new Scope("openid");
    @VisibleForTesting
    public static final Scope d = new Scope("https://www.googleapis.com/auth/games_lite");
    @VisibleForTesting
    public static final Scope e = new Scope("https://www.googleapis.com/auth/games");
    public static final GoogleSignInOptions f = new b().a().b().c();
    public static final GoogleSignInOptions g = new b().a(d, new Scope[0]).c();
    private static Comparator<Scope> r = new d();
    @VersionField(id = 1)
    private final int h;
    @Field(getter = "getScopes", id = 2)
    private final ArrayList<Scope> i;
    @Field(getter = "getAccount", id = 3)
    private Account j;
    @Field(getter = "isIdTokenRequested", id = 4)
    private boolean k;
    @Field(getter = "isServerAuthCodeRequested", id = 5)
    private final boolean l;
    @Field(getter = "isForceCodeForRefreshToken", id = 6)
    private final boolean m;
    @Field(getter = "getServerClientId", id = 7)
    private String n;
    @Field(getter = "getHostedDomain", id = 8)
    private String o;
    @Field(getter = "getExtensions", id = 9)
    private ArrayList<GoogleSignInOptionsExtensionParcelable> p;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> q;

    @Constructor
    GoogleSignInOptions(@Param(id = 1) int i, @Param(id = 2) ArrayList<Scope> arrayList, @Param(id = 3) Account account, @Param(id = 4) boolean z, @Param(id = 5) boolean z2, @Param(id = 6) boolean z3, @Param(id = 7) String str, @Param(id = 8) String str2, @Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i, (ArrayList) arrayList, account, z, z2, z3, str, str2, a(arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        this.h = i;
        this.i = arrayList;
        this.j = account;
        this.k = z;
        this.l = z2;
        this.m = z3;
        this.n = str;
        this.o = str2;
        this.p = new ArrayList(map.values());
        this.q = map;
    }

    /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, d dVar) {
        this(3, arrayList, account, z, z2, z3, str, str2, map);
    }

    private static Map<Integer, GoogleSignInOptionsExtensionParcelable> a(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        Map<Integer, GoogleSignInOptionsExtensionParcelable> hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.a()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    public ArrayList<Scope> a() {
        return new ArrayList(this.i);
    }

    public Account b() {
        return this.j;
    }

    public boolean c() {
        return this.k;
    }

    public boolean d() {
        return this.l;
    }

    public boolean e() {
        return this.m;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.p.size() > 0 || googleSignInOptions.p.size() > 0 || this.i.size() != googleSignInOptions.a().size() || !this.i.containsAll(googleSignInOptions.a())) {
                return false;
            }
            if (this.j == null) {
                if (googleSignInOptions.b() != null) {
                    return false;
                }
            } else if (!this.j.equals(googleSignInOptions.b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.n)) {
                if (!TextUtils.isEmpty(googleSignInOptions.f())) {
                    return false;
                }
            } else if (!this.n.equals(googleSignInOptions.f())) {
                return false;
            }
            return this.m == googleSignInOptions.e() && this.k == googleSignInOptions.c() && this.l == googleSignInOptions.d();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public String f() {
        return this.n;
    }

    public String g() {
        return this.o;
    }

    public ArrayList<GoogleSignInOptionsExtensionParcelable> h() {
        return this.p;
    }

    public int hashCode() {
        Object arrayList = new ArrayList();
        ArrayList arrayList2 = this.i;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((Scope) obj).a());
        }
        Collections.sort(arrayList);
        return new b().a(arrayList).a(this.j).a(this.n).a(this.m).a(this.k).a(this.l).a();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.h);
        a.c(parcel, 2, a(), false);
        a.a(parcel, 3, b(), i, false);
        a.a(parcel, 4, c());
        a.a(parcel, 5, d());
        a.a(parcel, 6, e());
        a.a(parcel, 7, f(), false);
        a.a(parcel, 8, g(), false);
        a.c(parcel, 9, h(), false);
        a.a(parcel, a);
    }
}

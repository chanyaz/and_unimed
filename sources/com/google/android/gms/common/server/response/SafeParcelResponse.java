package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.b;
import com.google.android.gms.common.util.c;
import com.google.android.gms.common.util.m;
import com.google.android.gms.common.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Class(creator = "SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Creator<SafeParcelResponse> CREATOR = new e();
    @VersionField(getter = "getVersionCode", id = 1)
    private final int a;
    @Field(getter = "getParcel", id = 2)
    private final Parcel b;
    private final int c = 2;
    @Field(getter = "getFieldMappingDictionary", id = 3)
    private final FieldMappingDictionary d;
    private final String e;
    private int f;
    private int g;

    @Constructor
    SafeParcelResponse(@Param(id = 1) int i, @Param(id = 2) Parcel parcel, @Param(id = 3) FieldMappingDictionary fieldMappingDictionary) {
        this.a = i;
        this.b = (Parcel) ar.a((Object) parcel);
        this.d = fieldMappingDictionary;
        if (this.d == null) {
            this.e = null;
        } else {
            this.e = this.d.b();
        }
        this.f = 2;
    }

    public static HashMap<String, String> a(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    private static void a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(m.b(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(c.a((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(c.b((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                n.a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private final void a(StringBuilder stringBuilder, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.c()) {
            ArrayList arrayList = (ArrayList) obj;
            stringBuilder.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                a(stringBuilder, field.b(), arrayList.get(i));
            }
            stringBuilder.append("]");
            return;
        }
        a(stringBuilder, field.b(), obj);
    }

    private final void a(StringBuilder stringBuilder, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        Entry entry;
        SparseArray sparseArray = new SparseArray();
        for (Entry entry2 : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry2.getValue()).g(), entry2);
        }
        stringBuilder.append('{');
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            entry2 = (Entry) sparseArray.get(SafeParcelReader.a(a));
            if (entry2 != null) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                stringBuilder.append("\"").append(str).append("\":");
                if (field.i()) {
                    switch (field.d()) {
                        case 0:
                            a(stringBuilder, field, a(field, Integer.valueOf(SafeParcelReader.e(parcel, a))));
                            break;
                        case 1:
                            a(stringBuilder, field, a(field, SafeParcelReader.i(parcel, a)));
                            break;
                        case 2:
                            a(stringBuilder, field, a(field, Long.valueOf(SafeParcelReader.g(parcel, a))));
                            break;
                        case 3:
                            a(stringBuilder, field, a(field, Float.valueOf(SafeParcelReader.j(parcel, a))));
                            break;
                        case 4:
                            a(stringBuilder, field, a(field, Double.valueOf(SafeParcelReader.l(parcel, a))));
                            break;
                        case 5:
                            a(stringBuilder, field, a(field, SafeParcelReader.n(parcel, a)));
                            break;
                        case 6:
                            a(stringBuilder, field, a(field, Boolean.valueOf(SafeParcelReader.c(parcel, a))));
                            break;
                        case 7:
                            a(stringBuilder, field, a(field, SafeParcelReader.o(parcel, a)));
                            break;
                        case 8:
                        case 9:
                            a(stringBuilder, field, a(field, SafeParcelReader.r(parcel, a)));
                            break;
                        case 10:
                            a(stringBuilder, field, a(field, a(SafeParcelReader.q(parcel, a))));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + field.d());
                    }
                } else if (field.e()) {
                    stringBuilder.append("[");
                    switch (field.d()) {
                        case 0:
                            b.a(stringBuilder, SafeParcelReader.t(parcel, a));
                            break;
                        case 1:
                            b.a(stringBuilder, SafeParcelReader.v(parcel, a));
                            break;
                        case 2:
                            b.a(stringBuilder, SafeParcelReader.u(parcel, a));
                            break;
                        case 3:
                            b.a(stringBuilder, SafeParcelReader.w(parcel, a));
                            break;
                        case 4:
                            b.a(stringBuilder, SafeParcelReader.x(parcel, a));
                            break;
                        case 5:
                            b.a(stringBuilder, SafeParcelReader.y(parcel, a));
                            break;
                        case 6:
                            b.a(stringBuilder, SafeParcelReader.s(parcel, a));
                            break;
                        case 7:
                            b.a(stringBuilder, SafeParcelReader.z(parcel, a));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] D = SafeParcelReader.D(parcel, a);
                            int length = D.length;
                            for (i = 0; i < length; i++) {
                                if (i > 0) {
                                    stringBuilder.append(",");
                                }
                                D[i].setDataPosition(0);
                                a(stringBuilder, field.j(), D[i]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    stringBuilder.append("]");
                } else {
                    switch (field.d()) {
                        case 0:
                            stringBuilder.append(SafeParcelReader.e(parcel, a));
                            break;
                        case 1:
                            stringBuilder.append(SafeParcelReader.i(parcel, a));
                            break;
                        case 2:
                            stringBuilder.append(SafeParcelReader.g(parcel, a));
                            break;
                        case 3:
                            stringBuilder.append(SafeParcelReader.j(parcel, a));
                            break;
                        case 4:
                            stringBuilder.append(SafeParcelReader.l(parcel, a));
                            break;
                        case 5:
                            stringBuilder.append(SafeParcelReader.n(parcel, a));
                            break;
                        case 6:
                            stringBuilder.append(SafeParcelReader.c(parcel, a));
                            break;
                        case 7:
                            stringBuilder.append("\"").append(m.b(SafeParcelReader.o(parcel, a))).append("\"");
                            break;
                        case 8:
                            stringBuilder.append("\"").append(c.a(SafeParcelReader.r(parcel, a))).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(c.b(SafeParcelReader.r(parcel, a)));
                            stringBuilder.append("\"");
                            break;
                        case 10:
                            Bundle q = SafeParcelReader.q(parcel, a);
                            Set<String> keySet = q.keySet();
                            keySet.size();
                            stringBuilder.append("{");
                            i = 1;
                            for (String str2 : keySet) {
                                if (i == 0) {
                                    stringBuilder.append(",");
                                }
                                stringBuilder.append("\"").append(str2).append("\"");
                                stringBuilder.append(":");
                                stringBuilder.append("\"").append(m.b(q.getString(str2))).append("\"");
                                i = 0;
                            }
                            stringBuilder.append("}");
                            break;
                        case 11:
                            Parcel C = SafeParcelReader.C(parcel, a);
                            C.setDataPosition(0);
                            a(stringBuilder, field.j(), C);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                i = 1;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new ParseException("Overread allowed size end=" + b, parcel);
        }
        stringBuilder.append('}');
    }

    public Object a(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Map<String, FastJsonResponse.Field<?, ?>> a() {
        return this.d == null ? null : this.d.a(this.e);
    }

    public boolean b(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int d() {
        return this.a;
    }

    public Parcel e() {
        switch (this.f) {
            case 0:
                this.g = a.a(this.b);
                break;
            case 1:
                break;
        }
        a.a(this.b, this.g);
        this.f = 2;
        return this.b;
    }

    public String toString() {
        ar.a(this.d, (Object) "Cannot convert to JSON on client side.");
        Parcel e = e();
        e.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        a(stringBuilder, this.d.a(this.e), e);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcelable parcelable;
        int a = a.a(parcel);
        a.a(parcel, 1, d());
        a.a(parcel, 2, e(), false);
        switch (this.c) {
            case 0:
                parcelable = null;
                break;
            case 1:
                parcelable = this.d;
                break;
            case 2:
                parcelable = this.d;
                break;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.c);
        }
        a.a(parcel, 3, parcelable, i, false);
        a.a(parcel, a);
    }
}

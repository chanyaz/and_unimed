package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.aq;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.c;
import com.google.android.gms.common.util.m;
import com.google.android.gms.common.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public interface FieldConverter<I, O> {
        O convert(I i);

        I convertBack(O o);

        int getTypeIn();

        int getTypeOut();
    }

    @Class(creator = "FieldCreator")
    @VisibleForTesting
    public class Field<I, O> extends AbstractSafeParcelable {
        public static final a CREATOR = new a();
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getTypeIn", id = 2)
        protected final int a;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "isTypeInArray", id = 3)
        protected final boolean b;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getTypeOut", id = 4)
        protected final int c;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "isTypeOutArray", id = 5)
        protected final boolean d;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getOutputFieldName", id = 6)
        protected final String e;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getSafeParcelableFieldId", id = 7)
        protected final int f;
        protected final Class<? extends FastJsonResponse> g;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getConcreteTypeName", id = 8)
        protected final String h;
        @VersionField(getter = "getVersionCode", id = 1)
        private final int i;
        private FieldMappingDictionary j;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getWrappedConverter", id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")
        private FieldConverter<I, O> k;

        @Constructor
        Field(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) boolean z, @Param(id = 4) int i3, @Param(id = 5) boolean z2, @Param(id = 6) String str, @Param(id = 7) int i4, @Param(id = 8) String str2, @Param(id = 9) ConverterWrapper converterWrapper) {
            this.i = i;
            this.a = i2;
            this.b = z;
            this.c = i3;
            this.d = z2;
            this.e = str;
            this.f = i4;
            if (str2 == null) {
                this.g = null;
                this.h = null;
            } else {
                this.g = SafeParcelResponse.class;
                this.h = str2;
            }
            if (converterWrapper == null) {
                this.k = null;
            } else {
                this.k = converterWrapper.a();
            }
        }

        private final String k() {
            return this.h == null ? null : this.h;
        }

        private final ConverterWrapper l() {
            return this.k == null ? null : ConverterWrapper.a(this.k);
        }

        public int a() {
            return this.i;
        }

        public I a(O o) {
            return this.k.convertBack(o);
        }

        public void a(FieldMappingDictionary fieldMappingDictionary) {
            this.j = fieldMappingDictionary;
        }

        public int b() {
            return this.a;
        }

        public boolean c() {
            return this.b;
        }

        public int d() {
            return this.c;
        }

        public boolean e() {
            return this.d;
        }

        public String f() {
            return this.e;
        }

        public int g() {
            return this.f;
        }

        public Class<? extends FastJsonResponse> h() {
            return this.g;
        }

        public boolean i() {
            return this.k != null;
        }

        public Map<String, Field<?, ?>> j() {
            ar.a(this.h);
            ar.a(this.j);
            return this.j.a(this.h);
        }

        public String toString() {
            aq a = ap.a((Object) this).a("versionCode", Integer.valueOf(this.i)).a("typeIn", Integer.valueOf(this.a)).a("typeInArray", Boolean.valueOf(this.b)).a("typeOut", Integer.valueOf(this.c)).a("typeOutArray", Boolean.valueOf(this.d)).a("outputFieldName", this.e).a("safeParcelFieldId", Integer.valueOf(this.f)).a("concreteTypeName", k());
            Class h = h();
            if (h != null) {
                a.a("concreteType.class", h.getCanonicalName());
            }
            if (this.k != null) {
                a.a("converterName", this.k.getClass().getCanonicalName());
            }
            return a.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int a = a.a(parcel);
            a.a(parcel, 1, a());
            a.a(parcel, 2, b());
            a.a(parcel, 3, c());
            a.a(parcel, 4, d());
            a.a(parcel, 5, e());
            a.a(parcel, 6, f(), false);
            a.a(parcel, 7, g());
            a.a(parcel, 8, k(), false);
            a.a(parcel, 9, l(), i, false);
            a.a(parcel, a);
        }
    }

    public interface FieldType {
    }

    private static void a(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.b() == 11) {
            stringBuilder.append(((FastJsonResponse) field.h().cast(obj)).toString());
        } else if (field.b() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(m.b((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    protected <O, I> I a(Field<I, O> field, Object obj) {
        return field.k != null ? field.a(obj) : obj;
    }

    protected abstract Object a(String str);

    public abstract Map<String, Field<?, ?>> a();

    protected boolean a(Field field) {
        return field.d() == 11 ? field.e() ? d(field.f()) : c(field.f()) : b(field.f());
    }

    protected Object b(Field field) {
        String f = field.f();
        if (field.h() == null) {
            return a(field.f());
        }
        ar.a(a(field.f()) == null, "Concrete field shouldn't be value object: %s", field.f());
        Map c = field.e() ? c() : b();
        if (c != null) {
            return c.get(f);
        }
        try {
            char toUpperCase = Character.toUpperCase(f.charAt(0));
            String substring = f.substring(1);
            return getClass().getMethod(new StringBuilder(String.valueOf(substring).length() + 4).append("get").append(toUpperCase).append(substring).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, Object> b() {
        return null;
    }

    protected abstract boolean b(String str);

    public HashMap<String, Object> c() {
        return null;
    }

    protected boolean c(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean d(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public String toString() {
        Map a = a();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : a.keySet()) {
            Field field = (Field) a.get(str);
            if (a(field)) {
                Object a2 = a(field, b(field));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a2 != null) {
                    switch (field.d()) {
                        case 8:
                            stringBuilder.append("\"").append(c.a((byte[]) a2)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(c.b((byte[]) a2)).append("\"");
                            break;
                        case 10:
                            n.a(stringBuilder, (HashMap) a2);
                            break;
                        default:
                            if (!field.c()) {
                                a(stringBuilder, field, a2);
                                break;
                            }
                            ArrayList arrayList = (ArrayList) a2;
                            stringBuilder.append("[");
                            int size = arrayList.size();
                            for (int i = 0; i < size; i++) {
                                if (i > 0) {
                                    stringBuilder.append(",");
                                }
                                Object obj = arrayList.get(i);
                                if (obj != null) {
                                    a(stringBuilder, field, obj);
                                }
                            }
                            stringBuilder.append("]");
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}

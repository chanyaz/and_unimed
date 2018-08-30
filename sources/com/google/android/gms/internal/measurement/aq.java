package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.t;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.k;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class aq extends af implements Closeable {
    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private static final String b = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    private final ar c;
    private final cf d = new cf(i());
    private final cf e = new cf(i());

    aq(ah ahVar) {
        super(ahVar);
        this.c = new ar(this, ahVar.a(), "google_analytics_v4.db");
    }

    private final long C() {
        t.d();
        y();
        return a("SELECT COUNT(*) FROM hits2", null);
    }

    private static String D() {
        return "google_analytics_v4.db";
    }

    private final long a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = A().rawQuery(str, null);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            d("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002c  */
    private final long a(java.lang.String r4, java.lang.String[] r5, long r6) {
        /*
        r3 = this;
        r0 = r3.A();
        r1 = 0;
        r2 = r0.rawQuery(r4, r5);	 Catch:{ SQLiteException -> 0x0022 }
        r0 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x0033, all -> 0x0030 }
        if (r0 == 0) goto L_0x001a;
    L_0x000f:
        r0 = 0;
        r0 = r2.getLong(r0);	 Catch:{ SQLiteException -> 0x0033, all -> 0x0030 }
        if (r2 == 0) goto L_0x0019;
    L_0x0016:
        r2.close();
    L_0x0019:
        return r0;
    L_0x001a:
        if (r2 == 0) goto L_0x001f;
    L_0x001c:
        r2.close();
    L_0x001f:
        r0 = 0;
        goto L_0x0019;
    L_0x0022:
        r0 = move-exception;
    L_0x0023:
        r2 = "Database error";
        r3.d(r2, r4, r0);	 Catch:{ all -> 0x0029 }
        throw r0;	 Catch:{ all -> 0x0029 }
    L_0x0029:
        r0 = move-exception;
    L_0x002a:
        if (r1 == 0) goto L_0x002f;
    L_0x002c:
        r1.close();
    L_0x002f:
        throw r0;
    L_0x0030:
        r0 = move-exception;
        r1 = r2;
        goto L_0x002a;
    L_0x0033:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.aq.a(java.lang.String, java.lang.String[], long):long");
    }

    @VisibleForTesting
    private final Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                String str2 = "?";
                String valueOf = String.valueOf(str);
                str = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            }
            return k.a(new URI(str), "UTF-8");
        } catch (URISyntaxException e) {
            e("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    private final java.util.List<java.lang.Long> d(long r14) {
        /*
        r13 = this;
        r10 = 0;
        com.google.android.gms.analytics.t.d();
        r13.y();
        r0 = 0;
        r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x0012;
    L_0x000d:
        r0 = java.util.Collections.emptyList();
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = r13.A();
        r9 = new java.util.ArrayList;
        r9.<init>();
        r1 = "hits2";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
        r3 = 0;
        r4 = "hit_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "%s ASC";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
        r11 = 0;
        r12 = "hit_id";
        r8[r11] = r12;	 Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
        r7 = java.lang.String.format(r7, r8);	 Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
        r8 = java.lang.Long.toString(r14);	 Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
        r0 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x0075 }
        if (r0 == 0) goto L_0x0057;
    L_0x0045:
        r0 = 0;
        r2 = r1.getLong(r0);	 Catch:{ SQLiteException -> 0x0075 }
        r0 = java.lang.Long.valueOf(r2);	 Catch:{ SQLiteException -> 0x0075 }
        r9.add(r0);	 Catch:{ SQLiteException -> 0x0075 }
        r0 = r1.moveToNext();	 Catch:{ SQLiteException -> 0x0075 }
        if (r0 != 0) goto L_0x0045;
    L_0x0057:
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();
    L_0x005c:
        r0 = r9;
        goto L_0x0011;
    L_0x005e:
        r0 = move-exception;
        r1 = r10;
    L_0x0060:
        r2 = "Error selecting hit ids";
        r13.d(r2, r0);	 Catch:{ all -> 0x0072 }
        if (r1 == 0) goto L_0x005c;
    L_0x0067:
        r1.close();
        goto L_0x005c;
    L_0x006b:
        r0 = move-exception;
    L_0x006c:
        if (r10 == 0) goto L_0x0071;
    L_0x006e:
        r10.close();
    L_0x0071:
        throw r0;
    L_0x0072:
        r0 = move-exception;
        r10 = r1;
        goto L_0x006c;
    L_0x0075:
        r0 = move-exception;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.aq.d(long):java.util.List<java.lang.Long>");
    }

    @VisibleForTesting
    private final Map<String, String> g(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String str2 = "?";
            String valueOf = String.valueOf(str);
            return k.a(new URI(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2)), "UTF-8");
        } catch (URISyntaxException e) {
            e("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    @VisibleForTesting
    final SQLiteDatabase A() {
        try {
            return this.c.getWritableDatabase();
        } catch (SQLiteException e) {
            d("Error opening database", e);
            throw e;
        }
    }

    public final long a(long j, String str, String str2) {
        ar.a(str);
        ar.a(str2);
        y();
        t.d();
        return a("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:3:0x0016} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:22:0x009e, code:
            r9.close();
     */
    /* JADX WARNING: Missing block: B:24:0x00a2, code:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:25:0x00a4, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:26:0x00a5, code:
            r1 = r9;
     */
    public final java.util.List<com.google.android.gms.internal.measurement.bp> a(long r14) {
        /*
        r13 = this;
        r0 = 1;
        r1 = 0;
        r9 = 0;
        r2 = 0;
        r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x008f;
    L_0x0009:
        com.google.android.gms.common.internal.ar.b(r0);
        com.google.android.gms.analytics.t.d();
        r13.y();
        r0 = r13.A();
        r1 = "hits2";
        r2 = 5;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 0;
        r4 = "hit_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 1;
        r4 = "hit_time";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 2;
        r4 = "hit_string";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 3;
        r4 = "hit_url";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 4;
        r4 = "hit_app_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "%s ASC";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r10 = 0;
        r11 = "hit_id";
        r8[r10] = r11;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r7 = java.lang.String.format(r7, r8);	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r8 = java.lang.Long.toString(r14);	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r10 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r10.<init>();	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r0 = r9.moveToFirst();	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        if (r0 == 0) goto L_0x0089;
    L_0x0059:
        r0 = 0;
        r6 = r9.getLong(r0);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r0 = 1;
        r3 = r9.getLong(r0);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r0 = 2;
        r0 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r1 = 3;
        r1 = r9.getString(r1);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r2 = 4;
        r8 = r9.getInt(r2);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r2 = r13.a(r0);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r5 = com.google.android.gms.internal.measurement.cj.c(r1);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r0 = new com.google.android.gms.internal.measurement.bp;	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r1 = r13;
        r0.<init>(r1, r2, r3, r5, r6, r8);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r10.add(r0);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r0 = r9.moveToNext();	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        if (r0 != 0) goto L_0x0059;
    L_0x0089:
        if (r9 == 0) goto L_0x008e;
    L_0x008b:
        r9.close();
    L_0x008e:
        return r10;
    L_0x008f:
        r0 = r1;
        goto L_0x0009;
    L_0x0092:
        r0 = move-exception;
        r1 = r9;
    L_0x0094:
        r2 = "Error loading hits from the database";
        r13.e(r2, r0);	 Catch:{ all -> 0x009a }
        throw r0;	 Catch:{ all -> 0x009a }
    L_0x009a:
        r0 = move-exception;
        r9 = r1;
    L_0x009c:
        if (r9 == 0) goto L_0x00a1;
    L_0x009e:
        r9.close();
    L_0x00a1:
        throw r0;
    L_0x00a2:
        r0 = move-exception;
        goto L_0x009c;
    L_0x00a4:
        r0 = move-exception;
        r1 = r9;
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.aq.a(long):java.util.List<com.google.android.gms.internal.measurement.bp>");
    }

    protected final void a() {
    }

    public final void a(bp bpVar) {
        String str;
        ar.a((Object) bpVar);
        t.d();
        y();
        ar.a((Object) bpVar);
        Builder builder = new Builder();
        for (Entry entry : bpVar.b().entrySet()) {
            str = (String) entry.getKey();
            if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str))) {
                builder.appendQueryParameter(str, (String) entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        str = encodedQuery == null ? "" : encodedQuery;
        if (str.length() > 8192) {
            h().a(bpVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = ((Integer) bk.c.a()).intValue();
        long C = C();
        if (C > ((long) (intValue - 1))) {
            List d = d((C - ((long) intValue)) + 1);
            d("Store full, deleting hits to make room, count", Integer.valueOf(d.size()));
            a(d);
        }
        SQLiteDatabase A = A();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", str);
        contentValues.put("hit_time", Long.valueOf(bpVar.d()));
        contentValues.put("hit_app_id", Integer.valueOf(bpVar.a()));
        contentValues.put("hit_url", bpVar.f() ? bd.h() : bd.i());
        try {
            long insert = A.insert("hits2", null, contentValues);
            if (insert == -1) {
                f("Failed to insert a hit (got -1)");
            } else {
                b("Hit saved to database. db-id, hit", Long.valueOf(insert), bpVar);
            }
        } catch (SQLiteException e) {
            e("Error storing a hit", e);
        }
    }

    public final void a(List<Long> list) {
        ar.a((Object) list);
        t.d();
        y();
        if (!list.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("hit_id");
            stringBuilder.append(" in (");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    Long l = (Long) list.get(i2);
                    if (l != null && l.longValue() != 0) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append(l);
                        i = i2 + 1;
                    }
                } else {
                    stringBuilder.append(")");
                    String stringBuilder2 = stringBuilder.toString();
                    try {
                        SQLiteDatabase A = A();
                        a("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                        i2 = A.delete("hits2", stringBuilder2, null);
                        if (i2 != list.size()) {
                            b("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(i2), stringBuilder2);
                            return;
                        }
                        return;
                    } catch (SQLiteException e) {
                        e("Error deleting hits", e);
                        throw e;
                    }
                }
            }
            throw new SQLiteException("Invalid hit id");
        }
    }

    public final void b() {
        y();
        A().beginTransaction();
    }

    public final void b(long j) {
        t.d();
        y();
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        a("Deleting hit, id", Long.valueOf(j));
        a(arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bb A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:1:0x000c} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:35:0x00bb, code:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:36:0x00bd, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:37:0x00be, code:
            r1 = r9;
     */
    public final java.util.List<com.google.android.gms.internal.measurement.ak> c(long r13) {
        /*
        r12 = this;
        r12.y();
        com.google.android.gms.analytics.t.d();
        r0 = r12.A();
        r9 = 0;
        r1 = 5;
        r2 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r1 = 0;
        r3 = "cid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r1 = 1;
        r3 = "tid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r1 = 2;
        r3 = "adid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r1 = 3;
        r3 = "hits_count";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r1 = 4;
        r3 = "params";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r1 = com.google.android.gms.internal.measurement.bk.d;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r1 = r1.a();	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r1 = (java.lang.Integer) r1;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r10 = r1.intValue();	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r8 = java.lang.String.valueOf(r10);	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r3 = "app_uid=?";
        r1 = 1;
        r4 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r1 = 0;
        r5 = "0";
        r4[r1] = r5;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r1 = "properties";
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        r11.<init>();	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        r0 = r9.moveToFirst();	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        if (r0 == 0) goto L_0x008d;
    L_0x0055:
        r0 = 0;
        r3 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        r0 = 1;
        r4 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        r0 = 2;
        r0 = r9.getInt(r0);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        if (r0 == 0) goto L_0x009e;
    L_0x0066:
        r5 = 1;
    L_0x0067:
        r0 = 3;
        r0 = r9.getInt(r0);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        r6 = (long) r0;	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        r0 = 4;
        r0 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        r8 = r12.g(r0);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        if (r0 != 0) goto L_0x0082;
    L_0x007c:
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        if (r0 == 0) goto L_0x00a0;
    L_0x0082:
        r0 = "Read property with empty client id or tracker id";
        r12.c(r0, r3, r4);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
    L_0x0087:
        r0 = r9.moveToNext();	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        if (r0 != 0) goto L_0x0055;
    L_0x008d:
        r0 = r11.size();	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        if (r0 < r10) goto L_0x0098;
    L_0x0093:
        r0 = "Sending hits to too many properties. Campaign report might be incorrect";
        r12.e(r0);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
    L_0x0098:
        if (r9 == 0) goto L_0x009d;
    L_0x009a:
        r9.close();
    L_0x009d:
        return r11;
    L_0x009e:
        r5 = 0;
        goto L_0x0067;
    L_0x00a0:
        r0 = new com.google.android.gms.internal.measurement.ak;	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        r1 = 0;
        r0.<init>(r1, r3, r4, r5, r6, r8);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        r11.add(r0);	 Catch:{ SQLiteException -> 0x00ab, all -> 0x00bb }
        goto L_0x0087;
    L_0x00ab:
        r0 = move-exception;
        r1 = r9;
    L_0x00ad:
        r2 = "Error loading hits from the database";
        r12.e(r2, r0);	 Catch:{ all -> 0x00b3 }
        throw r0;	 Catch:{ all -> 0x00b3 }
    L_0x00b3:
        r0 = move-exception;
        r9 = r1;
    L_0x00b5:
        if (r9 == 0) goto L_0x00ba;
    L_0x00b7:
        r9.close();
    L_0x00ba:
        throw r0;
    L_0x00bb:
        r0 = move-exception;
        goto L_0x00b5;
    L_0x00bd:
        r0 = move-exception;
        r1 = r9;
        goto L_0x00ad;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.aq.c(long):java.util.List<com.google.android.gms.internal.measurement.ak>");
    }

    public final void c() {
        y();
        A().setTransactionSuccessful();
    }

    public final void close() {
        try {
            this.c.close();
        } catch (SQLiteException e) {
            e("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            e("Error closing database", e2);
        }
    }

    public final void d() {
        y();
        A().endTransaction();
    }

    final boolean e() {
        return C() == 0;
    }

    public final int f() {
        t.d();
        y();
        if (!this.d.a(86400000)) {
            return 0;
        }
        this.d.a();
        b("Deleting stale hits (if any)");
        int delete = A().delete("hits2", "hit_time < ?", new String[]{Long.toString(i().currentTimeMillis() - 2592000000L)});
        a("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final long g() {
        t.d();
        y();
        return a(b, null, 0);
    }
}

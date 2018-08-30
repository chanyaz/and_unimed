package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.appnext.base.b.c;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class cv extends hv {
    private static final String[] b = new String[]{"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    private static final String[] c = new String[]{"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] d = new String[]{"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", c.jr, "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;"};
    private static final String[] e = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] f = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] g = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final cx h = new cx(this, getContext(), "google_app_measurement.db");
    private final hr i = new hr(zzbt());

    cv(hw hwVar) {
        super(hwVar);
    }

    private final boolean L() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    private final long a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = t().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzge().r().a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final Object a(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                zzge().r().a("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzge().r().a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzge().r().a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    @WorkerThread
    private static Set<String> a(SQLiteDatabase sQLiteDatabase, String str) {
        Set<String> hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    @WorkerThread
    private static void a(ContentValues contentValues, String str, Object obj) {
        ar.a(str);
        ar.a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    static void a(dp dpVar, SQLiteDatabase sQLiteDatabase) {
        if (dpVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            dpVar.u().a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            dpVar.u().a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            dpVar.u().a("Failed to turn on database read permission for owner");
        }
        if (!file.setWritable(true, true)) {
            dpVar.u().a("Failed to turn on database write permission for owner");
        }
    }

    @WorkerThread
    static void a(dp dpVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        int i = 0;
        if (dpVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!a(dpVar, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        if (dpVar == null) {
            try {
                throw new IllegalArgumentException("Monitor must not be null");
            } catch (SQLiteException e) {
                dpVar.r().a("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }
        Iterable a = a(sQLiteDatabase, str);
        String[] split = str3.split(",");
        int length = split.length;
        int i2 = 0;
        while (i2 < length) {
            String str4 = split[i2];
            if (a.remove(str4)) {
                i2++;
            } else {
                throw new SQLiteException(new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(str4).length()).append("Table ").append(str).append(" is missing required column: ").append(str4).toString());
            }
        }
        if (strArr != null) {
            while (i < strArr.length) {
                if (!a.remove(strArr[i])) {
                    sQLiteDatabase.execSQL(strArr[i + 1]);
                }
                i += 2;
            }
        }
        if (!a.isEmpty()) {
            dpVar.u().a("Table has extra columns. table, columns", str, TextUtils.join(", ", a));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
    @android.support.annotation.WorkerThread
    private static boolean a(com.google.android.gms.internal.measurement.dp r10, android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
        r8 = 0;
        r9 = 0;
        if (r10 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Monitor must not be null";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r1 = "SQLITE_MASTER";
        r0 = 1;
        r2 = new java.lang.String[r0];	 Catch:{ SQLiteException -> 0x0030, all -> 0x0042 }
        r0 = 0;
        r3 = "name";
        r2[r0] = r3;	 Catch:{ SQLiteException -> 0x0030, all -> 0x0042 }
        r3 = "name=?";
        r0 = 1;
        r4 = new java.lang.String[r0];	 Catch:{ SQLiteException -> 0x0030, all -> 0x0042 }
        r0 = 0;
        r4[r0] = r12;	 Catch:{ SQLiteException -> 0x0030, all -> 0x0042 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r11;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x0030, all -> 0x0042 }
        r0 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x004c }
        if (r1 == 0) goto L_0x002f;
    L_0x002c:
        r1.close();
    L_0x002f:
        return r0;
    L_0x0030:
        r0 = move-exception;
        r1 = r9;
    L_0x0032:
        r2 = r10.u();	 Catch:{ all -> 0x0049 }
        r3 = "Error querying for table";
        r2.a(r3, r12, r0);	 Catch:{ all -> 0x0049 }
        if (r1 == 0) goto L_0x0040;
    L_0x003d:
        r1.close();
    L_0x0040:
        r0 = r8;
        goto L_0x002f;
    L_0x0042:
        r0 = move-exception;
    L_0x0043:
        if (r9 == 0) goto L_0x0048;
    L_0x0045:
        r9.close();
    L_0x0048:
        throw r0;
    L_0x0049:
        r0 = move-exception;
        r9 = r1;
        goto L_0x0043;
    L_0x004c:
        r0 = move-exception;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.a(com.google.android.gms.internal.measurement.dp, android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    @WorkerThread
    private final boolean a(String str, int i, ii iiVar) {
        J();
        c();
        ar.a(str);
        ar.a((Object) iiVar);
        if (TextUtils.isEmpty(iiVar.d)) {
            zzge().u().a("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", dp.a(str), Integer.valueOf(i), String.valueOf(iiVar.c));
            return false;
        }
        try {
            byte[] bArr = new byte[iiVar.d()];
            i a = i.a(bArr, 0, bArr.length);
            iiVar.a(a);
            a.a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", iiVar.c);
            contentValues.put("event_name", iiVar.d);
            contentValues.put("data", bArr);
            try {
                if (t().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzge().r().a("Failed to insert event filter (got -1). appId", dp.a(str));
                }
                return true;
            } catch (SQLiteException e) {
                zzge().r().a("Error storing event filter. appId", dp.a(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().r().a("Configuration loss. Failed to serialize event filter. appId", dp.a(str), e2);
            return false;
        }
    }

    @WorkerThread
    private final boolean a(String str, int i, il ilVar) {
        J();
        c();
        ar.a(str);
        ar.a((Object) ilVar);
        if (TextUtils.isEmpty(ilVar.d)) {
            zzge().u().a("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", dp.a(str), Integer.valueOf(i), String.valueOf(ilVar.c));
            return false;
        }
        try {
            byte[] bArr = new byte[ilVar.d()];
            i a = i.a(bArr, 0, bArr.length);
            ilVar.a(a);
            a.a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", ilVar.c);
            contentValues.put("property_name", ilVar.d);
            contentValues.put("data", bArr);
            try {
                if (t().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzge().r().a("Failed to insert property filter (got -1). appId", dp.a(str));
                return false;
            } catch (SQLiteException e) {
                zzge().r().a("Error storing property filter. appId", dp.a(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().r().a("Configuration loss. Failed to serialize property filter. appId", dp.a(str), e2);
            return false;
        }
    }

    private final boolean a(String str, List<Integer> list) {
        ar.a(str);
        J();
        c();
        SQLiteDatabase t = t();
        try {
            if (b("select count(1) from audience_filter_values where app_id=?", new String[]{str}) <= ((long) Math.max(0, Math.min(2000, o().b(str, dg.G))))) {
                return false;
            }
            Iterable arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = (Integer) list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            join = new StringBuilder(String.valueOf(join).length() + 2).append("(").append(join).append(")").toString();
            return t.delete("audience_filter_values", new StringBuilder(String.valueOf(join).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(join).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(r5)}) > 0;
        } catch (SQLiteException e) {
            zzge().r().a("Database error querying filters. appId", dp.a(str), e);
            return false;
        }
    }

    @WorkerThread
    private final long b(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = t().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzge().r().a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean A() {
        return b("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long B() {
        long j = -1;
        Cursor cursor = null;
        try {
            cursor = t().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteException e) {
            zzge().r().a("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return j;
    }

    public final long a(iu iuVar) {
        c();
        J();
        ar.a((Object) iuVar);
        ar.a(iuVar.q);
        try {
            long j;
            Object obj = new byte[iuVar.d()];
            i a = i.a(obj, 0, obj.length);
            iuVar.a(a);
            a.a();
            fn l = l();
            ar.a(obj);
            l.c();
            MessageDigest f = ie.f("MD5");
            if (f == null) {
                l.zzge().r().a("Failed to get MD5");
                j = 0;
            } else {
                j = ie.c(f.digest(obj));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", iuVar.q);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", obj);
            try {
                t().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                zzge().r().a("Error storing raw event metadata. appId", dp.a(iuVar.q), e);
                throw e;
            }
        } catch (IOException e2) {
            zzge().r().a("Data loss. Failed to serialize event metadata. appId", dp.a(iuVar.q), e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f  */
    public final android.util.Pair<com.google.android.gms.internal.measurement.ir, java.lang.Long> a(java.lang.String r7, java.lang.Long r8) {
        /*
        r6 = this;
        r0 = 0;
        r6.c();
        r6.J();
        r1 = r6.t();	 Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
        r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
        r4 = 0;
        r3[r4] = r7;	 Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
        r4 = 1;
        r5 = java.lang.String.valueOf(r8);	 Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
        r2 = r1.rawQuery(r2, r3);	 Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
        r1 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x0095 }
        if (r1 != 0) goto L_0x0037;
    L_0x0024:
        r1 = r6.zzge();	 Catch:{ SQLiteException -> 0x0095 }
        r1 = r1.y();	 Catch:{ SQLiteException -> 0x0095 }
        r3 = "Main event not found";
        r1.a(r3);	 Catch:{ SQLiteException -> 0x0095 }
        if (r2 == 0) goto L_0x0036;
    L_0x0033:
        r2.close();
    L_0x0036:
        return r0;
    L_0x0037:
        r1 = 0;
        r1 = r2.getBlob(r1);	 Catch:{ SQLiteException -> 0x0095 }
        r3 = 1;
        r4 = r2.getLong(r3);	 Catch:{ SQLiteException -> 0x0095 }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x0095 }
        r4 = 0;
        r5 = r1.length;	 Catch:{ SQLiteException -> 0x0095 }
        r1 = com.google.android.gms.internal.measurement.h.a(r1, r4, r5);	 Catch:{ SQLiteException -> 0x0095 }
        r4 = new com.google.android.gms.internal.measurement.ir;	 Catch:{ SQLiteException -> 0x0095 }
        r4.<init>();	 Catch:{ SQLiteException -> 0x0095 }
        r4.a(r1);	 Catch:{ IOException -> 0x005d }
        r0 = android.util.Pair.create(r4, r3);	 Catch:{ SQLiteException -> 0x0095 }
        if (r2 == 0) goto L_0x0036;
    L_0x0059:
        r2.close();
        goto L_0x0036;
    L_0x005d:
        r1 = move-exception;
        r3 = r6.zzge();	 Catch:{ SQLiteException -> 0x0095 }
        r3 = r3.r();	 Catch:{ SQLiteException -> 0x0095 }
        r4 = "Failed to merge main event. appId, eventId";
        r5 = com.google.android.gms.internal.measurement.dp.a(r7);	 Catch:{ SQLiteException -> 0x0095 }
        r3.a(r4, r5, r8, r1);	 Catch:{ SQLiteException -> 0x0095 }
        if (r2 == 0) goto L_0x0036;
    L_0x0071:
        r2.close();
        goto L_0x0036;
    L_0x0075:
        r1 = move-exception;
        r2 = r0;
    L_0x0077:
        r3 = r6.zzge();	 Catch:{ all -> 0x0093 }
        r3 = r3.r();	 Catch:{ all -> 0x0093 }
        r4 = "Error selecting main event";
        r3.a(r4, r1);	 Catch:{ all -> 0x0093 }
        if (r2 == 0) goto L_0x0036;
    L_0x0086:
        r2.close();
        goto L_0x0036;
    L_0x008a:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x008d:
        if (r2 == 0) goto L_0x0092;
    L_0x008f:
        r2.close();
    L_0x0092:
        throw r0;
    L_0x0093:
        r0 = move-exception;
        goto L_0x008d;
    L_0x0095:
        r1 = move-exception;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.a(java.lang.String, java.lang.Long):android.util.Pair<com.google.android.gms.internal.measurement.ir, java.lang.Long>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0135  */
    @android.support.annotation.WorkerThread
    public final com.google.android.gms.internal.measurement.cw a(long r12, java.lang.String r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19) {
        /*
        r11 = this;
        com.google.android.gms.common.internal.ar.a(r14);
        r11.c();
        r11.J();
        r0 = 1;
        r10 = new java.lang.String[r0];
        r0 = 0;
        r10[r0] = r14;
        r8 = new com.google.android.gms.internal.measurement.cw;
        r8.<init>();
        r9 = 0;
        r0 = r11.t();	 Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
        r1 = "apps";
        r2 = 6;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
        r3 = 0;
        r4 = "day";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
        r3 = 1;
        r4 = "daily_events_count";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
        r3 = 2;
        r4 = "daily_public_events_count";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
        r3 = 3;
        r4 = "daily_conversions_count";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
        r3 = 4;
        r4 = "daily_error_events_count";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
        r3 = 5;
        r4 = "daily_realtime_events_count";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
        r3 = "app_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
        r5 = 0;
        r4[r5] = r14;	 Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
        r2 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x013b }
        if (r2 != 0) goto L_0x0069;
    L_0x0051:
        r0 = r11.zzge();	 Catch:{ SQLiteException -> 0x013b }
        r0 = r0.u();	 Catch:{ SQLiteException -> 0x013b }
        r2 = "Not updating daily counts, app is not known. appId";
        r3 = com.google.android.gms.internal.measurement.dp.a(r14);	 Catch:{ SQLiteException -> 0x013b }
        r0.a(r2, r3);	 Catch:{ SQLiteException -> 0x013b }
        if (r1 == 0) goto L_0x0067;
    L_0x0064:
        r1.close();
    L_0x0067:
        r0 = r8;
    L_0x0068:
        return r0;
    L_0x0069:
        r2 = 0;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x013b }
        r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r2 != 0) goto L_0x0095;
    L_0x0072:
        r2 = 1;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x013b }
        r8.b = r2;	 Catch:{ SQLiteException -> 0x013b }
        r2 = 2;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x013b }
        r8.a = r2;	 Catch:{ SQLiteException -> 0x013b }
        r2 = 3;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x013b }
        r8.c = r2;	 Catch:{ SQLiteException -> 0x013b }
        r2 = 4;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x013b }
        r8.d = r2;	 Catch:{ SQLiteException -> 0x013b }
        r2 = 5;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x013b }
        r8.e = r2;	 Catch:{ SQLiteException -> 0x013b }
    L_0x0095:
        if (r15 == 0) goto L_0x009e;
    L_0x0097:
        r2 = r8.b;	 Catch:{ SQLiteException -> 0x013b }
        r4 = 1;
        r2 = r2 + r4;
        r8.b = r2;	 Catch:{ SQLiteException -> 0x013b }
    L_0x009e:
        if (r16 == 0) goto L_0x00a7;
    L_0x00a0:
        r2 = r8.a;	 Catch:{ SQLiteException -> 0x013b }
        r4 = 1;
        r2 = r2 + r4;
        r8.a = r2;	 Catch:{ SQLiteException -> 0x013b }
    L_0x00a7:
        if (r17 == 0) goto L_0x00b0;
    L_0x00a9:
        r2 = r8.c;	 Catch:{ SQLiteException -> 0x013b }
        r4 = 1;
        r2 = r2 + r4;
        r8.c = r2;	 Catch:{ SQLiteException -> 0x013b }
    L_0x00b0:
        if (r18 == 0) goto L_0x00b9;
    L_0x00b2:
        r2 = r8.d;	 Catch:{ SQLiteException -> 0x013b }
        r4 = 1;
        r2 = r2 + r4;
        r8.d = r2;	 Catch:{ SQLiteException -> 0x013b }
    L_0x00b9:
        if (r19 == 0) goto L_0x00c2;
    L_0x00bb:
        r2 = r8.e;	 Catch:{ SQLiteException -> 0x013b }
        r4 = 1;
        r2 = r2 + r4;
        r8.e = r2;	 Catch:{ SQLiteException -> 0x013b }
    L_0x00c2:
        r2 = new android.content.ContentValues;	 Catch:{ SQLiteException -> 0x013b }
        r2.<init>();	 Catch:{ SQLiteException -> 0x013b }
        r3 = "day";
        r4 = java.lang.Long.valueOf(r12);	 Catch:{ SQLiteException -> 0x013b }
        r2.put(r3, r4);	 Catch:{ SQLiteException -> 0x013b }
        r3 = "daily_public_events_count";
        r4 = r8.a;	 Catch:{ SQLiteException -> 0x013b }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x013b }
        r2.put(r3, r4);	 Catch:{ SQLiteException -> 0x013b }
        r3 = "daily_events_count";
        r4 = r8.b;	 Catch:{ SQLiteException -> 0x013b }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x013b }
        r2.put(r3, r4);	 Catch:{ SQLiteException -> 0x013b }
        r3 = "daily_conversions_count";
        r4 = r8.c;	 Catch:{ SQLiteException -> 0x013b }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x013b }
        r2.put(r3, r4);	 Catch:{ SQLiteException -> 0x013b }
        r3 = "daily_error_events_count";
        r4 = r8.d;	 Catch:{ SQLiteException -> 0x013b }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x013b }
        r2.put(r3, r4);	 Catch:{ SQLiteException -> 0x013b }
        r3 = "daily_realtime_events_count";
        r4 = r8.e;	 Catch:{ SQLiteException -> 0x013b }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x013b }
        r2.put(r3, r4);	 Catch:{ SQLiteException -> 0x013b }
        r3 = "apps";
        r4 = "app_id=?";
        r0.update(r3, r2, r4, r10);	 Catch:{ SQLiteException -> 0x013b }
        if (r1 == 0) goto L_0x0113;
    L_0x0110:
        r1.close();
    L_0x0113:
        r0 = r8;
        goto L_0x0068;
    L_0x0116:
        r0 = move-exception;
        r1 = r9;
    L_0x0118:
        r2 = r11.zzge();	 Catch:{ all -> 0x0139 }
        r2 = r2.r();	 Catch:{ all -> 0x0139 }
        r3 = "Error updating daily counts. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r14);	 Catch:{ all -> 0x0139 }
        r2.a(r3, r4, r0);	 Catch:{ all -> 0x0139 }
        if (r1 == 0) goto L_0x012e;
    L_0x012b:
        r1.close();
    L_0x012e:
        r0 = r8;
        goto L_0x0068;
    L_0x0131:
        r0 = move-exception;
        r1 = r9;
    L_0x0133:
        if (r1 == 0) goto L_0x0138;
    L_0x0135:
        r1.close();
    L_0x0138:
        throw r0;
    L_0x0139:
        r0 = move-exception;
        goto L_0x0133;
    L_0x013b:
        r0 = move-exception;
        goto L_0x0118;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.a(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.measurement.cw");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x011b  */
    @android.support.annotation.WorkerThread
    public final com.google.android.gms.internal.measurement.dc a(java.lang.String r19, java.lang.String r20) {
        /*
        r18 = this;
        com.google.android.gms.common.internal.ar.a(r19);
        com.google.android.gms.common.internal.ar.a(r20);
        r18.c();
        r18.J();
        r10 = 0;
        r2 = r18.t();	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r3 = "events";
        r4 = 7;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r5 = 0;
        r6 = "lifetime_count";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r5 = 1;
        r6 = "current_bundle_count";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r5 = 2;
        r6 = "last_fire_timestamp";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r5 = 3;
        r6 = "last_bundled_timestamp";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r5 = 4;
        r6 = "last_sampled_complex_event_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r5 = 5;
        r6 = "last_sampling_rate";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r5 = 6;
        r6 = "last_exempt_from_sampling";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r5 = "app_id=? and name=?";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r7 = 0;
        r6[r7] = r19;	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r7 = 1;
        r6[r7] = r20;	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r17 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
        r2 = r17.moveToFirst();	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        if (r2 != 0) goto L_0x0058;
    L_0x0051:
        if (r17 == 0) goto L_0x0056;
    L_0x0053:
        r17.close();
    L_0x0056:
        r3 = 0;
    L_0x0057:
        return r3;
    L_0x0058:
        r2 = 0;
        r0 = r17;
        r6 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        r2 = 1;
        r0 = r17;
        r8 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        r2 = 2;
        r0 = r17;
        r10 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        r2 = 3;
        r0 = r17;
        r2 = r0.isNull(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        if (r2 == 0) goto L_0x00cf;
    L_0x0076:
        r12 = 0;
    L_0x0078:
        r2 = 4;
        r0 = r17;
        r2 = r0.isNull(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        if (r2 == 0) goto L_0x00d7;
    L_0x0081:
        r14 = 0;
    L_0x0082:
        r2 = 5;
        r0 = r17;
        r2 = r0.isNull(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        if (r2 == 0) goto L_0x00e3;
    L_0x008b:
        r15 = 0;
    L_0x008c:
        r16 = 0;
        r2 = 6;
        r0 = r17;
        r2 = r0.isNull(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        if (r2 != 0) goto L_0x00a9;
    L_0x0097:
        r2 = 6;
        r0 = r17;
        r2 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        r4 = 1;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x00ef;
    L_0x00a4:
        r2 = 1;
    L_0x00a5:
        r16 = java.lang.Boolean.valueOf(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
    L_0x00a9:
        r3 = new com.google.android.gms.internal.measurement.dc;	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        r4 = r19;
        r5 = r20;
        r3.<init>(r4, r5, r6, r8, r10, r12, r14, r15, r16);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        r2 = r17.moveToNext();	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        if (r2 == 0) goto L_0x00c9;
    L_0x00b8:
        r2 = r18.zzge();	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        r2 = r2.r();	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        r4 = "Got multiple records for event aggregates, expected one. appId";
        r5 = com.google.android.gms.internal.measurement.dp.a(r19);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        r2.a(r4, r5);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
    L_0x00c9:
        if (r17 == 0) goto L_0x0057;
    L_0x00cb:
        r17.close();
        goto L_0x0057;
    L_0x00cf:
        r2 = 3;
        r0 = r17;
        r12 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        goto L_0x0078;
    L_0x00d7:
        r2 = 4;
        r0 = r17;
        r2 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        r14 = java.lang.Long.valueOf(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        goto L_0x0082;
    L_0x00e3:
        r2 = 5;
        r0 = r17;
        r2 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        r15 = java.lang.Long.valueOf(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        goto L_0x008c;
    L_0x00ef:
        r2 = 0;
        goto L_0x00a5;
    L_0x00f1:
        r2 = move-exception;
        r3 = r10;
    L_0x00f3:
        r4 = r18.zzge();	 Catch:{ all -> 0x0121 }
        r4 = r4.r();	 Catch:{ all -> 0x0121 }
        r5 = "Error querying events. appId";
        r6 = com.google.android.gms.internal.measurement.dp.a(r19);	 Catch:{ all -> 0x0121 }
        r7 = r18.k();	 Catch:{ all -> 0x0121 }
        r0 = r20;
        r7 = r7.a(r0);	 Catch:{ all -> 0x0121 }
        r4.a(r5, r6, r7, r2);	 Catch:{ all -> 0x0121 }
        if (r3 == 0) goto L_0x0113;
    L_0x0110:
        r3.close();
    L_0x0113:
        r3 = 0;
        goto L_0x0057;
    L_0x0116:
        r2 = move-exception;
        r17 = r10;
    L_0x0119:
        if (r17 == 0) goto L_0x011e;
    L_0x011b:
        r17.close();
    L_0x011e:
        throw r2;
    L_0x011f:
        r2 = move-exception;
        goto L_0x0119;
    L_0x0121:
        r2 = move-exception;
        r17 = r3;
        goto L_0x0119;
    L_0x0125:
        r2 = move-exception;
        r3 = r17;
        goto L_0x00f3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.a(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.dc");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    public final java.lang.String a(long r8) {
        /*
        r7 = this;
        r0 = 0;
        r7.c();
        r7.J();
        r1 = r7.t();	 Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
        r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
        r4 = 0;
        r5 = java.lang.String.valueOf(r8);	 Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
        r2 = r1.rawQuery(r2, r3);	 Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
        r1 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x005f }
        if (r1 != 0) goto L_0x0034;
    L_0x0021:
        r1 = r7.zzge();	 Catch:{ SQLiteException -> 0x005f }
        r1 = r1.y();	 Catch:{ SQLiteException -> 0x005f }
        r3 = "No expired configs for apps with pending events";
        r1.a(r3);	 Catch:{ SQLiteException -> 0x005f }
        if (r2 == 0) goto L_0x0033;
    L_0x0030:
        r2.close();
    L_0x0033:
        return r0;
    L_0x0034:
        r1 = 0;
        r0 = r2.getString(r1);	 Catch:{ SQLiteException -> 0x005f }
        if (r2 == 0) goto L_0x0033;
    L_0x003b:
        r2.close();
        goto L_0x0033;
    L_0x003f:
        r1 = move-exception;
        r2 = r0;
    L_0x0041:
        r3 = r7.zzge();	 Catch:{ all -> 0x005d }
        r3 = r3.r();	 Catch:{ all -> 0x005d }
        r4 = "Error selecting expired configs";
        r3.a(r4, r1);	 Catch:{ all -> 0x005d }
        if (r2 == 0) goto L_0x0033;
    L_0x0050:
        r2.close();
        goto L_0x0033;
    L_0x0054:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0057:
        if (r2 == 0) goto L_0x005c;
    L_0x0059:
        r2.close();
    L_0x005c:
        throw r0;
    L_0x005d:
        r0 = move-exception;
        goto L_0x0057;
    L_0x005f:
        r1 = move-exception;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.a(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00aa  */
    @android.support.annotation.WorkerThread
    public final java.util.List<com.google.android.gms.internal.measurement.id> a(java.lang.String r12) {
        /*
        r11 = this;
        r10 = 0;
        com.google.android.gms.common.internal.ar.a(r12);
        r11.c();
        r11.J();
        r9 = new java.util.ArrayList;
        r9.<init>();
        r0 = r11.t();	 Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
        r1 = "user_attributes";
        r2 = 4;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
        r3 = 0;
        r4 = "name";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
        r3 = 1;
        r4 = "origin";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
        r3 = 2;
        r4 = "set_timestamp";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
        r3 = 3;
        r4 = "value";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
        r3 = "app_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
        r5 = 0;
        r4[r5] = r12;	 Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
        r5 = 0;
        r6 = 0;
        r7 = "rowid";
        r8 = "1000";
        r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
        r0 = r7.moveToFirst();	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        if (r0 != 0) goto L_0x004b;
    L_0x0044:
        if (r7 == 0) goto L_0x0049;
    L_0x0046:
        r7.close();
    L_0x0049:
        r0 = r9;
    L_0x004a:
        return r0;
    L_0x004b:
        r0 = 0;
        r3 = r7.getString(r0);	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        r0 = 1;
        r2 = r7.getString(r0);	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        if (r2 != 0) goto L_0x0059;
    L_0x0057:
        r2 = "";
    L_0x0059:
        r0 = 2;
        r4 = r7.getLong(r0);	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        r0 = 3;
        r6 = r11.a(r7, r0);	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        if (r6 != 0) goto L_0x0083;
    L_0x0065:
        r0 = r11.zzge();	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        r0 = r0.r();	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        r1 = "Read invalid user property value, ignoring it. appId";
        r2 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        r0.a(r1, r2);	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
    L_0x0076:
        r0 = r7.moveToNext();	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        if (r0 != 0) goto L_0x004b;
    L_0x007c:
        if (r7 == 0) goto L_0x0081;
    L_0x007e:
        r7.close();
    L_0x0081:
        r0 = r9;
        goto L_0x004a;
    L_0x0083:
        r0 = new com.google.android.gms.internal.measurement.id;	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        r1 = r12;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        r9.add(r0);	 Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        goto L_0x0076;
    L_0x008d:
        r0 = move-exception;
        r1 = r7;
    L_0x008f:
        r2 = r11.zzge();	 Catch:{ all -> 0x00b1 }
        r2 = r2.r();	 Catch:{ all -> 0x00b1 }
        r3 = "Error querying user properties. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ all -> 0x00b1 }
        r2.a(r3, r4, r0);	 Catch:{ all -> 0x00b1 }
        if (r1 == 0) goto L_0x00a5;
    L_0x00a2:
        r1.close();
    L_0x00a5:
        r0 = r10;
        goto L_0x004a;
    L_0x00a7:
        r0 = move-exception;
    L_0x00a8:
        if (r10 == 0) goto L_0x00ad;
    L_0x00aa:
        r10.close();
    L_0x00ad:
        throw r0;
    L_0x00ae:
        r0 = move-exception;
        r10 = r7;
        goto L_0x00a8;
    L_0x00b1:
        r0 = move-exception;
        r10 = r1;
        goto L_0x00a8;
    L_0x00b4:
        r0 = move-exception;
        r1 = r10;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.a(java.lang.String):java.util.List<com.google.android.gms.internal.measurement.id>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fe  */
    @android.support.annotation.WorkerThread
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.iu, java.lang.Long>> a(java.lang.String r12, int r13, int r14) {
        /*
        r11 = this;
        r10 = 0;
        r1 = 1;
        r9 = 0;
        r11.c();
        r11.J();
        if (r13 <= 0) goto L_0x0053;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        com.google.android.gms.common.internal.ar.b(r0);
        if (r14 <= 0) goto L_0x0055;
    L_0x0011:
        com.google.android.gms.common.internal.ar.b(r1);
        com.google.android.gms.common.internal.ar.a(r12);
        r0 = r11.t();	 Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
        r1 = "queue";
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
        r3 = 0;
        r4 = "rowid";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
        r3 = 1;
        r4 = "data";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
        r3 = 2;
        r4 = "retry_count";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
        r3 = "app_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
        r5 = 0;
        r4[r5] = r12;	 Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
        r5 = 0;
        r6 = 0;
        r7 = "rowid";
        r8 = java.lang.String.valueOf(r13);	 Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
        r0 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        if (r0 != 0) goto L_0x0057;
    L_0x0049:
        r0 = java.util.Collections.emptyList();	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        if (r2 == 0) goto L_0x0052;
    L_0x004f:
        r2.close();
    L_0x0052:
        return r0;
    L_0x0053:
        r0 = r9;
        goto L_0x000c;
    L_0x0055:
        r1 = r9;
        goto L_0x0011;
    L_0x0057:
        r0 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r0.<init>();	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r3 = r9;
    L_0x005d:
        r1 = 0;
        r4 = r2.getLong(r1);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r1 = 1;
        r1 = r2.getBlob(r1);	 Catch:{ IOException -> 0x00b4 }
        r6 = r11.l();	 Catch:{ IOException -> 0x00b4 }
        r1 = r6.b(r1);	 Catch:{ IOException -> 0x00b4 }
        r6 = r0.isEmpty();	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        if (r6 != 0) goto L_0x0079;
    L_0x0075:
        r6 = r1.length;	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r6 = r6 + r3;
        if (r6 > r14) goto L_0x00ae;
    L_0x0079:
        r6 = 0;
        r7 = r1.length;	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r6 = com.google.android.gms.internal.measurement.h.a(r1, r6, r7);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r7 = new com.google.android.gms.internal.measurement.iu;	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r7.<init>();	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r7.a(r6);	 Catch:{ IOException -> 0x00c8 }
        r6 = 2;
        r6 = r2.isNull(r6);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        if (r6 != 0) goto L_0x0099;
    L_0x008e:
        r6 = 2;
        r6 = r2.getInt(r6);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r7.J = r6;	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
    L_0x0099:
        r1 = r1.length;	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r1 = r1 + r3;
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r3 = android.util.Pair.create(r7, r3);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r0.add(r3);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
    L_0x00a6:
        r3 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        if (r3 == 0) goto L_0x00ae;
    L_0x00ac:
        if (r1 <= r14) goto L_0x010a;
    L_0x00ae:
        if (r2 == 0) goto L_0x0052;
    L_0x00b0:
        r2.close();
        goto L_0x0052;
    L_0x00b4:
        r1 = move-exception;
        r4 = r11.zzge();	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r4 = r4.r();	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r5 = "Failed to unzip queued bundle. appId";
        r6 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r4.a(r5, r6, r1);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r1 = r3;
        goto L_0x00a6;
    L_0x00c8:
        r1 = move-exception;
        r4 = r11.zzge();	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r4 = r4.r();	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r5 = "Failed to merge queued bundle. appId";
        r6 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r4.a(r5, r6, r1);	 Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        r1 = r3;
        goto L_0x00a6;
    L_0x00dc:
        r0 = move-exception;
        r1 = r10;
    L_0x00de:
        r2 = r11.zzge();	 Catch:{ all -> 0x0104 }
        r2 = r2.r();	 Catch:{ all -> 0x0104 }
        r3 = "Error querying bundles. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ all -> 0x0104 }
        r2.a(r3, r4, r0);	 Catch:{ all -> 0x0104 }
        r0 = java.util.Collections.emptyList();	 Catch:{ all -> 0x0104 }
        if (r1 == 0) goto L_0x0052;
    L_0x00f5:
        r1.close();
        goto L_0x0052;
    L_0x00fa:
        r0 = move-exception;
        r2 = r10;
    L_0x00fc:
        if (r2 == 0) goto L_0x0101;
    L_0x00fe:
        r2.close();
    L_0x0101:
        throw r0;
    L_0x0102:
        r0 = move-exception;
        goto L_0x00fc;
    L_0x0104:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00fc;
    L_0x0107:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00de;
    L_0x010a:
        r3 = r1;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.a(java.lang.String, int, int):java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.iu, java.lang.Long>>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0106 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:9:0x007c} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0102  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:43:0x0106, code:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:44:0x0107, code:
            r10 = r7;
     */
    /* JADX WARNING: Missing block: B:49:0x010f, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:50:0x0110, code:
            r1 = r7;
     */
    @android.support.annotation.WorkerThread
    public final java.util.List<com.google.android.gms.internal.measurement.id> a(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
        r11 = this;
        r10 = 0;
        com.google.android.gms.common.internal.ar.a(r12);
        r11.c();
        r11.J();
        r9 = new java.util.ArrayList;
        r9.<init>();
        r0 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r1 = 3;
        r0.<init>(r1);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r0.add(r12);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r1 = "app_id=?";
        r3.<init>(r1);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r1 = android.text.TextUtils.isEmpty(r13);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        if (r1 != 0) goto L_0x002d;
    L_0x0025:
        r0.add(r13);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r1 = " and origin=?";
        r3.append(r1);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
    L_0x002d:
        r1 = android.text.TextUtils.isEmpty(r14);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        if (r1 != 0) goto L_0x0045;
    L_0x0033:
        r1 = java.lang.String.valueOf(r14);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r2 = "*";
        r1 = r1.concat(r2);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r0.add(r1);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r1 = " and name glob ?";
        r3.append(r1);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
    L_0x0045:
        r1 = r0.size();	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r1 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r4 = r0.toArray(r1);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r4 = (java.lang.String[]) r4;	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r0 = r11.t();	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r1 = "user_attributes";
        r2 = 4;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r5 = 0;
        r6 = "name";
        r2[r5] = r6;	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r5 = 1;
        r6 = "set_timestamp";
        r2[r5] = r6;	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r5 = 2;
        r6 = "value";
        r2[r5] = r6;	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r5 = 3;
        r6 = "origin";
        r2[r5] = r6;	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r3 = r3.toString();	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r5 = 0;
        r6 = 0;
        r7 = "rowid";
        r8 = "1001";
        r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        r0 = r7.moveToFirst();	 Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
        if (r0 != 0) goto L_0x008a;
    L_0x0082:
        if (r7 == 0) goto L_0x0087;
    L_0x0084:
        r7.close();
    L_0x0087:
        r0 = r9;
    L_0x0088:
        return r0;
    L_0x0089:
        r13 = r2;
    L_0x008a:
        r0 = r9.size();	 Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r0 < r1) goto L_0x00ac;
    L_0x0092:
        r0 = r11.zzge();	 Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
        r0 = r0.r();	 Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
        r1 = "Read more than the max allowed user properties, ignoring excess";
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
        r0.a(r1, r2);	 Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
    L_0x00a5:
        if (r7 == 0) goto L_0x00aa;
    L_0x00a7:
        r7.close();
    L_0x00aa:
        r0 = r9;
        goto L_0x0088;
    L_0x00ac:
        r0 = 0;
        r3 = r7.getString(r0);	 Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
        r0 = 1;
        r4 = r7.getLong(r0);	 Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
        r0 = 2;
        r6 = r11.a(r7, r0);	 Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
        r0 = 3;
        r2 = r7.getString(r0);	 Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
        if (r6 != 0) goto L_0x00da;
    L_0x00c2:
        r0 = r11.zzge();	 Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
        r0 = r0.r();	 Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
        r1 = "(2)Read invalid user property value, ignoring it";
        r3 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
        r0.a(r1, r3, r2, r14);	 Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
    L_0x00d3:
        r0 = r7.moveToNext();	 Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
        if (r0 != 0) goto L_0x0089;
    L_0x00d9:
        goto L_0x00a5;
    L_0x00da:
        r0 = new com.google.android.gms.internal.measurement.id;	 Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
        r1 = r12;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
        r9.add(r0);	 Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
        goto L_0x00d3;
    L_0x00e4:
        r0 = move-exception;
        r1 = r7;
        r13 = r2;
    L_0x00e7:
        r2 = r11.zzge();	 Catch:{ all -> 0x0109 }
        r2 = r2.r();	 Catch:{ all -> 0x0109 }
        r3 = "(2)Error querying user properties";
        r4 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ all -> 0x0109 }
        r2.a(r3, r4, r13, r0);	 Catch:{ all -> 0x0109 }
        if (r1 == 0) goto L_0x00fd;
    L_0x00fa:
        r1.close();
    L_0x00fd:
        r0 = r10;
        goto L_0x0088;
    L_0x00ff:
        r0 = move-exception;
    L_0x0100:
        if (r10 == 0) goto L_0x0105;
    L_0x0102:
        r10.close();
    L_0x0105:
        throw r0;
    L_0x0106:
        r0 = move-exception;
        r10 = r7;
        goto L_0x0100;
    L_0x0109:
        r0 = move-exception;
        r10 = r1;
        goto L_0x0100;
    L_0x010c:
        r0 = move-exception;
        r1 = r10;
        goto L_0x00e7;
    L_0x010f:
        r0 = move-exception;
        r1 = r7;
        goto L_0x00e7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.a(java.lang.String, java.lang.String, java.lang.String):java.util.List<com.google.android.gms.internal.measurement.id>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0165  */
    public final java.util.List<com.google.android.gms.internal.measurement.zzed> a(java.lang.String r24, java.lang.String[] r25) {
        /*
        r23 = this;
        r23.c();
        r23.J();
        r20 = new java.util.ArrayList;
        r20.<init>();
        r11 = 0;
        r2 = r23.t();	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r3 = "conditional_properties";
        r4 = 13;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 0;
        r6 = "app_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 1;
        r6 = "origin";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 2;
        r6 = "name";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 3;
        r6 = "value";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 4;
        r6 = "active";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 5;
        r6 = "trigger_event_name";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 6;
        r6 = "trigger_timeout";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 7;
        r6 = "timed_out_event";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 8;
        r6 = "creation_timestamp";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 9;
        r6 = "triggered_event";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 10;
        r6 = "triggered_timestamp";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 11;
        r6 = "time_to_live";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r5 = 12;
        r6 = "expired_event";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r7 = 0;
        r8 = 0;
        r9 = "rowid";
        r10 = "1001";
        r5 = r24;
        r6 = r25;
        r21 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
        r2 = r21.moveToFirst();	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        if (r2 != 0) goto L_0x0078;
    L_0x0070:
        if (r21 == 0) goto L_0x0075;
    L_0x0072:
        r21.close();
    L_0x0075:
        r2 = r20;
    L_0x0077:
        return r2;
    L_0x0078:
        r2 = r20.size();	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r2 < r3) goto L_0x009b;
    L_0x0080:
        r2 = r23.zzge();	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = r2.r();	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r3 = "Read more than the max allowed conditional properties, ignoring extra";
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2.a(r3, r4);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
    L_0x0093:
        if (r21 == 0) goto L_0x0098;
    L_0x0095:
        r21.close();
    L_0x0098:
        r2 = r20;
        goto L_0x0077;
    L_0x009b:
        r2 = 0;
        r0 = r21;
        r8 = r0.getString(r2);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = 1;
        r0 = r21;
        r7 = r0.getString(r2);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = 2;
        r0 = r21;
        r3 = r0.getString(r2);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = 3;
        r0 = r23;
        r1 = r21;
        r6 = r0.a(r1, r2);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = 4;
        r0 = r21;
        r2 = r0.getInt(r2);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        if (r2 == 0) goto L_0x0143;
    L_0x00c2:
        r11 = 1;
    L_0x00c3:
        r2 = 5;
        r0 = r21;
        r12 = r0.getString(r2);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = 6;
        r0 = r21;
        r14 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = r23.l();	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r4 = 7;
        r0 = r21;
        r4 = r0.getBlob(r4);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r5 = com.google.android.gms.internal.measurement.zzeu.CREATOR;	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r13 = r2.a(r4, r5);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r13 = (com.google.android.gms.internal.measurement.zzeu) r13;	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = 8;
        r0 = r21;
        r9 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = r23.l();	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r4 = 9;
        r0 = r21;
        r4 = r0.getBlob(r4);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r5 = com.google.android.gms.internal.measurement.zzeu.CREATOR;	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r16 = r2.a(r4, r5);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r16 = (com.google.android.gms.internal.measurement.zzeu) r16;	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = 10;
        r0 = r21;
        r4 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = 11;
        r0 = r21;
        r17 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = r23.l();	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r19 = 12;
        r0 = r21;
        r1 = r19;
        r19 = r0.getBlob(r1);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r22 = com.google.android.gms.internal.measurement.zzeu.CREATOR;	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r0 = r19;
        r1 = r22;
        r19 = r2.a(r0, r1);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r19 = (com.google.android.gms.internal.measurement.zzeu) r19;	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = new com.google.android.gms.internal.measurement.zzjx;	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2.<init>(r3, r4, r6, r7);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r5 = new com.google.android.gms.internal.measurement.zzed;	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r6 = r8;
        r8 = r2;
        r5.<init>(r6, r7, r8, r9, r11, r12, r13, r14, r16, r17, r19);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r0 = r20;
        r0.add(r5);	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = r21.moveToNext();	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        if (r2 != 0) goto L_0x0078;
    L_0x0141:
        goto L_0x0093;
    L_0x0143:
        r11 = 0;
        goto L_0x00c3;
    L_0x0146:
        r2 = move-exception;
        r3 = r11;
    L_0x0148:
        r4 = r23.zzge();	 Catch:{ all -> 0x016b }
        r4 = r4.r();	 Catch:{ all -> 0x016b }
        r5 = "Error querying conditional user property value";
        r4.a(r5, r2);	 Catch:{ all -> 0x016b }
        r2 = java.util.Collections.emptyList();	 Catch:{ all -> 0x016b }
        if (r3 == 0) goto L_0x0077;
    L_0x015b:
        r3.close();
        goto L_0x0077;
    L_0x0160:
        r2 = move-exception;
        r21 = r11;
    L_0x0163:
        if (r21 == 0) goto L_0x0168;
    L_0x0165:
        r21.close();
    L_0x0168:
        throw r2;
    L_0x0169:
        r2 = move-exception;
        goto L_0x0163;
    L_0x016b:
        r2 = move-exception;
        r21 = r3;
        goto L_0x0163;
    L_0x016f:
        r2 = move-exception;
        r3 = r21;
        goto L_0x0148;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.a(java.lang.String, java.lang.String[]):java.util.List<com.google.android.gms.internal.measurement.zzed>");
    }

    @WorkerThread
    public final void a(cp cpVar) {
        ar.a((Object) cpVar);
        c();
        J();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", cpVar.b());
        contentValues.put("app_instance_id", cpVar.c());
        contentValues.put("gmp_app_id", cpVar.d());
        contentValues.put("resettable_device_id_hash", cpVar.e());
        contentValues.put("last_bundle_index", Long.valueOf(cpVar.o()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(cpVar.g()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(cpVar.h()));
        contentValues.put("app_version", cpVar.i());
        contentValues.put("app_store", cpVar.k());
        contentValues.put("gmp_version", Long.valueOf(cpVar.l()));
        contentValues.put("dev_cert_hash", Long.valueOf(cpVar.m()));
        contentValues.put("measurement_enabled", Boolean.valueOf(cpVar.n()));
        contentValues.put(c.jr, Long.valueOf(cpVar.s()));
        contentValues.put("daily_public_events_count", Long.valueOf(cpVar.t()));
        contentValues.put("daily_events_count", Long.valueOf(cpVar.u()));
        contentValues.put("daily_conversions_count", Long.valueOf(cpVar.v()));
        contentValues.put("config_fetched_time", Long.valueOf(cpVar.p()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(cpVar.q()));
        contentValues.put("app_version_int", Long.valueOf(cpVar.j()));
        contentValues.put("firebase_instance_id", cpVar.f());
        contentValues.put("daily_error_events_count", Long.valueOf(cpVar.x()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(cpVar.w()));
        contentValues.put("health_monitor_sample", cpVar.y());
        contentValues.put("android_id", Long.valueOf(cpVar.A()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(cpVar.B()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(cpVar.C()));
        try {
            SQLiteDatabase t = t();
            if (((long) t.update("apps", contentValues, "app_id = ?", new String[]{cpVar.b()})) == 0 && t.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzge().r().a("Failed to insert/update app (got -1). appId", dp.a(cpVar.b()));
            }
        } catch (SQLiteException e) {
            zzge().r().a("Error storing app. appId", dp.a(cpVar.b()), e);
        }
    }

    @WorkerThread
    public final void a(dc dcVar) {
        Long l = null;
        ar.a((Object) dcVar);
        c();
        J();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", dcVar.a);
        contentValues.put("name", dcVar.b);
        contentValues.put("lifetime_count", Long.valueOf(dcVar.c));
        contentValues.put("current_bundle_count", Long.valueOf(dcVar.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(dcVar.e));
        contentValues.put("last_bundled_timestamp", Long.valueOf(dcVar.f));
        contentValues.put("last_sampled_complex_event_id", dcVar.g);
        contentValues.put("last_sampling_rate", dcVar.h);
        if (dcVar.i != null && dcVar.i.booleanValue()) {
            l = Long.valueOf(1);
        }
        contentValues.put("last_exempt_from_sampling", l);
        try {
            if (t().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzge().r().a("Failed to insert/update event aggregates (got -1). appId", dp.a(dcVar.a));
            }
        } catch (SQLiteException e) {
            zzge().r().a("Error storing event aggregates. appId", dp.a(dcVar.a), e);
        }
    }

    @WorkerThread
    final void a(String str, ih[] ihVarArr) {
        int i = 0;
        J();
        c();
        ar.a(str);
        ar.a((Object) ihVarArr);
        SQLiteDatabase t = t();
        t.beginTransaction();
        try {
            int i2;
            J();
            c();
            ar.a(str);
            SQLiteDatabase t2 = t();
            t2.delete("property_filters", "app_id=?", new String[]{str});
            t2.delete("event_filters", "app_id=?", new String[]{str});
            for (Object obj : ihVarArr) {
                J();
                c();
                ar.a(str);
                ar.a(obj);
                ar.a(obj.e);
                ar.a(obj.d);
                if (obj.c == null) {
                    zzge().u().a("Audience with no ID. appId", dp.a(str));
                } else {
                    int intValue = obj.c.intValue();
                    for (ii iiVar : obj.e) {
                        if (iiVar.c == null) {
                            zzge().u().a("Event filter with no ID. Audience definition ignored. appId, audienceId", dp.a(str), obj.c);
                            break;
                        }
                    }
                    for (il ilVar : obj.d) {
                        if (ilVar.c == null) {
                            zzge().u().a("Property filter with no ID. Audience definition ignored. appId, audienceId", dp.a(str), obj.c);
                            break;
                        }
                    }
                    for (ii iiVar2 : obj.e) {
                        if (!a(str, intValue, iiVar2)) {
                            i2 = 0;
                            break;
                        }
                    }
                    i2 = 1;
                    if (i2 != 0) {
                        for (il ilVar2 : obj.d) {
                            if (!a(str, intValue, ilVar2)) {
                                i2 = 0;
                                break;
                            }
                        }
                    }
                    if (i2 == 0) {
                        J();
                        c();
                        ar.a(str);
                        SQLiteDatabase t3 = t();
                        t3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                        t3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                    }
                }
            }
            List arrayList = new ArrayList();
            i2 = ihVarArr.length;
            while (i < i2) {
                arrayList.add(ihVarArr[i].c);
                i++;
            }
            a(str, arrayList);
            t.setTransactionSuccessful();
        } finally {
            t.endTransaction();
        }
    }

    @WorkerThread
    @VisibleForTesting
    final void a(List<Long> list) {
        c();
        J();
        ar.a((Object) list);
        ar.a(list.size());
        if (L()) {
            String join = TextUtils.join(",", list);
            join = new StringBuilder(String.valueOf(join).length() + 2).append("(").append(join).append(")").toString();
            if (b(new StringBuilder(String.valueOf(join).length() + 80).append("SELECT COUNT(1) FROM queue WHERE rowid IN ").append(join).append(" AND retry_count =  2147483647 LIMIT 1").toString(), null) > 0) {
                zzge().u().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                t().execSQL(new StringBuilder(String.valueOf(join).length() + 127).append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ").append(join).append(" AND (retry_count IS NULL OR retry_count < 2147483647)").toString());
            } catch (SQLiteException e) {
                zzge().r().a("Error incrementing retry count. error", e);
            }
        }
    }

    public final boolean a(db dbVar, long j, boolean z) {
        c();
        J();
        ar.a((Object) dbVar);
        ar.a(dbVar.a);
        p irVar = new ir();
        irVar.f = Long.valueOf(dbVar.d);
        irVar.c = new is[dbVar.e.a()];
        Iterator it = dbVar.e.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            is isVar = new is();
            int i2 = i + 1;
            irVar.c[i] = isVar;
            isVar.c = str;
            l().a(isVar, dbVar.e.a(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[irVar.d()];
            i a = i.a(bArr, 0, bArr.length);
            irVar.a(a);
            a.a();
            zzge().y().a("Saving event, name, data size", k().a(dbVar.b), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", dbVar.a);
            contentValues.put("name", dbVar.b);
            contentValues.put("timestamp", Long.valueOf(dbVar.c));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (t().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                zzge().r().a("Failed to insert raw event (got -1). appId", dp.a(dbVar.a));
                return false;
            } catch (SQLiteException e) {
                zzge().r().a("Error storing raw event. appId", dp.a(dbVar.a), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().r().a("Data loss. Failed to serialize event params/data. appId", dp.a(dbVar.a), e2);
            return false;
        }
    }

    @WorkerThread
    public final boolean a(id idVar) {
        ar.a((Object) idVar);
        c();
        J();
        if (c(idVar.a, idVar.c) == null) {
            if (ie.a(idVar.c)) {
                if (b("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{idVar.a}) >= 25) {
                    return false;
                }
            }
            if (b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{idVar.a, idVar.b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", idVar.a);
        contentValues.put("origin", idVar.b);
        contentValues.put("name", idVar.c);
        contentValues.put("set_timestamp", Long.valueOf(idVar.d));
        a(contentValues, "value", idVar.e);
        try {
            if (t().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzge().r().a("Failed to insert/update user property (got -1). appId", dp.a(idVar.a));
            }
        } catch (SQLiteException e) {
            zzge().r().a("Error storing user property. appId", dp.a(idVar.a), e);
        }
        return true;
    }

    @WorkerThread
    public final boolean a(iu iuVar, boolean z) {
        c();
        J();
        ar.a((Object) iuVar);
        ar.a(iuVar.q);
        ar.a(iuVar.h);
        w();
        long currentTimeMillis = zzbt().currentTimeMillis();
        if (iuVar.h.longValue() < currentTimeMillis - ct.r() || iuVar.h.longValue() > ct.r() + currentTimeMillis) {
            zzge().u().a("Storing bundle outside of the max uploading time span. appId, now, timestamp", dp.a(iuVar.q), Long.valueOf(currentTimeMillis), iuVar.h);
        }
        try {
            byte[] bArr = new byte[iuVar.d()];
            i a = i.a(bArr, 0, bArr.length);
            iuVar.a(a);
            a.a();
            bArr = l().a(bArr);
            zzge().y().a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", iuVar.q);
            contentValues.put("bundle_end_timestamp", iuVar.h);
            contentValues.put("data", bArr);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (iuVar.J != null) {
                contentValues.put("retry_count", iuVar.J);
            }
            try {
                if (t().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzge().r().a("Failed to insert bundle (got -1). appId", dp.a(iuVar.q));
                return false;
            } catch (SQLiteException e) {
                zzge().r().a("Error storing bundle. appId", dp.a(iuVar.q), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().r().a("Data loss. Failed to serialize bundle. appId", dp.a(iuVar.q), e2);
            return false;
        }
    }

    @WorkerThread
    public final boolean a(zzed zzed) {
        ar.a((Object) zzed);
        c();
        J();
        if (c(zzed.a, zzed.c.a) == null) {
            if (b("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzed.a}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzed.a);
        contentValues.put("origin", zzed.b);
        contentValues.put("name", zzed.c.a);
        a(contentValues, "value", zzed.c.a());
        contentValues.put("active", Boolean.valueOf(zzed.e));
        contentValues.put("trigger_event_name", zzed.f);
        contentValues.put("trigger_timeout", Long.valueOf(zzed.h));
        l();
        contentValues.put("timed_out_event", ie.a(zzed.g));
        contentValues.put("creation_timestamp", Long.valueOf(zzed.d));
        l();
        contentValues.put("triggered_event", ie.a(zzed.i));
        contentValues.put("triggered_timestamp", Long.valueOf(zzed.c.b));
        contentValues.put("time_to_live", Long.valueOf(zzed.j));
        l();
        contentValues.put("expired_event", ie.a(zzed.k));
        try {
            if (t().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzge().r().a("Failed to insert/update conditional user property (got -1)", dp.a(zzed.a));
            }
        } catch (SQLiteException e) {
            zzge().r().a("Error storing conditional user property", dp.a(zzed.a), e);
        }
        return true;
    }

    public final boolean a(String str, Long l, long j, ir irVar) {
        c();
        J();
        ar.a((Object) irVar);
        ar.a(str);
        ar.a((Object) l);
        try {
            byte[] bArr = new byte[irVar.d()];
            i a = i.a(bArr, 0, bArr.length);
            irVar.a(a);
            a.a();
            zzge().y().a("Saving complex main event, appId, data size", k().a(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (t().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                    return true;
                }
                zzge().r().a("Failed to insert complex main event (got -1). appId", dp.a(str));
                return false;
            } catch (SQLiteException e) {
                zzge().r().a("Error storing complex main event. appId", dp.a(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().r().a("Data loss. Failed to serialize event params/data. appId, eventId", dp.a(str), l, e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0225  */
    @android.support.annotation.WorkerThread
    public final com.google.android.gms.internal.measurement.cp b(java.lang.String r12) {
        /*
        r11 = this;
        r8 = 0;
        r10 = 1;
        r9 = 0;
        com.google.android.gms.common.internal.ar.a(r12);
        r11.c();
        r11.J();
        r0 = r11.t();	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r1 = "apps";
        r2 = 25;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 0;
        r4 = "app_instance_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 1;
        r4 = "gmp_app_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 2;
        r4 = "resettable_device_id_hash";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 3;
        r4 = "last_bundle_index";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 4;
        r4 = "last_bundle_start_timestamp";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 5;
        r4 = "last_bundle_end_timestamp";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 6;
        r4 = "app_version";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 7;
        r4 = "app_store";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 8;
        r4 = "gmp_version";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 9;
        r4 = "dev_cert_hash";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 10;
        r4 = "measurement_enabled";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 11;
        r4 = "day";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 12;
        r4 = "daily_public_events_count";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 13;
        r4 = "daily_events_count";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 14;
        r4 = "daily_conversions_count";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 15;
        r4 = "config_fetched_time";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 16;
        r4 = "failed_config_fetch_time";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 17;
        r4 = "app_version_int";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 18;
        r4 = "firebase_instance_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 19;
        r4 = "daily_error_events_count";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 20;
        r4 = "daily_realtime_events_count";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 21;
        r4 = "health_monitor_sample";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 22;
        r4 = "android_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 23;
        r4 = "adid_reporting_enabled";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = 24;
        r4 = "ssaid_reporting_enabled";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r3 = "app_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r5 = 0;
        r4[r5] = r12;	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
        r0 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x022b }
        if (r0 != 0) goto L_0x00c0;
    L_0x00b9:
        if (r1 == 0) goto L_0x00be;
    L_0x00bb:
        r1.close();
    L_0x00be:
        r0 = r8;
    L_0x00bf:
        return r0;
    L_0x00c0:
        r0 = new com.google.android.gms.internal.measurement.cp;	 Catch:{ SQLiteException -> 0x022b }
        r2 = r11.a;	 Catch:{ SQLiteException -> 0x022b }
        r2 = r2.F();	 Catch:{ SQLiteException -> 0x022b }
        r0.<init>(r2, r12);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 0;
        r2 = r1.getString(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.a(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 1;
        r2 = r1.getString(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.b(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 2;
        r2 = r1.getString(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.c(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 3;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.f(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 4;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.a(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 5;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.b(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 6;
        r2 = r1.getString(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.e(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 7;
        r2 = r1.getString(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.f(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 8;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.d(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 9;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.e(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 10;
        r2 = r1.isNull(r2);	 Catch:{ SQLiteException -> 0x022b }
        if (r2 != 0) goto L_0x012d;
    L_0x0125:
        r2 = 10;
        r2 = r1.getInt(r2);	 Catch:{ SQLiteException -> 0x022b }
        if (r2 == 0) goto L_0x01ef;
    L_0x012d:
        r2 = r10;
    L_0x012e:
        r0.a(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 11;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.i(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 12;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.j(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 13;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.k(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 14;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.l(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 15;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.g(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 16;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.h(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 17;
        r2 = r1.isNull(r2);	 Catch:{ SQLiteException -> 0x022b }
        if (r2 == 0) goto L_0x01f2;
    L_0x016f:
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x0172:
        r0.c(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 18;
        r2 = r1.getString(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.d(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 19;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.n(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 20;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.m(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 21;
        r2 = r1.getString(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.g(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 22;
        r2 = r1.isNull(r2);	 Catch:{ SQLiteException -> 0x022b }
        if (r2 == 0) goto L_0x01fb;
    L_0x01a1:
        r2 = 0;
    L_0x01a3:
        r0.o(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 23;
        r2 = r1.isNull(r2);	 Catch:{ SQLiteException -> 0x022b }
        if (r2 != 0) goto L_0x01b6;
    L_0x01ae:
        r2 = 23;
        r2 = r1.getInt(r2);	 Catch:{ SQLiteException -> 0x022b }
        if (r2 == 0) goto L_0x0202;
    L_0x01b6:
        r2 = r10;
    L_0x01b7:
        r0.b(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = 24;
        r2 = r1.isNull(r2);	 Catch:{ SQLiteException -> 0x022b }
        if (r2 != 0) goto L_0x01ca;
    L_0x01c2:
        r2 = 24;
        r2 = r1.getInt(r2);	 Catch:{ SQLiteException -> 0x022b }
        if (r2 == 0) goto L_0x0204;
    L_0x01ca:
        r2 = r10;
    L_0x01cb:
        r0.c(r2);	 Catch:{ SQLiteException -> 0x022b }
        r0.a();	 Catch:{ SQLiteException -> 0x022b }
        r2 = r1.moveToNext();	 Catch:{ SQLiteException -> 0x022b }
        if (r2 == 0) goto L_0x01e8;
    L_0x01d7:
        r2 = r11.zzge();	 Catch:{ SQLiteException -> 0x022b }
        r2 = r2.r();	 Catch:{ SQLiteException -> 0x022b }
        r3 = "Got multiple records for app, expected one. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ SQLiteException -> 0x022b }
        r2.a(r3, r4);	 Catch:{ SQLiteException -> 0x022b }
    L_0x01e8:
        if (r1 == 0) goto L_0x00bf;
    L_0x01ea:
        r1.close();
        goto L_0x00bf;
    L_0x01ef:
        r2 = r9;
        goto L_0x012e;
    L_0x01f2:
        r2 = 17;
        r2 = r1.getInt(r2);	 Catch:{ SQLiteException -> 0x022b }
        r2 = (long) r2;	 Catch:{ SQLiteException -> 0x022b }
        goto L_0x0172;
    L_0x01fb:
        r2 = 22;
        r2 = r1.getLong(r2);	 Catch:{ SQLiteException -> 0x022b }
        goto L_0x01a3;
    L_0x0202:
        r2 = r9;
        goto L_0x01b7;
    L_0x0204:
        r2 = r9;
        goto L_0x01cb;
    L_0x0206:
        r0 = move-exception;
        r1 = r8;
    L_0x0208:
        r2 = r11.zzge();	 Catch:{ all -> 0x0229 }
        r2 = r2.r();	 Catch:{ all -> 0x0229 }
        r3 = "Error querying app. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ all -> 0x0229 }
        r2.a(r3, r4, r0);	 Catch:{ all -> 0x0229 }
        if (r1 == 0) goto L_0x021e;
    L_0x021b:
        r1.close();
    L_0x021e:
        r0 = r8;
        goto L_0x00bf;
    L_0x0221:
        r0 = move-exception;
        r1 = r8;
    L_0x0223:
        if (r1 == 0) goto L_0x0228;
    L_0x0225:
        r1.close();
    L_0x0228:
        throw r0;
    L_0x0229:
        r0 = move-exception;
        goto L_0x0223;
    L_0x022b:
        r0 = move-exception;
        goto L_0x0208;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.b(java.lang.String):com.google.android.gms.internal.measurement.cp");
    }

    @WorkerThread
    public final List<zzed> b(String str, String str2, String str3) {
        ar.a(str);
        c();
        J();
        List arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder stringBuilder = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            stringBuilder.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            stringBuilder.append(" and name glob ?");
        }
        return a(stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @WorkerThread
    public final void b(String str, String str2) {
        ar.a(str);
        ar.a(str2);
        c();
        J();
        try {
            zzge().y().a("Deleted user attribute rows", Integer.valueOf(t().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzge().r().a("Error deleting user attribute. appId", dp.a(str), k().c(str2), e);
        }
    }

    public final long c(String str) {
        ar.a(str);
        c();
        J();
        try {
            SQLiteDatabase t = t();
            String valueOf = String.valueOf(Math.max(0, Math.min(1000000, o().b(str, dg.q))));
            return (long) t.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            zzge().r().a("Error deleting over the limit events. appId", dp.a(str), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c  */
    @android.support.annotation.WorkerThread
    public final com.google.android.gms.internal.measurement.id c(java.lang.String r10, java.lang.String r11) {
        /*
        r9 = this;
        r8 = 0;
        com.google.android.gms.common.internal.ar.a(r10);
        com.google.android.gms.common.internal.ar.a(r11);
        r9.c();
        r9.J();
        r0 = r9.t();	 Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
        r1 = "user_attributes";
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
        r3 = 0;
        r4 = "set_timestamp";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
        r3 = 1;
        r4 = "value";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
        r3 = 2;
        r4 = "origin";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
        r3 = "app_id=? and name=?";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
        r5 = 0;
        r4[r5] = r10;	 Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
        r5 = 1;
        r4[r5] = r11;	 Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r7 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
        r0 = r7.moveToFirst();	 Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
        if (r0 != 0) goto L_0x0044;
    L_0x003d:
        if (r7 == 0) goto L_0x0042;
    L_0x003f:
        r7.close();
    L_0x0042:
        r0 = r8;
    L_0x0043:
        return r0;
    L_0x0044:
        r0 = 0;
        r4 = r7.getLong(r0);	 Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
        r0 = 1;
        r6 = r9.a(r7, r0);	 Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
        r0 = 2;
        r2 = r7.getString(r0);	 Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
        r0 = new com.google.android.gms.internal.measurement.id;	 Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
        r1 = r10;
        r3 = r11;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
        r1 = r7.moveToNext();	 Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
        if (r1 == 0) goto L_0x0071;
    L_0x0060:
        r1 = r9.zzge();	 Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
        r1 = r1.r();	 Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
        r2 = "Got multiple records for user property, expected one. appId";
        r3 = com.google.android.gms.internal.measurement.dp.a(r10);	 Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
        r1.a(r2, r3);	 Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
    L_0x0071:
        if (r7 == 0) goto L_0x0043;
    L_0x0073:
        r7.close();
        goto L_0x0043;
    L_0x0077:
        r0 = move-exception;
        r1 = r8;
    L_0x0079:
        r2 = r9.zzge();	 Catch:{ all -> 0x00a3 }
        r2 = r2.r();	 Catch:{ all -> 0x00a3 }
        r3 = "Error querying user property. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r10);	 Catch:{ all -> 0x00a3 }
        r5 = r9.k();	 Catch:{ all -> 0x00a3 }
        r5 = r5.c(r11);	 Catch:{ all -> 0x00a3 }
        r2.a(r3, r4, r5, r0);	 Catch:{ all -> 0x00a3 }
        if (r1 == 0) goto L_0x0097;
    L_0x0094:
        r1.close();
    L_0x0097:
        r0 = r8;
        goto L_0x0043;
    L_0x0099:
        r0 = move-exception;
    L_0x009a:
        if (r8 == 0) goto L_0x009f;
    L_0x009c:
        r8.close();
    L_0x009f:
        throw r0;
    L_0x00a0:
        r0 = move-exception;
        r8 = r7;
        goto L_0x009a;
    L_0x00a3:
        r0 = move-exception;
        r8 = r1;
        goto L_0x009a;
    L_0x00a6:
        r0 = move-exception;
        r1 = r7;
        goto L_0x0079;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.c(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.id");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x014d  */
    @android.support.annotation.WorkerThread
    public final com.google.android.gms.internal.measurement.zzed d(java.lang.String r22, java.lang.String r23) {
        /*
        r21 = this;
        com.google.android.gms.common.internal.ar.a(r22);
        com.google.android.gms.common.internal.ar.a(r23);
        r21.c();
        r21.J();
        r10 = 0;
        r2 = r21.t();	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r3 = "conditional_properties";
        r4 = 11;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = 0;
        r6 = "origin";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = 1;
        r6 = "value";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = 2;
        r6 = "active";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = 3;
        r6 = "trigger_event_name";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = 4;
        r6 = "trigger_timeout";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = 5;
        r6 = "timed_out_event";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = 6;
        r6 = "creation_timestamp";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = 7;
        r6 = "triggered_event";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = 8;
        r6 = "triggered_timestamp";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = 9;
        r6 = "time_to_live";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = 10;
        r6 = "expired_event";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r5 = "app_id=? and name=?";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r7 = 0;
        r6[r7] = r22;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r7 = 1;
        r6[r7] = r23;	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r20 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
        r2 = r20.moveToFirst();	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        if (r2 != 0) goto L_0x0070;
    L_0x0069:
        if (r20 == 0) goto L_0x006e;
    L_0x006b:
        r20.close();
    L_0x006e:
        r5 = 0;
    L_0x006f:
        return r5;
    L_0x0070:
        r2 = 0;
        r0 = r20;
        r7 = r0.getString(r2);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = 1;
        r0 = r21;
        r1 = r20;
        r6 = r0.a(r1, r2);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = 2;
        r0 = r20;
        r2 = r0.getInt(r2);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        if (r2 == 0) goto L_0x0120;
    L_0x0089:
        r11 = 1;
    L_0x008a:
        r2 = 3;
        r0 = r20;
        r12 = r0.getString(r2);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = 4;
        r0 = r20;
        r14 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = r21.l();	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r3 = 5;
        r0 = r20;
        r3 = r0.getBlob(r3);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r4 = com.google.android.gms.internal.measurement.zzeu.CREATOR;	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r13 = r2.a(r3, r4);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r13 = (com.google.android.gms.internal.measurement.zzeu) r13;	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = 6;
        r0 = r20;
        r9 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = r21.l();	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r3 = 7;
        r0 = r20;
        r3 = r0.getBlob(r3);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r4 = com.google.android.gms.internal.measurement.zzeu.CREATOR;	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r16 = r2.a(r3, r4);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r16 = (com.google.android.gms.internal.measurement.zzeu) r16;	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = 8;
        r0 = r20;
        r4 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = 9;
        r0 = r20;
        r17 = r0.getLong(r2);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = r21.l();	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r3 = 10;
        r0 = r20;
        r3 = r0.getBlob(r3);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r8 = com.google.android.gms.internal.measurement.zzeu.CREATOR;	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r19 = r2.a(r3, r8);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r19 = (com.google.android.gms.internal.measurement.zzeu) r19;	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = new com.google.android.gms.internal.measurement.zzjx;	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r3 = r23;
        r2.<init>(r3, r4, r6, r7);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r5 = new com.google.android.gms.internal.measurement.zzed;	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r6 = r22;
        r8 = r2;
        r5.<init>(r6, r7, r8, r9, r11, r12, r13, r14, r16, r17, r19);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = r20.moveToNext();	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        if (r2 == 0) goto L_0x0119;
    L_0x00fe:
        r2 = r21.zzge();	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2 = r2.r();	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r3 = "Got multiple records for conditional property, expected one";
        r4 = com.google.android.gms.internal.measurement.dp.a(r22);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r6 = r21.k();	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r0 = r23;
        r6 = r6.c(r0);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        r2.a(r3, r4, r6);	 Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
    L_0x0119:
        if (r20 == 0) goto L_0x006f;
    L_0x011b:
        r20.close();
        goto L_0x006f;
    L_0x0120:
        r11 = 0;
        goto L_0x008a;
    L_0x0123:
        r2 = move-exception;
        r3 = r10;
    L_0x0125:
        r4 = r21.zzge();	 Catch:{ all -> 0x0153 }
        r4 = r4.r();	 Catch:{ all -> 0x0153 }
        r5 = "Error querying conditional property";
        r6 = com.google.android.gms.internal.measurement.dp.a(r22);	 Catch:{ all -> 0x0153 }
        r7 = r21.k();	 Catch:{ all -> 0x0153 }
        r0 = r23;
        r7 = r7.c(r0);	 Catch:{ all -> 0x0153 }
        r4.a(r5, r6, r7, r2);	 Catch:{ all -> 0x0153 }
        if (r3 == 0) goto L_0x0145;
    L_0x0142:
        r3.close();
    L_0x0145:
        r5 = 0;
        goto L_0x006f;
    L_0x0148:
        r2 = move-exception;
        r20 = r10;
    L_0x014b:
        if (r20 == 0) goto L_0x0150;
    L_0x014d:
        r20.close();
    L_0x0150:
        throw r2;
    L_0x0151:
        r2 = move-exception;
        goto L_0x014b;
    L_0x0153:
        r2 = move-exception;
        r20 = r3;
        goto L_0x014b;
    L_0x0157:
        r2 = move-exception;
        r3 = r20;
        goto L_0x0125;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.d(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.zzed");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
    @android.support.annotation.WorkerThread
    public final byte[] d(java.lang.String r10) {
        /*
        r9 = this;
        r8 = 0;
        com.google.android.gms.common.internal.ar.a(r10);
        r9.c();
        r9.J();
        r0 = r9.t();	 Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
        r1 = "apps";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
        r3 = 0;
        r4 = "remote_config";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
        r3 = "app_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
        r5 = 0;
        r4[r5] = r10;	 Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
        r0 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x007a }
        if (r0 != 0) goto L_0x0034;
    L_0x002d:
        if (r1 == 0) goto L_0x0032;
    L_0x002f:
        r1.close();
    L_0x0032:
        r0 = r8;
    L_0x0033:
        return r0;
    L_0x0034:
        r0 = 0;
        r0 = r1.getBlob(r0);	 Catch:{ SQLiteException -> 0x007a }
        r2 = r1.moveToNext();	 Catch:{ SQLiteException -> 0x007a }
        if (r2 == 0) goto L_0x0050;
    L_0x003f:
        r2 = r9.zzge();	 Catch:{ SQLiteException -> 0x007a }
        r2 = r2.r();	 Catch:{ SQLiteException -> 0x007a }
        r3 = "Got multiple records for app config, expected one. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r10);	 Catch:{ SQLiteException -> 0x007a }
        r2.a(r3, r4);	 Catch:{ SQLiteException -> 0x007a }
    L_0x0050:
        if (r1 == 0) goto L_0x0033;
    L_0x0052:
        r1.close();
        goto L_0x0033;
    L_0x0056:
        r0 = move-exception;
        r1 = r8;
    L_0x0058:
        r2 = r9.zzge();	 Catch:{ all -> 0x0078 }
        r2 = r2.r();	 Catch:{ all -> 0x0078 }
        r3 = "Error querying remote config. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r10);	 Catch:{ all -> 0x0078 }
        r2.a(r3, r4, r0);	 Catch:{ all -> 0x0078 }
        if (r1 == 0) goto L_0x006e;
    L_0x006b:
        r1.close();
    L_0x006e:
        r0 = r8;
        goto L_0x0033;
    L_0x0070:
        r0 = move-exception;
        r1 = r8;
    L_0x0072:
        if (r1 == 0) goto L_0x0077;
    L_0x0074:
        r1.close();
    L_0x0077:
        throw r0;
    L_0x0078:
        r0 = move-exception;
        goto L_0x0072;
    L_0x007a:
        r0 = move-exception;
        goto L_0x0058;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.d(java.lang.String):byte[]");
    }

    @WorkerThread
    public final int e(String str, String str2) {
        int i = 0;
        ar.a(str);
        ar.a(str2);
        c();
        J();
        try {
            return t().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzge().r().a("Error deleting conditional property", dp.a(str), k().c(str2), e);
            return i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d  */
    final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.iv> e(java.lang.String r10) {
        /*
        r9 = this;
        r8 = 0;
        r9.J();
        r9.c();
        com.google.android.gms.common.internal.ar.a(r10);
        r0 = r9.t();
        r1 = "audience_filter_values";
        r2 = 2;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
        r3 = 0;
        r4 = "audience_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
        r3 = 1;
        r4 = "current_results";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
        r3 = "app_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
        r5 = 0;
        r4[r5] = r10;	 Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
        r0 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x0080 }
        if (r0 != 0) goto L_0x0039;
    L_0x0032:
        if (r1 == 0) goto L_0x0037;
    L_0x0034:
        r1.close();
    L_0x0037:
        r0 = r8;
    L_0x0038:
        return r0;
    L_0x0039:
        r0 = new android.support.v4.util.a;	 Catch:{ SQLiteException -> 0x0080 }
        r0.<init>();	 Catch:{ SQLiteException -> 0x0080 }
    L_0x003e:
        r2 = 0;
        r2 = r1.getInt(r2);	 Catch:{ SQLiteException -> 0x0080 }
        r3 = 1;
        r3 = r1.getBlob(r3);	 Catch:{ SQLiteException -> 0x0080 }
        r4 = 0;
        r5 = r3.length;	 Catch:{ SQLiteException -> 0x0080 }
        r3 = com.google.android.gms.internal.measurement.h.a(r3, r4, r5);	 Catch:{ SQLiteException -> 0x0080 }
        r4 = new com.google.android.gms.internal.measurement.iv;	 Catch:{ SQLiteException -> 0x0080 }
        r4.<init>();	 Catch:{ SQLiteException -> 0x0080 }
        r4.a(r3);	 Catch:{ IOException -> 0x0069 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0080 }
        r0.put(r2, r4);	 Catch:{ SQLiteException -> 0x0080 }
    L_0x005d:
        r2 = r1.moveToNext();	 Catch:{ SQLiteException -> 0x0080 }
        if (r2 != 0) goto L_0x003e;
    L_0x0063:
        if (r1 == 0) goto L_0x0038;
    L_0x0065:
        r1.close();
        goto L_0x0038;
    L_0x0069:
        r3 = move-exception;
        r4 = r9.zzge();	 Catch:{ SQLiteException -> 0x0080 }
        r4 = r4.r();	 Catch:{ SQLiteException -> 0x0080 }
        r5 = "Failed to merge filter results. appId, audienceId, error";
        r6 = com.google.android.gms.internal.measurement.dp.a(r10);	 Catch:{ SQLiteException -> 0x0080 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0080 }
        r4.a(r5, r6, r2, r3);	 Catch:{ SQLiteException -> 0x0080 }
        goto L_0x005d;
    L_0x0080:
        r0 = move-exception;
    L_0x0081:
        r2 = r9.zzge();	 Catch:{ all -> 0x00a1 }
        r2 = r2.r();	 Catch:{ all -> 0x00a1 }
        r3 = "Database error querying filter results. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r10);	 Catch:{ all -> 0x00a1 }
        r2.a(r3, r4, r0);	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x0097;
    L_0x0094:
        r1.close();
    L_0x0097:
        r0 = r8;
        goto L_0x0038;
    L_0x0099:
        r0 = move-exception;
        r1 = r8;
    L_0x009b:
        if (r1 == 0) goto L_0x00a0;
    L_0x009d:
        r1.close();
    L_0x00a0:
        throw r0;
    L_0x00a1:
        r0 = move-exception;
        goto L_0x009b;
    L_0x00a3:
        r0 = move-exception;
        r1 = r8;
        goto L_0x0081;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.e(java.lang.String):java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.iv>");
    }

    public final long f(String str) {
        ar.a(str);
        return a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b7  */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.ii>> f(java.lang.String r11, java.lang.String r12) {
        /*
        r10 = this;
        r9 = 0;
        r10.J();
        r10.c();
        com.google.android.gms.common.internal.ar.a(r11);
        com.google.android.gms.common.internal.ar.a(r12);
        r8 = new android.support.v4.util.a;
        r8.<init>();
        r0 = r10.t();
        r1 = "event_filters";
        r2 = 2;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r3 = 0;
        r4 = "audience_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r3 = 1;
        r4 = "data";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r3 = "app_id=? AND event_name=?";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r5 = 0;
        r4[r5] = r11;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r5 = 1;
        r4[r5] = r12;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r0 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x009a }
        if (r0 != 0) goto L_0x0047;
    L_0x003d:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x009a }
        if (r1 == 0) goto L_0x0046;
    L_0x0043:
        r1.close();
    L_0x0046:
        return r0;
    L_0x0047:
        r0 = 1;
        r0 = r1.getBlob(r0);	 Catch:{ SQLiteException -> 0x009a }
        r2 = 0;
        r3 = r0.length;	 Catch:{ SQLiteException -> 0x009a }
        r0 = com.google.android.gms.internal.measurement.h.a(r0, r2, r3);	 Catch:{ SQLiteException -> 0x009a }
        r2 = new com.google.android.gms.internal.measurement.ii;	 Catch:{ SQLiteException -> 0x009a }
        r2.<init>();	 Catch:{ SQLiteException -> 0x009a }
        r2.a(r0);	 Catch:{ IOException -> 0x0087 }
        r0 = 0;
        r3 = r1.getInt(r0);	 Catch:{ SQLiteException -> 0x009a }
        r0 = java.lang.Integer.valueOf(r3);	 Catch:{ SQLiteException -> 0x009a }
        r0 = r8.get(r0);	 Catch:{ SQLiteException -> 0x009a }
        r0 = (java.util.List) r0;	 Catch:{ SQLiteException -> 0x009a }
        if (r0 != 0) goto L_0x0077;
    L_0x006b:
        r0 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x009a }
        r0.<init>();	 Catch:{ SQLiteException -> 0x009a }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ SQLiteException -> 0x009a }
        r8.put(r3, r0);	 Catch:{ SQLiteException -> 0x009a }
    L_0x0077:
        r0.add(r2);	 Catch:{ SQLiteException -> 0x009a }
    L_0x007a:
        r0 = r1.moveToNext();	 Catch:{ SQLiteException -> 0x009a }
        if (r0 != 0) goto L_0x0047;
    L_0x0080:
        if (r1 == 0) goto L_0x0085;
    L_0x0082:
        r1.close();
    L_0x0085:
        r0 = r8;
        goto L_0x0046;
    L_0x0087:
        r0 = move-exception;
        r2 = r10.zzge();	 Catch:{ SQLiteException -> 0x009a }
        r2 = r2.r();	 Catch:{ SQLiteException -> 0x009a }
        r3 = "Failed to merge filter. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r11);	 Catch:{ SQLiteException -> 0x009a }
        r2.a(r3, r4, r0);	 Catch:{ SQLiteException -> 0x009a }
        goto L_0x007a;
    L_0x009a:
        r0 = move-exception;
    L_0x009b:
        r2 = r10.zzge();	 Catch:{ all -> 0x00bb }
        r2 = r2.r();	 Catch:{ all -> 0x00bb }
        r3 = "Database error querying filters. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r11);	 Catch:{ all -> 0x00bb }
        r2.a(r3, r4, r0);	 Catch:{ all -> 0x00bb }
        if (r1 == 0) goto L_0x00b1;
    L_0x00ae:
        r1.close();
    L_0x00b1:
        r0 = r9;
        goto L_0x0046;
    L_0x00b3:
        r0 = move-exception;
        r1 = r9;
    L_0x00b5:
        if (r1 == 0) goto L_0x00ba;
    L_0x00b7:
        r1.close();
    L_0x00ba:
        throw r0;
    L_0x00bb:
        r0 = move-exception;
        goto L_0x00b5;
    L_0x00bd:
        r0 = move-exception;
        r1 = r9;
        goto L_0x009b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.f(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.ii>>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b7  */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.il>> g(java.lang.String r11, java.lang.String r12) {
        /*
        r10 = this;
        r9 = 0;
        r10.J();
        r10.c();
        com.google.android.gms.common.internal.ar.a(r11);
        com.google.android.gms.common.internal.ar.a(r12);
        r8 = new android.support.v4.util.a;
        r8.<init>();
        r0 = r10.t();
        r1 = "property_filters";
        r2 = 2;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r3 = 0;
        r4 = "audience_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r3 = 1;
        r4 = "data";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r3 = "app_id=? AND property_name=?";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r5 = 0;
        r4[r5] = r11;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r5 = 1;
        r4[r5] = r12;	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
        r0 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x009a }
        if (r0 != 0) goto L_0x0047;
    L_0x003d:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x009a }
        if (r1 == 0) goto L_0x0046;
    L_0x0043:
        r1.close();
    L_0x0046:
        return r0;
    L_0x0047:
        r0 = 1;
        r0 = r1.getBlob(r0);	 Catch:{ SQLiteException -> 0x009a }
        r2 = 0;
        r3 = r0.length;	 Catch:{ SQLiteException -> 0x009a }
        r0 = com.google.android.gms.internal.measurement.h.a(r0, r2, r3);	 Catch:{ SQLiteException -> 0x009a }
        r2 = new com.google.android.gms.internal.measurement.il;	 Catch:{ SQLiteException -> 0x009a }
        r2.<init>();	 Catch:{ SQLiteException -> 0x009a }
        r2.a(r0);	 Catch:{ IOException -> 0x0087 }
        r0 = 0;
        r3 = r1.getInt(r0);	 Catch:{ SQLiteException -> 0x009a }
        r0 = java.lang.Integer.valueOf(r3);	 Catch:{ SQLiteException -> 0x009a }
        r0 = r8.get(r0);	 Catch:{ SQLiteException -> 0x009a }
        r0 = (java.util.List) r0;	 Catch:{ SQLiteException -> 0x009a }
        if (r0 != 0) goto L_0x0077;
    L_0x006b:
        r0 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x009a }
        r0.<init>();	 Catch:{ SQLiteException -> 0x009a }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ SQLiteException -> 0x009a }
        r8.put(r3, r0);	 Catch:{ SQLiteException -> 0x009a }
    L_0x0077:
        r0.add(r2);	 Catch:{ SQLiteException -> 0x009a }
    L_0x007a:
        r0 = r1.moveToNext();	 Catch:{ SQLiteException -> 0x009a }
        if (r0 != 0) goto L_0x0047;
    L_0x0080:
        if (r1 == 0) goto L_0x0085;
    L_0x0082:
        r1.close();
    L_0x0085:
        r0 = r8;
        goto L_0x0046;
    L_0x0087:
        r0 = move-exception;
        r2 = r10.zzge();	 Catch:{ SQLiteException -> 0x009a }
        r2 = r2.r();	 Catch:{ SQLiteException -> 0x009a }
        r3 = "Failed to merge filter";
        r4 = com.google.android.gms.internal.measurement.dp.a(r11);	 Catch:{ SQLiteException -> 0x009a }
        r2.a(r3, r4, r0);	 Catch:{ SQLiteException -> 0x009a }
        goto L_0x007a;
    L_0x009a:
        r0 = move-exception;
    L_0x009b:
        r2 = r10.zzge();	 Catch:{ all -> 0x00bb }
        r2 = r2.r();	 Catch:{ all -> 0x00bb }
        r3 = "Database error querying filters. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r11);	 Catch:{ all -> 0x00bb }
        r2.a(r3, r4, r0);	 Catch:{ all -> 0x00bb }
        if (r1 == 0) goto L_0x00b1;
    L_0x00ae:
        r1.close();
    L_0x00b1:
        r0 = r9;
        goto L_0x0046;
    L_0x00b3:
        r0 = move-exception;
        r1 = r9;
    L_0x00b5:
        if (r1 == 0) goto L_0x00ba;
    L_0x00b7:
        r1.close();
    L_0x00ba:
        throw r0;
    L_0x00bb:
        r0 = move-exception;
        goto L_0x00b5;
    L_0x00bd:
        r0 = move-exception;
        r1 = r9;
        goto L_0x009b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.g(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.il>>");
    }

    @WorkerThread
    @VisibleForTesting
    protected final long h(String str, String str2) {
        Object e;
        ar.a(str);
        ar.a(str2);
        c();
        J();
        SQLiteDatabase t = t();
        t.beginTransaction();
        long a;
        try {
            a = a(new StringBuilder(String.valueOf(str2).length() + 32).append("select ").append(str2).append(" from app2 where app_id=?").toString(), new String[]{str}, -1);
            if (a == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", Integer.valueOf(0));
                contentValues.put("previous_install_count", Integer.valueOf(0));
                if (t.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    zzge().r().a("Failed to insert column (got -1). appId", dp.a(str), str2);
                    t.endTransaction();
                    return -1;
                }
                a = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + a));
                if (((long) t.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzge().r().a("Failed to update column (got 0). appId", dp.a(str), str2);
                    t.endTransaction();
                    return -1;
                }
                t.setTransactionSuccessful();
                t.endTransaction();
                return a;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().r().a("Error inserting column. appId", dp.a(str), str2, e);
                    return a;
                } finally {
                    t.endTransaction();
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            a = 0;
            zzge().r().a("Error inserting column. appId", dp.a(str), str2, e);
            return a;
        }
    }

    protected final boolean p() {
        return false;
    }

    @WorkerThread
    public final void q() {
        J();
        t().beginTransaction();
    }

    @WorkerThread
    public final void r() {
        J();
        t().setTransactionSuccessful();
    }

    @WorkerThread
    public final void s() {
        J();
        t().endTransaction();
    }

    @WorkerThread
    @VisibleForTesting
    final SQLiteDatabase t() {
        c();
        try {
            return this.h.getWritableDatabase();
        } catch (SQLiteException e) {
            zzge().u().a("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    @android.support.annotation.WorkerThread
    public final java.lang.String u() {
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.t();
        r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;";
        r3 = 0;
        r2 = r1.rawQuery(r2, r3);	 Catch:{ SQLiteException -> 0x0023, all -> 0x0038 }
        r1 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x0043 }
        if (r1 == 0) goto L_0x001d;
    L_0x0012:
        r1 = 0;
        r0 = r2.getString(r1);	 Catch:{ SQLiteException -> 0x0043 }
        if (r2 == 0) goto L_0x001c;
    L_0x0019:
        r2.close();
    L_0x001c:
        return r0;
    L_0x001d:
        if (r2 == 0) goto L_0x001c;
    L_0x001f:
        r2.close();
        goto L_0x001c;
    L_0x0023:
        r1 = move-exception;
        r2 = r0;
    L_0x0025:
        r3 = r5.zzge();	 Catch:{ all -> 0x0041 }
        r3 = r3.r();	 Catch:{ all -> 0x0041 }
        r4 = "Database error getting next bundle app id";
        r3.a(r4, r1);	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x001c;
    L_0x0034:
        r2.close();
        goto L_0x001c;
    L_0x0038:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x003b:
        if (r2 == 0) goto L_0x0040;
    L_0x003d:
        r2.close();
    L_0x0040:
        throw r0;
    L_0x0041:
        r0 = move-exception;
        goto L_0x003b;
    L_0x0043:
        r1 = move-exception;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.u():java.lang.String");
    }

    public final boolean v() {
        return b("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    @WorkerThread
    final void w() {
        c();
        J();
        if (L()) {
            long a = n().f.a();
            long elapsedRealtime = zzbt().elapsedRealtime();
            if (Math.abs(elapsedRealtime - a) > ((Long) dg.z.b()).longValue()) {
                n().f.a(elapsedRealtime);
                c();
                J();
                if (L()) {
                    int delete = t().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzbt().currentTimeMillis()), String.valueOf(ct.r())});
                    if (delete > 0) {
                        zzge().y().a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    @WorkerThread
    public final long x() {
        return a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    @WorkerThread
    public final long y() {
        return a("select max(timestamp) from raw_events", null, 0);
    }

    public final boolean z() {
        return b("select count(1) > 0 from raw_events", null) != 0;
    }
}

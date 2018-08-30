package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;

public final class dl extends fo {
    private final dm a = new dm(this, getContext(), "google_app_measurement_local.db");
    private boolean b;

    dl(es esVar) {
        super(esVar);
    }

    @WorkerThread
    private final boolean a(int i, byte[] bArr) {
        c();
        if (this.b) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 5;
        int i3 = 0;
        while (true) {
            int i4 = i2;
            if (i3 < 5) {
                SQLiteDatabase sQLiteDatabase = null;
                Cursor cursor = null;
                try {
                    sQLiteDatabase = s();
                    if (sQLiteDatabase == null) {
                        this.b = true;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return false;
                    }
                    sQLiteDatabase.beginTransaction();
                    long j = 0;
                    cursor = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                    if (cursor != null && cursor.moveToFirst()) {
                        j = cursor.getLong(0);
                    }
                    if (j >= 100000) {
                        zzge().r().a("Data loss, local db full");
                        j = (100000 - j) + 1;
                        long delete = (long) sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j)});
                        if (delete != j) {
                            zzge().r().a("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j), Long.valueOf(delete), Long.valueOf(j - delete));
                        }
                    }
                    sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return true;
                } catch (SQLiteFullException e) {
                    zzge().r().a("Error writing entry to local database", e);
                    this.b = true;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (SQLiteDatabaseLockedException e2) {
                    SystemClock.sleep((long) i4);
                    i4 += 20;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (SQLiteException e3) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    zzge().r().a("Error writing entry to local database", e3);
                    this.b = true;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                }
            } else {
                zzge().u().a("Failed to write entry to local database");
                return false;
            }
            i2 = i3 + 1;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final SQLiteDatabase s() {
        if (this.b) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.b = true;
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x00b6 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ec A:{SYNTHETIC, Splitter: B:68:0x00ec} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010c  */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> a(int r15) {
        /*
        r14 = this;
        r14.c();
        r0 = r14.b;
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        r0 = 0;
    L_0x0008:
        return r0;
    L_0x0009:
        r10 = new java.util.ArrayList;
        r10.<init>();
        r0 = r14.getContext();
        r1 = "google_app_measurement_local.db";
        r0 = r0.getDatabasePath(r1);
        r0 = r0.exists();
        if (r0 != 0) goto L_0x0020;
    L_0x001e:
        r0 = r10;
        goto L_0x0008;
    L_0x0020:
        r9 = 5;
        r0 = 0;
        r12 = r0;
    L_0x0023:
        r0 = 5;
        if (r12 >= r0) goto L_0x01dd;
    L_0x0026:
        r1 = 0;
        r11 = 0;
        r0 = r14.s();	 Catch:{ SQLiteFullException -> 0x0215, SQLiteDatabaseLockedException -> 0x020c, SQLiteException -> 0x0201, all -> 0x01ed }
        if (r0 != 0) goto L_0x0038;
    L_0x002e:
        r1 = 1;
        r14.b = r1;	 Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
        if (r0 == 0) goto L_0x0036;
    L_0x0033:
        r0.close();
    L_0x0036:
        r0 = 0;
        goto L_0x0008;
    L_0x0038:
        r0.beginTransaction();	 Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
        r1 = "messages";
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
        r3 = 0;
        r4 = "rowid";
        r2[r3] = r4;	 Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
        r3 = 1;
        r4 = "type";
        r2[r3] = r4;	 Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
        r3 = 2;
        r4 = "entry";
        r2[r3] = r4;	 Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "rowid asc";
        r8 = 100;
        r8 = java.lang.Integer.toString(r8);	 Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
        r4 = -1;
    L_0x0061:
        r1 = r2.moveToNext();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        if (r1 == 0) goto L_0x01a5;
    L_0x0067:
        r1 = 0;
        r4 = r2.getLong(r1);	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r1 = 1;
        r1 = r2.getInt(r1);	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r3 = 2;
        r6 = r2.getBlob(r3);	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        if (r1 != 0) goto L_0x0111;
    L_0x0078:
        r3 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r1 = 0;
        r7 = r6.length;	 Catch:{ ParseException -> 0x00bc }
        r3.unmarshall(r6, r1, r7);	 Catch:{ ParseException -> 0x00bc }
        r1 = 0;
        r3.setDataPosition(r1);	 Catch:{ ParseException -> 0x00bc }
        r1 = com.google.android.gms.internal.measurement.zzeu.CREATOR;	 Catch:{ ParseException -> 0x00bc }
        r1 = r1.createFromParcel(r3);	 Catch:{ ParseException -> 0x00bc }
        r1 = (com.google.android.gms.internal.measurement.zzeu) r1;	 Catch:{ ParseException -> 0x00bc }
        r3.recycle();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        if (r1 == 0) goto L_0x0061;
    L_0x0092:
        r10.add(r1);	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        goto L_0x0061;
    L_0x0096:
        r1 = move-exception;
        r13 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r13;
    L_0x009b:
        r3 = r14.zzge();	 Catch:{ all -> 0x01f8 }
        r3 = r3.r();	 Catch:{ all -> 0x01f8 }
        r4 = "Error reading entries from local database";
        r3.a(r4, r0);	 Catch:{ all -> 0x01f8 }
        r0 = 1;
        r14.b = r0;	 Catch:{ all -> 0x01f8 }
        if (r1 == 0) goto L_0x00b0;
    L_0x00ad:
        r1.close();
    L_0x00b0:
        if (r2 == 0) goto L_0x0220;
    L_0x00b2:
        r2.close();
        r0 = r9;
    L_0x00b6:
        r1 = r12 + 1;
        r12 = r1;
        r9 = r0;
        goto L_0x0023;
    L_0x00bc:
        r1 = move-exception;
        r1 = r14.zzge();	 Catch:{ all -> 0x00e1 }
        r1 = r1.r();	 Catch:{ all -> 0x00e1 }
        r6 = "Failed to load event from local database";
        r1.a(r6);	 Catch:{ all -> 0x00e1 }
        r3.recycle();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        goto L_0x0061;
    L_0x00ce:
        r1 = move-exception;
        r1 = r0;
    L_0x00d0:
        r4 = (long) r9;
        android.os.SystemClock.sleep(r4);	 Catch:{ all -> 0x01fe }
        r0 = r9 + 20;
        if (r2 == 0) goto L_0x00db;
    L_0x00d8:
        r2.close();
    L_0x00db:
        if (r1 == 0) goto L_0x00b6;
    L_0x00dd:
        r1.close();
        goto L_0x00b6;
    L_0x00e1:
        r1 = move-exception;
        r3.recycle();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        throw r1;	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
    L_0x00e6:
        r1 = move-exception;
        r13 = r1;
        r1 = r0;
        r0 = r13;
    L_0x00ea:
        if (r1 == 0) goto L_0x00f5;
    L_0x00ec:
        r3 = r1.inTransaction();	 Catch:{ all -> 0x01fe }
        if (r3 == 0) goto L_0x00f5;
    L_0x00f2:
        r1.endTransaction();	 Catch:{ all -> 0x01fe }
    L_0x00f5:
        r3 = r14.zzge();	 Catch:{ all -> 0x01fe }
        r3 = r3.r();	 Catch:{ all -> 0x01fe }
        r4 = "Error reading entries from local database";
        r3.a(r4, r0);	 Catch:{ all -> 0x01fe }
        r0 = 1;
        r14.b = r0;	 Catch:{ all -> 0x01fe }
        if (r2 == 0) goto L_0x010a;
    L_0x0107:
        r2.close();
    L_0x010a:
        if (r1 == 0) goto L_0x0220;
    L_0x010c:
        r1.close();
        r0 = r9;
        goto L_0x00b6;
    L_0x0111:
        r3 = 1;
        if (r1 != r3) goto L_0x015b;
    L_0x0114:
        r7 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r3 = 0;
        r1 = 0;
        r8 = r6.length;	 Catch:{ ParseException -> 0x0143 }
        r7.unmarshall(r6, r1, r8);	 Catch:{ ParseException -> 0x0143 }
        r1 = 0;
        r7.setDataPosition(r1);	 Catch:{ ParseException -> 0x0143 }
        r1 = com.google.android.gms.internal.measurement.zzjx.CREATOR;	 Catch:{ ParseException -> 0x0143 }
        r1 = r1.createFromParcel(r7);	 Catch:{ ParseException -> 0x0143 }
        r1 = (com.google.android.gms.internal.measurement.zzjx) r1;	 Catch:{ ParseException -> 0x0143 }
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
    L_0x012d:
        if (r1 == 0) goto L_0x0061;
    L_0x012f:
        r10.add(r1);	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        goto L_0x0061;
    L_0x0134:
        r1 = move-exception;
        r13 = r1;
        r1 = r0;
        r0 = r13;
    L_0x0138:
        if (r2 == 0) goto L_0x013d;
    L_0x013a:
        r2.close();
    L_0x013d:
        if (r1 == 0) goto L_0x0142;
    L_0x013f:
        r1.close();
    L_0x0142:
        throw r0;
    L_0x0143:
        r1 = move-exception;
        r1 = r14.zzge();	 Catch:{ all -> 0x0156 }
        r1 = r1.r();	 Catch:{ all -> 0x0156 }
        r6 = "Failed to load user property from local database";
        r1.a(r6);	 Catch:{ all -> 0x0156 }
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r1 = r3;
        goto L_0x012d;
    L_0x0156:
        r1 = move-exception;
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        throw r1;	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
    L_0x015b:
        r3 = 2;
        if (r1 != r3) goto L_0x0196;
    L_0x015e:
        r7 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r3 = 0;
        r1 = 0;
        r8 = r6.length;	 Catch:{ ParseException -> 0x017e }
        r7.unmarshall(r6, r1, r8);	 Catch:{ ParseException -> 0x017e }
        r1 = 0;
        r7.setDataPosition(r1);	 Catch:{ ParseException -> 0x017e }
        r1 = com.google.android.gms.internal.measurement.zzed.CREATOR;	 Catch:{ ParseException -> 0x017e }
        r1 = r1.createFromParcel(r7);	 Catch:{ ParseException -> 0x017e }
        r1 = (com.google.android.gms.internal.measurement.zzed) r1;	 Catch:{ ParseException -> 0x017e }
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
    L_0x0177:
        if (r1 == 0) goto L_0x0061;
    L_0x0179:
        r10.add(r1);	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        goto L_0x0061;
    L_0x017e:
        r1 = move-exception;
        r1 = r14.zzge();	 Catch:{ all -> 0x0191 }
        r1 = r1.r();	 Catch:{ all -> 0x0191 }
        r6 = "Failed to load user property from local database";
        r1.a(r6);	 Catch:{ all -> 0x0191 }
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r1 = r3;
        goto L_0x0177;
    L_0x0191:
        r1 = move-exception;
        r7.recycle();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        throw r1;	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
    L_0x0196:
        r1 = r14.zzge();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r1 = r1.r();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r3 = "Unknown record type in local database";
        r1.a(r3);	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        goto L_0x0061;
    L_0x01a5:
        r1 = "messages";
        r3 = "rowid <= ?";
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r7 = 0;
        r4 = java.lang.Long.toString(r4);	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r6[r7] = r4;	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r1 = r0.delete(r1, r3, r6);	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r3 = r10.size();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        if (r1 >= r3) goto L_0x01ca;
    L_0x01bd:
        r1 = r14.zzge();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r1 = r1.r();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r3 = "Fewer entries removed from local database than expected";
        r1.a(r3);	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
    L_0x01ca:
        r0.setTransactionSuccessful();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        r0.endTransaction();	 Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        if (r2 == 0) goto L_0x01d5;
    L_0x01d2:
        r2.close();
    L_0x01d5:
        if (r0 == 0) goto L_0x01da;
    L_0x01d7:
        r0.close();
    L_0x01da:
        r0 = r10;
        goto L_0x0008;
    L_0x01dd:
        r0 = r14.zzge();
        r0 = r0.u();
        r1 = "Failed to read events from database in reasonable time";
        r0.a(r1);
        r0 = 0;
        goto L_0x0008;
    L_0x01ed:
        r0 = move-exception;
        r2 = r11;
        goto L_0x0138;
    L_0x01f1:
        r1 = move-exception;
        r2 = r11;
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x0138;
    L_0x01f8:
        r0 = move-exception;
        r13 = r1;
        r1 = r2;
        r2 = r13;
        goto L_0x0138;
    L_0x01fe:
        r0 = move-exception;
        goto L_0x0138;
    L_0x0201:
        r0 = move-exception;
        r2 = r11;
        goto L_0x00ea;
    L_0x0205:
        r1 = move-exception;
        r2 = r11;
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x00ea;
    L_0x020c:
        r0 = move-exception;
        r2 = r11;
        goto L_0x00d0;
    L_0x0210:
        r1 = move-exception;
        r2 = r11;
        r1 = r0;
        goto L_0x00d0;
    L_0x0215:
        r0 = move-exception;
        r2 = r1;
        r1 = r11;
        goto L_0x009b;
    L_0x021a:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r11;
        goto L_0x009b;
    L_0x0220:
        r0 = r9;
        goto L_0x00b6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.dl.a(int):java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>");
    }

    public final boolean a(zzed zzed) {
        l();
        byte[] a = ie.a((Parcelable) zzed);
        if (a.length <= 131072) {
            return a(2, a);
        }
        zzge().u().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean a(zzeu zzeu) {
        Parcel obtain = Parcel.obtain();
        zzeu.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return a(0, marshall);
        }
        zzge().u().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean a(zzjx zzjx) {
        Parcel obtain = Parcel.obtain();
        zzjx.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return a(1, marshall);
        }
        zzge().u().a("User property too long for local database. Sending directly to service");
        return false;
    }

    protected final boolean p() {
        return false;
    }

    @WorkerThread
    public final void r() {
        c();
        try {
            int delete = s().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzge().y().a("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzge().r().a("Error resetting local analytics data. error", e);
        }
    }
}

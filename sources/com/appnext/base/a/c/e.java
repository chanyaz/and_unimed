package com.appnext.base.a.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import com.appnext.base.a.b.d;
import com.appnext.base.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class e<MODEL extends d> {
    private static final int gI = -1;
    private static final String gJ = " DESC";

    public enum a {
        Equals(" = ? "),
        GreaterThan(" >= ? "),
        LessThan(" <= ? ");
        
        private String mOperator;

        private a(String str) {
            this.mOperator = str;
        }

        public String bo() {
            return this.mOperator;
        }
    }

    private String a(String[] strArr, List<a> list) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    stringBuilder.append(" AND ");
                }
                stringBuilder.append(strArr[i]);
                stringBuilder.append(((a) list.get(i)).bo());
            }
        } catch (Throwable th) {
            b.a(th);
        }
        return stringBuilder.toString();
    }

    private ContentValues b(JSONObject jSONObject) {
        try {
            ContentValues contentValues = new ContentValues();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                contentValues.put(str, jSONObject.getString(str));
            }
            return contentValues;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    private List<MODEL> e(Cursor cursor) {
        List<MODEL> arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(b(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return arrayList;
    }

    protected int a(String str, String[] strArr, String[] strArr2, List<a> list) {
        int delete;
        SQLiteFullException e;
        Throwable th;
        try {
            SQLiteDatabase aU = com.appnext.base.a.a.a.aT().aU();
            String str2 = null;
            if (strArr != null) {
                str2 = a(strArr, (List) list);
            }
            delete = aU.delete(str, str2, strArr2);
            try {
                com.appnext.base.a.a.a.aT().aV();
            } catch (SQLiteFullException e2) {
                e = e2;
                com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.DatabaseOrDiskFull, new Exception(e.getMessage()));
                return delete;
            } catch (Throwable th2) {
                th = th2;
                com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.Global, new Exception(th.getMessage()));
                return delete;
            }
        } catch (SQLiteFullException e3) {
            SQLiteFullException sQLiteFullException = e3;
            delete = 0;
            e = sQLiteFullException;
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.DatabaseOrDiskFull, new Exception(e.getMessage()));
            return delete;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            delete = 0;
            th = th4;
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.Global, new Exception(th.getMessage()));
            return delete;
        }
        return delete;
    }

    protected long a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        long j = -1;
        try {
            return sQLiteDatabase.insertWithOnConflict(str, null, contentValues, 5);
        } catch (SQLiteFullException e) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.DatabaseOrDiskFull, new Exception(e.getMessage()));
            return j;
        } catch (Throwable th) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.Global, th);
            return j;
        }
    }

    protected long a(String str, ContentValues contentValues) {
        try {
            long insert = com.appnext.base.a.a.a.aT().aU().insert(str, null, contentValues);
            com.appnext.base.a.a.a.aT().aV();
            return insert;
        } catch (SQLiteFullException e) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.DatabaseOrDiskFull, new Exception(e.getMessage()));
            return -1;
        } catch (Throwable th) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.Global, th);
            return -1;
        }
    }

    protected long a(String str, JSONArray jSONArray) {
        long j = -1;
        if (jSONArray != null) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                int length = jSONArray.length();
                sQLiteDatabase = com.appnext.base.a.a.a.aT().aU();
                sQLiteDatabase.beginTransaction();
                int i = 0;
                while (i < length) {
                    i++;
                    j = a(sQLiteDatabase, str, b(jSONArray.getJSONObject(i)));
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                    com.appnext.base.a.a.a.aT().aV();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                    com.appnext.base.a.a.a.aT().aV();
                }
            }
        }
        return j;
    }

    protected long a(String str, JSONObject jSONObject) {
        try {
            long insertWithOnConflict = com.appnext.base.a.a.a.aT().aU().insertWithOnConflict(str, null, b(jSONObject), 5);
            com.appnext.base.a.a.a.aT().aV();
            return insertWithOnConflict;
        } catch (SQLiteFullException e) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.DatabaseOrDiskFull, new Exception(e.getMessage()));
            return -1;
        } catch (Throwable th) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.Global, th);
            return -1;
        }
    }

    protected List<MODEL> a(String str, String[] strArr, String[] strArr2, String str2, List<a> list) {
        try {
            List<MODEL> e = e(com.appnext.base.a.a.a.aT().aU().query(str, bn(), a(strArr, (List) list), strArr2, null, null, str2));
            com.appnext.base.a.a.a.aT().aV();
            return e;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    protected List<MODEL> ah(String str) {
        try {
            List<MODEL> e = e(com.appnext.base.a.a.a.aT().aU().query(str, bn(), null, null, null, null, null));
            com.appnext.base.a.a.a.aT().aV();
            return e;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    protected String ai(String str) {
        return str + gJ;
    }

    protected long b(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        long j = -1;
        try {
            return sQLiteDatabase.insert(str, null, contentValues);
        } catch (SQLiteFullException e) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.DatabaseOrDiskFull, new Exception(e.getMessage()));
            return j;
        } catch (Throwable th) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.Global, th);
            return j;
        }
    }

    protected long b(String str, ContentValues contentValues) {
        try {
            long insertWithOnConflict = com.appnext.base.a.a.a.aT().aU().insertWithOnConflict(str, null, contentValues, 5);
            com.appnext.base.a.a.a.aT().aV();
            return insertWithOnConflict;
        } catch (SQLiteFullException e) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.DatabaseOrDiskFull, new Exception(e.getMessage()));
            return -1;
        } catch (Throwable th) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.Global, th);
            return -1;
        }
    }

    protected long b(String str, JSONArray jSONArray) {
        long j = -1;
        if (jSONArray != null) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                int length = jSONArray.length();
                sQLiteDatabase = com.appnext.base.a.a.a.aT().aU();
                sQLiteDatabase.beginTransaction();
                int i = 0;
                while (i < length) {
                    i++;
                    j = b(sQLiteDatabase, str, b(jSONArray.getJSONObject(i)));
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                    com.appnext.base.a.a.a.aT().aV();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                    com.appnext.base.a.a.a.aT().aV();
                }
            }
        }
        return j;
    }

    protected abstract MODEL b(Cursor cursor);

    protected abstract String[] bn();

    protected void delete(String str) {
        a(str, null, null, null);
    }

    protected void f(String str, String str2) {
        try {
            com.appnext.base.a.a.a.aT().aU().delete(str, str2, null);
            com.appnext.base.a.a.a.aT().aV();
        } catch (SQLiteFullException e) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.DatabaseOrDiskFull, new Exception(e.getMessage()));
        } catch (Throwable th) {
            com.appnext.base.a.a.a.aT().a(com.appnext.base.a.a.a.a.Global, new Exception(th.getMessage()));
        }
    }
}

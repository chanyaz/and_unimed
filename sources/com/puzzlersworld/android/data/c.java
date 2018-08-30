package com.puzzlersworld.android.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import com.google.gson.Gson;
import com.puzzlersworld.wp.dto.Post;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class c {
    Gson a = new Gson();
    private final a b;

    @Inject
    public c(a aVar) {
        this.b = aVar;
    }

    private Post a(Cursor cursor) {
        return (Post) this.a.fromJson(cursor.getString(cursor.getColumnIndex("post_data")), Post.class);
    }

    public int a(Long l) {
        return this.b.getWritableDatabase().delete("saveforlater", "post_id=" + l, null);
    }

    public List<Post> a(int i, int i2) {
        List<Post> arrayList = new ArrayList();
        Cursor rawQuery = this.b.getReadableDatabase().rawQuery("SELECT  * FROM saveforlater order by save_date desc limit " + i2 + " offset " + ((i - 1) * i2), null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(a(rawQuery));
            } while (rawQuery.moveToNext());
        }
        return arrayList;
    }

    public void a(Post post) {
        try {
            Post b = b(post.getID());
            ContentValues contentValues = new ContentValues();
            contentValues.put("post_id", post.getID());
            contentValues.put("save_date", Long.valueOf(new Date().getTime()));
            contentValues.put("post_data", this.a.toJson((Object) post));
            if (b != null) {
                this.b.getWritableDatabase().update("saveforlater", contentValues, "post_id=" + post.getID(), null);
            } else {
                this.b.getWritableDatabase().insert("saveforlater", null, contentValues);
            }
        } catch (Throwable th) {
            Log.e("AndroApp", "Unable to write contact to disk", th);
        }
    }

    public Post b(Long l) {
        Cursor rawQuery = this.b.getReadableDatabase().rawQuery("SELECT  * FROM saveforlater where post_id=" + l, null);
        return rawQuery.moveToFirst() ? a(rawQuery) : null;
    }
}

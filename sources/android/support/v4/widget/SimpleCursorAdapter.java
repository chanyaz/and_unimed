package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter extends ae {
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected int[] j;
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected int[] k;
    String[] l;
    private int m;
    private CursorToStringConverter n;
    private ViewBinder o;

    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i);
    }

    private void a(Cursor cursor, String[] strArr) {
        if (cursor != null) {
            int length = strArr.length;
            if (this.j == null || this.j.length != length) {
                this.j = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.j[i] = cursor.getColumnIndexOrThrow(strArr[i]);
            }
            return;
        }
        this.j = null;
    }

    public Cursor a(Cursor cursor) {
        a(cursor, this.l);
        return super.a(cursor);
    }

    public void a(View view, Context context, Cursor cursor) {
        ViewBinder viewBinder = this.o;
        int length = this.k.length;
        int[] iArr = this.j;
        int[] iArr2 = this.k;
        for (int i = 0; i < length; i++) {
            View findViewById = view.findViewById(iArr2[i]);
            if (findViewById != null) {
                if (viewBinder != null ? viewBinder.setViewValue(findViewById, cursor, iArr[i]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof TextView) {
                        a((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        a((ImageView) findViewById, string);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void a(TextView textView, String str) {
        textView.setText(str);
    }

    public CharSequence convertToString(Cursor cursor) {
        return this.n != null ? this.n.convertToString(cursor) : this.m > -1 ? cursor.getString(this.m) : super.convertToString(cursor);
    }
}

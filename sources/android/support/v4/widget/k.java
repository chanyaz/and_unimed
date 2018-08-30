package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class k extends BaseAdapter implements CursorFilterClient, Filterable {
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected boolean a;
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected boolean b;
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected Cursor c;
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected Context d;
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected int e;
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected l f;
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected DataSetObserver g;
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected CursorFilter h;
    @RestrictTo({Scope.LIBRARY_GROUP})
    protected FilterQueryProvider i;

    public k(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    public Cursor a(Cursor cursor) {
        if (cursor == this.c) {
            return null;
        }
        Cursor cursor2 = this.c;
        if (cursor2 != null) {
            if (this.f != null) {
                cursor2.unregisterContentObserver(this.f);
            }
            if (this.g != null) {
                cursor2.unregisterDataSetObserver(this.g);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            if (this.f != null) {
                cursor.registerContentObserver(this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
            this.e = cursor.getColumnIndexOrThrow("_id");
            this.a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.e = -1;
        this.a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void a() {
        if (this.b && this.c != null && !this.c.isClosed()) {
            this.a = this.c.requery();
        }
    }

    void a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.b = true;
        } else {
            this.b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.c = cursor;
        this.a = z;
        this.d = context;
        this.e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f = new l(this);
            this.g = new m(this);
        } else {
            this.f = null;
            this.g = null;
        }
        if (z) {
            if (this.f != null) {
                cursor.registerContentObserver(this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    public void changeCursor(Cursor cursor) {
        Cursor a = a(cursor);
        if (a != null) {
            a.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public int getCount() {
        return (!this.a || this.c == null) ? 0 : this.c.getCount();
    }

    public Cursor getCursor() {
        return this.c;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.a) {
            return null;
        }
        this.c.moveToPosition(i);
        if (view == null) {
            view = b(this.d, this.c, viewGroup);
        }
        a(view, this.d, this.c);
        return view;
    }

    public Filter getFilter() {
        if (this.h == null) {
            this.h = new CursorFilter(this);
        }
        return this.h;
    }

    public Object getItem(int i) {
        if (!this.a || this.c == null) {
            return null;
        }
        this.c.moveToPosition(i);
        return this.c;
    }

    public long getItemId(int i) {
        return (this.a && this.c != null && this.c.moveToPosition(i)) ? this.c.getLong(this.e) : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.c.moveToPosition(i)) {
            if (view == null) {
                view = a(this.d, this.c, viewGroup);
            }
            a(view, this.d, this.c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public boolean hasStableIds() {
        return true;
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        return this.i != null ? this.i.runQuery(charSequence) : this.c;
    }
}

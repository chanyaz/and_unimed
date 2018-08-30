package android.support.v7.widget;

import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

class ab implements ListAdapter, SpinnerAdapter {
    private SpinnerAdapter a;
    private ListAdapter b;

    public ab(@Nullable SpinnerAdapter spinnerAdapter, @Nullable Theme theme) {
        this.a = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.b = (ListAdapter) spinnerAdapter;
        }
        if (theme == null) {
            return;
        }
        if (VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
            ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
            if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
            ThemedSpinnerAdapter themedSpinnerAdapter2 = (ThemedSpinnerAdapter) spinnerAdapter;
            if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                themedSpinnerAdapter2.setDropDownViewTheme(theme);
            }
        }
    }

    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.b;
        return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
    }

    public int getCount() {
        return this.a == null ? 0 : this.a.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return this.a == null ? null : this.a.getDropDownView(i, view, viewGroup);
    }

    public Object getItem(int i) {
        return this.a == null ? null : this.a.getItem(i);
    }

    public long getItemId(int i) {
        return this.a == null ? -1 : this.a.getItemId(i);
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return getDropDownView(i, view, viewGroup);
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return this.a != null && this.a.hasStableIds();
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public boolean isEnabled(int i) {
        ListAdapter listAdapter = this.b;
        return listAdapter != null ? listAdapter.isEnabled(i) : true;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.a != null) {
            this.a.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.a != null) {
            this.a.unregisterDataSetObserver(dataSetObserver);
        }
    }
}

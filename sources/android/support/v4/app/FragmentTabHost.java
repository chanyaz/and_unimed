package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<ab> a = new ArrayList();
    private Context b;
    private FragmentManager c;
    private int d;
    private OnTabChangeListener e;
    private ab f;
    private boolean g;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
        }
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    @Nullable
    private FragmentTransaction a(@Nullable String str, @Nullable FragmentTransaction fragmentTransaction) {
        ab a = a(str);
        if (this.f != a) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.c.a();
            }
            if (!(this.f == null || this.f.d == null)) {
                fragmentTransaction.b(this.f.d);
            }
            if (a != null) {
                if (a.d == null) {
                    a.d = Fragment.a(this.b, a.b.getName(), a.c);
                    fragmentTransaction.a(this.d, a.d, a.a);
                } else {
                    fragmentTransaction.c(a.d);
                }
            }
            this.f = a;
        }
        return fragmentTransaction;
    }

    @Nullable
    private ab a(String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ab abVar = (ab) this.a.get(i);
            if (abVar.a.equals(str)) {
                return abVar;
            }
        }
        return null;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.d = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ab abVar = (ab) this.a.get(i);
            abVar.d = this.c.a(abVar.a);
            if (!(abVar.d == null || abVar.d.p())) {
                if (abVar.a.equals(currentTabTag)) {
                    this.f = abVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.c.a();
                    }
                    fragmentTransaction.b(abVar.d);
                }
            }
        }
        this.g = true;
        FragmentTransaction a = a(currentTabTag, fragmentTransaction);
        if (a != null) {
            a.c();
            this.c.b();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setCurrentTabByTag(savedState.a);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getCurrentTabTag();
        return savedState;
    }

    public void onTabChanged(String str) {
        if (this.g) {
            FragmentTransaction a = a(str, null);
            if (a != null) {
                a.c();
            }
        }
        if (this.e != null) {
            this.e.onTabChanged(str);
        }
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.e = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}

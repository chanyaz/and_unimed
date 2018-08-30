package android.support.v4.app;

import android.arch.lifecycle.k;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new Creator<FragmentState>() {
        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: a */
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    Fragment l;

    FragmentState(Parcel parcel) {
        boolean z = true;
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.j = z;
        this.k = parcel.readBundle();
    }

    FragmentState(Fragment fragment) {
        this.a = fragment.getClass().getName();
        this.b = fragment.o;
        this.c = fragment.w;
        this.d = fragment.H;
        this.e = fragment.I;
        this.f = fragment.J;
        this.g = fragment.M;
        this.h = fragment.L;
        this.i = fragment.q;
        this.j = fragment.K;
    }

    public Fragment a(o oVar, m mVar, Fragment fragment, y yVar, k kVar) {
        if (this.l == null) {
            Context g = oVar.g();
            if (this.i != null) {
                this.i.setClassLoader(g.getClassLoader());
            }
            if (mVar != null) {
                this.l = mVar.a(g, this.a, this.i);
            } else {
                this.l = Fragment.a(g, this.a, this.i);
            }
            if (this.k != null) {
                this.k.setClassLoader(g.getClassLoader());
                this.l.l = this.k;
            }
            this.l.a(this.b, fragment);
            this.l.w = this.c;
            this.l.y = true;
            this.l.H = this.d;
            this.l.I = this.e;
            this.l.J = this.f;
            this.l.M = this.g;
            this.l.L = this.h;
            this.l.K = this.j;
            this.l.B = oVar.d;
            if (FragmentManagerImpl.a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        this.l.E = yVar;
        this.l.F = kVar;
        return this.l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        if (!this.j) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.k);
    }
}

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new Creator<BackStackState>() {
        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: a */
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    public BackStackState(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }

    public BackStackState(d dVar) {
        int size = dVar.b.size();
        this.a = new int[(size * 6)];
        if (dVar.i) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = (e) dVar.b.get(i2);
                int i3 = i + 1;
                this.a[i] = eVar.a;
                int i4 = i3 + 1;
                this.a[i3] = eVar.b != null ? eVar.b.o : -1;
                int i5 = i4 + 1;
                this.a[i4] = eVar.c;
                i3 = i5 + 1;
                this.a[i5] = eVar.d;
                i5 = i3 + 1;
                this.a[i3] = eVar.e;
                i = i5 + 1;
                this.a[i5] = eVar.f;
            }
            this.b = dVar.g;
            this.c = dVar.h;
            this.d = dVar.k;
            this.e = dVar.m;
            this.f = dVar.n;
            this.g = dVar.o;
            this.h = dVar.p;
            this.i = dVar.q;
            this.j = dVar.r;
            this.k = dVar.s;
            this.l = dVar.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public d a(FragmentManagerImpl fragmentManagerImpl) {
        int i = 0;
        d dVar = new d(fragmentManagerImpl);
        int i2 = 0;
        while (i < this.a.length) {
            e eVar = new e();
            int i3 = i + 1;
            eVar.a = this.a[i];
            if (FragmentManagerImpl.a) {
                Log.v("FragmentManager", "Instantiate " + dVar + " op #" + i2 + " base fragment #" + this.a[i3]);
            }
            int i4 = i3 + 1;
            i = this.a[i3];
            if (i >= 0) {
                eVar.b = (Fragment) fragmentManagerImpl.f.get(i);
            } else {
                eVar.b = null;
            }
            i3 = i4 + 1;
            eVar.c = this.a[i4];
            i4 = i3 + 1;
            eVar.d = this.a[i3];
            i3 = i4 + 1;
            eVar.e = this.a[i4];
            i4 = i3 + 1;
            eVar.f = this.a[i3];
            dVar.c = eVar.c;
            dVar.d = eVar.d;
            dVar.e = eVar.e;
            dVar.f = eVar.f;
            dVar.a(eVar);
            i2++;
            i = i4;
        }
        dVar.g = this.b;
        dVar.h = this.c;
        dVar.k = this.d;
        dVar.m = this.e;
        dVar.i = true;
        dVar.n = this.f;
        dVar.o = this.g;
        dVar.p = this.h;
        dVar.q = this.i;
        dVar.r = this.j;
        dVar.s = this.k;
        dVar.t = this.l;
        dVar.a(1);
        return dVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        if (this.l) {
            i2 = 1;
        }
        parcel.writeInt(i2);
    }
}

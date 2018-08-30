package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new Creator<ResultReceiver>() {
        /* renamed from: a */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        /* renamed from: a */
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    };
    final boolean a;
    final Handler b;
    IResultReceiver c;

    public ResultReceiver(Handler handler) {
        this.a = true;
        this.b = handler;
    }

    ResultReceiver(Parcel parcel) {
        this.a = false;
        this.b = null;
        this.c = b.a(parcel.readStrongBinder());
    }

    protected void a(int i, Bundle bundle) {
    }

    public void b(int i, Bundle bundle) {
        if (this.a) {
            if (this.b != null) {
                this.b.post(new g(this, i, bundle));
            } else {
                a(i, bundle);
            }
        } else if (this.c != null) {
            try {
                this.c.send(i, bundle);
            } catch (RemoteException e) {
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new f(this);
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }
}

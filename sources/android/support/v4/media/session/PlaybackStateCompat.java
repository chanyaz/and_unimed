package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new Creator<PlaybackStateCompat>() {
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: a */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };
    final int a;
    final long b;
    final long c;
    final float d;
    final long e;
    final int f;
    final CharSequence g;
    final long h;
    List<CustomAction> i;
    final long j;
    final Bundle k;
    private Object l;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Actions {
    }

    public final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new Creator<CustomAction>() {
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: a */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };
        private final String a;
        private final CharSequence b;
        private final int c;
        private final Bundle d;
        private Object e;

        CustomAction(Parcel parcel) {
            this.a = parcel.readString();
            this.b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.c = parcel.readInt();
            this.d = parcel.readBundle();
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.a = str;
            this.b = charSequence;
            this.c = i;
            this.d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(ah.a(obj), ah.b(obj), ah.c(obj), ah.d(obj));
            customAction.e = obj;
            return customAction;
        }

        public Object a() {
            if (this.e != null || VERSION.SDK_INT < 21) {
                return this.e;
            }
            this.e = ah.a(this.a, this.b, this.c, this.d);
            return this.e;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.b + ", mIcon=" + this.c + ", mExtras=" + this.d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            TextUtils.writeToParcel(this.b, parcel, i);
            parcel.writeInt(this.c);
            parcel.writeBundle(this.d);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaKeyAction {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShuffleMode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = f;
        this.e = j3;
        this.f = i2;
        this.g = charSequence;
        this.h = j4;
        this.i = new ArrayList(list);
        this.j = j5;
        this.k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readLong();
        this.d = parcel.readFloat();
        this.h = parcel.readLong();
        this.c = parcel.readLong();
        this.e = parcel.readLong();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.j = parcel.readLong();
        this.k = parcel.readBundle();
        this.f = parcel.readInt();
    }

    public static PlaybackStateCompat a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> h = ag.h(obj);
        List list = null;
        if (h != null) {
            list = new ArrayList(h.size());
            for (Object a : h) {
                list.add(CustomAction.a(a));
            }
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(ag.a(obj), ag.b(obj), ag.c(obj), ag.d(obj), ag.e(obj), 0, ag.f(obj), ag.g(obj), list, ag.i(obj), VERSION.SDK_INT >= 22 ? ai.a(obj) : null);
        playbackStateCompat.l = obj;
        return playbackStateCompat;
    }

    public int a() {
        return this.a;
    }

    public long b() {
        return this.e;
    }

    public Object c() {
        if (this.l == null && VERSION.SDK_INT >= 21) {
            List list = null;
            if (this.i != null) {
                list = new ArrayList(this.i.size());
                for (CustomAction a : this.i) {
                    list.add(a.a());
                }
            }
            if (VERSION.SDK_INT >= 22) {
                this.l = ai.a(this.a, this.b, this.c, this.d, this.e, this.g, this.h, list, this.j, this.k);
            } else {
                this.l = ag.a(this.a, this.b, this.c, this.d, this.e, this.g, this.h, list, this.j);
            }
        }
        return this.l;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.a);
        stringBuilder.append(", position=").append(this.b);
        stringBuilder.append(", buffered position=").append(this.c);
        stringBuilder.append(", speed=").append(this.d);
        stringBuilder.append(", updated=").append(this.h);
        stringBuilder.append(", actions=").append(this.e);
        stringBuilder.append(", error code=").append(this.f);
        stringBuilder.append(", error message=").append(this.g);
        stringBuilder.append(", custom actions=").append(this.i);
        stringBuilder.append(", active item id=").append(this.j);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeLong(this.b);
        parcel.writeFloat(this.d);
        parcel.writeLong(this.h);
        parcel.writeLong(this.c);
        parcel.writeLong(this.e);
        TextUtils.writeToParcel(this.g, parcel, i);
        parcel.writeTypedList(this.i);
        parcel.writeLong(this.j);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.f);
    }
}

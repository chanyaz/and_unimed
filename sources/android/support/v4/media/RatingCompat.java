package android.support.v4.media;

import android.media.Rating;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new Creator<RatingCompat>() {
        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: a */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };
    private final int a;
    private final float b;
    private Object c;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    RatingCompat(int i, float f) {
        this.a = i;
        this.b = f;
    }

    public static RatingCompat a(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            return new RatingCompat(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    public static RatingCompat a(int i, float f) {
        float f2;
        switch (i) {
            case 3:
                f2 = 3.0f;
                break;
            case 4:
                f2 = 4.0f;
                break;
            case 5:
                f2 = 5.0f;
                break;
            default:
                Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
        }
        if (f >= 0.0f && f <= f2) {
            return new RatingCompat(i, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 19) {
            return null;
        }
        RatingCompat a;
        int ratingStyle = ((Rating) obj).getRatingStyle();
        if (((Rating) obj).isRated()) {
            switch (ratingStyle) {
                case 1:
                    a = a(((Rating) obj).hasHeart());
                    break;
                case 2:
                    a = b(((Rating) obj).isThumbUp());
                    break;
                case 3:
                case 4:
                case 5:
                    a = a(ratingStyle, ((Rating) obj).getStarRating());
                    break;
                case 6:
                    a = a(((Rating) obj).getPercentRating());
                    break;
                default:
                    return null;
            }
        }
        a = a(ratingStyle);
        a.c = obj;
        return a;
    }

    public static RatingCompat a(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat b(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public int describeContents() {
        return this.a;
    }

    public String toString() {
        return "Rating:style=" + this.a + " rating=" + (this.b < 0.0f ? "unrated" : String.valueOf(this.b));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
    }
}

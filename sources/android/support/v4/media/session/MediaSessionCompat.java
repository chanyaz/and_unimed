package android.support.v4.media.session;

import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.VolumeProviderCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    interface MediaSessionImpl {
        String getCallingPackage();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z);

        void setCallback(v vVar, Handler handler);

        void setCaptioningEnabled(boolean z);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setRepeatMode(int i);

        void setSessionActivity(PendingIntent pendingIntent);

        void setShuffleMode(int i);
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    public final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new Creator<QueueItem>() {
            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: a */
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        };
        private final MediaDescriptionCompat a;
        private final long b;
        private Object c;

        QueueItem(Parcel parcel) {
            this.a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.b = parcel.readLong();
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.a = mediaDescriptionCompat;
                this.b = j;
                this.c = obj;
            }
        }

        public static QueueItem a(Object obj) {
            return (obj == null || VERSION.SDK_INT < 21) ? null : new QueueItem(obj, MediaDescriptionCompat.a(ac.a(obj)), ac.b(obj));
        }

        public static List<QueueItem> a(List<?> list) {
            if (list == null || VERSION.SDK_INT < 21) {
                return null;
            }
            List<QueueItem> arrayList = new ArrayList();
            for (Object a : list) {
                arrayList.add(a(a));
            }
            return arrayList;
        }

        public MediaDescriptionCompat a() {
            return this.a;
        }

        public Object b() {
            if (this.c != null || VERSION.SDK_INT < 21) {
                return this.c;
            }
            this.c = ac.a(this.a.b(), this.b);
            return this.c;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.a + ", Id=" + this.b + " }";
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.a.writeToParcel(parcel, i);
            parcel.writeLong(this.b);
        }
    }

    final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new Creator<ResultReceiverWrapper>() {
            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: a */
            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        };
        private ResultReceiver a;

        ResultReceiverWrapper(Parcel parcel) {
            this.a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.a = resultReceiver;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.a.writeToParcel(parcel, i);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    public final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new Creator<Token>() {
            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                return new Token(VERSION.SDK_INT >= 21 ? parcel.readParcelable(null) : parcel.readStrongBinder());
            }

            /* renamed from: a */
            public Token[] newArray(int i) {
                return new Token[i];
            }
        };
        private final Object a;
        private final IMediaSession b;

        Token(Object obj) {
            this(obj, null);
        }

        Token(Object obj, IMediaSession iMediaSession) {
            this.a = obj;
            this.b = iMediaSession;
        }

        public static Token a(Object obj) {
            return a(obj, null);
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public static Token a(Object obj, IMediaSession iMediaSession) {
            return (obj == null || VERSION.SDK_INT < 21) ? null : new Token(MediaSessionCompatApi21.a(obj), iMediaSession);
        }

        public Object a() {
            return this.a;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public IMediaSession b() {
            return this.b;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            return this.a == null ? token.a == null : token.a == null ? false : this.a.equals(token.a);
        }

        public int hashCode() {
            return this.a == null ? 0 : this.a.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.a);
            }
        }
    }
}

package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {
    static final boolean a = Log.isLoggable("MediaBrowserCompat", 3);
    private final MediaBrowserImpl b;

    public class ConnectionCallback {
        final Object a;
        ConnectionCallbackInternal b;

        interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public ConnectionCallback() {
            if (VERSION.SDK_INT >= 21) {
                this.a = MediaBrowserCompatApi21.a(new d(this));
            } else {
                this.a = null;
            }
        }

        public void a() {
        }

        void a(ConnectionCallbackInternal connectionCallbackInternal) {
            this.b = connectionCallbackInternal;
        }

        public void b() {
        }

        public void c() {
        }
    }

    class CustomActionResultReceiver extends ResultReceiver {
        private final String d;
        private final Bundle e;
        private final e f;

        CustomActionResultReceiver(String str, Bundle bundle, e eVar, Handler handler) {
            super(handler);
            this.d = str;
            this.e = bundle;
            this.f = eVar;
        }

        protected void a(int i, Bundle bundle) {
            if (this.f != null) {
                switch (i) {
                    case -1:
                        this.f.c(this.d, this.e, bundle);
                        return;
                    case 0:
                        this.f.b(this.d, this.e, bundle);
                        return;
                    case 1:
                        this.f.a(this.d, this.e, bundle);
                        return;
                    default:
                        Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.e + ", resultData=" + bundle + ")");
                        return;
                }
            }
        }
    }

    class ItemReceiver extends ResultReceiver {
        private final String d;
        private final f e;

        ItemReceiver(String str, f fVar, Handler handler) {
            super(handler);
            this.d = str;
            this.e = fVar;
        }

        protected void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null && bundle.containsKey("media_item")) {
                Parcelable parcelable = bundle.getParcelable("media_item");
                if (parcelable == null || (parcelable instanceof MediaItem)) {
                    this.e.a((MediaItem) parcelable);
                    return;
                } else {
                    this.e.a(this.d);
                    return;
                }
            }
            this.e.a(this.d);
        }
    }

    interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @Nullable
        Bundle getExtras();

        void getItem(@NonNull String str, @NonNull f fVar);

        @NonNull
        String getRoot();

        ComponentName getServiceComponent();

        @NonNull
        Token getSessionToken();

        boolean isConnected();

        void search(@NonNull String str, Bundle bundle, @NonNull m mVar);

        void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable e eVar);

        void subscribe(@NonNull String str, @Nullable Bundle bundle, @NonNull p pVar);

        void unsubscribe(@NonNull String str, p pVar);
    }

    interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger messenger);

        void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle);

        void onServiceConnected(Messenger messenger, String str, Token token, Bundle bundle);
    }

    public class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: a */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        private final int a;
        private final MediaDescriptionCompat b;

        @RestrictTo({Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Flags {
        }

        MediaItem(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (TextUtils.isEmpty(mediaDescriptionCompat.a())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            } else {
                this.a = i;
                this.b = mediaDescriptionCompat;
            }
        }

        public static MediaItem a(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            return new MediaItem(MediaDescriptionCompat.a(t.b(obj)), t.a(obj));
        }

        public static List<MediaItem> a(List<?> list) {
            if (list == null || VERSION.SDK_INT < 21) {
                return null;
            }
            List<MediaItem> arrayList = new ArrayList(list.size());
            for (Object a : list) {
                arrayList.add(a(a));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=").append(this.a);
            stringBuilder.append(", mDescription=").append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            this.b.writeToParcel(parcel, i);
        }
    }

    class SearchResultReceiver extends ResultReceiver {
        private final String d;
        private final Bundle e;
        private final m f;

        SearchResultReceiver(String str, Bundle bundle, m mVar, Handler handler) {
            super(handler);
            this.d = str;
            this.e = bundle;
            this.f = mVar;
        }

        protected void a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null && bundle.containsKey("search_results")) {
                Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
                List list = null;
                if (parcelableArray != null) {
                    List arrayList = new ArrayList();
                    for (Parcelable parcelable : parcelableArray) {
                        arrayList.add((MediaItem) parcelable);
                    }
                    list = arrayList;
                }
                this.f.a(this.d, this.e, list);
                return;
            }
            this.f.a(this.d, this.e);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        if (VERSION.SDK_INT >= 26) {
            this.b = new j(context, componentName, connectionCallback, bundle);
        } else if (VERSION.SDK_INT >= 23) {
            this.b = new i(context, componentName, connectionCallback, bundle);
        } else if (VERSION.SDK_INT >= 21) {
            this.b = new h(context, componentName, connectionCallback, bundle);
        } else {
            this.b = new k(context, componentName, connectionCallback, bundle);
        }
    }

    public void a() {
        this.b.connect();
    }

    public void b() {
        this.b.disconnect();
    }

    @NonNull
    public Token c() {
        return this.b.getSessionToken();
    }
}

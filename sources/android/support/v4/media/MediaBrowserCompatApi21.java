package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import java.util.List;

@RequiresApi(21)
class MediaBrowserCompatApi21 {

    interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    interface SubscriptionCallback {
        void onChildrenLoaded(@NonNull String str, List<?> list);

        void onError(@NonNull String str);
    }

    MediaBrowserCompatApi21() {
    }

    public static Object a(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (android.media.browse.MediaBrowser.ConnectionCallback) obj, bundle);
    }

    public static Object a(ConnectionCallback connectionCallback) {
        return new s(connectionCallback);
    }

    public static Object a(SubscriptionCallback subscriptionCallback) {
        return new u(subscriptionCallback);
    }

    public static void a(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    public static void a(Object obj, String str) {
        ((MediaBrowser) obj).unsubscribe(str);
    }

    public static void a(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).subscribe(str, (android.media.browse.MediaBrowser.SubscriptionCallback) obj2);
    }

    public static void b(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    public static boolean c(Object obj) {
        return ((MediaBrowser) obj).isConnected();
    }

    public static ComponentName d(Object obj) {
        return ((MediaBrowser) obj).getServiceComponent();
    }

    public static String e(Object obj) {
        return ((MediaBrowser) obj).getRoot();
    }

    public static Bundle f(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    public static Object g(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }
}

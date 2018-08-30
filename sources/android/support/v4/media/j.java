package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.media.MediaBrowserCompat.ConnectionCallback;

@RequiresApi(26)
class j extends i {
    j(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        super(context, componentName, connectionCallback, bundle);
    }

    public void subscribe(@NonNull String str, @Nullable Bundle bundle, @NonNull p pVar) {
        if (this.f != null && this.e >= 2) {
            super.subscribe(str, bundle, pVar);
        } else if (bundle == null) {
            MediaBrowserCompatApi21.a(this.b, str, pVar.b);
        } else {
            MediaBrowserCompatApi26.a(this.b, str, bundle, pVar.b);
        }
    }

    public void unsubscribe(@NonNull String str, p pVar) {
        if (this.f != null && this.e >= 2) {
            super.unsubscribe(str, pVar);
        } else if (pVar == null) {
            MediaBrowserCompatApi21.a(this.b, str);
        } else {
            MediaBrowserCompatApi26.a(this.b, str, pVar.b);
        }
    }
}

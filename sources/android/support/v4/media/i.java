package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.media.MediaBrowserCompat.ConnectionCallback;

@RequiresApi(23)
class i extends h {
    i(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        super(context, componentName, connectionCallback, bundle);
    }

    public void getItem(@NonNull String str, @NonNull f fVar) {
        if (this.f == null) {
            MediaBrowserCompatApi23.a(this.b, str, fVar.a);
        } else {
            super.getItem(str, fVar);
        }
    }
}

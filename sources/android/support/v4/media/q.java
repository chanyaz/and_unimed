package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import java.util.Collections;
import java.util.List;

class q implements SubscriptionCallback {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    List<MediaItem> a(List<MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int i4 = i3 + i2;
        if (i < 0 || i2 < 1 || i3 >= list.size()) {
            return Collections.EMPTY_LIST;
        }
        if (i4 > list.size()) {
            i4 = list.size();
        }
        return list.subList(i3, i4);
    }

    public void onChildrenLoaded(@NonNull String str, List<?> list) {
        o oVar = this.a.a == null ? null : (o) this.a.a.get();
        if (oVar == null) {
            this.a.a(str, MediaItem.a((List) list));
            return;
        }
        List a = MediaItem.a((List) list);
        List c = oVar.c();
        List b = oVar.b();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < c.size()) {
                Bundle bundle = (Bundle) b.get(i2);
                if (bundle == null) {
                    this.a.a(str, a);
                } else {
                    this.a.a(str, a(a, bundle), bundle);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void onError(@NonNull String str) {
        this.a.a(str);
    }
}

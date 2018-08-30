package android.support.v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.a;
import android.support.v4.util.o;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean a = Log.isLoggable("MBServiceCompat", 3);
    final a<IBinder, z> b = new a();
    z c;
    final ad d = new ad(this);
    Token e;

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(Token token);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    @interface ResultFlags {
    }

    interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, Token token, Bundle bundle);

        void onConnectFailed();

        void onLoadChildren(String str, List<MediaItem> list, Bundle bundle);
    }

    @Nullable
    public abstract y a(@NonNull String str, int i, @Nullable Bundle bundle);

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

    public void a(@NonNull String str, Bundle bundle, @NonNull aa<List<MediaItem>> aaVar) {
        aaVar.a(4);
        aaVar.b(null);
    }

    void a(String str, Bundle bundle, z zVar, final ResultReceiver resultReceiver) {
        aa anonymousClass3 = new aa<List<MediaItem>>(str) {
            void a(List<MediaItem> list) {
                if ((b() & 4) != 0 || list == null) {
                    resultReceiver.b(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaItem[0]));
                resultReceiver.b(0, bundle);
            }
        };
        this.c = zVar;
        a(str, bundle, anonymousClass3);
        this.c = null;
        if (!anonymousClass3.a()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    public abstract void a(@NonNull String str, @NonNull aa<List<MediaItem>> aaVar);

    public void a(@NonNull String str, @NonNull aa<List<MediaItem>> aaVar, @NonNull Bundle bundle) {
        aaVar.a(1);
        a(str, (aa) aaVar);
    }

    void a(String str, z zVar, Bundle bundle) {
        final z zVar2 = zVar;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        aa anonymousClass1 = new aa<List<MediaItem>>(str) {
            void a(List<MediaItem> list) {
                if (MediaBrowserServiceCompat.this.b.get(zVar2.c.asBinder()) == zVar2) {
                    List list2;
                    if ((b() & 1) != 0) {
                        list2 = MediaBrowserServiceCompat.this.a((List) list2, bundle2);
                    }
                    try {
                        zVar2.c.onLoadChildren(str2, list2, bundle2);
                    } catch (RemoteException e) {
                        Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str2 + " package=" + zVar2.a);
                    }
                } else if (MediaBrowserServiceCompat.a) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + zVar2.a + " id=" + str2);
                }
            }
        };
        this.c = zVar;
        if (bundle == null) {
            a(str, anonymousClass1);
        } else {
            a(str, anonymousClass1, bundle);
        }
        this.c = null;
        if (!anonymousClass1.a()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + zVar.a + " id=" + str);
        }
    }

    void a(String str, z zVar, IBinder iBinder, Bundle bundle) {
        List list = (List) zVar.e.get(str);
        List<o> arrayList = list == null ? new ArrayList() : list;
        for (o oVar : arrayList) {
            if (iBinder == oVar.a && x.a(bundle, (Bundle) oVar.b)) {
                return;
            }
        }
        arrayList.add(new o(iBinder, bundle));
        zVar.e.put(str, arrayList);
        a(str, zVar, bundle);
    }

    void a(String str, z zVar, final ResultReceiver resultReceiver) {
        aa anonymousClass2 = new aa<MediaItem>(str) {
            void a(MediaItem mediaItem) {
                if ((b() & 2) != 0) {
                    resultReceiver.b(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", mediaItem);
                resultReceiver.b(0, bundle);
            }
        };
        this.c = zVar;
        b(str, anonymousClass2);
        this.c = null;
        if (!anonymousClass2.a()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    boolean a(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    boolean a(String str, z zVar, IBinder iBinder) {
        if (iBinder == null) {
            return zVar.e.remove(str) != null;
        } else {
            boolean z;
            List list = (List) zVar.e.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                z = false;
                while (it.hasNext()) {
                    if (iBinder == ((o) it.next()).a) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    zVar.e.remove(str);
                }
            } else {
                z = false;
            }
            return z;
        }
    }

    public void b(@NonNull String str, Bundle bundle, @NonNull aa<Bundle> aaVar) {
        aaVar.c(null);
    }

    void b(String str, Bundle bundle, z zVar, final ResultReceiver resultReceiver) {
        aa anonymousClass4 = new aa<Bundle>(str) {
            void a(Bundle bundle) {
                resultReceiver.b(0, bundle);
            }

            void b(Bundle bundle) {
                resultReceiver.b(-1, bundle);
            }
        };
        this.c = zVar;
        b(str, bundle, anonymousClass4);
        this.c = null;
        if (!anonymousClass4.a()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    public void b(String str, @NonNull aa<MediaItem> aaVar) {
        aaVar.a(2);
        aaVar.b(null);
    }
}

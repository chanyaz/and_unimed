package android.support.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.text.TextUtils;

public class b {
    private final ICustomTabsService a;
    private final ComponentName b;

    @RestrictTo({Scope.LIBRARY_GROUP})
    b(ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.a = iCustomTabsService;
        this.b = componentName;
    }

    public static boolean a(Context context, String str, e eVar) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, eVar, 33);
    }

    public f a(final a aVar) {
        ICustomTabsCallback anonymousClass1 = new h() {
            private Handler c = new Handler(Looper.getMainLooper());

            public void extraCallback(final String str, final Bundle bundle) {
                if (aVar != null) {
                    this.c.post(new Runnable() {
                        public void run() {
                            aVar.a(str, bundle);
                        }
                    });
                }
            }

            public void onMessageChannelReady(final Bundle bundle) {
                if (aVar != null) {
                    this.c.post(new Runnable() {
                        public void run() {
                            aVar.a(bundle);
                        }
                    });
                }
            }

            public void onNavigationEvent(final int i, final Bundle bundle) {
                if (aVar != null) {
                    this.c.post(new Runnable() {
                        public void run() {
                            aVar.a(i, bundle);
                        }
                    });
                }
            }

            public void onPostMessage(final String str, final Bundle bundle) {
                if (aVar != null) {
                    this.c.post(new Runnable() {
                        public void run() {
                            aVar.b(str, bundle);
                        }
                    });
                }
            }
        };
        try {
            return !this.a.newSession(anonymousClass1) ? null : new f(this.a, anonymousClass1, this.b);
        } catch (RemoteException e) {
            return null;
        }
    }

    public boolean a(long j) {
        try {
            return this.a.warmup(j);
        } catch (RemoteException e) {
            return false;
        }
    }
}

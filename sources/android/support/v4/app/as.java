package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat.Action;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiresApi(16)
class as {
    private static final Object a = new Object();
    private static Field b;
    private static boolean c;
    private static final Object d = new Object();

    as() {
    }

    public static Bundle a(Builder builder, Action action) {
        builder.addAction(action.a(), action.b(), action.c());
        Bundle bundle = new Bundle(action.d());
        if (action.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(action.f()));
        }
        if (action.g() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(action.g()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.e());
        return bundle;
    }

    public static Bundle a(Notification notification) {
        synchronized (a) {
            if (c) {
                return null;
            }
            try {
                if (b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                c = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                c = true;
                return null;
            }
        }
    }

    private static Bundle a(au auVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", auVar.a());
        bundle.putCharSequence("label", auVar.b());
        bundle.putCharSequenceArray("choices", auVar.c());
        bundle.putBoolean("allowFreeFormInput", auVar.e());
        bundle.putBundle("extras", auVar.f());
        Set<String> d = auVar.d();
        if (!(d == null || d.isEmpty())) {
            ArrayList arrayList = new ArrayList(d.size());
            for (String add : d) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    private static Bundle[] a(au[] auVarArr) {
        if (auVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[auVarArr.length];
        for (int i = 0; i < auVarArr.length; i++) {
            bundleArr[i] = a(auVarArr[i]);
        }
        return bundleArr;
    }
}

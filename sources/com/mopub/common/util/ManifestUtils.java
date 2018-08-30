package com.mopub.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.appnext.base.b.c;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import java.util.ArrayList;
import java.util.List;

public class ManifestUtils {
    private static final List<Class<? extends Activity>> a = new ArrayList(4);
    private static b b = new b();
    private static final List<Class<? extends Activity>> c = new ArrayList(1);

    static {
        a.add(MoPubActivity.class);
        a.add(MraidActivity.class);
        a.add(MraidVideoPlayerActivity.class);
        a.add(MoPubBrowser.class);
        c.add(MoPubBrowser.class);
    }

    private ManifestUtils() {
    }

    private static a a(@NonNull Context context, @NonNull Class<? extends Activity> cls) {
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new ComponentName(context, cls.getName()), 0);
        a aVar = new a();
        aVar.hasKeyboardHidden = b.hasFlag(cls, activityInfo.configChanges, 32);
        aVar.hasOrientation = b.hasFlag(cls, activityInfo.configChanges, 128);
        aVar.hasScreenSize = true;
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB_MR2) && context.getApplicationInfo().targetSdkVersion >= VersionCode.HONEYCOMB_MR2.getApiLevel()) {
            aVar.hasScreenSize = b.hasFlag(cls, activityInfo.configChanges, c.jk);
        }
        return aVar;
    }

    private static List<Class<? extends Activity>> a(@NonNull Context context, @NonNull List<Class<? extends Activity>> list, boolean z) {
        List<Class<? extends Activity>> arrayList = new ArrayList();
        for (Class cls : list) {
            if (Intents.deviceCanHandleIntent(context, new Intent(context, cls)) == z) {
                arrayList.add(cls);
            }
        }
        return arrayList;
    }

    private static void a(@NonNull Context context) {
        if (isDebuggable(context)) {
            String str = "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities and configuration.";
            Toast makeText = Toast.makeText(context, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities and configuration.", 1);
            makeText.setGravity(7, 0, 0);
            makeText.show();
        }
    }

    @VisibleForTesting
    static void a(@NonNull Context context, @NonNull List<Class<? extends Activity>> list) {
        List a = a(context, list, false);
        if (!a.isEmpty()) {
            a(context);
            a(a);
        }
    }

    private static void a(@NonNull List<Class<? extends Activity>> list) {
        StringBuilder stringBuilder = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
        for (Class name : list) {
            stringBuilder.append("\n\t").append(name.getName());
        }
        stringBuilder.append("\n\nPlease update your manifest to include them.");
        MoPubLog.w(stringBuilder.toString());
    }

    @VisibleForTesting
    static void b(@NonNull Context context, @NonNull List<Class<? extends Activity>> list) {
        List c = c(context, a(context, list, true));
        if (!c.isEmpty()) {
            a(context);
            d(context, c);
        }
    }

    @TargetApi(13)
    private static List<Class<? extends Activity>> c(@NonNull Context context, @NonNull List<Class<? extends Activity>> list) {
        List<Class<? extends Activity>> arrayList = new ArrayList();
        for (Class cls : list) {
            try {
                a a = a(context, cls);
                if (!a.hasKeyboardHidden || !a.hasOrientation || !a.hasScreenSize) {
                    arrayList.add(cls);
                }
            } catch (NameNotFoundException e) {
            }
        }
        return arrayList;
    }

    public static void checkNativeActivitiesDeclared(@NonNull Context context) {
        if (NoThrow.checkNotNull(context, "context is not allowed to be null")) {
            a(context, c);
            b(context, c);
        }
    }

    public static void checkWebViewActivitiesDeclared(@NonNull Context context) {
        if (NoThrow.checkNotNull(context, "context is not allowed to be null")) {
            a(context, a);
            b(context, a);
        }
    }

    private static void d(@NonNull Context context, @NonNull List<Class<? extends Activity>> list) {
        StringBuilder stringBuilder = new StringBuilder("In AndroidManifest, the android:configChanges param is missing values for the following MoPub activities:\n");
        for (Class cls : list) {
            try {
                a a = a(context, cls);
                if (!a.hasKeyboardHidden) {
                    stringBuilder.append("\n\tThe android:configChanges param for activity " + cls.getName() + " must include keyboardHidden.");
                }
                if (!a.hasOrientation) {
                    stringBuilder.append("\n\tThe android:configChanges param for activity " + cls.getName() + " must include orientation.");
                }
                if (!a.hasScreenSize) {
                    stringBuilder.append("\n\tThe android:configChanges param for activity " + cls.getName() + " must include screenSize.");
                }
            } catch (NameNotFoundException e) {
            }
        }
        stringBuilder.append("\n\nPlease update your manifest to include them.");
        MoPubLog.w(stringBuilder.toString());
    }

    public static boolean isDebuggable(@NonNull Context context) {
        return Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, 2);
    }
}

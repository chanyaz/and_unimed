package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.ano;
import com.google.android.gms.internal.ads.anq;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.auo;
import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzpw;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyc;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class r {
    @Nullable
    public static View a(@Nullable gr grVar) {
        if (grVar == null) {
            kk.c("AdState is null");
            return null;
        } else if (b(grVar) && grVar.b != null) {
            return grVar.b.getView();
        } else {
            try {
                IObjectWrapper view = grVar.p != null ? grVar.p.getView() : null;
                if (view != null) {
                    return (View) c.a(view);
                }
                kk.e("View in mediation adapter is null.");
                return null;
            } catch (Throwable e) {
                kk.c("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    @VisibleForTesting
    static zzv<zzaqw> a(@Nullable zzxz zzxz, @Nullable zzyc zzyc, d dVar) {
        return new w(zzxz, dVar, zzyc);
    }

    @Nullable
    private static zzpw a(Object obj) {
        return obj instanceof IBinder ? aoq.a((IBinder) obj) : null;
    }

    private static String a(@Nullable Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            kk.e("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        encodeToString = String.valueOf(encodeToString);
        return encodeToString.length() != 0 ? valueOf.concat(encodeToString) : new String(valueOf);
    }

    @VisibleForTesting
    private static String a(@Nullable zzpw zzpw) {
        if (zzpw == null) {
            kk.e("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzpw.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            kk.e("Unable to get image uri. Trying data uri next");
        }
        return b(zzpw);
    }

    private static JSONObject a(@Nullable Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (bundle.containsKey(str2)) {
                if ("image".equals(jSONObject2.getString(str2))) {
                    Object obj = bundle.get(str2);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(str2, a((Bitmap) obj));
                    } else {
                        kk.e("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(str2) instanceof Bitmap) {
                    kk.e("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(str2, String.valueOf(bundle.get(str2)));
                }
            }
        }
        return jSONObject;
    }

    public static boolean a(zzaqw zzaqw, auo auo, CountDownLatch countDownLatch) {
        boolean z;
        try {
            View view = zzaqw.getView();
            if (view == null) {
                kk.e("AdWebView is null");
                z = false;
            } else {
                view.setVisibility(4);
                List list = auo.b.r;
                if (list == null || list.isEmpty()) {
                    kk.e("No template ids present in mediation response");
                    z = false;
                } else {
                    zzaqw.zza("/nativeExpressAssetsLoaded", new u(countDownLatch));
                    zzaqw.zza("/nativeExpressAssetsLoadingFailed", new v(countDownLatch));
                    zzxz zzmo = auo.c.zzmo();
                    zzyc zzmp = auo.c.zzmp();
                    if (list.contains("2") && zzmo != null) {
                        zzaqw.zzuf().zza(new s(new ano(zzmo.getHeadline(), zzmo.getImages(), zzmo.getBody(), zzmo.zzjz(), zzmo.getCallToAction(), zzmo.getStarRating(), zzmo.getStore(), zzmo.getPrice(), null, zzmo.getExtras(), null, zzmo.zzmw() != null ? (View) c.a(zzmo.zzmw()) : null, zzmo.zzke(), null), auo.b.q, zzaqw));
                    } else if (!list.contains("1") || zzmp == null) {
                        kk.e("No matching template id and mapper");
                        z = false;
                    } else {
                        zzaqw.zzuf().zza(new t(new anq(zzmp.getHeadline(), zzmp.getImages(), zzmp.getBody(), zzmp.zzkg(), zzmp.getCallToAction(), zzmp.getAdvertiser(), null, zzmp.getExtras(), null, zzmp.zzmw() != null ? (View) c.a(zzmp.zzmw()) : null, zzmp.zzke(), null), auo.b.q, zzaqw));
                    }
                    String str = auo.b.o;
                    String str2 = auo.b.p;
                    if (str2 != null) {
                        zzaqw.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                    } else {
                        zzaqw.loadData(str, "text/html", "UTF-8");
                    }
                    z = true;
                }
            }
        } catch (Throwable e) {
            kk.c("Unable to invoke load assets", e);
            z = false;
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    private static String b(zzpw zzpw) {
        try {
            IObjectWrapper zzjy = zzpw.zzjy();
            if (zzjy == null) {
                kk.e("Drawable is null. Returning empty string");
                return "";
            }
            Drawable drawable = (Drawable) c.a(zzjy);
            if (drawable instanceof BitmapDrawable) {
                return a(((BitmapDrawable) drawable).getBitmap());
            }
            kk.e("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return "";
        } catch (RemoteException e) {
            kk.e("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    private static void b(zzaqw zzaqw) {
        OnClickListener onClickListener = zzaqw.getOnClickListener();
        if (onClickListener != null) {
            onClickListener.onClick(zzaqw.getView());
        }
    }

    public static boolean b(@Nullable gr grVar) {
        return (grVar == null || !grVar.n || grVar.o == null || grVar.o.o == null) ? false : true;
    }
}

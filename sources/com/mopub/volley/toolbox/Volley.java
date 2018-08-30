package com.mopub.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.mopub.volley.RequestQueue;
import java.io.File;

public class Volley {
    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, null);
    }

    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
        }
        if (httpStack == null) {
            httpStack = VERSION.SDK_INT >= 9 ? new HurlStack() : new HttpClientStack(AndroidHttpClient.newInstance(str));
        }
        RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(file), new BasicNetwork(httpStack));
        requestQueue.start();
        return requestQueue;
    }
}

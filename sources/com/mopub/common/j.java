package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.GpsHelper.GpsHelperListener;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;

class j extends AsyncTask<Void, Void, Void> {
    private WeakReference<Context> a;
    private WeakReference<GpsHelperListener> b;

    public j(Context context, GpsHelperListener gpsHelperListener) {
        this.a = new WeakReference(context);
        this.b = new WeakReference(gpsHelperListener);
    }

    /* renamed from: a */
    protected Void doInBackground(Void... voidArr) {
        try {
            Context context = (Context) this.a.get();
            if (context != null) {
                Object execute = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(GpsHelper.b)).addParam(Context.class, context).execute();
                if (execute != null) {
                    GpsHelper.a(context, execute);
                }
            }
        } catch (Exception e) {
            MoPubLog.d("Unable to obtain Google AdvertisingIdClient.Info via reflection.");
        }
        return null;
    }

    /* renamed from: a */
    protected void onPostExecute(Void voidR) {
        GpsHelperListener gpsHelperListener = (GpsHelperListener) this.b.get();
        if (gpsHelperListener != null) {
            gpsHelperListener.onFetchAdInfoCompleted();
        }
    }
}

package com.appnext.base.operations.imp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.b.i;
import com.appnext.base.operations.a;
import com.google.android.gms.awareness.Awareness;
import com.google.android.gms.awareness.snapshot.WeatherResult;
import com.google.android.gms.awareness.state.Weather;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.ResultCallback;
import java.util.ArrayList;
import java.util.List;

public class ulwc extends a {
    private static final int hg = 1;
    private static final int hh = 2;
    private GoogleApiClient hi;
    private int hj = 0;
    private List<Integer> hk;

    public ulwc(c cVar, Bundle bundle) {
        super(cVar, bundle);
        bK();
    }

    private void bK() {
        this.hk = new ArrayList();
        this.hk.add(Integer.valueOf(5));
        this.hk.add(Integer.valueOf(8));
        this.hk.add(Integer.valueOf(6));
        this.hk.add(Integer.valueOf(7));
        this.hk.add(Integer.valueOf(2));
    }

    private void bL() {
        Awareness.SnapshotApi.getWeather(this.hi).a(new ResultCallback<WeatherResult>() {
            public void onResult(@NonNull WeatherResult weatherResult) {
                if (weatherResult.getStatus().c()) {
                    Weather weather = weatherResult.getWeather();
                    if (weather != null) {
                        Log.e("Weather", weather.toString());
                    }
                    int[] conditions = weather.getConditions();
                    if (conditions != null) {
                        for (int valueOf : conditions) {
                            if (ulwc.this.hk.contains(Integer.valueOf(valueOf))) {
                                ulwc.this.d(1);
                                return;
                            }
                        }
                        ulwc.this.d(2);
                        return;
                    }
                    return;
                }
                ulwc.this.bC();
            }
        });
    }

    private void d(final int i) {
        new Thread(new Runnable() {
            public void run() {
                if (i.cE().getInt(ulwc.class.getSimpleName(), 0) != i) {
                    i.cE().putInt(ulwc.class.getSimpleName(), i);
                    ulwc.this.hj = i;
                    ulwc.this.c();
                    return;
                }
                ulwc.this.bC();
            }
        }).start();
    }

    public void bB() {
        if (hasPermission()) {
            this.hi = new com.google.android.gms.common.api.i(d.getContext()).a(Awareness.API).a(new ConnectionCallbacks() {
                public void onConnected(@Nullable Bundle bundle) {
                    ulwc.this.bL();
                }

                public void onConnectionSuspended(int i) {
                    ulwc.this.bC();
                }
            }).a(new OnConnectionFailedListener() {
                public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                    ulwc.this.bC();
                }
            }).b();
            this.hi.b();
            return;
        }
        com.appnext.base.operations.d.bG().a(this);
    }

    public void bC() {
        if (this.hi != null && this.hi.d()) {
            this.hi.c();
        }
    }

    protected List<b> getData() {
        if (this.hj != 1 && this.hj != 2) {
            return null;
        }
        List<b> arrayList = new ArrayList();
        arrayList.add(new b(ulwc.class.getSimpleName(), String.valueOf(this.hj), com.appnext.base.b.c.a.Integer.getType()));
        return arrayList;
    }

    public boolean hasPermission() {
        return f.g(d.getContext().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION");
    }
}

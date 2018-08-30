package com.appnext.base.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.appnext.base.a.a.a;
import com.appnext.base.b;
import com.appnext.base.b.c;
import com.appnext.base.b.d;
import com.appnext.base.b.e;
import com.appnext.base.b.i;
import com.appnext.base.b.k;
import com.google.android.gms.location.ActivityRecognitionResult;
import java.util.ArrayList;

public class OperationService extends IntentService {
    private static final String TAG = OperationService.class.getSimpleName();

    public OperationService() {
        super(OperationService.class.getName());
    }

    private boolean b(@Nullable Intent intent) {
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        String string = extras.getString(c.jz);
        return string != null && string.equals(c.jz);
    }

    private void c(@Nullable Intent intent) {
        String str = null;
        try {
            i.cE().init(getApplicationContext());
            d.init(getApplicationContext());
            a.g(getApplicationContext());
            if (k.p(getApplicationContext())) {
                i.cE().putBoolean(i.ki, true);
                return;
            }
            Bundle extras;
            com.appnext.base.a.b.c av;
            if (intent != null) {
                String stringExtra = intent.getStringExtra(c.jn);
                str = intent.getStringExtra(c.jD);
                extras = intent.getExtras();
                av = e.cy().av(stringExtra);
            } else {
                extras = null;
                av = null;
            }
            if (av != null) {
                String bc = av.bc();
                if (bc == null || bc.equalsIgnoreCase(c.jt) || !c.jw.equalsIgnoreCase(av.be()) || System.currentTimeMillis() - i.cE().getLong(av.getKey() + i.jY, 0) >= 4000) {
                    com.appnext.base.operations.d bG = com.appnext.base.operations.d.bG();
                    if (str == null) {
                        str = av.getKey();
                    }
                    bG.a(str, av, extras);
                }
            }
        } catch (Throwable th) {
            b.a(th);
        }
    }

    private void d(@Nullable Intent intent) {
        ActivityRecognitionResult b = ActivityRecognitionResult.b(intent);
        if (b != null) {
            ArrayList arrayList = (ArrayList) b.a();
            if (arrayList != null) {
                Intent intent2 = new Intent(c.jA);
                intent2.putExtra(c.jB, arrayList);
                android.support.v4.content.c.a((Context) this).a(intent2);
            }
        }
    }

    protected void onHandleIntent(@Nullable Intent intent) {
        if (b(intent)) {
            d(intent);
        } else {
            c(intent);
        }
    }
}

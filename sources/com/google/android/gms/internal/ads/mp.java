package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import javax.annotation.concurrent.GuardedBy;

@zzadh
final class mp implements SensorEventListener {
    private final SensorManager a;
    private final Object b = new Object();
    private final Display c;
    private final float[] d = new float[9];
    private final float[] e = new float[9];
    @GuardedBy("mSensorThreadLock")
    private float[] f;
    private Handler g;
    private zzapt h;

    mp(Context context) {
        this.a = (SensorManager) context.getSystemService("sensor");
        this.c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private final void a(int i, int i2) {
        float f = this.e[i];
        this.e[i] = this.e[i2];
        this.e[i2] = f;
    }

    final void a() {
        if (this.g == null) {
            Sensor defaultSensor = this.a.getDefaultSensor(11);
            if (defaultSensor == null) {
                kk.c("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.g = new Handler(handlerThread.getLooper());
            if (!this.a.registerListener(this, defaultSensor, 0, this.g)) {
                kk.c("SensorManager.registerListener failed.");
                b();
            }
        }
    }

    final void a(zzapt zzapt) {
        this.h = zzapt;
    }

    final boolean a(float[] fArr) {
        boolean z = false;
        synchronized (this.b) {
            if (this.f == null) {
            } else {
                System.arraycopy(this.f, 0, fArr, 0, this.f.length);
                z = true;
            }
        }
        return z;
    }

    final void b() {
        if (this.g != null) {
            this.a.unregisterListener(this);
            this.g.post(new mq(this));
            this.g = null;
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.b) {
                if (this.f == null) {
                    this.f = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.d, fArr);
            switch (this.c.getRotation()) {
                case 1:
                    SensorManager.remapCoordinateSystem(this.d, 2, 129, this.e);
                    break;
                case 2:
                    SensorManager.remapCoordinateSystem(this.d, 129, 130, this.e);
                    break;
                case 3:
                    SensorManager.remapCoordinateSystem(this.d, 130, 1, this.e);
                    break;
                default:
                    System.arraycopy(this.d, 0, this.e, 0, 9);
                    break;
            }
            a(1, 3);
            a(2, 6);
            a(5, 7);
            synchronized (this.b) {
                System.arraycopy(this.e, 0, this.f, 0, 9);
            }
            if (this.h != null) {
                this.h.zznn();
            }
        }
    }
}

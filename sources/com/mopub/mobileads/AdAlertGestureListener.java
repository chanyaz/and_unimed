package com.mopub.mobileads;

import android.support.annotation.Nullable;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.AdReport;

public class AdAlertGestureListener extends SimpleOnGestureListener {
    @Nullable
    private final AdReport a;
    private float b = 100.0f;
    private float c;
    private boolean d;
    private boolean e;
    private AdAlertReporter f;
    private int g;
    private float h;
    private a i = a.UNSET;
    private View j;

    AdAlertGestureListener(View view, @Nullable AdReport adReport) {
        if (view != null && view.getWidth() > 0) {
            this.b = Math.min(100.0f, ((float) view.getWidth()) / 3.0f);
        }
        this.j = view;
        this.a = adReport;
    }

    private void a(float f) {
        if (f > this.h) {
            this.i = a.GOING_RIGHT;
        }
    }

    private boolean a(float f, float f2) {
        return Math.abs(f2 - f) > 100.0f;
    }

    private void b(float f) {
        if (d(f) && g(f)) {
            this.i = a.GOING_LEFT;
            this.h = f;
        }
    }

    private void c() {
        this.g++;
        if (this.g >= 4) {
            this.i = a.FINISHED;
        }
    }

    private void c(float f) {
        if (e(f) && f(f)) {
            this.i = a.GOING_RIGHT;
            this.h = f;
        }
    }

    private boolean d(float f) {
        if (this.e) {
            return true;
        }
        if (f < this.h + this.b) {
            return false;
        }
        this.d = false;
        this.e = true;
        return true;
    }

    private boolean e(float f) {
        if (this.d) {
            return true;
        }
        if (f > this.h - this.b) {
            return false;
        }
        this.e = false;
        this.d = true;
        c();
        return true;
    }

    private boolean f(float f) {
        return f > this.c;
    }

    private boolean g(float f) {
        return f < this.c;
    }

    void a() {
        a aVar = this.i;
        a aVar2 = this.i;
        if (aVar == a.FINISHED) {
            this.f = new AdAlertReporter(this.j.getContext(), this.j, this.a);
            this.f.send();
        }
        b();
    }

    void b() {
        this.g = 0;
        this.i = a.UNSET;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.i == a.FINISHED) {
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        if (a(motionEvent.getY(), motionEvent2.getY())) {
            this.i = a.FAILED;
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        switch (this.i) {
            case UNSET:
                this.h = motionEvent.getX();
                a(motionEvent2.getX());
                break;
            case GOING_RIGHT:
                b(motionEvent2.getX());
                break;
            case GOING_LEFT:
                c(motionEvent2.getX());
                break;
        }
        this.c = motionEvent2.getX();
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }
}

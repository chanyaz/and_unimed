package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.logging.MoPubLog;

public class ViewGestureDetector extends GestureDetector {
    private final View a;
    private AdAlertGestureListener b;
    private UserClickListener c;

    public interface UserClickListener {
        void onResetUserClick();

        void onUserClick();

        boolean wasClicked();
    }

    public ViewGestureDetector(@NonNull Context context, @NonNull View view, @Nullable AdReport adReport) {
        this(context, view, new AdAlertGestureListener(view, adReport));
    }

    private ViewGestureDetector(Context context, View view, AdAlertGestureListener adAlertGestureListener) {
        super(context, adAlertGestureListener);
        this.b = adAlertGestureListener;
        this.a = view;
        setIsLongpressEnabled(false);
    }

    private boolean a(MotionEvent motionEvent, View view) {
        if (motionEvent == null || view == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return x >= 0.0f && x <= ((float) view.getWidth()) && y >= 0.0f && y <= ((float) view.getHeight());
    }

    void a() {
        this.b.b();
    }

    public void sendTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                onTouchEvent(motionEvent);
                return;
            case 1:
                if (this.c != null) {
                    this.c.onUserClick();
                } else {
                    MoPubLog.d("View's onUserClick() is not registered.");
                }
                this.b.a();
                return;
            case 2:
                if (a(motionEvent, this.a)) {
                    onTouchEvent(motionEvent);
                    return;
                } else {
                    a();
                    return;
                }
            default:
                return;
        }
    }

    public void setUserClickListener(UserClickListener userClickListener) {
        this.c = userClickListener;
    }
}

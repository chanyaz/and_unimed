package com.mopub.common;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.mobileads.MoPubRewardedVideoListener;
import com.mopub.mobileads.MoPubRewardedVideoManager;
import com.mopub.mobileads.MoPubRewardedVideoManager.RequestParameters;

public class MoPub {
    public static final String SDK_VERSION = "4.5.0";
    private static volatile LocationAwareness a = LocationAwareness.NORMAL;
    private static volatile int b = 6;

    public enum LocationAwareness {
        NORMAL,
        TRUNCATED,
        DISABLED
    }

    private static void a(@NonNull Activity activity) {
        MoPubRewardedVideoManager.updateActivity(activity);
    }

    public static LocationAwareness getLocationAwareness() {
        return a;
    }

    public static int getLocationPrecision() {
        return b;
    }

    public static boolean hasRewardedVideo(@NonNull String str) {
        return MoPubRewardedVideoManager.hasVideo(str);
    }

    public static void initializeRewardedVideo(@NonNull Activity activity, MediationSettings... mediationSettingsArr) {
        MoPubRewardedVideoManager.init(activity, mediationSettingsArr);
    }

    public static void loadRewardedVideo(@NonNull String str, @Nullable RequestParameters requestParameters, @Nullable MediationSettings... mediationSettingsArr) {
        MoPubRewardedVideoManager.loadVideo(str, requestParameters, mediationSettingsArr);
    }

    public static void loadRewardedVideo(@NonNull String str, @Nullable MediationSettings... mediationSettingsArr) {
        MoPubRewardedVideoManager.loadVideo(str, null, mediationSettingsArr);
    }

    public static void onBackPressed(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onBackPressed(activity);
    }

    public static void onCreate(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onCreate(activity);
        a(activity);
    }

    public static void onDestroy(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onDestroy(activity);
    }

    public static void onPause(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onPause(activity);
    }

    public static void onRestart(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onRestart(activity);
        a(activity);
    }

    public static void onResume(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onResume(activity);
        a(activity);
    }

    public static void onStart(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onStart(activity);
        a(activity);
    }

    public static void onStop(@NonNull Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onStop(activity);
    }

    public static void setLocationAwareness(LocationAwareness locationAwareness) {
        a = locationAwareness;
    }

    public static void setLocationPrecision(int i) {
        b = Math.min(Math.max(0, i), 6);
    }

    public static void setRewardedVideoListener(@Nullable MoPubRewardedVideoListener moPubRewardedVideoListener) {
        MoPubRewardedVideoManager.setVideoListener(moPubRewardedVideoListener);
    }

    public static void showRewardedVideo(@NonNull String str) {
        MoPubRewardedVideoManager.showVideo(str);
    }
}

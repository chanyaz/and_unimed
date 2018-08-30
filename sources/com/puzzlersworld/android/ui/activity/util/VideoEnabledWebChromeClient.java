package com.puzzlersworld.android.ui.activity.util;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.puzzlersworld.android.ui.activity.FeedDetailActivity;
import com.puzzlersworld.wp.dto.StringConstants;

public class VideoEnabledWebChromeClient extends WebChromeClient implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private Activity a;
    private Fragment b;
    private FeedDetailActivity c;
    private View d;
    private ViewGroup e;
    private View f;
    private VideoEnabledWebView g;
    private boolean h;
    private FrameLayout i;
    private CustomViewCallback j;
    private ToggledFullscreenCallback k;

    public interface ToggledFullscreenCallback {
        void toggledFullscreen(boolean z);
    }

    public VideoEnabledWebChromeClient(View view, ViewGroup viewGroup, Activity activity, Fragment fragment) {
        this.d = view;
        this.e = viewGroup;
        this.f = null;
        this.g = null;
        this.a = activity;
        this.b = fragment;
        if (fragment instanceof FeedDetailActivity) {
            this.c = (FeedDetailActivity) fragment;
        }
        this.h = false;
    }

    public void a(ToggledFullscreenCallback toggledFullscreenCallback) {
        this.k = toggledFullscreenCallback;
    }

    public boolean a() {
        if (!this.h) {
            return false;
        }
        onHideCustomView();
        return true;
    }

    public View getVideoLoadingProgressView() {
        if (this.f == null) {
            return super.getVideoLoadingProgressView();
        }
        this.f.setVisibility(0);
        return this.f;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        onHideCustomView();
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    public void onHideCustomView() {
        if (this.h) {
            this.e.setVisibility(8);
            this.e.removeView(this.i);
            this.d.setVisibility(0);
            if (!(this.j == null || this.j.getClass().getName().contains(".chromium."))) {
                this.j.onCustomViewHidden();
            }
            this.h = false;
            this.i = null;
            this.j = null;
            if (this.k != null) {
                this.k.toggledFullscreen(false);
            }
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (this.f != null) {
            this.f.setVisibility(8);
        }
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            View focusedChild = frameLayout.getFocusedChild();
            this.h = true;
            this.i = frameLayout;
            this.j = customViewCallback;
            this.d.setVisibility(8);
            this.e.addView(this.i, new LayoutParams(-1, -1));
            this.e.setVisibility(0);
            if (focusedChild instanceof VideoView) {
                VideoView videoView = (VideoView) focusedChild;
                videoView.setOnPreparedListener(this);
                videoView.setOnCompletionListener(this);
                videoView.setOnErrorListener(this);
            } else if (this.g != null && this.g.getSettings().getJavaScriptEnabled() && (focusedChild instanceof SurfaceView)) {
                this.g.loadUrl((((((((("javascript:" + "var _ytrp_html5_video_last;") + "var _ytrp_html5_video = document.getElementsByTagName('video')[0];") + "if (_ytrp_html5_video != undefined && _ytrp_html5_video != _ytrp_html5_video_last) {") + "_ytrp_html5_video_last = _ytrp_html5_video;") + "function _ytrp_html5_video_ended() {") + "_VideoEnabledWebView.notifyVideoEnd();") + "}") + "_ytrp_html5_video.addEventListener('ended', _ytrp_html5_video_ended);") + "}");
            }
            if (this.k != null) {
                this.k.toggledFullscreen(true);
            }
            this.e.bringToFront();
        }
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        if (this.c.ai() != null) {
            this.c.ai().onReceiveValue(null);
        }
        this.c.a((ValueCallback) valueCallback);
        Parcelable intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent);
        intent2.putExtra("android.intent.extra.TITLE", StringConstants.SELECT.getMessage());
        this.b.startActivityForResult(intent2, 100);
        return true;
    }
}

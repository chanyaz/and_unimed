package com.mopub.mraid;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseVideoPlayerActivity;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener;

public class MraidVideoViewController extends BaseVideoViewController {
    private final VideoView a;
    private ImageButton b;
    private int c;
    private int d;

    public MraidVideoViewController(Context context, Bundle bundle, Bundle bundle2, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        super(context, null, baseVideoViewControllerListener);
        this.a = new VideoView(context);
        this.a.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                MraidVideoViewController.this.b.setVisibility(0);
                MraidVideoViewController.this.a(true);
            }
        });
        this.a.setOnErrorListener(new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                MraidVideoViewController.this.b.setVisibility(0);
                MraidVideoViewController.this.b(false);
                return false;
            }
        });
        this.a.setVideoPath(bundle.getString(BaseVideoPlayerActivity.VIDEO_URL));
    }

    private void i() {
        this.b = new ImageButton(f());
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(f()));
        stateListDrawable.addState(new int[]{16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(f()));
        this.b.setImageDrawable(stateListDrawable);
        this.b.setBackgroundDrawable(null);
        this.b.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MraidVideoViewController.this.b().onFinish();
            }
        });
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.d, this.d);
        layoutParams.addRule(11);
        layoutParams.setMargins(this.c, 0, this.c, 0);
        getLayout().addView(this.b, layoutParams);
    }

    protected void a() {
        super.a();
        this.d = Dips.asIntPixels(50.0f, f());
        this.c = Dips.asIntPixels(8.0f, f());
        i();
        this.b.setVisibility(8);
        this.a.start();
    }

    protected void a(Configuration configuration) {
    }

    protected void a(@NonNull Bundle bundle) {
    }

    protected VideoView b() {
        return this.a;
    }

    protected void c() {
    }

    protected void d() {
    }

    protected void e() {
    }

    protected void f() {
    }
}

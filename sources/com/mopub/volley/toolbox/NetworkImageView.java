package com.mopub.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;

public class NetworkImageView extends ImageView {
    private String a;
    private int b;
    private int c;
    private ImageLoader d;
    private ImageContainer e;

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a() {
        if (this.b != 0) {
            setImageResource(this.b);
        } else {
            setImageBitmap(null);
        }
    }

    void a(final boolean z) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        int width = getWidth();
        int height = getHeight();
        if (getLayoutParams() != null) {
            i = getLayoutParams().width == -2 ? 1 : 0;
            i2 = getLayoutParams().height == -2 ? 1 : 0;
        } else {
            i2 = 0;
            i = 0;
        }
        if (i == 0 || i2 == 0) {
            i3 = 0;
        }
        if (width != 0 || height != 0 || i3 != 0) {
            if (TextUtils.isEmpty(this.a)) {
                if (this.e != null) {
                    this.e.cancelRequest();
                    this.e = null;
                }
                a();
                return;
            }
            if (!(this.e == null || this.e.getRequestUrl() == null)) {
                if (!this.e.getRequestUrl().equals(this.a)) {
                    this.e.cancelRequest();
                    a();
                } else {
                    return;
                }
            }
            i = i != 0 ? 0 : width;
            if (i2 == 0) {
                i4 = height;
            }
            this.e = this.d.get(this.a, new ImageListener() {
                public void onErrorResponse(VolleyError volleyError) {
                    if (NetworkImageView.this.c != 0) {
                        NetworkImageView.this.setImageResource(NetworkImageView.this.c);
                    }
                }

                public void onResponse(final ImageContainer imageContainer, boolean z) {
                    if (z && z) {
                        NetworkImageView.this.post(new Runnable() {
                            public void run() {
                                AnonymousClass1.this.onResponse(imageContainer, false);
                            }
                        });
                    } else if (imageContainer.getBitmap() != null) {
                        NetworkImageView.this.setImageBitmap(imageContainer.getBitmap());
                    } else if (NetworkImageView.this.b != 0) {
                        NetworkImageView.this.setImageResource(NetworkImageView.this.b);
                    }
                }
            }, i, i4);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    protected void onDetachedFromWindow() {
        if (this.e != null) {
            this.e.cancelRequest();
            setImageBitmap(null);
            this.e = null;
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a(true);
    }

    public void setDefaultImageResId(int i) {
        this.b = i;
    }

    public void setErrorImageResId(int i) {
        this.c = i;
    }

    public void setImageUrl(String str, ImageLoader imageLoader) {
        this.a = str;
        this.d = imageLoader;
        a(false);
    }
}

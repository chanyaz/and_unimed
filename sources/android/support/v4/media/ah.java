package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

public final class ah {
    private String a;
    private CharSequence b;
    private CharSequence c;
    private CharSequence d;
    private Bitmap e;
    private Uri f;
    private Bundle g;
    private Uri h;

    public MediaDescriptionCompat a() {
        return new MediaDescriptionCompat(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public ah a(@Nullable Bitmap bitmap) {
        this.e = bitmap;
        return this;
    }

    public ah a(@Nullable Uri uri) {
        this.f = uri;
        return this;
    }

    public ah a(@Nullable Bundle bundle) {
        this.g = bundle;
        return this;
    }

    public ah a(@Nullable CharSequence charSequence) {
        this.b = charSequence;
        return this;
    }

    public ah a(@Nullable String str) {
        this.a = str;
        return this;
    }

    public ah b(@Nullable Uri uri) {
        this.h = uri;
        return this;
    }

    public ah b(@Nullable CharSequence charSequence) {
        this.c = charSequence;
        return this;
    }

    public ah c(@Nullable CharSequence charSequence) {
        this.d = charSequence;
        return this;
    }
}

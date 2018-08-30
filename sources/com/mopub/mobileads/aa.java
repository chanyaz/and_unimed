package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

class aa implements Serializable {
    private static final List<String> a = Arrays.asList(new String[]{"image/jpeg", "image/png", "image/bmp", "image/gif"});
    private static final List<String> b = Arrays.asList(new String[]{"application/x-javascript"});
    private static final long serialVersionUID = 0;
    @NonNull
    private String c;
    @NonNull
    private ac d;
    @NonNull
    private ab e;
    private int f;
    private int g;

    aa(@NonNull String str, @NonNull ac acVar, @NonNull ab abVar, int i, int i2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(acVar);
        Preconditions.checkNotNull(abVar);
        this.c = str;
        this.d = acVar;
        this.e = abVar;
        this.f = i;
        this.g = i2;
    }

    @Nullable
    static aa a(@NonNull VastResourceXmlManager vastResourceXmlManager, @NonNull ac acVar, int i, int i2) {
        ab abVar;
        Preconditions.checkNotNull(vastResourceXmlManager);
        Preconditions.checkNotNull(acVar);
        String c = vastResourceXmlManager.c();
        String d = vastResourceXmlManager.d();
        String a = vastResourceXmlManager.a();
        String b = vastResourceXmlManager.b();
        if (acVar == ac.STATIC_RESOURCE && a != null && b != null && (a.contains(b) || b.contains(b))) {
            abVar = a.contains(b) ? ab.IMAGE : ab.JAVASCRIPT;
        } else if (acVar == ac.HTML_RESOURCE && d != null) {
            abVar = ab.NONE;
            a = d;
        } else if (acVar != ac.IFRAME_RESOURCE || c == null) {
            return null;
        } else {
            abVar = ab.NONE;
            a = c;
        }
        return new aa(a, acVar, abVar, i, i2);
    }

    @Nullable
    public String getCorrectClickThroughUrl(@Nullable String str, @Nullable String str2) {
        switch (this.d) {
            case STATIC_RESOURCE:
                return ab.IMAGE == this.e ? str : ab.JAVASCRIPT != this.e ? null : str2;
            case HTML_RESOURCE:
            case IFRAME_RESOURCE:
                return str2;
            default:
                return null;
        }
    }

    @NonNull
    public ab getCreativeType() {
        return this.e;
    }

    @NonNull
    public String getResource() {
        return this.c;
    }

    @NonNull
    public ac getType() {
        return this.d;
    }

    public void initializeWebView(@NonNull VastWebView vastWebView) {
        Preconditions.checkNotNull(vastWebView);
        if (this.d == ac.IFRAME_RESOURCE) {
            vastWebView.a("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.f + "\" height=\"" + this.g + "\" src=\"" + this.c + "\"></iframe>");
        } else if (this.d == ac.HTML_RESOURCE) {
            vastWebView.a(this.c);
        } else if (this.d != ac.STATIC_RESOURCE) {
        } else {
            if (this.e == ab.IMAGE) {
                vastWebView.a("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.c + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" />" + "</body>" + "</html>");
            } else if (this.e == ab.JAVASCRIPT) {
                vastWebView.a("<script src=\"" + this.c + "\"></script>");
            }
        }
    }
}

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.util.ManifestFetcher.RedirectingManifest;
import java.util.List;

public class b implements RedirectingManifest {
    public final long a;
    public final long b;
    public final boolean c;
    public final long d;
    public final long e;
    public final String f;
    public final List<c> g;

    public String getNextManifestUri() {
        return this.f;
    }
}

package com.google.android.exoplayer.extractor;

import android.net.Uri;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.upstream.c;
import com.google.android.exoplayer.util.b;

class d implements Loadable {
    private final Uri a;
    private final DataSource b;
    private final e c;
    private final Allocator d;
    private final int e;
    private final g f = new g();
    private volatile boolean g;
    private boolean h;

    public d(Uri uri, DataSource dataSource, e eVar, Allocator allocator, int i, long j) {
        this.a = (Uri) b.a((Object) uri);
        this.b = (DataSource) b.a((Object) dataSource);
        this.c = (e) b.a((Object) eVar);
        this.d = (Allocator) b.a((Object) allocator);
        this.e = i;
        this.f.a = j;
        this.h = true;
    }

    public void cancelLoad() {
        this.g = true;
    }

    public boolean isLoadCanceled() {
        return this.g;
    }

    public void load() {
        int i;
        ExtractorInput extractorInput;
        Throwable th;
        int i2 = 0;
        while (i2 == 0 && !this.g) {
            try {
                long j = this.f.a;
                long open = this.b.open(new c(this.a, j, -1, null));
                if (open != -1) {
                    open += j;
                }
                ExtractorInput bVar = new b(this.b, j, open);
                try {
                    int i3;
                    Extractor a = this.c.a(bVar);
                    if (this.h) {
                        a.seek();
                        this.h = false;
                    }
                    int i4 = i2;
                    while (i4 == 0) {
                        try {
                            if (this.g) {
                                break;
                            }
                            this.d.blockWhileTotalBytesAllocatedExceeds(this.e);
                            i4 = a.read(bVar, this.f);
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            i = i4;
                            extractorInput = bVar;
                            th = th3;
                            if (!(i == 1 || extractorInput == null)) {
                                this.f.a = extractorInput.getPosition();
                            }
                            this.b.close();
                            throw th;
                        }
                    }
                    if (i4 == 1) {
                        i3 = 0;
                    } else {
                        if (bVar != null) {
                            this.f.a = bVar.getPosition();
                        }
                        i3 = i4;
                    }
                    this.b.close();
                    i2 = i3;
                } catch (Throwable th4) {
                    i = i2;
                    ExtractorInput extractorInput2 = bVar;
                    th = th4;
                    extractorInput = extractorInput2;
                    this.f.a = extractorInput.getPosition();
                    this.b.close();
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                extractorInput = null;
                i = i2;
                this.f.a = extractorInput.getPosition();
                this.b.close();
                throw th;
            }
        }
    }
}

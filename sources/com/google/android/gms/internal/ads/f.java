package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.au;

final class f implements OnClickListener {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ e c;

    f(e eVar, String str, String str2) {
        this.c = eVar;
        this.a = str;
        this.b = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.c.b.getSystemService("download");
        try {
            String str = this.a;
            String str2 = this.b;
            Request request = new Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            au.g().a(request);
            downloadManager.enqueue(request);
        } catch (IllegalStateException e) {
            this.c.a("Could not store picture.");
        }
    }
}

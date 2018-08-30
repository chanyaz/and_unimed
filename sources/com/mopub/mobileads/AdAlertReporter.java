package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.util.DateAndTime;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AdAlertReporter {
    private final String a = new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US).format(DateAndTime.now());
    private final View b;
    private final Context c;
    private Intent d;
    private ArrayList<Uri> e = new ArrayList();
    private String f;
    private String g;

    public AdAlertReporter(Context context, View view, @Nullable AdReport adReport) {
        this.b = view;
        this.c = context;
        a();
        Bitmap b = b();
        String a = a(b);
        this.f = "";
        this.g = "";
        if (adReport != null) {
            this.f = adReport.toString();
            this.g = adReport.getResponseString();
        }
        c();
        a(this.f, this.g, a);
        a("mp_adalert_parameters.txt", this.f);
        a("mp_adalert_markup.html", this.g);
        a("mp_adalert_screenshot.png", b);
    }

    private String a(Bitmap bitmap) {
        String str = null;
        if (bitmap == null) {
            return str;
        }
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 25, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return str;
        }
    }

    private void a() {
        Uri parse = Uri.parse("mailto:");
        this.d = new Intent("android.intent.action.SEND_MULTIPLE");
        this.d.setDataAndType(parse, "plain/text");
        this.d.putExtra("android.intent.extra.EMAIL", new String[]{"creative-review@mopub.com"});
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0043 A:{ExcHandler: java.lang.Exception (e java.lang.Exception), Splitter: B:3:0x0006} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:10:?, code:
            com.mopub.common.logging.MoPubLog.d("Unable to write text attachment to file: " + r6);
     */
    /* JADX WARNING: Missing block: B:11:0x005a, code:
            com.mopub.common.util.Streams.closeStream(r0);
     */
    /* JADX WARNING: Missing block: B:12:0x005e, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:13:0x005f, code:
            r4 = r1;
            r1 = r0;
            r0 = r4;
     */
    /* JADX WARNING: Missing block: B:21:?, code:
            return;
     */
    private void a(java.lang.String r6, android.graphics.Bitmap r7) {
        /*
        r5 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x0005;
    L_0x0003:
        if (r7 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r1 = r5.c;	 Catch:{ Exception -> 0x0043, all -> 0x005e }
        r2 = 1;
        r0 = r1.openFileOutput(r6, r2);	 Catch:{ Exception -> 0x0043, all -> 0x005e }
        r1 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ Exception -> 0x0043 }
        r2 = 25;
        r7.compress(r1, r2, r0);	 Catch:{ Exception -> 0x0043 }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0043 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0043 }
        r2.<init>();	 Catch:{ Exception -> 0x0043 }
        r3 = r5.c;	 Catch:{ Exception -> 0x0043 }
        r3 = r3.getFilesDir();	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0043 }
        r3 = java.io.File.separator;	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r6);	 Catch:{ Exception -> 0x0043 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0043 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0043 }
        r1 = android.net.Uri.fromFile(r1);	 Catch:{ Exception -> 0x0043 }
        r2 = r5.e;	 Catch:{ Exception -> 0x0043 }
        r2.add(r1);	 Catch:{ Exception -> 0x0043 }
        com.mopub.common.util.Streams.closeStream(r0);
        goto L_0x0005;
    L_0x0043:
        r1 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0066 }
        r1.<init>();	 Catch:{ all -> 0x0066 }
        r2 = "Unable to write text attachment to file: ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0066 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0066 }
        r1 = r1.toString();	 Catch:{ all -> 0x0066 }
        com.mopub.common.logging.MoPubLog.d(r1);	 Catch:{ all -> 0x0066 }
        com.mopub.common.util.Streams.closeStream(r0);
        goto L_0x0005;
    L_0x005e:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0062:
        com.mopub.common.util.Streams.closeStream(r1);
        throw r0;
    L_0x0066:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.AdAlertReporter.a(java.lang.String, android.graphics.Bitmap):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0043 A:{ExcHandler: java.lang.Exception (e java.lang.Exception), Splitter: B:3:0x0006} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:10:?, code:
            com.mopub.common.logging.MoPubLog.d("Unable to write text attachment to file: " + r6);
     */
    /* JADX WARNING: Missing block: B:11:0x005a, code:
            com.mopub.common.util.Streams.closeStream(r0);
     */
    /* JADX WARNING: Missing block: B:12:0x005e, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:13:0x005f, code:
            r4 = r1;
            r1 = r0;
            r0 = r4;
     */
    /* JADX WARNING: Missing block: B:21:?, code:
            return;
     */
    private void a(java.lang.String r6, java.lang.String r7) {
        /*
        r5 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x0005;
    L_0x0003:
        if (r7 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r1 = r5.c;	 Catch:{ Exception -> 0x0043, all -> 0x005e }
        r2 = 1;
        r0 = r1.openFileOutput(r6, r2);	 Catch:{ Exception -> 0x0043, all -> 0x005e }
        r1 = r7.getBytes();	 Catch:{ Exception -> 0x0043 }
        r0.write(r1);	 Catch:{ Exception -> 0x0043 }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0043 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0043 }
        r2.<init>();	 Catch:{ Exception -> 0x0043 }
        r3 = r5.c;	 Catch:{ Exception -> 0x0043 }
        r3 = r3.getFilesDir();	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0043 }
        r3 = java.io.File.separator;	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r6);	 Catch:{ Exception -> 0x0043 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0043 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0043 }
        r1 = android.net.Uri.fromFile(r1);	 Catch:{ Exception -> 0x0043 }
        r2 = r5.e;	 Catch:{ Exception -> 0x0043 }
        r2.add(r1);	 Catch:{ Exception -> 0x0043 }
        com.mopub.common.util.Streams.closeStream(r0);
        goto L_0x0005;
    L_0x0043:
        r1 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0066 }
        r1.<init>();	 Catch:{ all -> 0x0066 }
        r2 = "Unable to write text attachment to file: ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0066 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0066 }
        r1 = r1.toString();	 Catch:{ all -> 0x0066 }
        com.mopub.common.logging.MoPubLog.d(r1);	 Catch:{ all -> 0x0066 }
        com.mopub.common.util.Streams.closeStream(r0);
        goto L_0x0005;
    L_0x005e:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0062:
        com.mopub.common.util.Streams.closeStream(r1);
        throw r0;
    L_0x0066:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.AdAlertReporter.a(java.lang.String, java.lang.String):void");
    }

    private void a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            stringBuilder.append(strArr[i]);
            if (i != strArr.length - 1) {
                stringBuilder.append("\n=================\n");
            }
        }
        this.d.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
    }

    private Bitmap b() {
        if (this.b == null || this.b.getRootView() == null) {
            return null;
        }
        View rootView = this.b.getRootView();
        boolean isDrawingCacheEnabled = rootView.isDrawingCacheEnabled();
        rootView.setDrawingCacheEnabled(true);
        Bitmap drawingCache = rootView.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
        rootView.setDrawingCacheEnabled(isDrawingCacheEnabled);
        return createBitmap;
    }

    private void c() {
        this.d.putExtra("android.intent.extra.SUBJECT", "New creative violation report - " + this.a);
    }

    public void send() {
        this.d.putParcelableArrayListExtra("android.intent.extra.STREAM", this.e);
        Intent createChooser = Intent.createChooser(this.d, "Send Email...");
        createChooser.addFlags(268435456);
        this.c.startActivity(createChooser);
    }
}

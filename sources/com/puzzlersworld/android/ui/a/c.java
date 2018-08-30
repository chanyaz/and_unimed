package com.puzzlersworld.android.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.wp.dto.Post;
import com.puzzlersworld.wp.dto.ThemeColors;

public class c {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    ImageView f;
    int g;
    int h;
    Context i;
    Post j;
    LinearLayout k;
    CardView l;
    LinearLayout m;

    c(Context context) {
        this.i = context;
    }

    private void a() {
        ThemeColors z = FullscreenActivity.z();
        if (z != null) {
            if (this.d != null) {
                this.d.setTextColor(Color.parseColor(z.getAuthorTextColor()));
            }
            if (this.e != null) {
                this.e.setTextColor(Color.parseColor(z.getTimeTextColor()));
            }
            if (this.b != null) {
                this.b.setTextColor(Color.parseColor(z.getFeedTitleColor()));
            }
            if (this.c != null) {
                this.c.setTextColor(Color.parseColor(z.getFeedContentTextColor()));
            }
            if (this.a != null) {
                this.a.setTextColor(Color.parseColor(z.getTagTextColor()));
            }
            if (this.l != null) {
                this.l.setCardBackgroundColor(Color.parseColor(z.getFeedBgColor()));
            }
        }
    }

    private void c(int i) {
        this.f.setMaxHeight(i);
    }

    public void a(int i) {
        this.g = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0136 A:{SYNTHETIC, Splitter: B:48:0x0136} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009a A:{Catch:{ Exception -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x010e  */
    void a(com.puzzlersworld.wp.dto.Post r12) {
        /*
        r11 = this;
        r1 = 1;
        r10 = 8;
        r2 = 0;
        r11.j = r12;
        r3 = 1069547520; // 0x3fc00000 float:1.5 double:5.28426686E-315;
        r0 = r11.a;
        if (r0 == 0) goto L_0x0025;
    L_0x000c:
        r0 = r12.getTerms();
        r4 = r11.a;
        r0 = com.puzzlersworld.android.util.w.a(r0, r4);
        r4 = com.google.common.base.ab.a(r0);
        if (r4 != 0) goto L_0x0117;
    L_0x001c:
        r4 = r11.a;
        r0 = com.puzzlersworld.android.util.w.d(r0);
        r4.setText(r0);
    L_0x0025:
        r0 = r11.d;
        if (r0 == 0) goto L_0x0126;
    L_0x0029:
        r0 = r12.getAuthor();
        if (r0 == 0) goto L_0x011f;
    L_0x002f:
        r0 = r12.getAuthor();
        r0 = r0.getName();
        if (r0 == 0) goto L_0x011f;
    L_0x0039:
        r0 = r11.d;
        r4 = r12.getAuthor();
        r4 = r4.getName();
        r4 = com.puzzlersworld.android.util.w.d(r4);
        r0.setText(r4);
        r0 = r1;
    L_0x004b:
        r4 = r11.e;
        if (r4 == 0) goto L_0x0085;
    L_0x004f:
        r4 = r12.getDate();
        if (r4 == 0) goto L_0x012d;
    L_0x0055:
        r4 = r11.e;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        if (r0 == 0) goto L_0x0129;
    L_0x005e:
        r0 = " - ";
    L_0x0060:
        r0 = r5.append(r0);
        r5 = new java.util.Date;
        r5.<init>();
        r6 = r5.getTime();
        r5 = r12.getDate();
        r8 = r5.getTime();
        r6 = r6 - r8;
        r5 = com.puzzlersworld.android.ui.activity.util.a.a(r6);
        r0 = r0.append(r5);
        r0 = r0.toString();
        r4.setText(r0);
    L_0x0085:
        r0 = r11.b;
        r4 = r12.getTitle();
        r4 = com.puzzlersworld.android.util.w.d(r4);
        r0.setText(r4);
        r0 = r12.getImageDimensionType();	 Catch:{ Exception -> 0x01a8 }
        r4 = com.puzzlersworld.wp.dto.ImageDimensionType.noimage;	 Catch:{ Exception -> 0x01a8 }
        if (r0 != r4) goto L_0x0136;
    L_0x009a:
        r0 = r11.f;	 Catch:{ Exception -> 0x01a8 }
        r4 = 8;
        r0.setVisibility(r4);	 Catch:{ Exception -> 0x01a8 }
        r0 = 1075838976; // 0x40200000 float:2.5 double:5.315350785E-315;
    L_0x00a3:
        r3 = r11.f;
        r3 = r3.getVisibility();
        if (r3 != r10) goto L_0x0230;
    L_0x00ab:
        r3 = r11.c;
        r3.setVisibility(r2);
        r3 = r11.j;
        r3 = r3.getPreviewType();
        r4 = com.puzzlersworld.wp.dto.PreviewType.excerpt;
        if (r3 != r4) goto L_0x0225;
    L_0x00ba:
        r3 = r11.c;
        r4 = r12.getExcerpt();
        r4 = android.text.Html.fromHtml(r4);
        r3.setText(r4);
    L_0x00c7:
        r3 = r11.m;
        if (r3 == 0) goto L_0x010a;
    L_0x00cb:
        r3 = r11.m;
        r3.setOrientation(r2);
        r2 = com.puzzlersworld.android.FullscreenActivity.y();
        r3 = com.puzzlersworld.wp.dto.Layout.compact;
        if (r2 != r3) goto L_0x010a;
    L_0x00d8:
        r2 = r11.a;
        r2 = r2.getPaint();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "";
        r3 = r3.append(r4);
        r4 = r11.a;
        r4 = r4.getText();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2 = r2.measureText(r3);
        r2 = (int) r2;
        r2 = (float) r2;
        r3 = r11.h;
        r3 = (float) r3;
        r0 = r0 * r3;
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x010a;
    L_0x0105:
        r0 = r11.m;
        r0.setOrientation(r1);
    L_0x010a:
        r0 = r11.k;
        if (r0 == 0) goto L_0x0113;
    L_0x010e:
        r0 = r11.k;
        r0.setTag(r12);
    L_0x0113:
        r11.a();
        return;
    L_0x0117:
        r0 = r11.a;
        r4 = 4;
        r0.setVisibility(r4);
        goto L_0x0025;
    L_0x011f:
        r0 = r11.d;
        r4 = "";
        r0.setText(r4);
    L_0x0126:
        r0 = r2;
        goto L_0x004b;
    L_0x0129:
        r0 = "";
        goto L_0x0060;
    L_0x012d:
        r0 = r11.e;
        r4 = "";
        r0.setText(r4);
        goto L_0x0085;
    L_0x0136:
        r0 = r11.f;	 Catch:{ Exception -> 0x01a8 }
        r4 = 0;
        r0.setVisibility(r4);	 Catch:{ Exception -> 0x01a8 }
        r0 = 0;
        r4 = r12.getPostImage();	 Catch:{ Exception -> 0x01a8 }
        if (r4 == 0) goto L_0x0155;
    L_0x0143:
        r4 = r12.getPostImage();	 Catch:{ Exception -> 0x01a8 }
        r4 = r4.length();	 Catch:{ Exception -> 0x01a8 }
        if (r4 <= 0) goto L_0x0155;
    L_0x014d:
        r0 = r12.getPostImage();	 Catch:{ Exception -> 0x01a8 }
        r0 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x01a8 }
    L_0x0155:
        if (r0 == 0) goto L_0x01e0;
    L_0x0157:
        r0 = r0.getHost();	 Catch:{ Exception -> 0x01a8 }
        if (r0 == 0) goto L_0x01e0;
    L_0x015d:
        r0 = r12.getImageDimensionType();	 Catch:{ Exception -> 0x01a8 }
        r4 = com.puzzlersworld.wp.dto.ImageDimensionType.preview;	 Catch:{ Exception -> 0x01a8 }
        if (r0 != r4) goto L_0x01cb;
    L_0x0165:
        r0 = r11.f;	 Catch:{ Exception -> 0x01a8 }
        r4 = android.widget.ImageView.ScaleType.CENTER_CROP;	 Catch:{ Exception -> 0x01a8 }
        r0.setScaleType(r4);	 Catch:{ Exception -> 0x01a8 }
        r0 = com.puzzlersworld.android.FullscreenActivity.y();	 Catch:{ Exception -> 0x01a8 }
        r4 = com.puzzlersworld.wp.dto.Layout.cardview;	 Catch:{ Exception -> 0x01a8 }
        if (r0 != r4) goto L_0x018f;
    L_0x0174:
        r0 = r11.g;	 Catch:{ Exception -> 0x01a8 }
        r11.c(r0);	 Catch:{ Exception -> 0x01a8 }
    L_0x0179:
        r0 = r11.i;	 Catch:{ Exception -> 0x01a8 }
        r0 = com.squareup.picasso.Picasso.a(r0);	 Catch:{ Exception -> 0x01a8 }
        r4 = r12.getPostImage();	 Catch:{ Exception -> 0x01a8 }
        r0 = r0.a(r4);	 Catch:{ Exception -> 0x01a8 }
        r4 = r11.f;	 Catch:{ Exception -> 0x01a8 }
        r0.a(r4);	 Catch:{ Exception -> 0x01a8 }
        r0 = r3;
        goto L_0x00a3;
    L_0x018f:
        r0 = r11.f;	 Catch:{ Exception -> 0x01a8 }
        r0 = r0.getLayoutParams();	 Catch:{ Exception -> 0x01a8 }
        r4 = r11.h;	 Catch:{ Exception -> 0x01a8 }
        r4 = r4 + -5;
        r0.height = r4;	 Catch:{ Exception -> 0x01a8 }
        r0 = r11.f;	 Catch:{ Exception -> 0x01a8 }
        r0 = r0.getLayoutParams();	 Catch:{ Exception -> 0x01a8 }
        r4 = r11.h;	 Catch:{ Exception -> 0x01a8 }
        r4 = r4 + -5;
        r0.width = r4;	 Catch:{ Exception -> 0x01a8 }
        goto L_0x0179;
    L_0x01a8:
        r0 = move-exception;
        r4 = "FeedItemHolder";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Exception while setting image ";
        r5 = r5.append(r6);
        r6 = r0.getMessage();
        r5 = r5.append(r6);
        r5 = r5.toString();
        android.util.Log.d(r4, r5);
        r0.printStackTrace();
    L_0x01c8:
        r0 = r3;
        goto L_0x00a3;
    L_0x01cb:
        r0 = com.puzzlersworld.android.FullscreenActivity.y();	 Catch:{ Exception -> 0x01a8 }
        r4 = com.puzzlersworld.wp.dto.Layout.compact;	 Catch:{ Exception -> 0x01a8 }
        if (r0 != r4) goto L_0x0179;
    L_0x01d3:
        r0 = r11.f;	 Catch:{ Exception -> 0x01a8 }
        r0 = r0.getLayoutParams();	 Catch:{ Exception -> 0x01a8 }
        r4 = r11.h;	 Catch:{ Exception -> 0x01a8 }
        r4 = r4 + -5;
        r0.width = r4;	 Catch:{ Exception -> 0x01a8 }
        goto L_0x0179;
    L_0x01e0:
        r0 = com.puzzlersworld.android.FullscreenActivity.y();	 Catch:{ Exception -> 0x01a8 }
        r4 = com.puzzlersworld.wp.dto.Layout.cardview;	 Catch:{ Exception -> 0x01a8 }
        if (r0 != r4) goto L_0x01f2;
    L_0x01e8:
        r0 = r11.f;	 Catch:{ Exception -> 0x01a8 }
        r4 = 8;
        r0.setVisibility(r4);	 Catch:{ Exception -> 0x01a8 }
        r0 = r3;
        goto L_0x00a3;
    L_0x01f2:
        r0 = com.puzzlersworld.android.FullscreenActivity.y();	 Catch:{ Exception -> 0x01a8 }
        r4 = com.puzzlersworld.wp.dto.Layout.compact;	 Catch:{ Exception -> 0x01a8 }
        if (r0 != r4) goto L_0x01c8;
    L_0x01fa:
        r0 = r11.i;	 Catch:{ Exception -> 0x01a8 }
        r0 = com.squareup.picasso.Picasso.a(r0);	 Catch:{ Exception -> 0x01a8 }
        r4 = 2130837665; // 0x7f0200a1 float:1.728029E38 double:1.052773687E-314;
        r0 = r0.a(r4);	 Catch:{ Exception -> 0x01a8 }
        r4 = r11.f;	 Catch:{ Exception -> 0x01a8 }
        r0.a(r4);	 Catch:{ Exception -> 0x01a8 }
        r0 = r11.f;	 Catch:{ Exception -> 0x01a8 }
        r0 = r0.getLayoutParams();	 Catch:{ Exception -> 0x01a8 }
        r4 = r11.h;	 Catch:{ Exception -> 0x01a8 }
        r4 = r4 + -5;
        r0.height = r4;	 Catch:{ Exception -> 0x01a8 }
        r0 = r11.f;	 Catch:{ Exception -> 0x01a8 }
        r0 = r0.getLayoutParams();	 Catch:{ Exception -> 0x01a8 }
        r4 = r11.h;	 Catch:{ Exception -> 0x01a8 }
        r4 = r4 + -5;
        r0.width = r4;	 Catch:{ Exception -> 0x01a8 }
        goto L_0x01c8;
    L_0x0225:
        r3 = r11.c;
        r4 = r12.getExcerpt();
        r3.setText(r4);
        goto L_0x00c7;
    L_0x0230:
        r3 = com.puzzlersworld.android.FullscreenActivity.y();
        r4 = com.puzzlersworld.wp.dto.Layout.cardview;
        if (r3 != r4) goto L_0x023f;
    L_0x0238:
        r3 = r11.c;
        r3.setVisibility(r10);
        goto L_0x00c7;
    L_0x023f:
        r3 = r11.j;
        r3 = r3.getPreviewType();
        r4 = com.puzzlersworld.wp.dto.PreviewType.excerpt;
        if (r3 != r4) goto L_0x0258;
    L_0x0249:
        r3 = r11.c;
        r4 = r12.getExcerpt();
        r4 = com.puzzlersworld.android.util.w.d(r4);
        r3.setText(r4);
        goto L_0x00c7;
    L_0x0258:
        r3 = r11.c;
        r4 = r12.getExcerpt();
        r3.setText(r4);
        goto L_0x00c7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.puzzlersworld.android.ui.a.c.a(com.puzzlersworld.wp.dto.Post):void");
    }

    public void b(int i) {
        this.h = i;
    }
}

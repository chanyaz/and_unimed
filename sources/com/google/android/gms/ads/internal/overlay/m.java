package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.kb;
import com.google.android.gms.internal.ads.zzadh;
import javax.annotation.Nullable;

@zzadh
public final class m extends FrameLayout implements OnClickListener {
    private final ImageButton a;
    private final zzw b;

    public m(Context context, n nVar, @Nullable zzw zzw) {
        super(context);
        this.b = zzw;
        setOnClickListener(this);
        this.a = new ImageButton(context);
        this.a.setImageResource(17301527);
        this.a.setBackgroundColor(0);
        this.a.setOnClickListener(this);
        ImageButton imageButton = this.a;
        akc.a();
        int a = kb.a(context, nVar.a);
        akc.a();
        int a2 = kb.a(context, 0);
        akc.a();
        int a3 = kb.a(context, nVar.b);
        akc.a();
        imageButton.setPadding(a, a2, a3, kb.a(context, nVar.d));
        this.a.setContentDescription("Interstitial close button");
        akc.a();
        kb.a(context, nVar.e);
        View view = this.a;
        akc.a();
        a2 = kb.a(context, (nVar.e + nVar.a) + nVar.b);
        akc.a();
        addView(view, new LayoutParams(a2, kb.a(context, nVar.e + nVar.d), 17));
    }

    public final void a(boolean z) {
        if (z) {
            this.a.setVisibility(8);
        } else {
            this.a.setVisibility(0);
        }
    }

    public final void onClick(View view) {
        if (this.b != null) {
            this.b.zzni();
        }
    }
}

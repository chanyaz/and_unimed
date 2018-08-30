package com.puzzlersworld.android.ui.a;

import android.content.Context;
import android.net.Uri;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.dto.CartItem;
import com.puzzlersworld.wp.dto.Layout;
import com.squareup.picasso.Picasso;
import java.util.Map;

public class a {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public Button e;
    public Button f;
    int g;
    int h;
    int i;
    Context j;
    public ImageView k;
    public ImageButton l;

    public a(Context context) {
        this.j = context;
    }

    private String a(Map<String, String> map) {
        String str = "";
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                if (!str.isEmpty()) {
                    str = str + ", ";
                }
                str = str + str2 + " " + ((String) map.get(str2));
            }
        }
        return str;
    }

    private void d(int i) {
        this.k.setMaxHeight(i);
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(CartItem cartItem) {
        Uri uri = null;
        if (cartItem.getImage() != null && cartItem.getImage().length() > 0) {
            uri = Uri.parse(cartItem.getImage());
        }
        if (uri != null) {
            this.k.setScaleType(ScaleType.CENTER_CROP);
            if (FullscreenActivity.y() == Layout.cardview) {
                d(this.g);
            }
            Picasso.a(this.j).a(cartItem.getImage()).a(this.k);
        }
        this.a.setText(w.d(cartItem.getTitle()));
        this.d.setText("" + cartItem.getQuantity());
        this.c.setText("" + cartItem.getSellingPrice());
        this.e.setTag(cartItem.getCart_item_key());
        this.f.setTag(cartItem.getCart_item_key());
        CharSequence a = a(cartItem.getVariation());
        if (!a.isEmpty()) {
            this.b.setVisibility(0);
        }
        this.b.setText(a);
    }

    public void b(int i) {
        this.h = i;
    }

    public void c(int i) {
        this.i = i;
    }
}

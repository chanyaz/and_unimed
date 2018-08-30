package com.puzzlersworld.android.util;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.wp.dto.Cart;
import com.puzzlersworld.wp.dto.CartItem;
import com.puzzlersworld.wp.dto.LineItem;
import com.puzzlersworld.wp.dto.Product;
import com.puzzlersworld.wp.dto.ProductAttribute;
import com.puzzlersworld.wp.dto.ThemeColors;
import com.puzzlersworld.wp.dto.Variation;
import com.puzzlersworld.wp.service.CartService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mobi.androapp.ac.c8700.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.ai;

public class b {
    public static CartItem a(Cart cart, Long l, Long l2) {
        CartItem cartItem;
        Iterator it = cart.getCart_items().iterator();
        while (it.hasNext()) {
            cartItem = (CartItem) it.next();
            if (l2 != null && l2.equals(cartItem.getVariation_id())) {
                return cartItem;
            }
        }
        it = cart.getCart_items().iterator();
        while (it.hasNext()) {
            cartItem = (CartItem) it.next();
            if (l != null && l.equals(cartItem.getProductId())) {
                return cartItem;
            }
        }
        return null;
    }

    public static CartItem a(Cart cart, String str) {
        if (str == null) {
            return null;
        }
        Iterator it = cart.getCart_items().iterator();
        while (it.hasNext()) {
            CartItem cartItem = (CartItem) it.next();
            if (str.equals(cartItem.getCart_item_key())) {
                return cartItem;
            }
        }
        return null;
    }

    public static Map<String, String> a(Product product, Long l) {
        Map<String, String> hashMap = new HashMap();
        for (Variation variation : product.getVariations()) {
            if (l.equals(variation.getId())) {
                for (ProductAttribute productAttribute : variation.getAttributes()) {
                    hashMap.put(productAttribute.getName(), productAttribute.getOption());
                }
                return hashMap;
            }
        }
        return hashMap;
    }

    public static void a(Activity activity, final com.puzzlersworld.android.data.b bVar, CartService cartService, final Long l, final Long l2, Map<String, String> map, final AddToCartListener addToCartListener) {
        LineItem lineItem = new LineItem();
        lineItem.setQuantity(Integer.valueOf(1));
        lineItem.setProduct_id(l);
        lineItem.setVariation_id(l2);
        if (l2 != null) {
            lineItem.setVariations(map);
        }
        cartService.addToCart(lineItem).enqueue(new Callback<Cart>() {
            public void onFailure(Call<Cart> call, Throwable th) {
                if (addToCartListener != null) {
                    addToCartListener.onAddToCartFailure(th);
                }
            }

            public void onResponse(Call<Cart> call, ai<Cart> aiVar) {
                Cart cart = (Cart) aiVar.b();
                CartItem cartItem = null;
                if (cart != null) {
                    cartItem = b.a(cart, l, l2);
                    bVar.a(cartItem);
                }
                if (addToCartListener != null) {
                    addToCartListener.onAddToCartSuccess(cart, aiVar, cartItem);
                }
            }
        });
    }

    public static void a(Activity activity, final com.puzzlersworld.android.data.b bVar, CartService cartService, final String str, Integer num, final AddToCartListener addToCartListener) {
        CartItem cartItem = new CartItem();
        cartItem.setCart_item_key(str);
        cartItem.setQuantity(num);
        cartService.updateCart(cartItem).enqueue(new Callback<Cart>() {
            public void onFailure(Call<Cart> call, Throwable th) {
                if (addToCartListener != null) {
                    addToCartListener.onUpdateCartFailure(th);
                }
            }

            public void onResponse(Call<Cart> call, ai<Cart> aiVar) {
                Cart cart = (Cart) aiVar.b();
                CartItem cartItem = null;
                if (cart != null) {
                    cartItem = b.a(cart, str);
                    bVar.a(cartItem);
                }
                if (addToCartListener != null) {
                    addToCartListener.onUpdateCartSuccess(cart, aiVar, cartItem);
                }
            }
        });
    }

    public static void a(Activity activity, com.puzzlersworld.android.data.b bVar, CartService cartService, List<CartItem> list, AddToCartListener addToCartListener) {
        List arrayList = new ArrayList(list.size());
        for (CartItem fromCartItem : list) {
            arrayList.add(LineItem.fromCartItem(fromCartItem));
        }
        b(activity, bVar, cartService, arrayList, addToCartListener);
    }

    public static void a(Menu menu, com.puzzlersworld.android.data.b bVar) {
        MenuItem findItem = menu.findItem(R.id.cart);
        Log.i("AndroApp", "Prepare cart menu");
        if (findItem != null) {
            try {
                if (FullscreenActivity.A() == null || FullscreenActivity.A().getShowCartIcon() == null || FullscreenActivity.A().getShowCartIcon().intValue() != 1 || FullscreenActivity.E() == null || FullscreenActivity.E().getW() == null || !FullscreenActivity.E().getW().booleanValue()) {
                    findItem.setVisible(false);
                    return;
                }
                findItem.setVisible(true);
                View a = MenuItemCompat.a(findItem);
                if (a != null) {
                    TextView textView = (TextView) a.findViewById(R.id.cart_counts);
                    a(textView);
                    ImageView imageView = (ImageView) a.findViewById(R.id.cart_icon);
                    textView.setText("" + bVar.a());
                    OnClickListener anonymousClass1 = new OnClickListener() {
                        public void onClick(View view) {
                            Log.d("AndroApp", "Clicked on Cart Icon");
                            Activity j = InjectibleApplication.j();
                            if (j instanceof FullscreenActivity) {
                                ((FullscreenActivity) j).q();
                            }
                        }
                    };
                    textView.setOnClickListener(anonymousClass1);
                    imageView.setOnClickListener(anonymousClass1);
                    a.setOnClickListener(anonymousClass1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void a(TextView textView) {
        ThemeColors z = FullscreenActivity.z();
        if (z != null) {
            textView.setTextColor(Color.parseColor(z.getActionBarTitleColor()));
            Drawable background = textView.getBackground();
            if (z.getStatusBarBgColor() == null) {
                return;
            }
            if (background instanceof ShapeDrawable) {
                ((ShapeDrawable) background).getPaint().setColor(Color.parseColor(z.getStatusBarBgColor()));
            } else if (background instanceof GradientDrawable) {
                ((GradientDrawable) background).setColor(Color.parseColor(z.getStatusBarBgColor()));
            }
        }
    }

    public static void b(Activity activity, final com.puzzlersworld.android.data.b bVar, CartService cartService, List<LineItem> list, final AddToCartListener addToCartListener) {
        cartService.addItemsToCart(list).enqueue(new Callback<Cart>() {
            public void onFailure(Call<Cart> call, Throwable th) {
                if (addToCartListener != null) {
                    addToCartListener.onAddToCartFailure(th);
                }
            }

            public void onResponse(Call<Cart> call, ai<Cart> aiVar) {
                Cart cart = (Cart) aiVar.b();
                if (cart != null) {
                    Iterator it = cart.getCart_items().iterator();
                    while (it.hasNext()) {
                        bVar.a((CartItem) it.next());
                    }
                }
                if (addToCartListener != null) {
                    addToCartListener.onAddToCartSuccess(cart, aiVar, null);
                }
            }
        });
    }
}

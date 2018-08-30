package com.puzzlersworld.android.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.FriopinApplication;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.common.AndroAppFragmentType;
import com.puzzlersworld.android.data.b;
import com.puzzlersworld.android.exception.UiErrorHandler;
import com.puzzlersworld.android.exception.a;
import com.puzzlersworld.android.ui.a.d;
import com.puzzlersworld.android.util.AddToCartListener;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.annotations.ForBackground;
import com.puzzlersworld.android.util.annotations.ForUi;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.dto.Cart;
import com.puzzlersworld.wp.dto.CartItem;
import com.puzzlersworld.wp.dto.CouponLine;
import com.puzzlersworld.wp.dto.CreateOrderRequest;
import com.puzzlersworld.wp.dto.Customer;
import com.puzzlersworld.wp.dto.LineItem;
import com.puzzlersworld.wp.dto.Menu;
import com.puzzlersworld.wp.dto.MenuItemType;
import com.puzzlersworld.wp.dto.Order;
import com.puzzlersworld.wp.dto.StringConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.ai;

public class CartActivity extends Fragment implements UiErrorHandler, AndroAppFragment, AddToCartListener {
    @Inject
    g a;
    private LinearLayout ae;
    private LinearLayout af;
    private LinearLayout ag;
    private LinearLayout ah;
    private OnClickListener ai;
    private OnClickListener aj;
    private OnClickListener ak;
    private OnClickListener al;
    private a am = new a(this);
    private Cart an;
    private CreateOrderRequest ao;
    @Inject
    b b;
    @Inject
    @ForBackground
    ListeningScheduledExecutorService c;
    @ForUi
    @Inject
    ListeningExecutorService d;
    @Inject
    public ObjectMapper e;
    @Inject
    RestServiceManager f;
    private EditText g;
    private LinearLayout h;
    private LinearLayout i;

    private View a(CartItem cartItem) {
        View inflate = LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.cart_cell, null);
        com.puzzlersworld.android.ui.a.a aVar = new com.puzzlersworld.android.ui.a.a(getLifecycleActivity());
        aVar.a = (TextView) inflate.findViewById(R.id.title);
        aVar.k = (ImageView) inflate.findViewById(R.id.post_image);
        aVar.d = (TextView) inflate.findViewById(R.id.quantity);
        aVar.c = (TextView) inflate.findViewById(R.id.sellingprice);
        aVar.b = (TextView) inflate.findViewById(R.id.variant);
        aVar.l = (ImageButton) inflate.findViewById(R.id.removeFromCart);
        aVar.e = (Button) inflate.findViewById(R.id.minus);
        aVar.f = (Button) inflate.findViewById(R.id.plus);
        aVar.a(d.a(getLifecycleActivity()));
        aVar.b(d.b(getLifecycleActivity()));
        aVar.c(d.c(getLifecycleActivity()));
        inflate.setTag(aVar);
        aVar.a(cartItem);
        aVar.l.setOnClickListener(this.al);
        aVar.f.setOnClickListener(this.aj);
        aVar.e.setOnClickListener(this.ai);
        aVar.l.setTag(cartItem);
        return inflate;
    }

    private Customer a() {
        String g = this.a.g();
        return !g.isEmpty() ? (Customer) this.e.readValue(g, Customer.class) : null;
    }

    private void a(Cart cart) {
        this.ah.removeAllViews();
        Iterator it = cart.getCart_items().iterator();
        while (it.hasNext()) {
            this.ah.addView(a((CartItem) it.next()));
        }
    }

    private void a(String str, int i) {
        com.puzzlersworld.android.util.b.a(getLifecycleActivity(), this.b, this.f.getCartService(), str, Integer.valueOf(i), this);
    }

    private void a(List<CartItem> list) {
        this.ao = new CreateOrderRequest();
        Order order = new Order();
        this.ao.setOrder(order);
        if (list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (CartItem c : list) {
                arrayList.add(c(c));
            }
            order.setLine_items(arrayList);
        }
    }

    private void ac() {
        try {
            final Cart cart = (Cart) this.f.getCartService().getCartDetails().execute().b();
            if (cart == null) {
                throw new Exception("Server Error");
            }
            this.d.execute(new Runnable() {
                public void run() {
                    if (cart != null) {
                        CartActivity.this.an = cart;
                        if (CartActivity.this.an.getCart_items() == null || (CartActivity.this.an.getCart_items().size() == 0 && CartActivity.this.b.a() > 0)) {
                            Log.d("AndroApp", "Cart Refill");
                            CartActivity.this.ad();
                        }
                    }
                    CartActivity.this.b(CartActivity.this.an);
                }
            });
        } catch (Exception e) {
            this.am.a(e);
        }
    }

    private void ad() {
        com.puzzlersworld.android.util.b.a(getLifecycleActivity(), this.b, this.f.getCartService(), this.b.c(), this);
    }

    private void b(Cart cart) {
        this.an = cart;
        this.af.setVisibility(8);
        this.ae.setVisibility(8);
        if (cart.getCart_items() == null || cart.getCart_items().size() == 0) {
            this.i.setVisibility(8);
            this.ae.setVisibility(0);
            ((TextView) this.ae.findViewById(R.id.cartEmpty)).setText(StringConstants.CART_EMPTY.getMessage());
            return;
        }
        this.i.setVisibility(0);
        a(cart);
        this.h.removeAllViews();
        Iterator it = cart.getCoupon_lines().iterator();
        while (it.hasNext()) {
            CouponLine couponLine = (CouponLine) it.next();
            View inflate = LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.cart_details_line, null);
            TextView textView = (TextView) inflate.findViewById(R.id.couponMessage);
            Button button = (Button) inflate.findViewById(R.id.removeCoupon);
            button.setTag(couponLine.getCode());
            button.setOnClickListener(this.ak);
            textView.setText(StringConstants.COUPON.getMessage() + ": " + couponLine.getCode() + " " + StringConstants.APPLIED.getMessage());
            this.h.addView(inflate);
        }
        c(cart);
    }

    private void b(final CartItem cartItem) {
        Log.d("AndroApp", "Remove called");
        this.f.getCartService().removeFromCart(cartItem).enqueue(new Callback<Cart>() {
            public void onFailure(Call<Cart> call, Throwable th) {
            }

            public void onResponse(Call<Cart> call, ai<Cart> aiVar) {
                Cart cart = (Cart) aiVar.b();
                if (cart != null) {
                    CartActivity.this.an = cart;
                    CartActivity.this.b.a(cartItem.getCart_item_key());
                    CartActivity.this.b(CartActivity.this.an);
                    return;
                }
                w.a(CartActivity.this.getLifecycleActivity(), (ai) aiVar);
            }
        });
    }

    private void b(String str) {
        this.af.setVisibility(0);
        this.i.setVisibility(8);
        this.ae.setVisibility(8);
        ((TextView) this.af.findViewById(R.id.cartError)).setText(str);
    }

    private LineItem c(CartItem cartItem) {
        LineItem lineItem = new LineItem();
        lineItem.setProduct_id(cartItem.getProductId());
        lineItem.setQuantity(cartItem.getQuantity());
        return lineItem;
    }

    private void c(Cart cart) {
        TextView textView = (TextView) this.ag.findViewById(R.id.discountValue);
        TextView textView2 = (TextView) this.ag.findViewById(R.id.taxesValue);
        TextView textView3 = (TextView) this.ag.findViewById(R.id.totalValue);
        ((TextView) this.ag.findViewById(R.id.subtotalValue)).setText("" + cart.getSubtotal_ex_tax());
        textView2.setText("" + cart.getTax_total());
        textView.setText("" + cart.getDiscount_cart());
        textView3.setText("" + ((cart.getSubtotal_ex_tax().doubleValue() - cart.getDiscount_cart().doubleValue()) + cart.getTax_total().doubleValue()));
    }

    private void c(String str) {
        a(str, com.puzzlersworld.android.util.b.a(this.an, str).getQuantity().intValue() - 1);
    }

    private void d(String str) {
        a(str, com.puzzlersworld.android.util.b.a(this.an, str).getQuantity().intValue() + 1);
    }

    private void e(String str) {
        CouponLine couponLine = new CouponLine();
        couponLine.setCode(str);
        this.f.getCartService().removeCoupon(couponLine).enqueue(new Callback<Cart>() {
            public void onFailure(Call<Cart> call, Throwable th) {
            }

            public void onResponse(Call<Cart> call, ai<Cart> aiVar) {
                Cart cart = (Cart) aiVar.b();
                if (cart != null) {
                    CartActivity.this.an = cart;
                    CartActivity.this.d.execute(new Runnable() {
                        public void run() {
                            CartActivity.this.b(CartActivity.this.an);
                        }
                    });
                    return;
                }
                w.a(CartActivity.this.getLifecycleActivity(), (ai) aiVar);
            }
        });
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.cart_activity, viewGroup, false);
        InjectibleApplication.a((Fragment) this);
        Button button = (Button) inflate.findViewById(R.id.checkout);
        button.setText(StringConstants.CHECKOUT.getMessage());
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Activity j = InjectibleApplication.j();
                if (j instanceof FullscreenActivity) {
                    try {
                        Customer a = CartActivity.this.a();
                        if (a != null) {
                            CartActivity.this.ao.getOrder().setBilling_address(a.getBilling_address());
                            CartActivity.this.ao.getOrder().setShipping_address(a.getShipping_address());
                            CartActivity.this.ao.getOrder().setCustomer_id(a.getId());
                        }
                        ArrayList arrayList = new ArrayList();
                        if (CartActivity.this.an.getCart_items() != null) {
                            Iterator it = CartActivity.this.an.getCart_items().iterator();
                            while (it.hasNext()) {
                                arrayList.add(LineItem.fromCartItem((CartItem) it.next()));
                            }
                        }
                        CartActivity.this.ao.getOrder().setLine_items(arrayList);
                        if (CartActivity.this.an.getCoupon_lines() != null) {
                            CartActivity.this.ao.getOrder().setCoupon_lines(CartActivity.this.an.getCoupon_lines());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (FullscreenActivity.s.isEmpty()) {
                        CartActivity.this.startActivityForResult(new Intent(CartActivity.this.getLifecycleActivity(), LoginActivity.class), 12424);
                        return;
                    }
                    ((FullscreenActivity) j).a(CartActivity.this.ao, CartActivity.this.an);
                }
            }
        });
        if (FullscreenActivity.z() != null) {
            inflate.setBackgroundColor(Color.parseColor(FullscreenActivity.z().getScreenBgColor()));
        }
        this.al = new OnClickListener() {
            public void onClick(View view) {
                CartActivity.this.b((CartItem) view.getTag());
            }
        };
        this.aj = new OnClickListener() {
            public void onClick(View view) {
                CartActivity.this.d((String) view.getTag());
            }
        };
        this.ai = new OnClickListener() {
            public void onClick(View view) {
                CartActivity.this.c((String) view.getTag());
            }
        };
        a(new ArrayList());
        this.ah = (LinearLayout) inflate.findViewById(R.id.cartItems);
        this.h = (LinearLayout) inflate.findViewById(R.id.couponDetailsLayout);
        this.i = (LinearLayout) inflate.findViewById(R.id.cartDetails);
        this.ae = (LinearLayout) inflate.findViewById(R.id.cartEmptyLayout);
        this.af = (LinearLayout) inflate.findViewById(R.id.cartErrorLayout);
        this.ag = (LinearLayout) inflate.findViewById(R.id.price_details);
        ((TextView) this.ag.findViewById(R.id.subtotalHeader)).setText(StringConstants.SUBTOTAL.getMessage());
        ((TextView) this.ag.findViewById(R.id.taxesHeader)).setText(StringConstants.TAXES.getMessage());
        ((TextView) this.ag.findViewById(R.id.totalHeader)).setText(StringConstants.TOTAL.getMessage());
        ((TextView) this.ag.findViewById(R.id.discountHeader)).setText(StringConstants.Discount.getMessage());
        this.g = (EditText) inflate.findViewById(R.id.couponCode);
        this.g.setHint(StringConstants.ENTER_COUPON_CODE.getMessage());
        button = (Button) inflate.findViewById(R.id.applyCoupon);
        button.setText(StringConstants.APPLY_COUPON.getMessage());
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CouponLine couponLine = new CouponLine();
                couponLine.setCode(CartActivity.this.g.getText().toString());
                CartActivity.this.f.getCartService().applyCoupon(couponLine).enqueue(new Callback<Cart>() {
                    public void onFailure(Call<Cart> call, Throwable th) {
                    }

                    public void onResponse(Call<Cart> call, ai<Cart> aiVar) {
                        Cart cart = (Cart) aiVar.b();
                        if (cart != null) {
                            CartActivity.this.an = cart;
                            CartActivity.this.d.execute(new Runnable() {
                                public void run() {
                                    CartActivity.this.b(CartActivity.this.an);
                                }
                            });
                            return;
                        }
                        w.a(CartActivity.this.getLifecycleActivity(), (ai) aiVar);
                    }
                });
            }
        });
        this.ak = new OnClickListener() {
            public void onClick(View view) {
                CartActivity.this.e((String) view.getTag());
            }
        };
        try {
            a();
        } catch (IOException e) {
            e.printStackTrace();
        }
        button = (Button) this.ae.findViewById(R.id.shop);
        button.setText(StringConstants.BROWSE_PRODUCTS.getMessage());
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Menu menu = new Menu();
                menu.setName(StringConstants.HOME.getMessage());
                menu.setMenuItemType(MenuItemType.home);
                ((FullscreenActivity) CartActivity.this.getLifecycleActivity()).a(menu, -1);
            }
        });
        button = (Button) this.af.findViewById(R.id.reload);
        button.setText(StringConstants.RETRY.getMessage());
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CartActivity.this.c.execute(new Runnable() {
                    public void run() {
                        CartActivity.this.ac();
                    }
                });
            }
        });
        this.c.execute(new Runnable() {
            public void run() {
                CartActivity.this.ac();
            }
        });
        return inflate;
    }

    public void a(android.view.Menu menu, MenuInflater menuInflater) {
        Log.d("AndroApp:", "OnCreateOptionsMenu Called CartActivity");
        menu.clear();
        super.a(menu, menuInflater);
    }

    public void b(Bundle bundle) {
        super.b(bundle);
        d(true);
    }

    public AndroAppFragmentType getFragmentType() {
        return AndroAppFragmentType.CART_ACTIVITY;
    }

    public String getTitle() {
        return StringConstants.CART.getMessage();
    }

    public Object getTriggerObject() {
        return null;
    }

    public void onAddToCartFailure(Throwable th) {
    }

    public void onAddToCartSuccess(Cart cart, ai<Cart> aiVar, CartItem cartItem) {
        if (cart != null) {
            this.b.b();
            b(cart);
        }
    }

    public void onConnectionTimeout() {
        b(StringConstants.CONNECTION_TIMEOUT.getMessage());
    }

    public void onError(Exception exception) {
        b(StringConstants.UNKNOWN_ERROR.getMessage());
    }

    public void onNoNetwork() {
        b(StringConstants.CANT_CONNECT.getMessage());
    }

    public void onUpdateCartFailure(Throwable th) {
        this.am.a(new Exception(th));
    }

    public void onUpdateCartSuccess(Cart cart, ai<Cart> aiVar, CartItem cartItem) {
        if (cart != null) {
            b(cart);
        }
    }

    public void t() {
        super.t();
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).a(getFragmentType());
            ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
            ((FullscreenActivity) getLifecycleActivity()).b(false);
        }
        FriopinApplication.a().a("cart screen");
    }
}

package com.puzzlersworld.wp.service;

import com.puzzlersworld.wp.dto.Cart;
import com.puzzlersworld.wp.dto.CartItem;
import com.puzzlersworld.wp.dto.CouponLine;
import com.puzzlersworld.wp.dto.LineItem;
import com.puzzlersworld.wp.dto.Order;
import com.puzzlersworld.wp.dto.ShippingLine;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CartService {
    @POST("androappaddaddress/")
    Call<Cart> addAddress(@Body Order order);

    @POST("androapp/addtocart/bulk")
    Call<Cart> addItemsToCart(@Body List<LineItem> list);

    @POST("androappaddshippingmethod/")
    Call<Cart> addShippingMethod(@Body ShippingLine shippingLine);

    @POST("androappaddtocart")
    Call<Cart> addToCart(@Body LineItem lineItem);

    @POST("androappapplycoupon/")
    Call<Cart> applyCoupon(@Body CouponLine couponLine);

    @GET("androappgetcart/")
    Call<Cart> getCartDetails();

    @GET("androappgetstates/")
    Call<Map<String, String>> getStates(@Query("cc") String str);

    @POST("androappremovecoupon/")
    Call<Cart> removeCoupon(@Body CouponLine couponLine);

    @POST("androappremovefromcart")
    Call<Cart> removeFromCart(@Body CartItem cartItem);

    @POST("androappupdatecart")
    Call<Cart> updateCart(@Body CartItem cartItem);
}

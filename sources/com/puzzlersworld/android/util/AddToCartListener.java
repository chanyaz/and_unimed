package com.puzzlersworld.android.util;

import com.puzzlersworld.wp.dto.Cart;
import com.puzzlersworld.wp.dto.CartItem;
import retrofit2.ai;

public interface AddToCartListener {
    void onAddToCartFailure(Throwable th);

    void onAddToCartSuccess(Cart cart, ai<Cart> aiVar, CartItem cartItem);

    void onUpdateCartFailure(Throwable th);

    void onUpdateCartSuccess(Cart cart, ai<Cart> aiVar, CartItem cartItem);
}

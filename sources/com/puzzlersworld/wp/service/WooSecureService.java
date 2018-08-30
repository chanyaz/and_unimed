package com.puzzlersworld.wp.service;

import com.puzzlersworld.wp.dto.CreateOrderRequest;
import com.puzzlersworld.wp.dto.Customer;
import com.puzzlersworld.wp.dto.Order;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WooSecureService {
    @POST("androappcreateorder")
    Call<Order> createOrder(@Body CreateOrderRequest createOrderRequest);

    @GET("androapp/woo/me")
    Call<Customer> getCustomerInfo();

    @GET("androapp/woo/order")
    Call<Order> getOrderInfo(@Query("orderId") Long l);
}

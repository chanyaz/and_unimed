package com.puzzlersworld.wp.service;

import com.puzzlersworld.wp.dto.Comment;
import com.puzzlersworld.wp.dto.Config;
import com.puzzlersworld.wp.dto.CreateCommentRequest;
import com.puzzlersworld.wp.dto.CreateCustomerRequest;
import com.puzzlersworld.wp.dto.Customer;
import com.puzzlersworld.wp.dto.Post;
import com.puzzlersworld.wp.dto.Product;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface WpApiService {
    @POST("androapp/add/{postId}/comments")
    Call<Object> addComment(@Path("postId") Long l, @Body CreateCommentRequest createCommentRequest);

    @POST("androapp/add/{postId}/comments_new")
    Call<Comment> addCommentNew(@Path("postId") Long l, @Body CreateCommentRequest createCommentRequest);

    @POST("androapp/woo/customers")
    Call<Customer> createCustomer(@Body CreateCustomerRequest createCustomerRequest);

    @GET("androappposts")
    Call<List<Post>> fetchAndroAppPosts(@QueryMap Map<String, String> map);

    @GET("androappconfig")
    Call<Config> fetchConfig();

    @GET("posts")
    Call<List<Post>> fetchPosts(@QueryMap Map<String, String> map);

    @GET("androappgetproducts")
    Call<List<Product>> fetchProducts(@QueryMap Map<String, String> map);

    @GET("posts/slug")
    Call<Object> fetchUrl(@Query("slug") String str);

    @GET("gcm/register/{regId}")
    Call<String> registerUser(@Path("regId") String str, @Query("topics") String str2);
}

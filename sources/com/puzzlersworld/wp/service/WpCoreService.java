package com.puzzlersworld.wp.service;

import com.puzzlersworld.wp.dto.Comment;
import com.puzzlersworld.wp.dto.Post;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface WpCoreService {
    @GET("posts/{postId}/comments")
    Call<List<Comment>> fetchComments(@Path("postId") Long l);

    @GET("comments")
    Call<List<Comment>> fetchCommentsV2(@Query("post") Long l);

    @GET("{customPostType}/{postId}")
    Call<Post> fetchCustomPostV2(@Path("customPostType") String str, @Path("postId") Long l);

    @GET("{customPostType}")
    Call<List<Post>> fetchCustomPostsV2(@Path("customPostType") String str, @QueryMap Map<String, String> map);

    @GET("pages/{pageId}")
    Call<Post> fetchPage(@Path("pageId") Long l);

    @GET("pages")
    Call<List<Post>> fetchPages(@QueryMap Map<String, String> map);

    @GET("posts/{postId}")
    Call<Post> fetchPost(@Path("postId") Long l);

    @GET("posts")
    Call<List<Post>> fetchPosts(@QueryMap Map<String, String> map);
}

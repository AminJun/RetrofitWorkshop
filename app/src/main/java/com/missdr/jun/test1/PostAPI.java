package com.missdr.jun.test1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jun on 7/28/16.
 * A Lyan template!
 */
public interface PostAPI {
    @GET("/posts/")
    Call<List<Post>> getMyPosts();
}

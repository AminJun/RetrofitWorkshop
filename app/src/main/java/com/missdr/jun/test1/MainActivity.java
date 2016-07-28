package com.missdr.jun.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BLOG_POST_ID_KEY = "com.missdr.jun.test1.MainActivity.BLOG_POST_ID_KEY";
    private ListView mlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlistView = (ListView) findViewById(R.id.posts_list);
//        mlistView.setAdapter(new PostAdapter(new MockedDB().getPosts(), this));

        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.194.30:8000")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        PostAPI myposts = retrofit.create(PostAPI.class);
        myposts.getMyPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> list = response.body();
                mlistView.setAdapter(new PostAdapter(list, MainActivity.this));
                mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        showItem(position);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });



    }


    private void showItem(int id) {
        Log.d("MTM", " Starting activity " + id);
        Intent intent = new Intent(this, ShowBlogPostActivity.class);
        intent.putExtra(BLOG_POST_ID_KEY, id);

        startActivity(intent);
    }

}

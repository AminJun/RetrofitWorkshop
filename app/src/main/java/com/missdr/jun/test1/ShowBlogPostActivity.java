package com.missdr.jun.test1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowBlogPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_blog_post);

        int id = getIntent().getExtras().getInt(MainActivity.BLOG_POST_ID_KEY);
        Post p = new MockedDB().getPosts().get(id);

        TextView author = (TextView) findViewById(R.id.author);
        author.setText(p.getAuthor());
    }
}

package com.missdr.jun.test1;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jun on 7/28/16.
 * A Lyan template!
 */
public class PostAdapter extends BaseAdapter {
    private final List<Post> list;
    private final Activity activity;

    public PostAdapter(List<Post> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = activity.getLayoutInflater().inflate(R.layout.post_item, parent, false);

        Post p = (Post) this.getItem(position);
        TextView author = (TextView) convertView.findViewById(R.id.author);
        TextView description = (TextView) convertView.findViewById(R.id.description);
        TextView likes = (TextView) convertView.findViewById(R.id.mylikes);
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        ImageView blogImage = (ImageView) convertView.findViewById(R.id.blogimage);

        author.setText(p.getAuthor());
        description.setText(p.getDescription());
        likes.setText(String.valueOf(p.getLikes()));
        icon.setImageResource(R.drawable.heart);
        Picasso.with(activity).load(p.getImage())
                .placeholder(R.drawable.ic_downloding)
                .error(R.drawable.ic_fail_24dp)
                .into(blogImage);




        return convertView;
    }
}

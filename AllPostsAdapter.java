package com.clubconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class AllPostsAdapter extends ArrayAdapter<Posts> {

    private Context context;
    private List<Posts> postsList;

    public AllPostsAdapter(Context context, List<Posts> postsList) {
        super(context, 0, postsList);
        this.context = context;
        this.postsList = postsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.student_post_item, parent, false);
        }

        // Get the post object for this position
        Posts post = getItem(position);

        // Populate the views with the post data
        TextView titleTextView = convertView.findViewById(R.id.clubname);
        TextView contentTextView = convertView.findViewById(R.id.postdescs);

        if (post != null) {
            titleTextView.setText(post.getClubName());
            contentTextView.setText(post.getPostDesc());
        }

        return convertView;
    }

    // Add a method to add a post to the adapter
    public void addPost(Posts post) {
        postsList.add(post);
        notifyDataSetChanged();
    }

    // Add a method to clear all posts from the adapter
    public void clearPosts() {
        postsList.clear();
        notifyDataSetChanged();
    }
}

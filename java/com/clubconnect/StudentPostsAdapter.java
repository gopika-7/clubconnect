package com.clubconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentPostsAdapter extends RecyclerView.Adapter<StudentPostsAdapter.ViewHolder> {

    private final Context context;
    private List<Posts> postsList;

    public StudentPostsAdapter(Context context, List<Posts> postsList) {
        this.context = context;
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Posts post = postsList.get(position);
        holder.clubnameTextView.setText(post.getClubName());
        holder.postDescTextView.setText(post.getPostDesc());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView clubnameTextView, postDescTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            clubnameTextView = itemView.findViewById(R.id.clubnameTextView);
            postDescTextView = itemView.findViewById(R.id.postDescTextView);
        }
    }
}

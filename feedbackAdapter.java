package com.clubconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class feedbackAdapter extends RecyclerView.Adapter<feedbackAdapter.ViewHolder> {

    private Context context;
    private List<feedbackdata> feedbackList;

    public feedbackAdapter(Context context, List<feedbackdata> feedbackList) {
        this.context = context;
        this.feedbackList = feedbackList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.feedback_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        feedbackdata feedback = feedbackList.get(position);
        holder.nameTextView.setText(feedback.getName());
        holder.emailTextView.setText(feedback.getEmail());
        holder.feedbackTextView.setText(feedback.getFeedback());
    }

    @Override
    public int getItemCount() {
        return feedbackList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView emailTextView;
        TextView feedbackTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textViewName);
            emailTextView = itemView.findViewById(R.id.textViewEmail);
            feedbackTextView = itemView.findViewById(R.id.textViewFeedback);
        }
    }
}

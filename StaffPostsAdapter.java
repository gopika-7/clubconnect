package com.clubconnect;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StaffPostsAdapter extends RecyclerView.Adapter<StaffPostsAdapter.ViewHolder> {

    private final Context context;
    private List<staffpost> staffpostList;

    public StaffPostsAdapter(Context context, List<staffpost> staffpostList) {
        this.context = context;
        this.staffpostList = staffpostList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.staff_post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        staffpost post = staffpostList.get(position);
        holder.guestEditText.setText(post.getGuest());
        holder.numberStudentEditText.setText(String.valueOf(post.getNumberStudents()));
        holder.eventDateTimeEditText.setText(post.getEventDateTime());
        holder.postDescEditText.setText(post.getPostDesc());
        // Set image to PicsImageView using your method for loading images
        // For example:
        holder.PicsImageView.setImageURI(Uri.parse(post.getImageUri()));
    }

    @Override
    public int getItemCount() {
        return staffpostList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        EditText guestEditText, numberStudentEditText, eventDateTimeEditText, postDescEditText;
        ImageView PicsImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            guestEditText = itemView.findViewById(R.id.guestEditText);
            numberStudentEditText = itemView.findViewById(R.id.numberStudentEditText);
            eventDateTimeEditText = itemView.findViewById(R.id.eventDateTimeEditText);
            postDescEditText = itemView.findViewById(R.id.postDescEditText);
            PicsImageView = itemView.findViewById(R.id.PicsImageView);
        }
    }
}

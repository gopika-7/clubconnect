package com.clubconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    private Context context;
    private List<profiledata> profileList;

    public ProfileAdapter(Context context, List<profiledata> profileList) {
        this.context = context;
        this.profileList = profileList;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.studentprofile_item, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        profiledata profile = profileList.get(position);
        holder.bind(profile);
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, rollNoTextView, clubCategoryTextView, emailTextView;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            rollNoTextView = itemView.findViewById(R.id.rollNoTextView);
            clubCategoryTextView = itemView.findViewById(R.id.clubCategoryTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
        }

        public void bind(profiledata profile) {
            nameTextView.setText(profile.getName());
            rollNoTextView.setText(profile.getRollNo());
            clubCategoryTextView.setText(profile.getClubCategory());
            emailTextView.setText(profile.getEmail());
        }
    }
}

package com.clubconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private Context context;
    private List<EventHelper> eventHelperList;

    public EventAdapter(Context context, List<EventHelper> eventHelperList) {
        this.context = context;
        this.eventHelperList = eventHelperList;
    }

    public EventAdapter(FirebaseRecyclerOptions<EventHelper> options) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EventHelper event = eventHelperList.get(position);
        holder.eventNameTextView.setText(event.getEventName());
        holder.eventDateTimeTextView.setText(event.getEventDate());
        holder.eventLocationTextView.setText(event.getEventLocation());
        holder.eventDescriptionTextView.setText(event.getEventDescription());

        // Use EventHelper to fetch additional data

    }

    @Override
    public int getItemCount() {
        return eventHelperList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView eventNameTextView;
        TextView eventDateTimeTextView;
        TextView eventLocationTextView;
        TextView eventDescriptionTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventNameTextView = itemView.findViewById(R.id.textViewEventName);
            eventDateTimeTextView = itemView.findViewById(R.id.textViewEventDateTime);
            eventLocationTextView = itemView.findViewById(R.id.textViewEventLocation);
            eventDescriptionTextView = itemView.findViewById(R.id.textViewEventDescription);
        }
    }
}

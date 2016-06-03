package com.wokkaflokka.calabashrecyclerviewtest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wokkaflokka.calabashrecyclerviewtest.R;
import com.wokkaflokka.calabashrecyclerviewtest.configuration.PhotoConfiguration;
import com.wokkaflokka.calabashrecyclerviewtest.dtos.Image;
import com.wokkaflokka.calabashrecyclerviewtest.viewholders.LeftImage;
import com.wokkaflokka.calabashrecyclerviewtest.viewholders.RightImage;

public class PhotosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private PhotoConfiguration configuration;
    private final LayoutInflater inflater;
    private final View.OnClickListener listener;


    public PhotosAdapter(Context context, View.OnClickListener listener, PhotoConfiguration configuration) {
        this.configuration = configuration;
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Image image = configuration.getItemAtPosition(position);
        TextView caption = (TextView) holder.itemView.findViewById(R.id.caption);
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.image_view);

        caption.setText(image.getCaption());

        Picasso.with(holder.itemView.getContext()).load(image.getUrl()).into(imageView);

        holder.itemView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return configuration.getItemCount();
    }

    public void setConfiguration(PhotoConfiguration configuration) {
        this.configuration = configuration;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.grid_item_image, parent, false);
        StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) v.getLayoutParams();
        params.setFullSpan(false);

        if (viewType == 0) {
            return new LeftImage(v);
        } else {
            return new RightImage(v);
        }
    }
}
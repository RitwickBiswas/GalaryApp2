package com.example.galaryapp2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.galaryapp2.Activities.FullScreenActivity;
import com.example.galaryapp2.Model.Cell;
import com.example.galaryapp2.R;

import java.util.ArrayList;

public class GalleryImageAdapter extends RecyclerView.Adapter<GalleryImageAdapter.ImageViewHolder> {

    Context context;
    private ArrayList<Cell> gallaryList;

    public GalleryImageAdapter(Context context, ArrayList<Cell> gallaryList) {
        this.context = context;
        this.gallaryList = gallaryList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.galery_item,parent,false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryImageAdapter.ImageViewHolder holder, final int position) {

        ImageView imageView = holder.img;
        Glide.with(context).load(gallaryList.get(position).getPath()).into(imageView);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullScreenActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("fullGalary" , gallaryList);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gallaryList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_image_view);

        }
    }
}

package com.example.galaryapp2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.galaryapp2.Activities.MainActivity;
import com.example.galaryapp2.R;

import java.io.File;
import java.util.ArrayList;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.FolderListHolder> {

    Context context;
    ArrayList<String> folderList;
    ArrayList<String> folderNameList;

    public FolderAdapter(Context context, ArrayList<String> folderList, ArrayList<String> folderName) {
        this.context = context;
        this.folderList = folderList;
        this.folderNameList = folderName;
    }

    @NonNull
    @Override
    public FolderListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.folder_item,parent,false);

        return new FolderListHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull FolderListHolder holder, final int position) {
        holder.folderName.setText(folderNameList.get(position));
        Log.d("image Path", "onBindViewHolder: "+folderNameList.get(position));
//        holder.imageView.setBackgroundResource(R.drawable.ic_launcher_foreground);
//        Glide.with(context).load(folderList.get(position).concat("/*.jpg")).into(holder.imageView);
        Log.d("image Path", "onBindViewHolder22: "+folderList.get(position));
//        GetSingleImage getSingleImage = new GetSingleImage();
//        getSingleImage.getImage(folderList.get(position));
//        File checkFile = new File(Environment.getDataDirectory().getAbsolutePath().concat(folderList.get(position)).concat("//"));
//        Log.d("image Path", "onBindViewHolder33: "+checkFile);
//        Log.d("image Path", "onBindViewHolder44: "+checkFile.length());
//        if(checkFile.length() > 0)
//        {
//
//                Log.d("image Path", "onBindViewHolder33: "+getSingleImage.getImage(folderList.get(position)).get(0).getPath());
//
//        }
//        Log.d("image Path", "onBindViewHolder22: "+emptyFolderCheck);
        if(folderList.get(position).length() > 0){
            GetSingleImage getSingleImage = new GetSingleImage();
//            getSingleImage.getImage(folderList.get(position));
            Glide.with(context).load(getSingleImage.getImage(folderList.get(position)).get(0).getPath()).into(holder.imageView);
            Log.d("image Path", "onBindViewHolder22: "+getSingleImage.getImage(folderList.get(position)).get(1).getPath());
        }
        else{

            //Give warning

        }


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("SubFolderPath",folderNameList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return folderList.size();
    }

    public class FolderListHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView folderName;
        public FolderListHolder(@NonNull View itemView) {
            super(itemView);
            folderName = itemView.findViewById(R.id.folder_name_card_view);
            imageView = itemView.findViewById(R.id.folder_id_image);

        }
    }
}

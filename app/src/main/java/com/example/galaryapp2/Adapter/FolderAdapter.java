package com.example.galaryapp2.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.FolderListHolder> {
    @NonNull
    @Override
    public FolderListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FolderListHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FolderListHolder extends RecyclerView.ViewHolder {
        public FolderListHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

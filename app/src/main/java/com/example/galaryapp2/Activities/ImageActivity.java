package com.example.galaryapp2.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.example.galaryapp2.Adapter.FolderAdapter;
import com.example.galaryapp2.Model.Cell;
import com.example.galaryapp2.R;

import java.io.File;
import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    RecyclerView recyclerViewFolder;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<String> allFolderPath = new ArrayList<>();
    ArrayList<String> allFoldername = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        recyclerViewFolder = findViewById(R.id.recycler_view_folder);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1000 );

        }
        else{
            getDirList();
        }

    }

    private void getDirList() {
        File file = new File(Environment.getExternalStorageDirectory(), "DCIM");
        Log.d("Files", "getDirList: "+file.listFiles());
        File[] pictures = file.listFiles();
        for(int i = 0; i < pictures.length  ; i++){
//            Log.d("FILE:", ""+pictures[i].getName());
            Log.d("FILE:", ""+pictures[i].getAbsolutePath());
            allFolderPath.add(pictures[i].getAbsolutePath());
            allFoldername.add(pictures[i].getName());
        }
        layoutManager = new GridLayoutManager(this,2);
        recyclerViewFolder.setLayoutManager(layoutManager);
        FolderAdapter folderAdapter = new FolderAdapter(this,allFolderPath,allFoldername);
        recyclerViewFolder.setAdapter(folderAdapter);
    }

}

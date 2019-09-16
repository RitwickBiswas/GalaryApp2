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
import android.view.View;

import com.example.galaryapp2.Adapter.GalleryImageAdapter;
import com.example.galaryapp2.Interface.RecyclerViewClickListner;
import com.example.galaryapp2.Model.Cell;
import com.example.galaryapp2.R;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListner {

    RecyclerView recyclerViewMain;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Cell> allFilesPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerViewMain = findViewById(R.id.recycler_view_main);
//        layoutManager = new GridLayoutManager(this,2);
//        recyclerViewMain.setHasFixedSize(true);
//        recyclerViewMain.setLayoutManager(layoutManager);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1000 );

        }
        else{
            showImages();
            getDirList();
        }
    }

    private void getDirList() {
        File file = new File(Environment.getExternalStorageDirectory(), "DCIM");
        Log.d("Files", "getDirList: "+file.listFiles());
        File[] pictures = file.listFiles();
        for(int i = 0; i < pictures.length; i++){
            Log.d("FILE:", ""+pictures[i].getName());
        }
    }

    private void showImages() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures/Walli Artworks/";
        allFilesPath = new ArrayList<>();
        allFilesPath = listAllFiles(path);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_main);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Cell> cells = prepareData();
        GalleryImageAdapter adapter = new GalleryImageAdapter(getApplicationContext(),cells);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Cell> prepareData(){
        ArrayList<Cell> allImages = new ArrayList<>();
        for (Cell c : allFilesPath){
            Cell cell = new Cell();
            cell.setTitle(c.getTitle());
            cell.setPath(c.getPath());
            allImages.add(cell);
        }
        return allImages;
    }

    private ArrayList<Cell> listAllFiles(String pathName){
        ArrayList<Cell> allFiles = new ArrayList<>();
        File file = new File(pathName);
        File[] files = file.listFiles();
        if(files!=null){
            for(File f: files){
                Cell cell = new Cell();
                cell.setTitle(f.getName());
                cell.setPath(f.getAbsolutePath());
                allFiles.add(cell);
            }
        }
        return allFiles;
    }



    @Override
    public void onClick(View view, int position) {
//        FullScreen Activity
    }
}

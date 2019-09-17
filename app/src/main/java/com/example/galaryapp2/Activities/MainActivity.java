package com.example.galaryapp2.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.galaryapp2.Adapter.GalleryImageAdapter;
import com.example.galaryapp2.Interface.RecyclerViewClickListner;
import com.example.galaryapp2.Model.Cell;
import com.example.galaryapp2.R;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListner {

    RecyclerView recyclerViewMain;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Cell> allFilesPath;
    String child;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerViewMain = findViewById(R.id.recycler_view_main);
//        layoutManager = new GridLayoutManager(this,2);
//        recyclerViewMain.setHasFixedSize(true);
//        recyclerViewMain.setLayoutManager(layoutManager);
        Intent intent = getIntent();
        child = intent.getStringExtra("SubFolderPath");
        showImages(child);
    }

    private void getDirList() {
        File file = new File(Environment.getExternalStorageDirectory(), "DCIM");
        Log.d("Files", "getDirList: "+file.listFiles());
        File[] pictures = file.listFiles();
        for(int i = 0; i < pictures.length; i++){
            Log.d("FILE:", ""+pictures[i].getName());
            Log.d("FILE:", ""+pictures[i].getAbsolutePath());
        }
    }

    private void showImages(String subPath) {

//        if((Environment.getDataDirectory().getAbsolutePath().concat("/DCIM/").concat(subPath).toLowerCase().endsWith(".jpg")) || Environment.getDataDirectory().getAbsolutePath().concat("/DCIM/").concat(subPath).toLowerCase().endsWith(".png")){
//            String path = Environment.getExternalStorageDirectory().getAbsolutePath().concat("/DCIM/").concat(subPath);
//            Log.d("Something", "showImages: "+path);
//            allFilesPath = new ArrayList<>();
//            allFilesPath = listAllFiles(path);
//            RecyclerView recyclerView = findViewById(R.id.recycler_view_main);
//            recyclerView.setHasFixedSize(true);
//            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
//            recyclerView.setLayoutManager(layoutManager);
//            ArrayList<Cell> cells = prepareData();
//            GalleryImageAdapter adapter = new GalleryImageAdapter(getApplicationContext(),cells);
//            recyclerView.setAdapter(adapter);
//        }
//        else{
//            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT);
//        }
        if(Environment.getDataDirectory().getAbsolutePath().concat("/DCIM/").concat(subPath).isEmpty())
        {
            Toast.makeText(this,"Empty",Toast.LENGTH_SHORT);
        }
        else{
            String path = Environment.getExternalStorageDirectory().getAbsolutePath().concat("/DCIM/").concat(subPath);
            Log.d("Something", "showImages: "+path);
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
        List<File> fileList =  Arrays.asList(files);
        Collections.reverse(fileList);
        if(files!=null){
            for(File f: fileList){
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

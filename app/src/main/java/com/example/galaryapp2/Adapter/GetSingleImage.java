package com.example.galaryapp2.Adapter;

import android.os.Environment;
import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galaryapp2.Model.Cell;
import com.example.galaryapp2.R;

import java.io.File;
import java.util.ArrayList;

public class GetSingleImage {

    ArrayList<Cell> allFilesPath;

    public ArrayList<Cell> getImage(String path){
        String imageLocation = Environment.getExternalStorageDirectory().getAbsolutePath().concat("/DCIM/").concat(path);
        Log.d("Something", "showImages: "+path);
        allFilesPath = new ArrayList<>();
        allFilesPath = listAllFiles(path);
//        RecyclerView recyclerView = findViewById(R.id.recycler_view_main);
//        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
//        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Cell> cells = prepareData();
//        GalleryImageAdapter adapter = new GalleryImageAdapter(getApplicationContext(),cells);
//        recyclerView.setAdapter(adapter);
        return cells;
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
        Log.d("Files", "listAllFiles: "+files);
        if(files!=null){
            for(File f: files){
                Cell cell = new Cell();
                cell.setTitle(f.getName());
                cell.setPath(f.getAbsolutePath());
                allFiles.add(cell);
                Log.d("Files", "listAllFiles11: "+f.getAbsolutePath());
            }
        }
        return allFiles;
    }
}

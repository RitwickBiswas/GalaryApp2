package com.example.galaryapp2.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.galaryapp2.R;

public class ImageActivity extends AppCompatActivity {

    RecyclerView recyclerViewFolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        recyclerViewFolder = findViewById(R.id.recycler_view_folder);

    }
}

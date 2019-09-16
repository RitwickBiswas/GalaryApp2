package com.example.galaryapp2.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.galaryapp2.Adapter.FullSizeAdapter;
import com.example.galaryapp2.Model.Cell;
import com.example.galaryapp2.R;

import java.util.ArrayList;

public class FullScreenActivity extends AppCompatActivity {

    String path="";
    ArrayList<Cell> FullScreen;
    int position;

    ViewPager imageViewPagerMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        if(savedInstanceState == null){
            Intent intent = getIntent();
            FullScreen = (ArrayList<Cell>) intent.getSerializableExtra("fullGalary");
            position = intent.getIntExtra("position",0);

        }
        imageViewPagerMain = findViewById(R.id.image_full_view_pager);
        FullSizeAdapter fullSizeAdapter = new FullSizeAdapter(this,FullScreen);
        imageViewPagerMain.setAdapter(fullSizeAdapter);
        imageViewPagerMain.setCurrentItem(position,true);


    }
}

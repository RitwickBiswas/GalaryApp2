package com.example.galaryapp2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.galaryapp2.Model.Cell;
import com.example.galaryapp2.R;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

public class FullSizeAdapter extends PagerAdapter {


    Context context;
    ArrayList<Cell> viewPagerImageArrayList;

    public FullSizeAdapter(Context context, ArrayList<Cell> viewPagerImageArrayList) {
        this.context = context;
        this.viewPagerImageArrayList = viewPagerImageArrayList;
    }



    LayoutInflater layoutInflater;



    @Override
    public int getCount() {
        return viewPagerImageArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.full_item,null);
        PhotoView imageView = view.findViewById(R.id.full_img);
        Glide.with(context).load(viewPagerImageArrayList.get(position).getPath()).apply(new RequestOptions().centerInside()).into(imageView);

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view,0);
        return view;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}

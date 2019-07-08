package com.people.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.comix.rounded.RoundedCornerImageView;
import com.people.Activity.PlaceDetailsScreen;
import com.people.R;

import java.util.List;

public class PlaceSliderAdapter extends PagerAdapter
{


    PlaceDetailsScreen placeDetailsScreen;


    List<Integer> images;
    TextView textView;
    RoundedCornerImageView imageView;

    public PlaceSliderAdapter(PlaceDetailsScreen placeDetailsScreen,  List<Integer> images) {
        this.placeDetailsScreen = placeDetailsScreen;

        this.images = images;
    }
    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) placeDetailsScreen.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.raw_place_iamge, null);


        imageView = view.findViewById(R.id.img_place);
//        FrameLayout relativeLayout = view.findViewById(R.id.relativelyt);




        imageView.setImageResource(images.get(position));
        // String a = textView.getText().toString();
        //System.out.println("--text "+a);
//        relativeLayout.setBackgroundColor(color.get(position));
        ViewPager viewPager = (ViewPager) container;

        viewPager.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}

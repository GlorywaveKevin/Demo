package com.people.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.people.Adapter.PlaceSliderAdapter;
import com.people.R;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class PlaceDetailsScreen extends Activity implements View.OnClickListener
{
    private String placeName,longdesc,location;
    private int img01,img02,img03,img04,img05,img06;
    private TextView txtLongDesc,txtLocation,txtToolbar_Title;
    private RelativeLayout backLayout;
    private ViewPager placeviewpager;
    PageIndicatorView pageIndicatorView;

    List<Integer> images;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_desc_screen);

        Intent i1=getIntent();
        placeName=i1.getStringExtra("placeName");
        longdesc=i1.getStringExtra("longdesc");
        location=i1.getStringExtra("location");
        img01=i1.getIntExtra("img01",0);
        img02=i1.getIntExtra("img02",0);
        img03=i1.getIntExtra("img03",0);
        img04=i1.getIntExtra("img04",0);
        img05=i1.getIntExtra("img05",0);
        img06=i1.getIntExtra("img06",0);

        images = new ArrayList<>();
        images.add(img01);
        images.add(img02);
        images.add(img03);
        images.add(img04);
        images.add(img05);
        images.add(img06);

        initViews();


    }
    public void initViews()
    {
        txtLocation=(TextView)findViewById(R.id.txtLocation);
        txtLongDesc=(TextView)findViewById(R.id.txtLongDesc);
        txtToolbar_Title=(TextView)findViewById(R.id.txtToolbar_Title);
        backLayout=(RelativeLayout)findViewById(R.id.backlayout);
        backLayout.setOnClickListener(this);
        placeviewpager=(ViewPager)findViewById(R.id.placeviewpager);
        pageIndicatorView=(PageIndicatorView)findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setCount(images.size());
        pageIndicatorView.setViewPager(placeviewpager);
//        placeName.setAdapter(new LoginSliderAdapter(this,color,texts,images));
        placeviewpager.setAdapter(new PlaceSliderAdapter(this,images));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000,6000);
        txtToolbar_Title.setText(placeName);
        txtLocation.setText(location);
        txtLongDesc.setText(longdesc);
        Utils.applyFont(txtToolbar_Title,PlaceDetailsScreen.this);
        Utils.applyFont(txtLocation,PlaceDetailsScreen.this);
        Utils.applyFont(txtLongDesc,PlaceDetailsScreen.this);


    }

    @Override
    public void onClick(View v)
    {
            switch (v.getId())
            {
                case R.id.backlayout:
                    onBackPressed();
                    break;
            }
    }
    private class SliderTimer extends TimerTask {
        @Override
        public void run() {
            PlaceDetailsScreen.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (placeviewpager.getCurrentItem() < images.size() - 1){
                        placeviewpager.setCurrentItem(placeviewpager.getCurrentItem()+1);
                    }else{
                        placeviewpager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}

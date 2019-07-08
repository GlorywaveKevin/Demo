package com.people.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.people.Adapter.PlaceAdapter;
import com.people.Bean.PlaceBean;
import com.people.R;

import java.util.ArrayList;

public class CityDetailsScreen extends Activity implements View.OnClickListener
{
    private TextView txtToolbar_Title;
    private String cityId,cityName;
    private RelativeLayout backlayout;
    private ListView placelist;
    private ArrayList<PlaceBean> listPlace;
    private PlaceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_details_screen);

        listPlace=new ArrayList<>();
        listPlace.add(new PlaceBean("1","RaceCource","Race Course Ring Road, Rajkot 360001, India","Great Place Lots Of people come here int the evening.","Great Place Lots Of people come here int the evening.Lots of eating restaurants surrounds the race course",R.drawable.ic_rajkot,R.drawable.ic_jamnagar,R.drawable.ic_vadodara,R.drawable.ic_rajkot,R.drawable.ic_jamnagar,R.drawable.ic_vadodara));
        listPlace.add(new PlaceBean("2","Aji Dam","Race Course Ring Road, Rajkot 360001, India","Great Place Lots Of people come here int the evening.","Great Place Lots Of people come here int the evening.Lots of eating restaurants surrounds the race course",R.drawable.ic_jamnagar,R.drawable.ic_jamnagar,R.drawable.ic_vadodara,R.drawable.ic_rajkot,R.drawable.ic_jamnagar,R.drawable.ic_vadodara));
        listPlace.add(new PlaceBean("3","Wastom Museum","Race Course Ring Road, Rajkot 360001, India","Great Place Lots Of people come here int the evening.","Great Place Lots Of people come here int the evening.Lots of eating restaurants surrounds the race course",R.drawable.ic_vadodara,R.drawable.ic_jamnagar,R.drawable.ic_vadodara,R.drawable.ic_rajkot,R.drawable.ic_jamnagar,R.drawable.ic_vadodara));


        Intent i1=getIntent();
        cityId=i1.getStringExtra("cityId");
        cityName=i1.getStringExtra("cityName");


        initViews();
    }
    public void initViews()
    {
        txtToolbar_Title=(TextView)findViewById(R.id.txtToolbar_Title);
        backlayout=(RelativeLayout)findViewById(R.id.backlayout);
        placelist=(ListView)findViewById(R.id.placelist);
        adapter=new PlaceAdapter(getApplicationContext(),listPlace);
        placelist.setAdapter(adapter);

        backlayout.setOnClickListener(this);

        placelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent i1=new Intent(getApplicationContext(),PlaceDetailsScreen.class);
                i1.putExtra("placeName",listPlace.get(position).placeName);
                i1.putExtra("longdesc",listPlace.get(position).placeLongdesc);
                i1.putExtra("location",listPlace.get(position).placeLocation);
                i1.putExtra("img01",listPlace.get(position).pImg1);
                i1.putExtra("img02",listPlace.get(position).pIMg2);
                i1.putExtra("img03",listPlace.get(position).pImg3);
                i1.putExtra("img04",listPlace.get(position).pImg4);
                i1.putExtra("img05",listPlace.get(position).pImg5);
                i1.putExtra("img06",listPlace.get(position).pImg6);
                startActivity(i1);


            }
        });




        txtToolbar_Title.setText(cityName);
        Utils.applyFont(txtToolbar_Title,CityDetailsScreen.this);

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
}

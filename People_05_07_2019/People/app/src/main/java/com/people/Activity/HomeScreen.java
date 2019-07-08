package com.people.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.people.Adapter.CityAdapter;
import com.people.Bean.CityBean;
import com.people.R;

import java.util.ArrayList;

public class HomeScreen extends Activity implements View.OnClickListener
{
    private TextView txtToolbar_Title;
    ArrayList<CityBean> citylist;
    private CityAdapter adapter;
    private GridView cityGrid;
    private RelativeLayout tab_profile,tab_addplace;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        citylist=new ArrayList<>();
        citylist.add(new CityBean("1","Rajkot",R.drawable.ic_rajkot));
        citylist.add(new CityBean("2","Jamnagar",R.drawable.ic_jamnagar));
        citylist.add(new CityBean("3","Vadodara",R.drawable.ic_vadodara));
        citylist.add(new CityBean("1","Rajkot",R.drawable.ic_rajkot));
        citylist.add(new CityBean("2","Jamnagar",R.drawable.ic_jamnagar));
        citylist.add(new CityBean("3","Vadodara",R.drawable.ic_vadodara));

        initviews();


    }
    public void initviews()
    {
        txtToolbar_Title=(TextView)findViewById(R.id.txtToolbar_Title);

        cityGrid=(GridView)findViewById(R.id.citygrid);
        adapter=new CityAdapter(getApplicationContext(),citylist);
        cityGrid.setAdapter(adapter);

        cityGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String cityId=citylist.get(position).cityId;
                String cityname=citylist.get(position).cityName;
                Intent i1=new Intent(getApplicationContext(),CityDetailsScreen.class);
                i1.putExtra("cityId",cityId);
                i1.putExtra("cityName",cityname);
                startActivity(i1);
            }
        });
        applyFont(txtToolbar_Title,HomeScreen.this);

        tab_profile=(RelativeLayout)findViewById(R.id.tab_profile);
        tab_addplace=(RelativeLayout)findViewById(R.id.tab_addplace);
        tab_profile.setOnClickListener(this);
        tab_addplace.setOnClickListener(this);
    }

    public static void applyFont(TextView tv, Activity context) {
        tv.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/FF Tisa OT Medium.otf"));
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.tab_profile:
                Intent i1=new Intent(getApplicationContext(),Profile.class);
                startActivity(i1);
                break;
            case R.id.tab_addplace:
                Intent i2=new Intent(getApplicationContext(),LoginScreen.class);
                startActivity(i2);
                break;
        }
    }
}

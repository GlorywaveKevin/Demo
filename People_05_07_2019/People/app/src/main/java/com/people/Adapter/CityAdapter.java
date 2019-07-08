package com.people.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.comix.rounded.RoundedCornerImageView;
import com.people.Activity.Utils;
import com.people.Bean.CityBean;
import com.people.R;

import java.util.ArrayList;

public class CityAdapter extends ArrayAdapter<CityBean>
{
    ArrayList<CityBean> drawerlist;


    Context context;

    public CityAdapter(Context context, ArrayList<CityBean> drawerlist)
    {
        super(context, R.layout.raw_city, drawerlist);
        this.drawerlist=drawerlist;
        this.context=context;

    }
    class Holder
    {
        TextView txtCityname;
        RoundedCornerImageView img_city;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        //    return super.getView(position, convertView, parent);
        CityBean data=drawerlist.get(position);

        final Holder viewHolder;
        if (convertView == null)
        {
            viewHolder = new Holder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.new_raw_city, parent, false);
            viewHolder.img_city=(RoundedCornerImageView) convertView.findViewById(R.id.img_city);
            viewHolder.txtCityname=(TextView)convertView.findViewById(R.id.txtCityname);


           convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (Holder) convertView.getTag();
        }


        Glide.with(context)
                .load(data.cityImg).placeholder(R.drawable.ic_people)
                .into(viewHolder.img_city);
        viewHolder.txtCityname.setText(data.cityName);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/FF Tisa OT Medium.otf");
        viewHolder.txtCityname.setTypeface(tf);

        return convertView;
    }
}

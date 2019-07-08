package com.people.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.comix.rounded.RoundedCornerImageView;
import com.people.Bean.CityBean;
import com.people.Bean.PlaceBean;
import com.people.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlaceAdapter extends ArrayAdapter<PlaceBean>
{
    ArrayList<PlaceBean> drawerlist;


    Context context;

    public PlaceAdapter(Context context, ArrayList<PlaceBean> drawerlist)
    {
        super(context, R.layout.raw_city, drawerlist);
        this.drawerlist=drawerlist;
        this.context=context;

    }
    class Holder
    {
        TextView txtPlaceName,txtShortDesc;
        CircleImageView img_place;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        //    return super.getView(position, convertView, parent);
        PlaceBean data=drawerlist.get(position);

        final PlaceAdapter.Holder viewHolder;
        if (convertView == null)
        {
            viewHolder = new PlaceAdapter.Holder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.raw_place, parent, false);
            viewHolder.img_place=(CircleImageView) convertView.findViewById(R.id.img_place);
            viewHolder.txtPlaceName=(TextView)convertView.findViewById(R.id.txtPlaceName);
            viewHolder.txtShortDesc=(TextView)convertView.findViewById(R.id.txtShortDesc);


            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (PlaceAdapter.Holder) convertView.getTag();
        }


        Glide.with(context)
                .load(data.pImg1).placeholder(R.drawable.ic_people)
                .into(viewHolder.img_place);
        viewHolder.txtPlaceName.setText(data.placeName);
        viewHolder.txtShortDesc.setText(data.placeShortdesc);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/FF Tisa OT Medium.otf");
        viewHolder.txtPlaceName.setTypeface(tf);

        return convertView;
    }
}


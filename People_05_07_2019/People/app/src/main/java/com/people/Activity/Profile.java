package com.people.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.people.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends Activity implements View.OnClickListener
{
    private RelativeLayout backlayout;
    private CircleImageView imgProfile;
    private TextView txtEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        initViews();

    }
    public void initViews()
    {
        backlayout=(RelativeLayout)findViewById(R.id.backlayout);
        imgProfile=(CircleImageView)findViewById(R.id.imgProfile);
        txtEditProfile=(TextView)findViewById(R.id.txtEditProfile);
        Glide.with(getApplicationContext())
                .load(R.drawable.ic_kevin).placeholder(R.drawable.ic_people)
                .into(imgProfile);
        backlayout.setOnClickListener(this);
        txtEditProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.backlayout:
                onBackPressed();
                break;
            case R.id.txtEditProfile:
                Intent i1=new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i1);
                break;
        }
    }
}

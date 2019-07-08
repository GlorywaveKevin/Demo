package com.people.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.people.R;

public class LoginScreen extends Activity implements View.OnClickListener
{
    private RelativeLayout idlogin;
    private TextView createaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        initViews();
    }
    public void initViews()
    {
        idlogin=(RelativeLayout)findViewById(R.id.idlogin);
        createaccount=(TextView)findViewById(R.id.createaccount);
        idlogin.setOnClickListener(this);
        createaccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.idlogin:
                Intent i1=new Intent(getApplicationContext(),AddPlaceActivity.class);
                startActivity(i1);
                finish();
                break;
            case R.id.createaccount:
                Intent i2=new Intent(getApplicationContext(),Register.class);
                startActivity(i2);
                finish();
                break;
        }



    }
}

package com.people.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.people.R;

public class Register extends Activity implements View.OnClickListener
{
    private RelativeLayout backLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        initViews();

    }
    public void initViews()
    {
        backLayout=(RelativeLayout)findViewById(R.id.backlayout);
        backLayout.setOnClickListener(this);
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

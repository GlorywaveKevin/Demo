package com.people.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.people.R;

public class EditProfile extends Activity implements View.OnClickListener
{
    private RelativeLayout backlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        initViews();
    }
    public void  initViews()
    {
        backlayout=(RelativeLayout)findViewById(R.id.backlayout);
        backlayout.setOnClickListener(this);
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

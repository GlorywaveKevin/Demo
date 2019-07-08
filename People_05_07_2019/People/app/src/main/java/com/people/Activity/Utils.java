package com.people.Activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

public class Utils
{
    public static void applyFont(TextView tv, Activity context) {
        tv.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/FF Tisa OT Medium.otf"));
    }
}

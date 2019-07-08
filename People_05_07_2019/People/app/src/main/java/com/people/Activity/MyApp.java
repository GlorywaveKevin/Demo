package com.people.Activity;

import android.app.Application;

public class MyApp extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
//        FontsOverride.setDefaultFont(this, "DEFAULT", "raleway_regular.ttf");
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/FF Tisa OT Medium.otf");
    }


}

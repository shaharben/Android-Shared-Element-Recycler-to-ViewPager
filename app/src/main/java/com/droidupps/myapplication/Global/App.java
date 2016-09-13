package com.droidupps.myapplication.Global;

import android.app.Application;

/**
 * Created by shahar ben hayun on 9/1/2016.
 */
public class App extends Application {

    public static App instance;
    private int position = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

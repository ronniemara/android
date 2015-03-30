package com.blackmirror.ron.androidtutorial;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    private MyGlSurfaceView mGLSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLSV = new MyGlSurfaceView(this);
        setContentView(mGLSV);
    }

    @Override
    protected void onPause(){
        
    }



}

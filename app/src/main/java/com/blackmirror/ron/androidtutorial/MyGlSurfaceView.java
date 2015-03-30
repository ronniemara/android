package com.blackmirror.ron.androidtutorial;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by ron on 14/03/15.
 */
public class MyGlSurfaceView extends GLSurfaceView {

    private final MyGLRenderer myRenderer;

    public MyGlSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        myRenderer = new MyGLRenderer(context);
        setRenderer(myRenderer);
    }




}

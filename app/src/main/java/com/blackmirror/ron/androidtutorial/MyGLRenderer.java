package com.blackmirror.ron.androidtutorial;

import android.content.Context;
import android.opengl.GLES10;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by ron on 14/03/15.
 */
public class MyGLRenderer implements GLSurfaceView.Renderer {

    private Context ctx;

    private Mesh model;

    public MyGLRenderer(Context context){
        ctx = context;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        Vertex[] data = new Vertex[] {new Vertex(-1.0f,-1.0f, 0f), new Vertex(0f,1.0f,0f),new Vertex(1.0f, -1.0f,0f) };

        model = new Mesh(data);

        Shader shaderProgram = new Shader();

        try {
            shaderProgram.addVertexShader(new ResourceLoader().readRawTextFile(ctx, R.raw.vertexshader));

        } catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        try {

            shaderProgram.addFragmentShader(new ResourceLoader().readRawTextFile(ctx, R.raw.fregmentshader));
        } catch (Exception e)
        {
            System.out.println("Could not find shader" + R.raw.fregmentshader);
            System.exit(1);
        }

        shaderProgram.compileShader();
        shaderProgram.bind();

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES10.glClear(GLES10.GL_COLOR_BUFFER_BIT);

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES10.glClearColor(1.0f,0.0f,1.0f,1.0f);
        model.draw();

    }
}

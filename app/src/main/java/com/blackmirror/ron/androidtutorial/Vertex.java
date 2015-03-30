package com.blackmirror.ron.androidtutorial;

/**
 * Created by ron on 18/03/15.
 */
public class Vertex {

    public static final int COORDS_PER_VERTEX = 3;

    private Vector3f pos;

    public Vertex(float x, float y, float z){
        pos = new Vector3f(x, y, z);
    }

    public Vector3f getPos() {
        return pos;
    }

    public void setPos(Vector3f pos) {
        this.pos = pos;
    }
}

package com.blackmirror.ron.androidtutorial;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by ron on 15/03/15.
 */
public class Mesh {
    private final FloatBuffer vertexBuffer;
    private final int NUM_VERTICES;

    public Mesh(Vertex[] vertices){
        NUM_VERTICES = vertices.length;

        // initialize vertex byte buffer for shape coordinates
        ByteBuffer bb = ByteBuffer.allocateDirect(
                // (number of coordinate values * 4 bytes per float)
                NUM_VERTICES * Vertex.COORDS_PER_VERTEX * 4);
        // use the device hardware's native byte order
        bb.order(ByteOrder.nativeOrder());

        // create a floating point buffer from the ByteBuffer
        vertexBuffer = bb.asFloatBuffer();

        // add the coordinates to the FloatBuffer
        for (int i = 0; i < NUM_VERTICES; i++) {
            vertexBuffer.put(vertices[i].getPos().getX());
            vertexBuffer.put(vertices[i].getPos().getY());
            vertexBuffer.put(vertices[i].getPos().getZ());
        }

        // set the buffer to read the first coordinate
        vertexBuffer.position(0);

    }

    public FloatBuffer getVertices(){
        return vertexBuffer;
    }

    public void draw(){
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(0, 3, GLES20.GL_FLOAT, false, Vertex.COORDS_PER_VERTEX * 4, vertexBuffer);
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, NUM_VERTICES);
        GLES20.glDisableVertexAttribArray(0);

    }
}

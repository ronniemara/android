package com.blackmirror.ron.androidtutorial;

import android.opengl.GLES20;
import java.nio.IntBuffer;

/**
 * Created by ron on 20/03/15.
 */
public class Shader {
    private int m_program;

    public Shader(){

        m_program = GLES20.glCreateProgram();

        if (m_program == 0){
            System.err.println("Creation of shader program filed in constructor!");
            System.exit(1);
        }
    }

    public void addVertexShader(String shaderText){
        addShader(shaderText, GLES20.GL_VERTEX_SHADER);
    }

    public void addFragmentShader(String shaderText){
        addShader(shaderText, GLES20.GL_FRAGMENT_SHADER);
    }

    public void compileShader(){
        GLES20.glLinkProgram(m_program);

        int statusCompileShader[] = new int[1];
        GLES20.glGetProgramiv(m_program, GLES20.GL_LINK_STATUS, statusCompileShader, 0);


        if (statusCompileShader[0] == 0){
            System.err.println(GLES20.glGetShaderInfoLog(m_program));
            System.exit(1);
        }
    }

    private void addShader(String shaderText, int shaderType){

        int shader = GLES20.glCreateShader(shaderType);

        if (shader == 0){
            System.err.println("Shader source invalid");
            System.exit(1);
        }

        GLES20.glShaderSource(shader,shaderText);

        GLES20.glCompileShader(shader);


        int statusVertexShader[] = new int[1];
        GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS,  statusVertexShader, 0);
        if(statusVertexShader[0] ==0){
            System.err.println(GLES20.glGetShaderInfoLog(shader));
            System.exit(1);
        }

        GLES20.glAttachShader(m_program,shader);



    }

    public void bind(){

        GLES20.glUseProgram(m_program);
    }


}

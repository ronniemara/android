
struct VertexData {
attribute vec3 vPosition;
attribute vec3 vColor;
attribute vec3 vNormal;
} vData;

struct Transform {
uniform ModelViewProjectionMatrix;
uniform NormalMatrix;
} matrices;

struct Object {
varying vec3 Color;
varying vec3 Normal;
} item;


void main(){
gl_Position = Transform matrices.ModelViewProjectionMatrix * vec4(VertexData vData.vPosition, 1.0f);
Object item.Color = VertexData vData.vColor;
Object item.Normal = VertexData vData.vNormal;
}

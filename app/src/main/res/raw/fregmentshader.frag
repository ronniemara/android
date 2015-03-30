struct Light {
uniform vec3 ambient;
uniform vec3 lightDirection;
uniform vec3 halfVector;
uniform vec3 lightColor;
} light;

struct Object {
varying vec3 Color;
varying vec3 Normal;
float Shininess;
float Strength;

} item;

void main(){

vec4 diffuse = max(0.0, dot(Object item Normal, Light light.lightDirection));
vec4 specular = max(0.0, dot(halfVector, Normal));

if(diffuse == 0.0){
specular = 0.0;
} else {
specular =pow(specular, Object item.Shininess);
}

vec3 scatteredLight = Light light.ambient + Light light.lightColor * diffuse;

vec3 reflectedLight = Light light.lightColor * specular * Object item.Strength;

vec3 rgb = min(Object item.Color * scatteredLight + reflectedLight,vec3(1.0)) 

gl_FragColor = Object item.Color * scatteredLight * diffuse + specular * Object item Strength;
}

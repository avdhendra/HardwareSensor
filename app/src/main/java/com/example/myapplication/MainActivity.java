package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
SensorManager sensorManager;
Sensor proxySensor,accelsensor;
SensorEventListener sensorEventListener;
FrameLayout flPRoxy;
Random rand;
int[] color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        flPRoxy=findViewById(R.id.flproxy);
        rand=new Random();
        color= getResources().getIntArray(R.array.random_color);
proxySensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
//A proximity sensor is a sensor able to detect the presence of nearby objects without any physical contact.

        //



        sensorEventListener=new SensorEventListener() {
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //sensorEvent have only two value 1 and 0 in proximity
        Log.d("HardwareSensor: ","OnSensorChanged: "+sensorEvent.values[0]);
    if(sensorEvent.values[0]>0)
    {
        flPRoxy.setBackgroundColor(color[rand.nextInt(color.length)]);

    }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
};
    }

    @Override
    protected void onResume() {
        super.onResume();                                                //how many time u observe the value of the sensor
        sensorManager.registerListener(sensorEventListener,proxySensor,100*100);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);

    }
}
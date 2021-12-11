package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
if(sensorManager==null)
{
    Toast.makeText(this, "Could not get Sensors", Toast.LENGTH_SHORT).show();
finish();
}
else{
     List<Sensor>sensors =sensorManager.getSensorList(Sensor.TYPE_ALL);
for(Sensor it:sensors)
{
    Log.d("HardWareSensor: ",it.getName()+" " +it.getStringType()+" "+it.getVendor());
}
}
    }
}
package com.example.macbook.compass;

        import android.hardware.Sensor;
        import android.hardware.SensorEvent;
        import android.hardware.SensorEventListener;
        import android.hardware.SensorManager;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.TextView;


    /*
    *   This code is found at developer.android.com
    *   from the project instructions
    *   This code builds an Accelerometer with help from
    *   the device and its accelerometer sensor
    */



public class Accelerometer extends AppCompatActivity implements SensorEventListener {

    //The vector is built with floats to get negative values

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private float[] linear_acceleration = new float[3];
    public String x;
    public String y;
    public String z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_accelerometer);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    protected void onResume() {
        super.onResume();
        // Trying to delay the sensors
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this, mAccelerometer);
    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // This method is not used in this version of the app
    }

    /*
    *   Gets the event values from the vector, and puts the correct coordinate in the correct text file
    *   @event the sensor event
    */

    public void onSensorChanged(SensorEvent event) {

        linear_acceleration[0] = event.values[0];
        linear_acceleration[1] = event.values[1];
        linear_acceleration[2] = event.values[2];

        // Sets the text view for the x-coordinate
        x = String.valueOf(linear_acceleration[0]);
        TextView textViewX = (TextView) findViewById(R.id.viewX);
        textViewX.setText(x);

        // Sets the text view for the y-coordinate
        y = String.valueOf(linear_acceleration[1]);
        TextView textViewY = (TextView) findViewById(R.id.viewY);
        textViewY.setText(y);

        // Sets the text view for the z-coordinate
        z = String.valueOf(linear_acceleration[2]);
        TextView textViewZ = (TextView) findViewById(R.id.viewZ);
        textViewZ.setText(z);
    }
}
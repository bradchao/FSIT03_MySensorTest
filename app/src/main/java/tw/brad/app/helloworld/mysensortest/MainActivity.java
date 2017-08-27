package tw.brad.app.helloworld.mysensortest;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor sensor;
    private MySensorListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensors){
            String sensorName = sensor.getName();
            String sensorType = sensor.getStringType();
            Log.i("brad", sensorName + ":" + sensorType);
        }

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        listener = new MySensorListener();


    }

    @Override
    protected void onStart() {
        super.onStart();
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listener);
    }

    private class MySensorListener implements SensorEventListener2 {
        @Override
        public void onFlushCompleted(Sensor sensor) {

        }

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }

}

package ml.nithishvasala.amit;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import me.itangqi.waveloadingview.WaveLoadingView;

public class MainActivity extends Activity implements SensorEventListener, StepListener {
    private TextView tv_distance,tv_kcal;
    private SimpleStepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    private int numSteps;
    WaveLoadingView waveLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        tv_distance=(TextView) findViewById(R.id.tv_distance);
        tv_kcal=(TextView) findViewById(R.id.tv_kcal);

        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        waveLoadingView =(WaveLoadingView) findViewById(R.id.waveLoadingView);
        simpleStepDetector = new SimpleStepDetector();
        simpleStepDetector.registerListener(this);

    waveLoadingView.setProgressValue(0);

    }
    @Override
    public void onResume() {
        super.onResume();
        numSteps = 0;
        sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        waveload(numSteps);
        convert(numSteps);
    }

    private void convert(int val) {
        Double d=val*0.762;
        int i=(int) Math.round(d);
        String distance=Integer.toString(i);
        String fdis=null;
     //   int m=0;
     //   char c;
        if(distance.contains(".")) {
            for (int p = 0; p < distance.length(); p++) {
                if (distance.charAt(i) == '.') {
                    break;
                }
                fdis = fdis + distance.charAt(i);
            }
            tv_distance.setText(fdis);
        }
        else {
            tv_distance.setText(distance);
        }
        tv_kcal.setText(Double.toString((double) val*0.04));

    }

    private void waveload(int steps) {
        waveLoadingView.setProgressValue(steps/30);
        if(steps<1000){
            waveLoadingView.setBottomTitle(Integer.toString(steps));
            waveLoadingView.setCenterTitle("");
            waveLoadingView.setTopTitle("");
        }
        else if(steps<2000){
            waveLoadingView.setBottomTitle("");
            waveLoadingView.setCenterTitle(Integer.toString(steps));
            waveLoadingView.setTopTitle("");

        }
        else{
            waveLoadingView.setBottomTitle("");
            waveLoadingView.setCenterTitle("");
            waveLoadingView.setTopTitle(Integer.toString(steps));
        }
    }

}
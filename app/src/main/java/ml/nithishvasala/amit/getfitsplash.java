package ml.nithishvasala.amit;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class getfitsplash extends AppCompatActivity {

    //splash screen timeout
    private static int SPLASH_TIME_OUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getfitsplash);

    new Handler().postDelayed(new Runnable(){
        @Override
        public void run() {

                Intent i = new Intent(getfitsplash.this, dashboard.class);
                startActivity(i);
                finish();
            }
            }, SPLASH_TIME_OUT);
        }
        }

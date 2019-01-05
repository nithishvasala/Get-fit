package ml.nithishvasala.amit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity {

    Button bt_pedometer,bt_bmi,bt_arms,bt_legs,bt_shulder,bt_chest,bt_abs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bt_pedometer=(Button)findViewById(R.id.bt_pedometer);
        bt_bmi=(Button) findViewById(R.id.bt_bmi);
        bt_arms=(Button) findViewById(R.id.bt_arms);
        bt_legs=(Button)findViewById(R.id.bt_legs);


        bt_shulder=(Button) findViewById(R.id.bt_shoulder);
        bt_chest=(Button) findViewById(R.id.bt_chest);
        bt_abs=(Button)findViewById(R.id.bt_abs);


        //intent to change activity

        bt_pedometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ip=new Intent(dashboard.this,MainActivity.class);
                startActivity(ip);
            }
        });

        bt_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip=new Intent(dashboard.this,bmi.class);
                startActivity(ip);
            }
        });



        bt_arms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip=new Intent(dashboard.this,arms.class);
                startActivity(ip);
            }
        });
        bt_legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip=new Intent(dashboard.this,legs.class);
                startActivity(ip);
            }
        });

        bt_shulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip=new Intent(dashboard.this,shoulder.class);
                startActivity(ip);
            }
        });

        bt_chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip=new Intent(dashboard.this,chest_wo.class);
                startActivity(ip);
            }
        });

        bt_abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip=new Intent(dashboard.this,abs.class);
                startActivity(ip);
            }
        });


    }

}

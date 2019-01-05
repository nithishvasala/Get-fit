package ml.nithishvasala.amit;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class shoulder extends AppCompatActivity {
    GifImageView iv1;
    Button bt_next1,bt_prev1;
    TextView tv_count1,tv_disc1;
    ProgressBar pb1;
    int c=1;
    MediaPlayer mp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder);


        bt_prev1=(Button) findViewById(R.id.bt_prev1);
        bt_next1=(Button) findViewById (R.id.bt_next1);
        tv_count1=(TextView) findViewById(R.id.tv_count1);
        tv_disc1=(TextView) findViewById(R.id.tv_disc1);
        pb1=(ProgressBar)findViewById(R.id.pb);
        iv1=(GifImageView) findViewById(R.id.iv1);

        mp1=MediaPlayer.create(this, R.raw.med);



        tv_count1.setText("1/4");
        mp1.start();

        bt_prev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c<1){
                    bt_prev1.setEnabled(false);
                    bt_next1.setEnabled(true);

                    mp1.start();
                }
                else{
                    c--;
                    changeimge();
                    bt_prev1.setEnabled(true);
                    bt_next1.setEnabled(true);

                    mp1.start();
                }


            }
        });


        bt_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c>4){
                    bt_next1.setEnabled(false);
                    bt_prev1.setEnabled(true);

                    mp1.start();
                }
                else{
                    c++;
                    changeimge();
                    bt_next1.setEnabled(true);
                    bt_prev1.setEnabled(true);

                    mp1.start();
                }


            }
        });

    }

    public void changeimge(){
        //image changer
        if(c==1){
            iv1.setImageResource(R.drawable.shoulder1);
            tv_count1.setText("1/4");
        }
        else if(c==2){
            iv1.setImageResource(R.drawable.shoulder2);
            tv_count1.setText("2/4");
        }
        else if(c==3){
            iv1.setImageResource(R.drawable.shoulder3);
            tv_count1.setText("3/4");
        }
        else if(c==4){
            iv1.setImageResource(R.drawable.shoulder5);
            tv_count1.setText("4/4");
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp1.stop();
        finish();
    }
}

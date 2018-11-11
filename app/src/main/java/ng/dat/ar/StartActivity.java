package ng.dat.ar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Thread removeTemp = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(this){
                    float alpha = 1.2F;
                    while(alpha > 0) {
                        if(alpha < 0.7){
                            alpha-=0.025;
                        } else {
                            alpha-=0.0075;
                        }
                        try{
                            wait(25);
                        } catch(Exception e) {
                            alpha = 0;
                            e.printStackTrace();
                        }finally {
                            setInvisible(alpha);
                        }
                    }
                }
            }
        });

        removeTemp.start();

    }
    public void setInvisible(float alpha) {
        ImageView img = (ImageView) findViewById(R.id.tempImage);

        img.setAlpha(alpha);
    }
    public void click_start(View v){
        Intent intent = new Intent(getApplicationContext(),ARActivity.class);
        startActivity(intent);
    }
}

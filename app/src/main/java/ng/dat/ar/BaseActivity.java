package ng.dat.ar;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {
    public Typeface mTypeface=null;

    @Override
    public void setContentView(int layoutResID){
        super.setContentView(layoutResID);
        if(mTypeface==null){
            mTypeface = Typeface.createFromAsset(this.getAssets(),"fonts/NanumBarunGothic.ttf");
        }
        setGlobalFont(getWindow().getDecorView());
    }

    private void setGlobalFont(View v){
        if(v!=null){
            if(v instanceof ViewGroup){
                ViewGroup vg = (ViewGroup) v;
                int vgcount = vg.getChildCount();
                for(int i=0;i<vgcount;i++){
                    View view = vg.getChildAt(i);
                    if(view instanceof TextView){
                        ((TextView)view).setTypeface(mTypeface);
                    }
                    setGlobalFont(view);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

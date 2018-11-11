package ng.dat.ar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class PopupActivity extends Activity {

    private TextView buildingname;
    private Button btn;
    private TextView r1;
    private TextView r2;
    private TextView r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup);

        //UI 객체생성
        buildingname = (TextView)findViewById(R.id.buildingname);
        btn = (Button)findViewById(R.id.closebtn);
        r1= (TextView)findViewById(R.id.resulttext1);
        r2= (TextView)findViewById(R.id.resulttext2);
        r= (TextView)findViewById(R.id.result);


        buildingname.setText("temp");

        r1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/NanumBarunpenB.ttf"));
        buildingname.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/NanumBarunpenB.ttf"));
        r2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/NanumBarunpenB.ttf"));
        r.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/NanumBarunpenB.ttf"));

        //X버튼 눌러서 팝업 지우기
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

    }

}

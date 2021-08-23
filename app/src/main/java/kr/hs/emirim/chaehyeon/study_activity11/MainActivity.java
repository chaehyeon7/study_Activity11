package kr.hs.emirim.chaehyeon.study_activity11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import java.util.prefs.PreferenceChangeEvent;

public class MainActivity extends AppCompatActivity {

    TextView value;
    Button btn_up, btn_down;
    int n = 0;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        value = findViewById(R.id.value);
        btn_up = findViewById(R.id.btn_UP);
        btn_down = findViewById(R.id.btn_down);

        value.setText(String.valueOf(n));  //String으로 넣어야 한다.

        btn_up.setOnClickListener( click);
        btn_down.setOnClickListener( click );
    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn_UP:
                    value.setText(String.valueOf( ++n ));
                    break;
                case R.id.btn_down:
                    value.setText(String.valueOf( --n ));
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //n값을 저장
        SharedPreferences.Editor edit = pref.edit();
        edit.putInt( "save", n);
        edit.commit();//n값을 물리적으로 저장

    }
}
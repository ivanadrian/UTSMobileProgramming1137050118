package com.example.ivan.utsmobpro1137050118;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by adrian on 31/10/2016.
 */
public class HasilActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        TextView utk = (TextView) findViewById(R.id.textView6);
        TextView psn = (TextView) findViewById(R.id.textView7);
        TextView dri = (TextView) findViewById(R.id.textView9);
        SharedPreferences pref =
                getApplicationContext().getSharedPreferences("MyPref", 0);
        String pesan =pref.getString("pesan", null);
        String dari=pref.getString("dari", null);
        String untuk=pref.getString("untuk",null);
        psn.setText("" + pesan);
        dri.setText("" + dari);
        utk.setText("" + untuk);
    }
}

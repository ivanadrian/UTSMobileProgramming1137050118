package com.example.ivan.utsmobpro1137050118;

/**
 * Created by adrian on 31/10/2016.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class PesanActivity extends AppCompatActivity {
    private Spinner spNamen;
    private EditText pesan;
    private EditText dari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        spNamen = (Spinner) findViewById(R.id.sp_name);
        pesan = (EditText) findViewById(R.id.editText);
        dari = (EditText) findViewById(R.id.editText2);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String data = bundle.getString("titleMember");
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(""+data);

        Button btSpinner = (Button) findViewById(R.id.button);
        btSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pesan1=pesan.getText().toString();
                String dari1=dari.getText().toString();
                String untk=spNamen.getSelectedItem().toString();
                SharedPreferences pref =
                        getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("pesan", pesan1);
                editor.putString("dari", dari1);
                editor.putString("untuk", untk);
                editor.commit();
                Intent  intent = new Intent(getApplicationContext(), HasilActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.ivan.utsmobpro1137050118;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    SessionManager session;

    int[] gambar={
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,

    };

    ListView list;

    String[] judul ={
            "Rainbow Cake",
            "Pinata Party Cake",
            "Chocolate Cake",
            "Signature Cake	",
            "Strawberry Chocolate Cake"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SessionManager(getApplicationContext());
        Button btnLogout= (Button)findViewById(R.id.button2);
        // Button logout
        // Cek User apakah sudah login
        session.checkLogin();
        // Mendapatkan data user dari session
        HashMap<String, String> user = session.getUserDetails();
        // nama
        String name = user.get(SessionManager.KEY_NAME);
        // email
        String email = user.get(SessionManager.KEY_EMAIL);

        // Inisialisasi CustomAdapter dengan Array yang telah dibuat
        CustomAdapter adapter = new CustomAdapter(this, gambar, judul);

        // Inisialisasi ListView
        list = (ListView) findViewById(R.id.listView);
        // set Adapter ke dalam ListView
        list.setAdapter(adapter);

        // action ketika ListView di klik
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

                // String untuk mengambil judul pada Listview

                Intent intent = new Intent(MainActivity.this, PesanActivity.class);
                intent.putExtra("titleMember", judul[position]);
                startActivity(intent);

                // menampilkan judul dengan Toast

            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // menghapus session data
                // dan mengarahakan ke LoginActivity
                session.logoutUser();
                finish();
            }
        });

    }
}

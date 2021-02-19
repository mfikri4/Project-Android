package com.example.go_ruqyah.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.go_ruqyah.R;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Checkout extends AppCompatActivity {

    EditText alamatCheckout, telpCheckout, mPesan;
    ImageButton btn;
    ProgressBar pgBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        alamatCheckout = findViewById(R.id.alamat_checkout);
        telpCheckout = findViewById(R.id.telp_checkout);
        mPesan = findViewById(R.id.pesan);
        btn=findViewById(R.id.btncheckout);
        pgBar = findViewById(R.id.progressBar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                final String jenis_ruqyah,nomor_hp,alamat;
                jenis_ruqyah = String.valueOf(mPesan.getText());
                nomor_hp = String.valueOf(telpCheckout.getText());
                alamat = String.valueOf(alamatCheckout.getText());

                if (!jenis_ruqyah.equals("") && !nomor_hp.equals("") && !alamat.equals("") ) {
                    pgBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[3];
                            field[0] = "jenis_ruqyah";
                            field[1] = "nomor_hp";
                            field[2] = "alamat";
                            String[] data = new String[3];
                            data[0] = jenis_ruqyah;
                            data[1] = nomor_hp;
                            data[2] = alamat;
                            PutData putData = new PutData("http://192.168.1.3/go-ruqyah/pesan-tambah.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    pgBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Tambah Data Sukses")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(),"Field Tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
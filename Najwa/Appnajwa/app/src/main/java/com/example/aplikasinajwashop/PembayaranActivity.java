package com.example.aplikasinajwashop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasinajwashop.API.APIRequestData;
import com.example.aplikasinajwashop.API.RetroServer;

public class PembayaranActivity extends AppCompatActivity {

    private TextView tvnama,tvharga, textHasil;
    private EditText jumlah;
    private Button btnHasil;
    private String  tv_namabarang= "";
    private int tv_hargabarang ;
    private ProgressBar pgBar;

    APIRequestData mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        mApiService = RetroServer.konekRetrofit().create(APIRequestData.class);


        tv_namabarang = getIntent().getStringExtra("tv_nama_barang");
        tv_hargabarang = getIntent().getIntExtra("tv_harga_barang",0);


        tvnama = findViewById(R.id.tvNama);
        tvharga = findViewById(R.id.tvHarga);
        jumlah = findViewById(R.id.etJumlah);
        btnHasil = findViewById(R.id.IB_Bayar);
        pgBar = findViewById(R.id.progress);
        textHasil= findViewById(R.id.tvHasil);


        tvnama.setText(tv_namabarang);
        tvharga.setText(String.valueOf(tv_hargabarang));

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nilaiharga = tvharga.getText().toString();
                String nilaijumlah = jumlah.getText().toString();
                double a = Double.parseDouble(nilaiharga);
                double b = Double.parseDouble(nilaijumlah);
                double Total = a * b;

                textHasil.setText(String.valueOf(Total));
                Intent intent = new Intent(getApplicationContext(), HasilActivity.class);
                startActivity(intent);


                /*
                final String nama_produk, harga_produk, jumlah_produk, total_harga;
                nama_produk = String.valueOf(tvnama.getText());
                harga_produk = String.valueOf(tvharga.getText());
                jumlah_produk = String.valueOf(jumlah.getText());
                total_harga = int.valueOf(textHasil.getText());

                if(!nama_produk.equals("") && !harga_produk.equals("") && !jumlah_produk.equals("") && !total_harga.equals("")  ) {
                    pgBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            String[] field = new String[4];
                            field[0] = "nama_produk";
                            field[1] = "harga_produk";
                            field[2] = "jumlah_produk";
                            field[3] = "total_harga";
                            String[] data = new String[4];
                            data[0] = nama_produk;
                            data[1] = harga_produk;
                            data[2] = jumlah_produk;
                            data[3] = total_harga;
                            PutData putData = new PutData("http://192.168.1.6/najwadb/tambahpesan.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    pgBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Tambah Data Sukses")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), HasilActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(),"All fields required", Toast.LENGTH_SHORT).show();
                }
*/

            }
        });
    }


}
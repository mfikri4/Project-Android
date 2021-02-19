package com.example.aplikasinajwashop;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.aplikasinajwashop.API.APIRequestData;
import com.example.aplikasinajwashop.API.RetroServer;

public class DetailActivity extends AppCompatActivity {


    private TextView tvid,tvnama,tvdeskripsi,tvharga;
    ImageView IvGambar;
    private String  tv_nama_barang= "",
            tv_deskripsi = "",ivGambar= "";
    private int tv_id,tv_harga_barang;
    APIRequestData mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mApiService = RetroServer.konekRetrofit().create(APIRequestData.class);


        tv_id = getIntent().getIntExtra("tv_id",0);
        tv_nama_barang = getIntent().getStringExtra("tv_nama_barang");
        tv_deskripsi = getIntent().getStringExtra("tv_deskripsi");
        tv_harga_barang = getIntent().getIntExtra("tv_harga_barang",0);
        ivGambar = getIntent().getStringExtra("iv_gambar");


        tvid = findViewById(R.id.tvid);
        tvnama = findViewById(R.id.tvnama);
        tvdeskripsi = findViewById(R.id.tvdeskripsi);
        tvharga = findViewById(R.id.tvharga);
        IvGambar = findViewById(R.id.IVGambar);

        tvid.setText(String.valueOf(tv_id));
        tvnama.setText(tv_nama_barang);
        tvdeskripsi.setText(tv_deskripsi);
        tvharga.setText(String.valueOf(tv_harga_barang));
        Glide.with(this).asBitmap().load(ivGambar).into(IvGambar);

    }
}
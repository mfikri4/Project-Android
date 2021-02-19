package com.example.go_ruqyah.View;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.go_ruqyah.API.APIRequestData;
import com.example.go_ruqyah.API.RetroServer;
import com.example.go_ruqyah.Adapter.AdapterData;
import com.example.go_ruqyah.Model.DataModel;
import com.example.go_ruqyah.Model.ResponseModel;
import com.example.go_ruqyah.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Daftarruqyah extends AppCompatActivity {

    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listPeruqyah = new ArrayList<>();
    private SwipeRefreshLayout srlData;
    private ProgressBar pbData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarruqyah);

        rvData = findViewById(R.id.rv_data);
        pbData = findViewById(R.id.pb_data);

        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);

    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveData();
    }

    public void  retrieveData (){

        pbData.setVisibility(View.VISIBLE);
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = ardData.ardRetrieveData();

        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode;
                kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(Daftarruqyah.this, " "+pesan, Toast.LENGTH_SHORT).show();

                listPeruqyah = response.body().getData();

                adData = new AdapterData(Daftarruqyah.this , listPeruqyah);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

                pbData.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(Daftarruqyah.this, "Gagal Menghubungi Server"+t.getMessage(), Toast.LENGTH_SHORT).show();

                pbData.setVisibility(View.INVISIBLE);
            }
        });
    }
}
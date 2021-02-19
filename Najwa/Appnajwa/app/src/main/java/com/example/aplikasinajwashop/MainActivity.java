package com.example.aplikasinajwashop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.aplikasinajwashop.API.APIRequestData;
import com.example.aplikasinajwashop.API.RetroServer;
import com.example.aplikasinajwashop.Adapter.AdapterData;
import com.example.aplikasinajwashop.Model.DataModel;
import com.example.aplikasinajwashop.Model.ResponseModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener,View.OnClickListener {

    private Button BtnMenu, BtnLogout;
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listBarang = new ArrayList<>();
    private SwipeRefreshLayout srlData;
    private ProgressBar pbData;

    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        BtnMenu = findViewById(R.id.menubtn);
        BtnLogout = findViewById(R.id.logoutbtn);
        BtnMenu.setOnClickListener(this::showPopUp);
        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    // ...
                    case R.id.logoutbtn:
                        signOut();
                        break;
                    // ...
                }
            }
        });
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
        }

        rvData = findViewById(R.id.rv_data);
        srlData = findViewById(R.id.srlData);
        pbData = findViewById(R.id.pb_data);

        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);



        srlData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlData.setRefreshing(true);
                retrieveData();
                srlData.setRefreshing(false);
            }
        });
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

                Toast.makeText(MainActivity.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();

                listBarang = response.body().getData();

                adData = new AdapterData(MainActivity.this , listBarang);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

                pbData.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungi Server"+t.getMessage(), Toast.LENGTH_SHORT).show();

                pbData.setVisibility(View.INVISIBLE);
            }
        });
    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this, "Logout Success", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MasukActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }

    private void showPopUp(View view) {
        PopupMenu popUp = new PopupMenu(this, view);
        popUp.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popUp.inflate(R.menu.menu);
        popUp.show();
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        String nomorHP = "+62 857-4076-2080";
        switch (item.getItemId()) {
            case R.id.call_center:
                String uriTel = "tel:" + nomorHP;
                Intent intentTel = new Intent(Intent.ACTION_DIAL);
                intentTel.setData(Uri.parse(uriTel));
                startActivity(intentTel);
                return true;
            case R.id.sms_center:
                String uriSms = "smsto:" + nomorHP;
                Intent intentSms = new Intent(Intent.ACTION_SENDTO);
                intentSms.setData(Uri.parse(uriSms));
                startActivity(intentSms);
                return true;
            case R.id.lokasi:
                String koordinat = "-6.747280, 111.021947";
                Intent intentMaps = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("geo:0,0?q=%s", koordinat)));
                intentMaps.setPackage("com.google.android.apps.maps");
                startActivity(intentMaps);
                return true;
            case R.id.akun:
                Intent intent = new Intent(MainActivity.this, Splash.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}
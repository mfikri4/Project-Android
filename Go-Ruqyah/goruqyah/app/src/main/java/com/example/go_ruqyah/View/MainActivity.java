package com.example.go_ruqyah.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.go_ruqyah.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener,View.OnClickListener {

    private Button BtnMenu;
    private Button Logout;
    private ImageButton BtnSilaturahmi;
    private ImageButton BtnInformasi;
    private ImageButton BtnCallcenter;
    private ImageButton BtnPesan;
    private ImageButton BtnRuqyahmandiri;
    private ImageButton BtnAlquran;
    private ImageButton BtnKonsultasi;
    private ImageButton BtnDzikir;
    private ImageButton BtnZiarah;
    private TextView name;

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
        Logout = findViewById(R.id.logout_btn);
        BtnSilaturahmi = findViewById(R.id.silaturahmi_icn);
        BtnInformasi = findViewById(R.id.informasi_icn);
        BtnCallcenter = findViewById(R.id.callcenter_icn);
        BtnPesan = findViewById(R.id.pesanruqyah_icn);
        BtnRuqyahmandiri = findViewById(R.id.ruqyahmandiri_icn);
        BtnAlquran = findViewById(R.id.alquran_icn);
        BtnKonsultasi = findViewById(R.id.konsultasi_icn);
        BtnDzikir = findViewById(R.id.dzikir_icn);
        BtnZiarah = findViewById(R.id.ziarahmakam_icn);
        name = findViewById(R.id.nametext);

        BtnMenu.setOnClickListener(this::showPopUp);
        BtnSilaturahmi.setOnClickListener((View.OnClickListener) this);
        BtnInformasi.setOnClickListener((View.OnClickListener) this);
        BtnCallcenter.setOnClickListener((View.OnClickListener) this);
        BtnPesan.setOnClickListener((View.OnClickListener) this);
        BtnRuqyahmandiri.setOnClickListener((View.OnClickListener) this);
        BtnAlquran.setOnClickListener((View.OnClickListener) this);
        BtnKonsultasi.setOnClickListener((View.OnClickListener) this);
        BtnDzikir.setOnClickListener((View.OnClickListener) this);
        BtnZiarah.setOnClickListener((View.OnClickListener) this);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    // ...
                    case R.id.logout_btn:
                        signOut();
                        break;
                    // ...
                }
            }
        });

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();

            name.setText(personName);
        }
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this, "Logout Success",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), Signin.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }

    private void showPopUp(View view) {
        PopupMenu popUp = new PopupMenu(this,view);
        popUp.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popUp.inflate(R.menu.menu);
        popUp.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        String nomorHP = "+62 822-2356-5653";
        switch (item.getItemId()){
            case R.id.call_center:
                String uriTel = "tel:"+nomorHP;
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
                String koordinat = "6°58'58.1\"S 110°24'33.1\"E";
                Intent intentMaps = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("geo:0,0?q=%s",koordinat)));
                intentMaps.setPackage("com.google.android.apps.maps");
                startActivity(intentMaps);
                return true;
            case R.id.akun:
                Intent intent = new Intent(MainActivity.this, Akunku.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.silaturahmi_icn:
                String koordinat = "6°58'58.1\"S 110°24'33.1\"E";
                Intent intentMaps = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("geo:0,0?q=%s",koordinat)));
                intentMaps.setPackage("com.google.android.apps.maps");
                startActivity(intentMaps);
                break;
            case R.id.informasi_icn:
                Intent intentInfoApp = new Intent(MainActivity.this, InfoApp.class);
                startActivity(intentInfoApp);
                break;
            case R.id.callcenter_icn:
                String uriTel = "tel:"+ "+62 822-2356-5653";
                Intent intentTel = new Intent(Intent.ACTION_DIAL);
                intentTel.setData(Uri.parse(uriTel));
                startActivity(intentTel);
                break;
            case R.id.pesanruqyah_icn:
                Intent intent= new Intent(MainActivity.this, Daftarruqyah.class);
                startActivity(intent);
                break;
            case R.id.ruqyahmandiri_icn:
                Toast.makeText(this,"Maaf, masih dalam pengembangan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.alquran_icn:
                Toast.makeText(this,"Maaf, masih dalam pengembangan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.konsultasi_icn:
                Toast.makeText(this,"Maaf, masih dalam pengembangan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dzikir_icn:
                Toast.makeText(this,"Maaf, masih dalam pengembangan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ziarahmakam_icn:
                Toast.makeText(this,"Maaf, masih dalam pengembangan", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
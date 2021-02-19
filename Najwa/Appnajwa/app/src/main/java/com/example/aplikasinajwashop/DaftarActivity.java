package com.example.aplikasinajwashop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class DaftarActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextNama,textInputEditTextEmail,textInputEditTextAlamat,textInputEditTextGender, textInputEditTextNoHp, textInputEditTextPassword;
    Button btndaftar;
    TextView najwa,textMasuk;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        najwa=findViewById(R.id.Najwa);
        textMasuk=findViewById(R.id.textMasuk);

        textInputEditTextNama=findViewById(R.id.nama);
        textInputEditTextEmail=findViewById(R.id.email);
        textInputEditTextAlamat=findViewById(R.id.alamat);
        textInputEditTextGender=findViewById(R.id.gender);
        textInputEditTextNoHp=findViewById(R.id.no_hp);
        textInputEditTextPassword=findViewById(R.id.password);

        btndaftar=findViewById(R.id.btndaftar);
        progressBar=findViewById(R.id.progress);

        textMasuk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MasukActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            final String nama, email, alamat, gender, no_hp, password;
            nama = String.valueOf(textInputEditTextNama.getText());
            email = String.valueOf(textInputEditTextEmail.getText());
            alamat = String.valueOf(textInputEditTextAlamat.getText());
            gender = String.valueOf(textInputEditTextGender.getText());
            no_hp = String.valueOf(textInputEditTextNoHp.getText());
            password = String.valueOf(textInputEditTextPassword.getText());

            if(!nama.equals("") && !email.equals("") && !alamat.equals("") && !gender.equals("") && !no_hp.equals("") && !password.equals("")  ) {
                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[6];
                        field[0] = "nama";
                        field[1] = "email";
                        field[2] = "alamat";
                        field[3] = "gender";
                        field[4] = "no_hp";
                        field[5] = "password";
                        String[] data = new String[6];
                        data[0] = nama;
                        data[1] = email;
                        data[2] = alamat;
                        data[3] = gender;
                        data[4] = no_hp;
                        data[5] = password;
                        PutData putData = new PutData("http://192.168.1.4/najwadb/signup.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                progressBar.setVisibility(View.GONE);
                                String result = putData.getResult();
                                if (result.equals("Pendaftaran Sukses")) {
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MasukActivity.class);
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
            }
        });


    }
}
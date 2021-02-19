package com.example.go_ruqyah.View;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.go_ruqyah.R;

public class Akunku extends AppCompatActivity {

    private ImageButton BtnSelesai;
    private EditText EditTextUser, EditTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akunku);

        EditTextUser = (EditText) findViewById(R.id.User);
        EditTextPass = (EditText) findViewById(R.id.pass);

    }
}
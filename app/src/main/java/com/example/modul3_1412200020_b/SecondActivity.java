package com.example.modul3_1412200020_b;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {

    private TextView tvNPM, tvNama, tvKelas, tvJenisKelamin, tvAngkatan, tvBahasaPemrograman, tvTglLahir;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvNPM = findViewById(R.id.tv_npm);
        tvNama = findViewById(R.id.tv_nama);
        tvKelas = findViewById(R.id.tv_kelas);
        tvJenisKelamin = findViewById(R.id.tv_jenis_kelamin);
        tvAngkatan = findViewById(R.id.tv_angkatan);
        tvBahasaPemrograman = findViewById(R.id.tv_bahasa_pemrograman);
        tvTglLahir = findViewById(R.id.tv_tgl_lahir);

        String npm = getIntent().getStringExtra("npm");
        String nama = getIntent().getStringExtra("nama");
        String kelas = getIntent().getStringExtra("kelas");
        String jenisKelamin = getIntent().getStringExtra("jenis_kelamin");
        String angkatan = getIntent().getStringExtra("angkatan");
        String tgl_lahir = getIntent().getStringExtra("tgl_lahir");
        ArrayList<String> bahasa_pemrograman = getIntent().getStringArrayListExtra("bahasa_pemrograman");

        // Menggabungkan semua elemen dari ArrayList menjadi satu string
        StringBuilder sb = new StringBuilder();
        for (String s : bahasa_pemrograman) {
            sb.append(s).append("\n");
        }

        tvNPM.setText(npm);
        tvNama.setText(nama);
        tvKelas.setText(kelas);
        tvJenisKelamin.setText(jenisKelamin);
        tvJenisKelamin.setText(tgl_lahir);
        tvAngkatan.setText(angkatan);
        tvBahasaPemrograman.setText(sb.toString());
    }
}
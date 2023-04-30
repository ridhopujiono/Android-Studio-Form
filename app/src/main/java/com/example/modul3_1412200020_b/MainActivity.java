package com.example.modul3_1412200020_b;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplayTglLahir;
    private EditText etNPM, etNama;
    private RadioGroup rbKelas, rbJenisKelamin;
    private Spinner spAngkatan;
    private LinearLayout cbBahasaPemrograman;
    private Button btnSubmit, btnReset, btnTglLahir;
    public String tglLahirValue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNPM = findViewById(R.id.et_npm);
        etNama = findViewById(R.id.et_nama);
        rbKelas = findViewById(R.id.rg_kelas);
        rbJenisKelamin = findViewById(R.id.rg_jk);
        spAngkatan = findViewById(R.id.sp_angkatan);
        cbBahasaPemrograman = findViewById(R.id.cb_bahasa_pemrograman);
        btnSubmit = findViewById(R.id.btn_submit);
        btnReset = findViewById(R.id.btn_reset);
        btnTglLahir = findViewById(R.id.btn_tgl_lahir);
        tvDisplayTglLahir = findViewById(R.id.tv_display_tgl_lahir);



        btnTglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                // Membuat DatePickerDialog untuk memilih tanggal lahir
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // Mengonversi nilai tanggal lahir menjadi string
                                String birthDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

                                // Menampilkan nilai tanggal lahir
                                tglLahirValue = birthDate;
                                tvDisplayTglLahir.setText(tglLahirValue);
                            }
                        }, year, month, dayOfMonth);

                // Menampilkan DatePickerDialog
                datePickerDialog.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String npm = etNPM.getText().toString();
                String nama = etNama.getText().toString();

                int selectedKelasId = rbKelas.getCheckedRadioButtonId();
                RadioButton rbKelasSelected = findViewById(selectedKelasId);
                String kelas = rbKelasSelected.getText().toString();

                int selectedJenisKelaminId = rbJenisKelamin.getCheckedRadioButtonId();
                RadioButton rbJenisKelaminSelected = findViewById(selectedJenisKelaminId);
                String jenisKelamin = rbJenisKelaminSelected.getText().toString();

                String angkatan = spAngkatan.getSelectedItem().toString();


                // Mendapatkan jumlah checkbox
                int checkboxCount = cbBahasaPemrograman.getChildCount();

                // Membuat list untuk menyimpan hasil
                ArrayList <String> selectedCheckboxItem = new ArrayList<>();

                // Melakukan iterasi pada semua checkbox dan memeriksa statusnya
                for (int i = 0; i < checkboxCount; i++) {
                    View view = cbBahasaPemrograman.getChildAt(i);

                    if (view instanceof CheckBox) {
                        CheckBox checkBox = (CheckBox) view;
                        if (checkBox.isChecked()) {
                            // Jika checkbox terpilih, tambahkan nilainya ke dalam list selectedItems
                            selectedCheckboxItem.add(checkBox.getText().toString());
                        }
                    }
                }


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("npm", npm);
                intent.putExtra("nama", nama);
                intent.putExtra("kelas", kelas);
                intent.putExtra("jenis_kelamin", jenisKelamin);
                intent.putExtra("angkatan", angkatan);
                intent.putExtra("tgl_lahir", tglLahirValue);
                intent.putStringArrayListExtra("bahasa_pemrograman", selectedCheckboxItem);
                startActivity(intent);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNPM.setText("");
                etNama.setText("");
                rbKelas.clearCheck();
                rbJenisKelamin.clearCheck();
                spAngkatan.setSelection(0);
                tvDisplayTglLahir.setText("");
                // Reset Checkbox adalah dengan looping semua checkbox lalu reset statusnya
                // Mendapatkan jumlah checkbox
                int checkboxCount = cbBahasaPemrograman.getChildCount();

                // Melakukan iterasi pada semua checkbox dan memeriksa statusnya
                for (int i = 0; i < checkboxCount; i++) {
                    View view = cbBahasaPemrograman.getChildAt(i);

                    if (view instanceof CheckBox) {
                        CheckBox checkBox = (CheckBox) view;
                        if (checkBox.isChecked()) {
                            checkBox.setChecked(false);
                        }
                    }
                }
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.w("Pesan", "Metode onPause(1412200020) dijalankan");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Pesan", "Metode onResume(1412200020) dijalankan");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.w("Pesan", "Metode onStart(1412200020) dijalankan");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("Pesan", "Metode onRestart(1412200020) dijalankan");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.w("Pesan", "Metode onStop(1412200020) dijalankan");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("Pesan", "Metode onDestroy(1412200020) dijalankan");
    }
}
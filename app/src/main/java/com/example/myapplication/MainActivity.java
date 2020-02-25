package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnHasil, btnPindah;
    private EditText etPanjang, etLebar, etTinggi;
    private TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHasil = findViewById(R.id.btn_hasil);
        etPanjang = findViewById(R.id.et_panjang);
        etLebar = findViewById(R.id.et_lebar);
        etTinggi = findViewById(R.id.et_tinggi);
        tvHasil = findViewById(R.id.tv_hasil);
        btnPindah = findViewById(R.id.btn_pindah);
        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String sPanjang = etPanjang.getText().toString();
                    String sLebar = etLebar.getText().toString();
                    String sTinggi = etTinggi.getText().toString();

                    double panjang = Double.parseDouble(sPanjang);
                    double lebar = Double.parseDouble(sLebar);
                    double tinggi = Double.parseDouble(sTinggi);
                    double hasil = panjang * lebar * tinggi;
                    String sHasil = String.valueOf(hasil);
                    tvHasil.setText(sHasil);

                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    intent.putExtra("volume", sHasil);
                    startActivity(intent);

                }
                catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(),"field tidak diisi",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });

    }
}

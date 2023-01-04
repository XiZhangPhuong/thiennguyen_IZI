package com.example.myappizi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myappizi.Model.ThamGia;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DanhGiaActivity extends AppCompatActivity {
private DatabaseReference data_Thamgia = FirebaseDatabase.getInstance().getReference("ThamGia");
private EditText edt_diemdanhgia,edt_tieuchi1,edt_tieuchi2,edt_tieuchi3,edt_nhanxetkhac;
private Button btn_danhgia;
private String mahD,maTv,batDau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_gia);
        initView();
        mahD = getIntent().getStringExtra("key");
        maTv = getIntent().getStringExtra("key1");
        batDau = getIntent().getStringExtra("key2");
        danhgia();
    }
    private void initView(){
        edt_diemdanhgia = findViewById(R.id.edt_diemdanhgia);
        edt_tieuchi1 = findViewById(R.id.edt_tieuchi1);
        edt_tieuchi2 = findViewById(R.id.edt_tieuchi2);
        edt_tieuchi3 = findViewById(R.id.edt_tieuchi3);
        edt_nhanxetkhac = findViewById(R.id.edt_nhanxetkhac);
        btn_danhgia =findViewById(R.id.btn_danhgia);
    }
    private void danhgia(){
        btn_danhgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThamGia tg = new ThamGia(maTv,mahD,"",batDau,Double.parseDouble(edt_diemdanhgia.getText().toString()),
                        Double.parseDouble(edt_tieuchi1.getText().toString()),Double.parseDouble(edt_tieuchi2.getText().toString()),
                        Double.parseDouble(edt_tieuchi3.getText().toString()),edt_nhanxetkhac.getText().toString());
                data_Thamgia.child(tg.getMahd()).setValue(tg);
                Toast.makeText(DanhGiaActivity.this,"Danh gia thanh cong",Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}
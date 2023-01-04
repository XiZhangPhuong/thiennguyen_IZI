package com.example.myappizi.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myappizi.Model.HoatDong;
import com.example.myappizi.Model.ThanhVien;
import com.example.myappizi.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class TaoMoiFragment extends Fragment {

private View mView;
    private EditText edt_maHD,edt_tenHD,edt_motaHD,edt_batdau,edt_ketthuc,edt_slToiThieu,
            edt_slToiDa,edt_thoihandk,edt_matv;
    private Button btn_taomoiHD;
    private Spinner spiner_trangthai;
    private DatabaseReference data_HoatDong = FirebaseDatabase.getInstance().getReference("HoatDong");
    private DatabaseReference data_ThanhVien = FirebaseDatabase.getInstance().getReference("ThanhVien");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_tao_moi, container, false);
        initView();
        taoMoiHoatDong();
        return mView;
    }

    private void taoMoiHoatDong(){
        btn_taomoiHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(edt_slToiThieu.getText().toString()) > Integer.parseInt(edt_slToiDa.getText().toString())){
                    edt_slToiDa.setText("");
                    edt_slToiThieu.setText("");
                    return;
                }
                if(edt_maHD.length()>0 && edt_tenHD.length()>0 && edt_motaHD.length()>0 &&
                        edt_batdau.length()>0 && edt_ketthuc.length()>0 && edt_slToiThieu.length()>0 &&
                        edt_slToiDa.length()>0 && edt_thoihandk.length()>0 && edt_matv.length()>0){


                    HoatDong hd = new HoatDong(edt_maHD.getText().toString(),edt_tenHD.getText().toString(),
                            edt_motaHD.getText().toString(),edt_batdau.getText().toString(),edt_ketthuc.getText().toString(),
                            Integer.parseInt(edt_slToiThieu.getText().toString()),Integer.parseInt(edt_slToiDa.getText().toString()),edt_thoihandk.getText().toString(),
                            "Đang mời đăng ký",edt_matv.getText().toString(),"");

                    data_HoatDong.child(edt_maHD.getText().toString()).setValue(hd);
                    Toast.makeText(getContext(),"Them thanh cong",Toast.LENGTH_SHORT).show();
                    edt_maHD.setText("");
                    edt_tenHD.setText("");
                    edt_motaHD.setText("");
                    edt_batdau.setText("");
                    edt_ketthuc.setText("");
                    edt_slToiThieu.setText("");
                    edt_slToiDa.setText("");
                    edt_thoihandk.setText("");
                    edt_matv.setText("");
                    edt_maHD.requestFocus();
                }else{
                    Toast.makeText(getContext(),"Vui long nhap day du tat ca cac truong",Toast.LENGTH_SHORT);
                }
            }
        });
    }

    private void initView(){
        edt_maHD = mView.findViewById(R.id.edt_maHD);
        edt_tenHD = mView.findViewById(R.id.edt_tenHD);
        edt_motaHD = mView.findViewById(R.id.edt_motaHD);
        edt_batdau = mView.findViewById(R.id.edt_maHD);
        edt_ketthuc = mView.findViewById(R.id.edt_ketthuc);
        edt_slToiThieu = mView.findViewById(R.id.edt_slToiThieu);
        edt_slToiDa = mView.findViewById(R.id.edt_slToiDa);
        edt_thoihandk = mView.findViewById(R.id.edt_thoihandk);
        edt_matv = mView.findViewById(R.id.edt_matv);
        btn_taomoiHD =mView.findViewById(R.id.btn_taomoiHD);
        spiner_trangthai = mView.findViewById(R.id.spiner_trangthai);
    }
}
package com.example.myappizi.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myappizi.Adapter.DanhGiaAdapter;
import com.example.myappizi.Adapter.HoatDongAdapter;
import com.example.myappizi.DanhGiaActivity;
import com.example.myappizi.Model.HoatDong;
import com.example.myappizi.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class SuaFragment extends Fragment {
private View mView;
private HoatDongAdapter hoatDongAdapter;
private RecyclerView rcv_hoatdong;
private List<HoatDong> listHD;
private DatabaseReference data_HoatDong = FirebaseDatabase.getInstance().getReference("HoatDong");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView =  inflater.inflate(R.layout.fragment_sua, container, false);
        rcv_hoatdong = mView.findViewById(R.id.rcv_hoatdong);

        rcv_hoatdong.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rcv_hoatdong.setHasFixedSize(true);
        listHD = new ArrayList<>();
        loadDataHoatDong();
        return mView;
    }

    private void loadDataHoatDong() {
        data_HoatDong.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listHD.clear();
                for(DataSnapshot ds : snapshot.getChildren()){
                    HoatDong hd = ds.getValue(HoatDong.class);
                    listHD.add(hd);
                }
                hoatDongAdapter = new HoatDongAdapter(listHD, new HoatDongAdapter.ClickHoatDong() {
                    @Override
                    public void ClickSua(EditText edt_maHD, EditText edt_tenHD, EditText edt_motaHD, EditText edt_batdau, EditText edt_ketthuc, EditText edt_slToiThieu, EditText edt_slToiDa, EditText edt_thoihandk, EditText edt_trangthai, EditText edt_matv) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Thong bao ?")
                                .setMessage("Xac nhan sua ?")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        HoatDong hd = new HoatDong(edt_maHD.getText().toString(),edt_tenHD.getText().toString(),
                                                edt_motaHD.getText().toString(),edt_batdau.getText().toString(),
                                                edt_ketthuc.getText().toString(),Integer.parseInt(edt_slToiThieu.getText().toString()),
                                                Integer.parseInt(edt_slToiDa.getText().toString()),edt_thoihandk.getText().toString(),edt_trangthai.getText().toString(),
                                                edt_matv.getText().toString(),"");
                                        data_HoatDong.child(hd.getMaHD()).setValue(hd);
                                        Toast.makeText(getContext(),"Cap nhap thanh cong",Toast.LENGTH_SHORT).show();
                                    }
                                }).setNegativeButton("No",null).create().show();
                    }

                    @Override
                    public void CLickXoa(HoatDong hoatDong) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Thong bao ?")
                                .setMessage("Xac nhan xoa ?")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        if(hoatDong.getTrangThai().equals("Đã kết thúc")){
                                            Toast.makeText(getContext(),"K the xoa",Toast.LENGTH_SHORT).show();
                                            return;
                                        }
                                        data_HoatDong.child(hoatDong.getMaHD()).removeValue();
                                        Toast.makeText(getContext(),"Delete sucessfully",Toast.LENGTH_SHORT).show();
                                        hoatDongAdapter.notifyDataSetChanged();
                                    }
                                }).setNegativeButton("No",null).create().show();
                    }
                    @Override
                    public void ClickDanhGia(HoatDong hoatDong){
                        if(hoatDong.getTrangThai().equals("Đã kết thúc")) {
                            Intent intent = new Intent(getContext(), DanhGiaActivity.class);
                            intent.putExtra("key",hoatDong.getMaHD());
                            intent.putExtra("key1",hoatDong.getMaTV());
                            intent.putExtra("key2",hoatDong.getNgayGioBatDau());
                            startActivity(intent);
                        }else{
                            Toast.makeText(getContext(),"K dc phep danh gia",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                rcv_hoatdong.setAdapter(hoatDongAdapter);
                hoatDongAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
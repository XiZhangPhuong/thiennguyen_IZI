package com.example.myappizi.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myappizi.Adapter.DanhGiaAdapter;
import com.example.myappizi.Model.HoatDong;
import com.example.myappizi.Model.ThamGia;
import com.example.myappizi.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class LietKeFragment extends Fragment {
private View mView;
private DanhGiaAdapter danhGiaAdapter;
private RecyclerView rcv_thongke;
private List<ThamGia> list;
    private DatabaseReference data_Thamgia = FirebaseDatabase.getInstance().getReference("ThamGia");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView =  inflater.inflate(R.layout.fragment_thong_ke, container, false);
        rcv_thongke = mView.findViewById(R.id.rcv_thongke);

        rcv_thongke.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rcv_thongke.setHasFixedSize(true);
        list = new ArrayList<>();
        pushData();
        loadData();
        return mView;
    }
    private void pushData(){
        list.add(new ThamGia("tv2","hd01","Phuong","3/3/2020",8,5,5,5,"tot"));
        list.add(new ThamGia("tv3","hd02","Huy","3/3/2020",8,1,2,3,"tot"));
        list.add(new ThamGia("tv4","hd03","Duong","3/3/2020",8,1,0,4,"tot"));
        list.add(new ThamGia("tv5","hd04","Lam","3/3/2020",8,5,5,2.5,"tot"));
        list.add(new ThamGia("tv6","hd05","Duc","3/3/2020",10,5,5,5,"tot"));
        for(ThamGia tg : list){
            data_Thamgia.child(tg.getMahd()).setValue(tg);
        }
    }
    private void loadData(){
        data_Thamgia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot ds : snapshot.getChildren()){
                    ThamGia tg = ds.getValue(ThamGia.class);
                    list.add(tg);
                }
                for(int i = 0;i<list.size()-1;i++){
                    for(int j = i+1;j<list.size();j++){
                        double dtb = (list.get(i).getDiemTruongDoan()+list.get(i).getDiemtc1()+list.get(i).getDiemtc2()+
                                list.get(i).getDiemtv3())/4.0;
                        double dtb1 = (list.get(j).getDiemTruongDoan()+list.get(j).getDiemtc1()+list.get(j).getDiemtc2()+
                                list.get(j).getDiemtv3())/4.0;
                        if(dtb<dtb1){
                            ThamGia tg = list.set(i,list.get(i));
                            list.set(i,list.get(j));
                            list.set(j,tg);
                        }
                    }
                }
                danhGiaAdapter = new DanhGiaAdapter(list);
                rcv_thongke.setAdapter(danhGiaAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
package com.example.myappizi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappizi.Model.HoatDong;
import com.example.myappizi.R;

import java.util.List;

public class HoatDongAdapter extends RecyclerView.Adapter<HoatDongAdapter.ViewHolder> {
    private List<HoatDong> listHD;
    public interface ClickHoatDong{
        void ClickSua(EditText edt_maHD,EditText edt_tenHD,EditText edt_motaHD,EditText edt_batdau,EditText edt_ketthuc,
                      EditText edt_slToiThieu,
                      EditText edt_slToiDa,EditText edt_thoihandk,EditText edt_trangthai,EditText edt_matv);
        void CLickXoa(HoatDong hoatDong);
        void ClickDanhGia(HoatDong hoatDong);
    }
    private ClickHoatDong clickHoatDong;

    public HoatDongAdapter(List<HoatDong> listHD, ClickHoatDong clickHoatDong) {
        this.listHD = listHD;
        this.clickHoatDong = clickHoatDong;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HoatDongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hoatdong,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoatDongAdapter.ViewHolder holder, int position) {
        HoatDong hd = this.listHD.get(position);
        holder.edt_maHD.setText(hd.getMaHD());
        holder.edt_tenHD.setText(hd.getTenHD());
        holder.edt_motaHD.setText(hd.getMotaHD());
        holder.edt_batdau.setText(hd.getNgayGioBatDau());
        holder.edt_ketthuc.setText(hd.getNgayGioKetThuc());
        holder.edt_slToiThieu.setText(String.valueOf(hd.getSl_ToiThieu()));
        holder.edt_slToiDa.setText(String.valueOf(hd.getSl_ToiDa()));
        holder.edt_thoihandk.setText(hd.getThoiHanDK());
        holder.edt_trangthai.setText(hd.getTrangThai());
        holder.edt_matv.setText(hd.getMaTV());

        holder.btn_suaHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHoatDong.ClickSua( holder.edt_maHD, holder.edt_tenHD,  holder.edt_motaHD, holder.edt_batdau,
                        holder.edt_ketthuc, holder.edt_slToiThieu ,  holder.edt_slToiDa,holder.edt_thoihandk,
                        holder.edt_trangthai,   holder.edt_matv);
            }
        });
        holder.btn_xoaHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHoatDong.CLickXoa(hd);
            }
        });
        holder.btn_danhgiaHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHoatDong.ClickDanhGia(hd);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listHD.size()!=0){
            return listHD.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private EditText edt_maHD,edt_tenHD,edt_motaHD,edt_batdau,edt_ketthuc,edt_slToiThieu,
                edt_slToiDa,edt_thoihandk,edt_trangthai,edt_matv;
        private Button btn_suaHD,btn_xoaHD,btn_danhgiaHD;
        public ViewHolder(@NonNull View mView) {
            super(mView);
            edt_maHD = mView.findViewById(R.id.edt_maHD);
            edt_tenHD = mView.findViewById(R.id.edt_tenHD);
            edt_motaHD = mView.findViewById(R.id.edt_motaHD);
            edt_batdau = mView.findViewById(R.id.edt_batdau);
            edt_ketthuc = mView.findViewById(R.id.edt_ketthuc);
            edt_slToiThieu = mView.findViewById(R.id.edt_slToiThieu);
            edt_slToiDa = mView.findViewById(R.id.edt_slToiDa);
            edt_thoihandk = mView.findViewById(R.id.edt_thoihandk);
            edt_trangthai = mView.findViewById(R.id.edt_trangthai);
            edt_matv = mView.findViewById(R.id.edt_matv);
            btn_suaHD =mView.findViewById(R.id.btn_suaHD);
            btn_xoaHD =mView.findViewById(R.id.btn_xoaHD);
            btn_danhgiaHD = mView.findViewById(R.id.btn_danhgiaHD);
        }
    }
}

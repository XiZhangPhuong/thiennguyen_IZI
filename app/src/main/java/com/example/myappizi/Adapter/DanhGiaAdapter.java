package com.example.myappizi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappizi.Model.ThamGia;
import com.example.myappizi.R;

import java.util.List;

public class DanhGiaAdapter extends RecyclerView.Adapter<DanhGiaAdapter.ViewHolder> {
    private List<ThamGia> listThamGia;

    public DanhGiaAdapter(List<ThamGia> listThamGia) {
        this.listThamGia = listThamGia;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DanhGiaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhgia,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhGiaAdapter.ViewHolder holder, int position) {
       ThamGia tg = this.listThamGia.get(position);
       if(tg==null){
           return;
       }
       holder.txt_matv.setText(tg.getMatv());
       holder.txt_hoten_tv.setText(tg.getTenTV());
       double dtb = (tg.getDiemTruongDoan()+tg.getDiemtc1()+tg.getDiemtc2()+tg.getDiemtv3())/4.0;
       holder.txt_dtb.setText(String.valueOf(dtb));
    }

    @Override
    public int getItemCount() {
        if(listThamGia.size()!=0){
            return listThamGia.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_matv,txt_hoten_tv,txt_dtb;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_matv = itemView.findViewById(R.id.txt_matv);
            txt_hoten_tv = itemView.findViewById(R.id.txt_hoten_tv);
            txt_dtb = itemView.findViewById(R.id.txt_dtb);

        }
    }
}

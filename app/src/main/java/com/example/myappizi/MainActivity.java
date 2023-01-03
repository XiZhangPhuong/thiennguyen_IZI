package com.example.myappizi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myappizi.Model.HoatDong;
import com.example.myappizi.Model.ThanhVien;
import com.example.myappizi.ViewPager.MyViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    public static ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayoutLoginSignUp);
        tabLayout.setTabTextColors(Color.parseColor("#000000"),Color.parseColor("#ff4d4d"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff4d4d"));
        viewPager2 = findViewById(R.id.viewPager);
        MyViewPager myViewPager = new MyViewPager(this);
        viewPager2.setAdapter(myViewPager);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("thêm mới");
                        break;
                    case 1:
                        tab.setText("sửa|xóa");
                        break;
                    case 2:
                        tab.setText("thống kê");
                        break;
                }
            }
        }).attach();


    }


}
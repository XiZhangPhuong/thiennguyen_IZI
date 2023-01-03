package com.example.myappizi.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myappizi.Fragment.SuaFragment;
import com.example.myappizi.Fragment.TaoMoiFragment;
import com.example.myappizi.Fragment.LietKeFragment;

public class MyViewPager extends FragmentStateAdapter {
    public MyViewPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new TaoMoiFragment();
            case 1:
                return new SuaFragment();
            case 2 :
                return new LietKeFragment();
            default:
                return new TaoMoiFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
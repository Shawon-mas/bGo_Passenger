package com.app.bGoPassenger.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.bGoPassenger.view.passengerProfileUi.DocumentInfo;
import com.app.bGoPassenger.view.passengerProfileUi.GeneralInfo;
import com.app.bGoPassenger.view.passengerProfileUi.SelfieInfo;

public class AccountPageAdapter extends FragmentStateAdapter {
    public AccountPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0)
        {
            return new GeneralInfo();
        }else if (position==1){
            return new DocumentInfo();
        }else if (position==2){
            return new SelfieInfo();
        }
        return new GeneralInfo();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

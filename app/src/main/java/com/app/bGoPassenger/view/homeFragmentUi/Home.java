package com.app.bGoPassenger.view.homeFragmentUi;

import static com.app.bGoPassenger.utilites.Constants.KEY_USER_ID;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bGoPassenger.R;
import com.app.bGoPassenger.databinding.FragmentHomeBinding;
import com.app.bGoPassenger.utilites.PreferenceManager;


public class Home extends Fragment {

   private FragmentHomeBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(getLayoutInflater());
        preferenceManager=new PreferenceManager(getActivity().getApplicationContext());
        initViews();
        return binding.getRoot();
    }

    private void initViews() {
      /*  byte[] bytes= Base64.decode(preferenceManager.getString(KEY_USER_ID),Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        binding.homeProfileImage.setImageBitmap(bitmap);*/
    }
}
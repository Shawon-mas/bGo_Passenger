package com.app.bGoPassenger.view;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.app.bGoPassenger.R;
import com.app.bGoPassenger.databinding.ActivityHomeBinding;
import com.app.bGoPassenger.utilites.PreferenceManager;
import com.app.bGoPassenger.view.homeFragmentUi.History;
import com.app.bGoPassenger.view.homeFragmentUi.Home;
import com.app.bGoPassenger.view.homeFragmentUi.Offer;
import com.app.bGoPassenger.view.homeFragmentUi.Settings;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private ActivityHomeBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        preferenceManager=new PreferenceManager(getApplicationContext());
        setContentView(binding.getRoot());
        bottomNavImplement();
    }

    private void bottomNavImplement() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this);
        binding.bottomNavigation.setSelectedItemId(R.id.navigation_home);
    }
    Home homeFragment=new Home();
    Offer offerFragment=new Offer();
    History historyFragment=new History();
    Settings settingFragment=new Settings();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.home_container,homeFragment).commit();
                return true;
            case R.id.navigation_offer:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.home_container,offerFragment).commit();
                return true;
            case R.id.navigation_history:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.home_container,historyFragment).commit();
                return true;
            case R.id.navigation_setting:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.home_container,settingFragment).commit();
                return true;
        }
        return false;
    }
}
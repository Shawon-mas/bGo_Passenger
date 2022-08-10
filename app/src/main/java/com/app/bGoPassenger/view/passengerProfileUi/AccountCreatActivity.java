package com.app.bGoPassenger.view.passengerProfileUi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.bGoPassenger.R;
import com.app.bGoPassenger.adapter.AccountPageAdapter;
import com.app.bGoPassenger.databinding.ActivityAccountCreatBinding;
import com.app.bGoPassenger.view.HomeActivity;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;

public class AccountCreatActivity extends AppCompatActivity {
    private ActivityAccountCreatBinding binding;
    private AccountPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAccountCreatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickListener();
        stepViewImplement();

    }

    private void stepViewImplement() {
        binding.stepView.getState()
                .selectedTextColor(ContextCompat.getColor(this, R.color.textPrimaryColor))
                .animationType(StepView.ANIMATION_CIRCLE)
                .selectedCircleColor(ContextCompat.getColor(this, R.color.mainColor))
                .selectedCircleRadius(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._14sdp))
                .selectedStepNumberColor(ContextCompat.getColor(this, R.color.white))
                .steps(new ArrayList<String>() {{
                    add("General Info");
                    add("Nid Upload");
                    add("Selfie");
                }})
                .stepsNumber(3)
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .stepLineWidth(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._1sdp))
                .textSize(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp))
                .stepNumberTextSize(getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp))
                .typeface(ResourcesCompat.getFont(getApplicationContext(), R.font.sf_ui_display))
                .commit();

        FragmentManager fragmentManager=getSupportFragmentManager();
        adapter=new AccountPageAdapter(fragmentManager,getLifecycle());
        binding.viewPager2.setAdapter(adapter);
        binding.viewPager2.setUserInputEnabled(false);
    }

    private void clickListener() {
        binding.next.setOnClickListener(v -> {
            if (binding.viewPager2.getCurrentItem() < 1)
            {
                binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() + 1);
                binding.stepView.go(1,true);
            }else if (binding.viewPager2.getCurrentItem() < 2)
            {
                binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() + 1);
                binding.stepView.go(2,true);
                binding.done.setVisibility(View.VISIBLE);
                binding.next.setVisibility(View.GONE);
            }
        });

        binding.done.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        });

    }
}
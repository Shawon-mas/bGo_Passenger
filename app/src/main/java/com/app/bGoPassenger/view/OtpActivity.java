package com.app.bGoPassenger.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.app.bGoPassenger.R;
import com.app.bGoPassenger.databinding.ActivityAccountCreatBinding;
import com.app.bGoPassenger.databinding.ActivityOtpBinding;
import com.app.bGoPassenger.view.passengerProfileUi.AccountCreatActivity;

public class OtpActivity extends AppCompatActivity {
    private ActivityOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickListeners();
    }

    private void clickListeners() {
        binding.otpVerifyButton.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), AccountCreatActivity.class));
        });
    }
}
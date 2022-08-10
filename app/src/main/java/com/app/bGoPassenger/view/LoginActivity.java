package com.app.bGoPassenger.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.WindowManager;

import com.app.bGoPassenger.R;
import com.app.bGoPassenger.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickListeners();

    }

    private void clickListeners() {
        binding.loginLoginButton.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),OtpActivity.class));
        });
    }


}
package com.example.demoapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.demoapp.databinding.ActivityMainBinding;
import com.example.demoapp.model.LoginResponse;
import com.example.demoapp.viewmodel.LoginViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonLogin.setOnClickListener(view -> {
            binding.progressBar.setVisibility(View.VISIBLE);
            String userName = binding.edtUserName.getText().toString();
            String password = binding.edtPassWord.getText().toString();
            loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
            loginViewModel.login().observe(this, new Observer<List<LoginResponse>>() {
                @Override
                public void onChanged(List<LoginResponse> list) {
                    if (!list.isEmpty()) {
                        for (LoginResponse item : list) {
                            if (item.getUsername().equals(userName)
                                    && item.getPassword().equals(password)) {
                                Log.d(TAG, "Username: " + item.getUsername() + ", password: "
                                        + item.getPassword());
                                binding.progressBar.setVisibility(View.GONE);
                                Toast.makeText(MainActivity.this,
                                        "Login success.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                            } else {
                                binding.progressBar.setVisibility(View.GONE);
                                Toast.makeText(MainActivity.this, "Login fail !",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            });
        });
    }

}
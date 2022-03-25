package com.example.demoapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.example.demoapp.R;
import com.example.demoapp.databinding.ActivityMain2Binding;
import com.example.demoapp.databinding.ActivityMainBinding;
import com.example.demoapp.model.UserResponse;
import com.example.demoapp.viewmodel.UserViewModel;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;
    private static final String TAG = "MainActivity2";
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);


        binding.buttonGetAll.setOnClickListener(view -> {
            binding.progressBar.setVisibility(View.VISIBLE);
            String[] str = {""};
            userViewModel.getAllUser().observe(this, new Observer<List<UserResponse>>() {
                @Override
                public void onChanged(List<UserResponse> list) {
                    if (!list.isEmpty()) {
                        for (UserResponse item : list) {
                            str[0] += "{ name: " + item.getName() + ", country: " + item.getCountry() +
                                    ", id: " + item.getId() + " }" + "\n";
                        }
                        binding.textViewResult.setText("");
                        binding.textViewResult.setText(str[0]);
                        binding.progressBar.setVisibility(View.GONE);
                        str[0] = "";
                    }
                }
            });
        });

        binding.buttonGetOne.setOnClickListener(view -> {
            binding.progressBar.setVisibility(View.VISIBLE);
            String[] str = {""};
            userViewModel.getOneUser("6").observe(this, new Observer<UserResponse>() {
                @Override
                public void onChanged(UserResponse userResponse) {
                    if (!userResponse.getId().equals("")) {
                        str[0] += "{ name: " + userResponse.getName() + ", country: " +
                                        userResponse.getCountry() +
                                        ", id: " + userResponse.getId() + " }" + "\n";
                        binding.textViewResult.setText("");
                        binding.textViewResult.setText(str[0]);
                        binding.progressBar.setVisibility(View.GONE);
                        str[0] = "";
                    }
                }
            });
        });

        binding.buttonPost.setOnClickListener(view -> {
            binding.progressBar.setVisibility(View.VISIBLE);
            String[] str = {""};
            userViewModel.addOneUser(new UserResponse("user123", "country123"))
                    .observe(this, new Observer<UserResponse>() {
                @Override
                public void onChanged(UserResponse userResponse) {
                    if (!userResponse.getId().equals("")) {
                        str[0] += "{ name: " + userResponse.getName() + ", country: " +
                                userResponse.getCountry() +
                                ", id: " + userResponse.getId() + " }" + "\n";
                        binding.textViewResult.setText("");
                        binding.textViewResult.setText("Add one user success." + "\n" + "User info: " +"\n" + str[0]);
                        binding.progressBar.setVisibility(View.GONE);
                        str[0] = "";
                    }
                }
            });
        });

        binding.buttonPut.setOnClickListener(view -> {
            binding.progressBar.setVisibility(View.VISIBLE);
            String[] str = {""};
            userViewModel.updateOneUser("11", new UserResponse("user123_update", "country123_update"))
                    .observe(this, new Observer<UserResponse>() {
                        @Override
                        public void onChanged(UserResponse userResponse) {
                            if (!userResponse.getId().equals("")) {
                                str[0] += "{ name: " + userResponse.getName() + ", country: " +
                                        userResponse.getCountry() +
                                        ", id: " + userResponse.getId() + " }" + "\n";
                                binding.textViewResult.setText("");
                                binding.textViewResult.setText("Update one user success." + "\n" + "User info: " +"\n" + str[0]);
                                binding.progressBar.setVisibility(View.GONE);
                                str[0] = "";
                            }
                        }
                    });
        });

        binding.buttonDelete.setOnClickListener(view -> {
            binding.progressBar.setVisibility(View.VISIBLE);
            userViewModel.deleteOneUser("12")
                    .observe(this, new Observer<UserResponse>() {
                        @Override
                        public void onChanged(UserResponse userResponse) {
                            if (!userResponse.getId().equals("")) {
                                binding.textViewResult.setText("");
                                binding.textViewResult.setText("Delete one user success." + "\n" + "User ID: " + userResponse.getId());
                                binding.progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
        });
    }
}
package com.example.demoapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demoapp.model.LoginResponse;
import com.example.demoapp.repository.LoginRepository;

import java.util.List;

public class LoginViewModel extends ViewModel {
    private LoginRepository repository = LoginRepository.getInstance();
    private MutableLiveData<List<LoginResponse>> loginResponse;

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public MutableLiveData<List<LoginResponse>> login() {
        loginResponse = repository.login();
        return loginResponse;
    }
}

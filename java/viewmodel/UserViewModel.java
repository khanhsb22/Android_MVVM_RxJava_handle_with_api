package com.example.demoapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demoapp.model.UserResponse;
import com.example.demoapp.repository.UserRepository;

import java.util.List;

public class UserViewModel extends ViewModel {
    private UserRepository repository = UserRepository.getInstance();
    private MutableLiveData<List<UserResponse>> list;
    private MutableLiveData<UserResponse> user;

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public MutableLiveData<List<UserResponse>> getAllUser() {
        list = repository.getAllUser();
        return list;
    }

    public MutableLiveData<UserResponse> getOneUser(String id) {
        user = repository.getOneUser(id);
        return user;
    }

    public MutableLiveData<UserResponse> addOneUser(UserResponse userObject) {
        user = repository.addOneUser(userObject);
        return user;
    }

    public MutableLiveData<UserResponse> updateOneUser(String id, UserResponse userObject) {
        user = repository.updateOneUser(id, userObject);
        return user;
    }

    public MutableLiveData<UserResponse> deleteOneUser(String id) {
        user = repository.deleteOneUser(id);
        return user;
    }
}

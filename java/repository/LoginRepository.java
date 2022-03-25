package com.example.demoapp.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.demoapp.model.LoginResponse;
import com.example.demoapp.service.LoginAPI;
import com.example.demoapp.service.LoginBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginRepository {
    private MutableLiveData<List<LoginResponse>> result = new MutableLiveData<>();
    private static final LoginRepository instance = new LoginRepository();
    private LoginAPI loginAPI;

    public static LoginRepository getInstance() {
        return instance;
    }

    private LoginRepository() {
        loginAPI = LoginBuilder.builder();
    }

    public MutableLiveData<List<LoginResponse>> login() {
        final List<LoginResponse>[] list1 = new List[]{new ArrayList<>()};

        loginAPI.login().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<LoginResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<LoginResponse> list) {
                        result.setValue(list);
                        list1[0] = list;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Login", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        for (LoginResponse item : list1[0]) {
                            Log.d("Login", "Username: " + item.getUsername() +
                                    " Password: " + item.getPassword());
                        }
                    }
                });
        return result;
    }
}

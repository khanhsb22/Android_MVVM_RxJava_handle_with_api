package com.example.demoapp.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.demoapp.model.UserResponse;
import com.example.demoapp.service.UserAPI;
import com.example.demoapp.service.UserBuilder;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {
    private MutableLiveData<List<UserResponse>> result = new MutableLiveData<>();
    private MutableLiveData<UserResponse> user = new MutableLiveData<>();
    private static final UserRepository instance = new UserRepository();
    private UserAPI userAPI;
    private static final String TAG = "UserRepository";

    public static UserRepository getInstance() {
        return instance;
    }

    private UserRepository() {
        userAPI = UserBuilder.builder();
    }

    public MutableLiveData<UserResponse> deleteOneUser(String id) {
        userAPI.deleteOneUser(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserResponse userResponse) {
                        user.setValue(userResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return user;
    }

    public MutableLiveData<UserResponse> updateOneUser(String id, UserResponse userObject) {
        userAPI.updateOneUser(id, userObject).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserResponse userResponse) {
                        user.setValue(userResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return user;
    }

    public MutableLiveData<UserResponse> addOneUser(UserResponse userObject) {
        userAPI.addOneUser(userObject).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserResponse userResponse) {
                        user.setValue(userResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return user;
    }

    public MutableLiveData<UserResponse> getOneUser(String id) {
        userAPI.getOneUser(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserResponse userResponse) {
                        user.setValue(userResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return user;
    }

    public MutableLiveData<List<UserResponse>> getAllUser() {
       userAPI.getAllUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<List<UserResponse>>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(List<UserResponse> userResponses) {
                        result.setValue(userResponses);
                   }

                   @Override
                   public void onError(Throwable e) {
                       Log.e(TAG, e.getMessage());
                   }

                   @Override
                   public void onComplete() {

                   }
               });
       return result;
    }
}

package com.zakharchenko.oksana.gallery.model;

import com.zakharchenko.oksana.gallery.api.LoginAPIService;
import com.zakharchenko.oksana.gallery.api.LoginRequestBody;
import com.zakharchenko.oksana.gallery.api.LoginResponse;

import io.reactivex.Observable;


public class Repository implements StartRepository{

    private LoginAPIService apiService;
    private String email;
    private String password;

    public Repository(LoginAPIService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<Boolean> getResultsFromNetwork() {

        Observable<LoginResponse> loginResponseObservable = apiService.getLoginUser(new LoginRequestBody(email, password));
        return loginResponseObservable.all(x -> !x.getToken().isEmpty()).toObservable();
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}

package com.zakharchenko.oksana.gallery.model;


import com.zakharchenko.oksana.gallery.mvp.StartActivityMVP;

import io.reactivex.Observable;

public class StartModel implements StartActivityMVP.Model {

    private StartRepository repository;

    public StartModel(StartRepository repository) {
        this.repository = repository;
    }


    @Override
    public Observable<Boolean> isUserLogged(String email, String password) {
        repository.setEmail(email);
        repository.setPassword(password);
        return repository.getResultsFromNetwork();
    }
}


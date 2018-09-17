package com.zakharchenko.oksana.gallery.model;


import io.reactivex.Observable;

public interface StartRepository {

    Observable<Boolean> getResultsFromNetwork();

    void setEmail(String email);

    void setPassword(String password);
}

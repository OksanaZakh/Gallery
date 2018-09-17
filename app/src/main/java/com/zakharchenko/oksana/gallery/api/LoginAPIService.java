package com.zakharchenko.oksana.gallery.api;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface LoginAPIService {

    @POST("/login")
    Observable<LoginResponse> getLoginUser(@Body LoginRequestBody loginRequestBody);
}

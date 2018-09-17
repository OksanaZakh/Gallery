package com.zakharchenko.oksana.gallery.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zakharchenko.oksana.gallery.App;
import com.zakharchenko.oksana.gallery.R;
import com.zakharchenko.oksana.gallery.mvp.StartActivityMVP;
import com.zakharchenko.oksana.gallery.utils.Constants;

import javax.inject.Inject;

public class StartActivity extends AppCompatActivity implements StartActivityMVP.View{

    @Inject
    StartActivityMVP.Presenter presenter;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start); preferences = getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        preferences.edit().putString(Constants.APP_PREFERENCES_EMAIL, "zaharchenkoop@gmail.com").apply();
        preferences.edit().putString(Constants.APP_PREFERENCES_IS_PASSWORD, "12345").apply();
        ((App) getApplication()).getComponent().inject(this);
    }

    @Override
    public void startLogin() {
        Intent startLogin = new Intent(this, LoginActivity.class);
        finish();
        startActivity(startLogin);
    }

    @Override
    public void goToGallery() {
        Intent startGallery = new Intent(this, GalleryActivity.class);
        finish();
        startActivity(startGallery);
    }


    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.checkIfUserLogged();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxUnsubscribe();
    }

    @Override
    public String getUserEmail() {
        return preferences.getString(Constants.APP_PREFERENCES_EMAIL, "");
    }

    @Override
    public String getUserPassword() {
        return preferences.getString(Constants.APP_PREFERENCES_IS_PASSWORD, "");
    }
}
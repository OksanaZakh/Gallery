package com.zakharchenko.oksana.gallery;

import android.app.Application;

import com.zakharchenko.oksana.gallery.dagger.components.ApplicationComponent;
import com.zakharchenko.oksana.gallery.dagger.components.DaggerApplicationComponent;
import com.zakharchenko.oksana.gallery.dagger.modules.APIModule;
import com.zakharchenko.oksana.gallery.dagger.modules.ApplicationModule;
import com.zakharchenko.oksana.gallery.dagger.modules.StartModule;


public class App extends Application {

    private static App instance;
    private ApplicationComponent component;

    public static App getInstance() {
        return instance;
    }

    public static void setInstance(App instance) {
        App.instance = instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .aPIModule(new APIModule())
                .startModule(new StartModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }

}

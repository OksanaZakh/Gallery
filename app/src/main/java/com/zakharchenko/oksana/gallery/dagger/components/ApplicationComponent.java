package com.zakharchenko.oksana.gallery.dagger.components;


import com.zakharchenko.oksana.gallery.activities.StartActivity;
import com.zakharchenko.oksana.gallery.dagger.modules.APIModule;
import com.zakharchenko.oksana.gallery.dagger.modules.ApplicationModule;
import com.zakharchenko.oksana.gallery.dagger.modules.StartModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, StartModule.class, APIModule.class})
public interface ApplicationComponent {

    void inject(StartActivity target);

}


package com.zakharchenko.oksana.gallery.dagger.components;

import com.zakharchenko.oksana.gallery.activities.LoginActivity;
import com.zakharchenko.oksana.gallery.dagger.modules.APIModule;
import com.zakharchenko.oksana.gallery.dagger.modules.StartModule;

import dagger.Subcomponent;

    @Subcomponent(modules ={StartModule.class, APIModule.class})
    public interface LoginComponent {

        void inject(LoginActivity activity);
}

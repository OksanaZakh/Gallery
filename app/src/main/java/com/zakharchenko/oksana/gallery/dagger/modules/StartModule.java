package com.zakharchenko.oksana.gallery.dagger.modules;

import com.zakharchenko.oksana.gallery.api.LoginAPIService;;
import com.zakharchenko.oksana.gallery.model.Repository;
import com.zakharchenko.oksana.gallery.model.StartModel;
import com.zakharchenko.oksana.gallery.model.StartRepository;
import com.zakharchenko.oksana.gallery.mvp.StartActivityMVP;
import com.zakharchenko.oksana.gallery.presenter.StartPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StartModule {

    @Provides
    public StartActivityMVP.Presenter provideStartPresenter(StartActivityMVP.Model startModel) {
        return new StartPresenter(startModel);
    }

    @Provides
    public StartActivityMVP.Model provideStartModel(StartRepository startRepository) {
        return new StartModel(startRepository);
    }

    @Singleton
    @Provides
    public StartRepository provideRepo(LoginAPIService loginAPIService) {
        return new Repository(loginAPIService);
    }
}
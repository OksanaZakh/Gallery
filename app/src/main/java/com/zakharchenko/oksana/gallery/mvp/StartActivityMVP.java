package com.zakharchenko.oksana.gallery.mvp;

import io.reactivex.Observable;

public interface StartActivityMVP {
    interface View{
        void startLogin();
        void goToGallery();
        String getUserEmail();
        String getUserPassword();
    }

    interface Presenter{
        void checkIfUserLogged();
        void setView(StartActivityMVP.View view);
        void rxUnsubscribe();
    }

    interface Model{
        Observable<Boolean> isUserLogged(String email, String password);
    }
}

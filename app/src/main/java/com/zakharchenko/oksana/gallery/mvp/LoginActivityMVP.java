package com.zakharchenko.oksana.gallery.mvp;

public interface LoginActivityMVP {

    interface View{
        void showErrorMessage();
        void showLoginMessage();
        void makeAddFieldsVisible();
        String getUserName();
        String getEmail();
        String getPassword();
        String getAvatar();
    }

    interface Presenter{
        void setView(LoginActivityMVP.View view);
        void  loggingButtonClicked();
        void getCurrentUser();
        void saveUser();
    }

    interface Model{

    }
}

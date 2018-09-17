package com.zakharchenko.oksana.gallery.presenter;

import com.zakharchenko.oksana.gallery.mvp.StartActivityMVP;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class StartPresenter implements StartActivityMVP.Presenter {

    private StartActivityMVP.View view;
    private Disposable subscription = null;
    private StartActivityMVP.Model model;


    public StartPresenter(StartActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void checkIfUserLogged() {
        if(view.getUserEmail().trim().isEmpty() || view.getUserPassword().trim().isEmpty()){
            view.startLogin();
        }else {
            subscription = model.isUserLogged(view.getUserEmail(), view.getUserPassword())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<Boolean>() {
                        @Override
                        public void onComplete() {
                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            view.startLogin();
                        }

                        @Override
                        public void onNext(Boolean b) {
                            if (view != null) {
                                if (b) {
                                    view.goToGallery();
                                } else {
                                    view.startLogin();
                                }
                            }
                        }
                    });
        }
    }
    @Override
    public void rxUnsubscribe() {
        if (subscription != null) {
            if (!subscription.isDisposed()) {
                subscription.dispose();
            }
        }
    }

    @Override
    public void setView(StartActivityMVP.View view) {
        this.view = view;
    }

}

package com.nivedita.weatherutility.presenter;

import android.view.View;

import com.nivedita.weatherutility.view.MVPView;

/**
 * Created by PUNEETU on 18-04-2018.
 */

public interface Presenter<V extends MVPView>  {

    void attachView(V mvpView);

    void detachView();

}

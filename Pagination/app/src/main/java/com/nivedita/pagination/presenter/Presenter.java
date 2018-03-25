package com.nivedita.pagination.presenter;

import com.nivedita.pagination.view.MVPView;

/**
 * Created by PUNEETU on 18-03-2018.
 */

public interface Presenter<V extends MVPView> {

    void attachView(V mvpView);

    void detachView();
}

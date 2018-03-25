package com.nivedita.pagination.presenter;

import com.nivedita.pagination.view.AdapterView;

/**
 * Created by PUNEETU on 18-03-2018.
 */

public class AdapterPresenter<T extends AdapterView>  {

    private T mAdapterView;

    public T getAdapterView() {
        return mAdapterView;
    }
}

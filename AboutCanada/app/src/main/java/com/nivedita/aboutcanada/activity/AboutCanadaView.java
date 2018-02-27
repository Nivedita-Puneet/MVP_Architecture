package com.nivedita.aboutcanada.activity;

import com.nivedita.aboutcanada.model.News;

/**
 * Created by NEETU on 28-02-2018.
 */

/*Contract which defines View layer.*/
public interface AboutCanadaView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getNewsListSuccess(News news);

}
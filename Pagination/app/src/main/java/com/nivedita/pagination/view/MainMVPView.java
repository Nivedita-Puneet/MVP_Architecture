package com.nivedita.pagination.view;

import com.nivedita.pagination.model.News;
import com.nivedita.pagination.model.Row;
import com.nivedita.pagination.util.LogNetworkError;

import java.util.List;

/**
 * Created by NEETU on 18-03-2018.
 */

public interface MainMVPView extends MVPView {

    void showLoading();

    void removeLoading();

    void showCurrentAffairs(News news);

    void noCurrentAffairs();

    void showError(LogNetworkError logNetworkError);

    // void addLoadingFooter();

    // void removeLoadingFooter();

    //Row getItem(int position);
    //void add(Row r);

}

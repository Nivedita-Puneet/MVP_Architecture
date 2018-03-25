package com.nivedita.pagination.view;

import com.nivedita.pagination.model.Row;

import java.util.List;

/**
 * Created by PUNEETU on 18-03-2018.
 */

public interface AdapterView extends MVPView {

    void add(Row row);

    void addAll(List<Row> rows);

    void remove(Row r);

    void clear();

    boolean isEmpty();

    void addLoadingFooter();

    void removeLoadingFooter();

    Row getItem(int position);
}

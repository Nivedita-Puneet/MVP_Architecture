package com.nivedita.pagination;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by PUNEETU on 19-03-2018.
 */

public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {

    private LinearLayoutManager linearLayoutManager;

    private int visibleThreshold = 5;
    private int currentPage;

    private boolean loading = true;
    private int previousTotalItemCount = 0;
    private int startingPageIndex = 1;


    /**
     * Supporting only LinearLayoutManager for now.
     *
     * @param linearLayoutManager
     */
    public PaginationScrollListener(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

        super.onScrolled(recyclerView, dx, dy);

        int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        int totalItemCount = linearLayoutManager.getItemCount();

        if (totalItemCount < previousTotalItemCount) {

            PaginationScrollListener.this.currentPage = this.startingPageIndex;
            this.previousTotalItemCount = totalItemCount;
            if (totalItemCount == 0) {
                this.loading = true;
            }
        }

        if (loading && (lastVisibleItemPosition + visibleThreshold) > totalItemCount) {

            currentPage++;
            onLoadMore(currentPage, totalItemCount, recyclerView);
            loading = true;
        }
    }

    abstract public void onLoadMore(int currentPage, int totalItemCount, View view);

}

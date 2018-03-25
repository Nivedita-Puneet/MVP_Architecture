package com.nivedita.pagination.di.module;

import android.app.Activity;
import android.content.Context;

import com.nivedita.pagination.CurrentAffairsAdapter;
import com.nivedita.pagination.di.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PUNEETU on 16-03-2018.
 */

@Module
public class ActivityModule {

    private Activity mActivity;
    private boolean isLastPage;

    public ActivityModule(Activity activity, boolean isLastPage) {

        this.mActivity = activity;
        this.isLastPage = isLastPage;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    CurrentAffairsAdapter provideMoviesAdapter() {
        return new CurrentAffairsAdapter(mActivity);
    }

    @Provides
    boolean isLastPage() {
        return isLastPage;
    }
}

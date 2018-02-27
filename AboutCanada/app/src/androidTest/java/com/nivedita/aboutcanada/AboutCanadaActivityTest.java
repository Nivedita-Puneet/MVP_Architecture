package com.nivedita.aboutcanada;

import android.app.Activity;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.test.InstrumentationTestCase;


import com.nivedita.aboutcanada.activity.AboutCanadaActivity;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertTrue;


/**
 * Created by Neetu on 28/02/2018.
 */

@RunWith(AndroidJUnit4.class)
public class AboutCanadaActivityTest {

    @Rule
    public ActivityTestRule<AboutCanadaActivity> mActivityTestRule =
            new ActivityTestRule<>(AboutCanadaActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLoadRecyclerView() throws Exception {

        Intent intent = new Intent();
        mActivityTestRule.launchActivity(intent);

        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.news_recyclerview);
        int itemCount = recyclerView.getAdapter().getItemCount();

        Espresso.onView(withId(R.id.news_recyclerview))
                .perform(RecyclerViewActions.scrollToPosition(itemCount - 1));

    }

    @Test
    public void testEmptyRecyclerView() throws Exception{

        Intent intent = new Intent();
        mActivityTestRule.launchActivity(intent);

        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.news_recyclerview);
        int itemCount = recyclerView.getAdapter().getItemCount();

        if(itemCount < 0){
            //Assert with the help of view matchers to check visibility.
        }

    }

}

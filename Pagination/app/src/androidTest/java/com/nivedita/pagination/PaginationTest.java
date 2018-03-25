package com.nivedita.pagination;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 * Created by PUNEETU on 22-03-2018.
 */


@RunWith(AndroidJUnit4.class)
public class PaginationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLoadRecyclerView() throws Exception {

        Intent intent = new Intent();
        mActivityTestRule.launchActivity(intent);

        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.main_recycler);
        int itemCount = recyclerView.getAdapter().getItemCount();

        Espresso.onView(withId(R.id.main_recycler))
                .perform(RecyclerViewActions.scrollToPosition(itemCount - 1));

    }

    @Test
    public void testEmptyRecyclerView() {
        Intent intent = new Intent();
        mActivityTestRule.launchActivity(intent);

        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.main_recycler);
        int itemCount = recyclerView.getAdapter().getItemCount();

        if (itemCount < 0) {
            //Assert with the help of view matchers to check visibility.

            Espresso.onView(withId(R.id.main_recycler)).check(ViewAssertions.matches(not(isDisplayed())));
            Espresso.onView(withId(R.id.empty_view)).check(ViewAssertions.matches(isDisplayed()));
        }
    }

}

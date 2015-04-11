package com.shaunchurch.androidpickings.ui.dashboard;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.shaunchurch.androidpickings.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;


/**
 * Created by shaun on 11/04/15.
 */
public class DashboardActivityTest extends ActivityInstrumentationTestCase2<DashboardActivity> {


    public DashboardActivityTest() {
        super(DashboardActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
        Log.d("TEST", "TEST");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        Log.d("END", "EMD");
    }

    public void testThisLaunches() {
        assertTrue(true);
    }

    public void testHelloWorld() {
        onView(withId(R.id.textHelloWorld)).check(matches(withText("Hello world!")));
    }

}
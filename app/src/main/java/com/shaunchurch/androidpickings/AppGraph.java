package com.shaunchurch.androidpickings;

import com.shaunchurch.androidpickings.ui.AppContainer;
import com.squareup.picasso.Picasso;

/**
 * A common interface (which can be) implemented by both the Release and Debug flavored components.
 */
public interface AppGraph {
    void inject(App app);
//    AppContainer appContainer();
//    Picasso picasso();
}
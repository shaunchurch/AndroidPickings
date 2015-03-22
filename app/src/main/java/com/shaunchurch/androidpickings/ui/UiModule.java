package com.shaunchurch.androidpickings.ui;

import com.shaunchurch.androidpickings.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class UiModule {

    @Provides
    @ApplicationScope
    AppContainer provideAppContainer() {
        return AppContainer.DEFAULT;
    }

}

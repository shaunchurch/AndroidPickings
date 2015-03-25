package com.shaunchurch.androidpickings.ui.trees;

import com.shaunchurch.androidpickings.AppComponent;

import dagger.Component;

@TreesScope
@Component(
        dependencies = AppComponent.class,
        modules = TreesModule.class
)
public interface TreesComponent {
    void inject(TreesActivity activity);
}

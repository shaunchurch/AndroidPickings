package com.shaunchurch.androidpickings.ui.trees;

import dagger.Module;
import dagger.Provides;

@TreesScope
@Module
public class TreesModule {

    @Provides
    TreeSupplier treeSupplier(TreeSupplierImpl impl) { return impl; }

    @Provides
    TreeItemPresenter treeItemPresenter(TreeItemPresenterImpl impl) { return impl; }

}

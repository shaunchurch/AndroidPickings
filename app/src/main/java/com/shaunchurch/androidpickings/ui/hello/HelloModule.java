package com.shaunchurch.androidpickings.ui.hello;

import dagger.Module;
import dagger.Provides;

@HelloScope
@Module
public class HelloModule {

    public final HelloView view;

    public HelloModule(HelloView view) {
        this.view = view;
    }

    @Provides
    HelloView helloView() {
        return this.view;
    }

    @Provides
    MessageSupplier messageSupplier(MessageSupplierImpl impl) {
        return impl;
    }

    @Provides
    HelloPresenter helloPresenter(HelloPresenterImpl impl) {
        return impl;
    }

}

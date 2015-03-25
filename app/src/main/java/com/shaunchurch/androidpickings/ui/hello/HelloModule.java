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
    HelloSupplier messageSupplier(HelloSupplierImpl impl) {
        return impl;
    }

    @Provides
    HelloPresenter helloPresenter(HelloPresenterImpl impl) {
        return impl;
    }

    @Provides
    HelloTimeService helloTimeService(HelloTimeServiceImpl impl) { return impl; }

}

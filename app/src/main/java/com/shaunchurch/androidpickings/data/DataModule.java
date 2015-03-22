package com.shaunchurch.androidpickings.data;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;

import com.shaunchurch.androidpickings.ApplicationScope;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

import static android.content.Context.MODE_PRIVATE;

@Module()
public final class DataModule {

    static final int DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB

    @Provides
    @ApplicationScope
    OkHttpClient provideOkHttpClient(Application app) {
        return createOkHttpClient(app);
    }

    @Provides
    @ApplicationScope
    Picasso providePicasso(Application app, OkHttpClient client) {
        return new Picasso.Builder(app)
                .downloader(new OkHttpDownloader(client))
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        Timber.e(exception, "Failed to load image: %s", uri);
                    }
                })
                .build();
    }

    @Provides
    @ApplicationScope
    SharedPreferences provideSharedPreferences(Application app) {
        return app.getSharedPreferences("android_pickings", MODE_PRIVATE);
    }

    /**
     * Set up okhttp client with cache directory
     * @param app
     * @return
     */
    static OkHttpClient createOkHttpClient(Application app) {
        OkHttpClient client = new OkHttpClient();

        // set up cache
        File cacheDir = new File(app.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        client.setCache(cache);

        return client;
    }

}

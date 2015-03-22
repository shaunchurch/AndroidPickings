package com.shaunchurch.androidpickings.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.shaunchurch.androidpickings.data.entities.Image;
import com.shaunchurch.androidpickings.ui.base.HasComponent;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class WebImageView extends ImageView {

    @Inject
    Picasso picasso;

    public WebImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.picasso = picasso;
//        ((HasComponent<Injector>) context).getComponent().inject(this);

    }

    public void bindTo(Image image) {
        picasso.load(image.link).into(this);
    }

    public static interface Injector {
        void inject(WebImageView view);
    }
}

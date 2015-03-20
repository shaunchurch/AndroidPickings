/*
 * Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shaunchurch.androidpickings.ui;

import android.graphics.Bitmap;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ImageView;

import com.shaunchurch.androidpickings.DemoApplication;
import com.shaunchurch.androidpickings.DemoBaseActivity;
import com.shaunchurch.androidpickings.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import timber.log.Timber;

public class HomeActivity extends DemoBaseActivity {

  @Inject LocationManager locationManager;
  @Inject Picasso picasso;
  @Inject DemoApplication app;

  @InjectView(R.id.imageViewPrimary) ImageView mImageView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // set the layout
    setContentView(R.layout.activity_main);

    // inject views
    ButterKnife.inject(this);

    loadImage();
  }

  private void loadImage() {
    picasso.with(this).load("http://cypressnorth.com/wp-content/uploads/2013/07/Best-Android-Apps-List-of-50-Free-Android-Apps.png").into(mImageView);
    Timber.e("We should have an image");
  }
}

package com.shaunchurch.androidpickings.ui.hello;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import com.shaunchurch.androidpickings.AppComponent;
import com.shaunchurch.androidpickings.R;
import com.shaunchurch.androidpickings.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by shaun on 22/03/15.
 */
public class HelloActivity extends BaseActivity
        implements HelloView {

    // component
    private HelloComponent helloComponent;

    // dependencies
    @Inject HelloPresenter presenter;

    // views
    @InjectView(R.id.textMessage) TextView textMessage;

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        helloComponent = Dagger_HelloComponent.builder()
                .appComponent(appComponent)
                .helloModule(new HelloModule(this))
                .build();
        helloComponent.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        ButterKnife.inject(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        // do whatever is needed to get a message
        presenter.requestMessage();
    }

    /**
     * HelloView interface implementation
     * @param message
     */
    @Override
    public void onMessageUpdated(String message) {
        textMessage.setText(message);
    }
}

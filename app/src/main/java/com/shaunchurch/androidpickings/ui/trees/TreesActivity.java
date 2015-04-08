package com.shaunchurch.androidpickings.ui.trees;

import android.os.Bundle;
import android.widget.ListView;

import com.shaunchurch.androidpickings.AppComponent;
import com.shaunchurch.androidpickings.R;
import com.shaunchurch.androidpickings.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TreesActivity extends BaseActivity {

    private TreesComponent treesComponent;

    @Inject TreeAdapter treeAdapter;
    @Inject TreeSupplier treeSupplier;

    @InjectView(R.id.listTrees) ListView listView;

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        treesComponent = DaggerTreesComponent.builder()
                .appComponent(appComponent)
                .treesModule(new TreesModule())
                .build();
        treesComponent.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trees);
        ButterKnife.inject(this);
        setAdapter();
    }

    public void setAdapter() {
        listView.setAdapter(treeAdapter);
    }
}

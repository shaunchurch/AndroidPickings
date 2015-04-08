package com.shaunchurch.androidpickings.ui.trees;


import android.view.View;
import android.widget.TextView;

import com.shaunchurch.androidpickings.R;
import com.shaunchurch.androidpickings.data.entities.Tree;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TreeItemPresenterImpl implements TreeItemPresenter {

    private Tree tree;

    @Inject
    public TreeItemPresenterImpl() {
    }

    @Override
    public void setItem(Tree tree) {
        this.tree = tree;
    }

    @Override
    public int provideLayoutRes() {
        return R.layout.list_item_tree;
    }

    /**
     *
     * @param view
     *            View that has been inflated
     * @param position
     */
    @Override
    public void display(View view, int position) {
        TextView textView = (TextView) view.findViewById(R.id.textTree);
        textView.setText(tree.name);
    }

    /**
     * Generates list of TreeAdapterPresenter objects for the given list of tree
     * objects
     *
     * @param trees
     * @return
     */
    @Override
    public List<TreeItemPresenter> generateTreePresenters(List<Tree> trees) {

        List<TreeItemPresenter> treePresenters = new ArrayList<TreeItemPresenter>();

        for (int i = 0; i < trees.size(); i++) {
            TreeItemPresenterImpl imple = new TreeItemPresenterImpl();
            imple.setItem(tree);
            treePresenters.add(imple);
        }

        return treePresenters;
    }
}

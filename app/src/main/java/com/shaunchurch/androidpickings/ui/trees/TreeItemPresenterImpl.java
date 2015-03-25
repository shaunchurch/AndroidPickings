package com.shaunchurch.androidpickings.ui.trees;


import android.view.View;
import android.widget.TextView;

import com.shaunchurch.androidpickings.R;
import com.shaunchurch.androidpickings.data.entities.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeItemPresenterImpl implements TreeItemPresenter {

    private Tree tree;

    public TreeItemPresenterImpl(Tree tree) {
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
    public static List<TreeItemPresenter> generateTreePresenters(List<Tree> trees) {

        List<TreeItemPresenter> treePresenters = new ArrayList<TreeItemPresenter>();

        for (int i = 0; i < trees.size(); i++) {
            treePresenters.add(new TreeItemPresenterImpl(trees.get(i)));
        }

        return treePresenters;
    }
}

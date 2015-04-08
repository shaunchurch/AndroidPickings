package com.shaunchurch.androidpickings.ui.trees;

import android.view.View;

import com.shaunchurch.androidpickings.data.entities.Tree;

import java.util.List;

public interface TreeItemPresenter {

    /**
     * Returns the resource id of the layout that represents the class that
     * implements this interface
     *
     * @return
     */
    int provideLayoutRes();

    /**
     * This method is called after a View has been inflated and is simply used
     * to display the wanted info for that inflated View
     *
     * @param view
     *            View that has been inflated
     * @param position
     *            Position of the element we are displaying
     */
    void display(View view, int position);

    void setItem(Tree tree);

    List<TreeItemPresenter> generateTreePresenters(List<Tree> trees);

}

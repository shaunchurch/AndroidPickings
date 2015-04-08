package com.shaunchurch.androidpickings.ui.trees;

import com.shaunchurch.androidpickings.data.entities.Tree;

import java.util.List;

public interface TreeSupplier {
    List<Tree> getTrees();
    Tree getTree(int position);
}

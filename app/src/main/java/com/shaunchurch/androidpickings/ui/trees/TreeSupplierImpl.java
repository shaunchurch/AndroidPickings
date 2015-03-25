package com.shaunchurch.androidpickings.ui.trees;

import com.shaunchurch.androidpickings.data.entities.Tree;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TreeSupplierImpl implements TreeSupplier {

    List<Tree> mTrees;

    @Inject
    public TreeSupplierImpl() {
        mTrees = new ArrayList<>();
        mTrees.add(new Tree("Spruce"));
        mTrees.add(new Tree("Oak"));
        mTrees.add(new Tree("Silver Birch"));
        mTrees.add(new Tree("Great Redwood"));
        mTrees.add(new Tree("Willow"));
    }

    @Override
    public List<Tree> getTrees() {
        return mTrees;
    }

    public Tree getTree(int position) {
        return mTrees.get(position);
    }
}

package com.shaunchurch.androidpickings.ui.trees;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TreeAdapter extends BaseAdapter {

    private List<TreeItemPresenter> trees;
    private Context context;
    private TreeSupplier treeSupplier;
    private TreeItemPresenter treeItemPresenter;

    /**
     * @param context
     * @param treeSupplier
     */
    @Inject
    public TreeAdapter(Application context, TreeSupplier treeSupplier, TreeItemPresenter treeItemPresenter) {
        this.context = context;
        this.treeSupplier = treeSupplier;
        this.treeItemPresenter = treeItemPresenter;
        this.trees = new ArrayList<>();
        update();
    }

    public void update() {
        trees = treeItemPresenter.generateTreePresenters(treeSupplier.getTrees());
    }

    @Override
    public int getCount() {
        return trees.size();
    }

    @Override
    public TreeItemPresenter getItem(int position) {
        return trees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TreeItemPresenter item = trees.get(position);
        convertView = inflateView(item.provideLayoutRes());
        item.display(convertView, position);
        return convertView;
    }

    /**
     * This method takes Id of the layout which we want to inflate, instantiates
     * LayoutInflater and inflates the View
     *
     * @param layoutId
     *            Id of the layout which is being inflated
     * @return View inflated
     */
    private View inflateView(int layoutId) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(layoutId, null, false);
    }
}

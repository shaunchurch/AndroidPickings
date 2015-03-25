package com.shaunchurch.androidpickings.ui.trees;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.shaunchurch.androidpickings.data.entities.Tree;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TreeAdapter extends BaseAdapter {

    private List<TreeItemPresenterImpl> trees;
    private Context context;
    private TreeSupplier treeSupplier;

    /**
     * @param context
     * @param treeSupplier
     */
    @Inject
    public TreeAdapter(Application context, TreeSupplier treeSupplier) {
        this.context = context;
        this.treeSupplier = treeSupplier;
        this.trees = new ArrayList<>();
        update();
    }

    public void update() {
        for (int i = 0; i < treeSupplier.getTrees().size(); i++) {
            // TODO: This calls the implementation directly. Not correct.
            trees.add(new TreeItemPresenterImpl(treeSupplier.getTree(i)));
        }
    }

    @Override
    public int getCount() {
        return trees.size();
    }

    @Override
    public TreeItemPresenterImpl getItem(int position) {
        return trees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TreeItemPresenterImpl item = trees.get(position);
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

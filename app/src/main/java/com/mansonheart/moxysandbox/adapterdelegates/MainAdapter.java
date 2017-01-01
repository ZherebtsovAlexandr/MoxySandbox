package com.mansonheart.moxysandbox.adapterdelegates;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;
import com.mansonheart.User;

import java.util.List;

/**
 * Created by Admin on 01.01.2017.
 */
public class MainAdapter extends RecyclerView.Adapter {

    private AdapterDelegatesManager<List<User>> delegatesManager;
    private List<User> items;

    public MainAdapter(Activity activity, List<User> items) {
        this.items = items;
        delegatesManager = new AdapterDelegatesManager<>();
        delegatesManager.addDelegate(new UserAdapterDelegate(activity));
    }

    @Override
    public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(items, position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(items, position, holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems(List<User> items) {
        this.items.addAll(items);
        this.notifyDataSetChanged();
    }
}

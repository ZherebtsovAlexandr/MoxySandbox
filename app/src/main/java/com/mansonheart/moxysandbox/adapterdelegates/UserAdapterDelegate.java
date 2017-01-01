package com.mansonheart.moxysandbox.adapterdelegates;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.mansonheart.User;
import com.mansonheart.moxysandbox.R;

import java.util.List;

/**
 * Created by Admin on 01.01.2017.
 */
public class UserAdapterDelegate extends AdapterDelegate<List<User>> {

    private LayoutInflater inflater;

    public UserAdapterDelegate(Activity activity) {
        this.inflater = activity.getLayoutInflater();
    }

    @Override
    protected boolean isForViewType(List<User> items, int position) {
        return items.get(position) instanceof User;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new UserViewHolder(inflater.inflate(R.layout.item_user, parent, false));

    }

    @Override
    protected void onBindViewHolder(@NonNull List<User> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        UserViewHolder vh = (UserViewHolder) holder;
        User user = (User) items.get(position);

        vh.name.setText(user.getName());

    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        public TextView name;

        public UserViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

}

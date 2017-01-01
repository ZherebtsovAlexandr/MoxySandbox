package com.mansonheart.moxysandbox;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


/**
 * Created by Zherebtsov Alexandr on 06.02.2016.
 */
public final class ScrollObservable {

    private static RecyclerView recyclerView;
    private static int limit;

    public static Observable<Integer> from(final RecyclerView rv) {

        recyclerView = rv;

        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(final ObservableEmitter<Integer> emitter) throws Exception {
                //subscriber.onNext(0);
                final RecyclerView.OnScrollListener sl = new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        if (!emitter.isDisposed()) {
                            final int position = getLastVisibleItemPosition();
                            final int limit = getLimit();
                            final int itemCount = rv.getAdapter().getItemCount();
                            final int updatePosition = itemCount - 1 - (limit / 2);
                            if (position >= updatePosition) {
                                emitter.onNext(itemCount);
                            }
                        }
                    }
                };
                rv.addOnScrollListener(sl);
          /*      subscriber.add(Subscriptions.create(new Action0() {
                    @Override
                    public void call() {
                        rv.removeOnScrollListener(sl);
                    }
                }));*/
            }
        });
    }

    private static int getLimit() {
        return limit;
    }

    public static void setLimit(int limit1) {
        limit = limit1;
    }

    private static int getLastVisibleItemPosition() {
        Class recyclerViewLMClass = recyclerView.getLayoutManager().getClass();
        if (recyclerViewLMClass == LinearLayoutManager.class) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            return linearLayoutManager.findLastVisibleItemPosition();
        } else if (recyclerViewLMClass == GridLayoutManager.class) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            return gridLayoutManager.findLastVisibleItemPosition();
        } else if (recyclerViewLMClass == StaggeredGridLayoutManager.class || StaggeredGridLayoutManager.class.isAssignableFrom(recyclerViewLMClass)) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
            int[] into = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
            List<Integer> intoList = new ArrayList<>();
            for (int i : into) {
                intoList.add(i);
            }
            return Collections.max(intoList);
        }
        throw new RuntimeException("Unknown LayoutManager class: " + recyclerViewLMClass.toString());
    }

    public static void onDestroy() {
        recyclerView = null;
    }
}


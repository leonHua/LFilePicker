package com.leon.lfilepickerlibrary.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：Leon
 * 时间：2017/3/17 13:44
 */
public class EmptyRecyclerView extends RecyclerView {
    private View mEmptyView;

    public EmptyRecyclerView(Context context) {
        super(context);
    }

    public EmptyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 根据数据源判断是否显示空白view
     */
    private void checkIfEmpty() {
        if (mEmptyView != null || getAdapter() != null) {
            mEmptyView.setVisibility(getAdapter().getItemCount() > 0 ? GONE : VISIBLE);
        }
    }

    public void setmEmptyView(View mEmptyView) {
        this.mEmptyView = mEmptyView;
        checkIfEmpty();
    }

    @Override
    public void setAdapter(Adapter adapter) {
        Adapter adapterOld = getAdapter();
        if (adapterOld != null) {
            adapterOld.unregisterAdapterDataObserver(observer);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(observer);
        }
    }

    AdapterDataObserver observer = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            checkIfEmpty();
        }
    };
}

package com.lj.coordinatorlayout.loadmorerv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lj.paging.PagingAdapter;
import com.lj.paging.footer.ProgressAndTextFooterView;

/**
 * @author liujian
 * @date 2023/3/9
 */
public class LoadMoreSimpleAdapter extends PagingAdapter {
    private int count = 20;
    private boolean isLoadFinish;

    @Override
    public int getItemViewType(int position) {
        if (position < getMyItemCount() - 1) {
            if (position % 2 == 0) {
                return 1;
            } else {
                return 2;
            }
        }
        return super.getItemViewType(position);
    }

    @Override
    protected void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
        contentViewHolder.tv.setText(String.valueOf(position));
    }

    /**
     * footer绑定，可以替换footer中的显示的文字，比如“正在加载...”、“全部数据加载完毕”。
     *
     * @param holder
     * @param position
     */
    @Override
    protected void onBindMyFooterViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProgressAndTextFooterView progressAndTextFooterView = (ProgressAndTextFooterView) holder.itemView;
        if (isLoadFinish) {
            progressAndTextFooterView.setLoadFinish();
        } else {
            progressAndTextFooterView.setLoading();
        }
    }

    /**
     * 绑定开发者提供的数据
     *
     * @param parent
     * @return
     */
    @Override
    protected RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        if (viewType == 1) {
            itemView.getLayoutParams().height += 150;
        }
        return new ContentViewHolder(itemView);
    }


    /**
     * 开发者需要提供 footer显示view，框架中有一些简单内置样式。不过满足不了，开发者可以自己定义。
     *
     * @param parent
     * @return
     */
    @Override
    protected RecyclerView.ViewHolder onCreateFootViewHolder(ViewGroup parent, int viewType) {
        View footerView = ProgressAndTextFooterView.createViewWithParams(parent);
        return new FooterViewHolder(footerView);
    }

    @Override
    protected int getMyItemCount() {
        return count;
    }

    public void newData() {
        count += 10;
        notifyDataSetChanged();
    }

    private class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class ContentViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    /**
     * 全部数据加载完成。此时需要将 footer中的文案改为 “数据全部加载完成”等字样
     */
    @Override
    public void onLoadFinish() {
        isLoadFinish = true;
        notifyItemChanged(getMyItemCount());
    }
}

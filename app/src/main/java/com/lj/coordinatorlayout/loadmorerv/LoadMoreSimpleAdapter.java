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

    @Override
    protected void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == CONTENT_ID) {
            ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
            contentViewHolder.tv.setText(String.valueOf(position));
        }
    }

    @Override
    protected void onBindMyFooterViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    protected RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        itemView.getLayoutParams().height += Math.random() * 100;
        return new ContentViewHolder(itemView);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateFootViewHolder(ViewGroup parent) {
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

    @Override
    public void onLoadFinish() {

    }
}

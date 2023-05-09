//package com.lj.coordinatorlayout.loadmorerv;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.util.AttributeSet;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.lj.page.LoadMoreAdapter;
//
///**
// * @author liujian
// * @date 2023/3/6
// */
//public class XRecyclerView extends FrameLayout {
//    private RecyclerView mRv;
//    private LinearLayout mLoadMoreLayout;
//
//    public XRecyclerView(Context context) {
//        this(context, null);
//    }
//
//    public XRecyclerView(Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public XRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        installView();
//        findView();
//        initView();
//    }
//
//    private void initView() {
//        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
//        mRv.setAdapter(new LoadMoreAdapter() {
//            @Override
//            public View getLoadMoreView() {
//                return LayoutInflater.from(getContext()).inflate(R.layout.load_more_footer, mRv, false);
//            }
//
//            @NonNull
//            @Override
//            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                TextView tv = new TextView(getContext());
//                tv.setTextSize(40);
//                tv.setGravity(Gravity.CENTER);
//                tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
//                tv.setBackgroundColor(Color.parseColor(ColorUtil.getRanDomColor()));
//                tv.setText((int) (Math.random() * 10) + "");
//                return new RecyclerView.ViewHolder(tv) {
//
//                };
//            }
//
//            @Override
//            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//            }
//
//            @Override
//            public int getItemCount() {
//                return 30;
//            }
//        });
////        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
////            @Override
////            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
////                super.onScrollStateChanged(recyclerView, newState);
////            }
////
////            @Override
////            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
////                super.onScrolled(recyclerView, dx, dy);
//////                if (!mRv.canScrollVertically(1)) {
//////                    mLoadMoreLayout.setVisibility(VISIBLE);
//////                } else {
//////                    mLoadMoreLayout.setVisibility(GONE);
//////                }
////            }
////        });
//        mRv.addItemDecoration(new LoadMoreDecoration());
////        mRv.addItemDecoration(new LoadMoreDecoration(getContext(), this));
//    }
//
//    private void findView() {
//        mRv = this.findViewById(R.id.x_recycler_view_rv);
//        mLoadMoreLayout = this.findViewById(R.id.ll_load_more);
//    }
//
//    private void installView() {
//        LayoutInflater.from(getContext()).inflate(R.layout.x_recycler_view, this);
//    }
//}

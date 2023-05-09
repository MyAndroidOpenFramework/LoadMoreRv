//package com.lj.coordinatorlayout.loadmorerv;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.lj.android.common.util.view.MeasureViewUtil;
//
///**
// * @author liujian
// * @date 2023/3/7
// */
//public class LoadMoreDecoration extends RecyclerView.ItemDecoration {
//    private View mLoadMoreView;
//    private final Rect mBounds = new Rect();
//    private Paint mPaint = new Paint();
//    private Rect rectTmp = new Rect();
//
//    public LoadMoreDecoration(Context context, ViewGroup parent) {
////        this.mLoadMoreTv = Layout;
//        mLoadMoreView = LayoutInflater.from(context).inflate(R.layout.load_more_footer, parent, false);
//        mLoadMoreView.setVisibility(View.VISIBLE);
//        MeasureViewUtil.measureView(mLoadMoreView);
//        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
//        mPaint.setTextSize(40);
//        mPaint.setColor(Color.RED);
//    }
//
//    @Override
//    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//        super.onDraw(c, parent, state);
//    }
//
//    private void drawLoadMore(Canvas c) {
//        c.drawText("加载中...", 0, 40, mPaint);
//    }
//
//    @Override
//    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//        super.onDrawOver(c, parent, state);
//        int itemCount = parent.getAdapter().getItemCount();
//        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
//        if (layoutManager instanceof LinearLayoutManager) {
//            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
//            if ((itemCount - 1) == linearLayoutManager.findLastVisibleItemPosition()) {
//                View lastView = linearLayoutManager.findViewByPosition(linearLayoutManager.findLastVisibleItemPosition());
//                c.save();
//                parent.getDecoratedBoundsWithMargins(lastView, mBounds);
//                mLoadMoreView.layout(0, 0, parent.getWidth(), mLoadMoreView.getMeasuredHeight());
//                rectTmp.set(mBounds.left, mBounds.bottom - 300, mBounds.right, mBounds.bottom);
//                c.translate(mBounds.left, mBounds.bottom - 300);
//                mLoadMoreView.draw(c);
////                c.drawColor(Color.CYAN);
////                drawLoadMore(c);
//                c.restore();
//            }
//        }
//
//    }
//
//    @Override
//    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
//        int itemCount = parent.getAdapter().getItemCount();
//        int position = parent.getChildAdapterPosition(view);
//        Log.i(LoadMoreDecoration.class.getSimpleName(), "当前位置：" + position);
//        if ((itemCount - 1) == position) {
//            outRect.bottom = 300;
//        }
//    }
//}

package com.lj.coordinatorlayout.loadmorerv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.lj.paging.PagingRvView;


public class MainActivity extends AppCompatActivity {
    private PagingRvView mRv;
    private LoadMoreSimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRv = findViewById(R.id.rv);
        mRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        simpleAdapter = new LoadMoreSimpleAdapter();
        mRv.setAdapter(simpleAdapter);
        mRv.setOnPagingCallBack(new PagingRvView.OnPagingCallBack() {
            @Override
            public void loadMore() {
                mRv.getHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        simpleAdapter.newData();
                        mRv.currentPageLoadOkPerNextPage();
                    }
                }, 1000);
            }
        });
    }
}
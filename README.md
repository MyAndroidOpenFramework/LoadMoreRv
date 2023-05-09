# LoadMoreRv
> 本项目是一个demo项目，旨在提供一个可以运行的简单demo，真正的库使用的库是  [库项目](https://gitee.com/lj-framework-java/paging-rv)
上拉加载更多框架，超级简单实用，非常方便二次开发，随心所欲修改适配自己的项目，代码量很少哦
> 适用于 RecyclerView提供的三种布局管理器
>使用 RecyclerView 为基础做的分页控件 [库项目](https://gitee.com/lj-framework-java/paging-rv)
## 1、使用指南
### 1.1、引入
* 通过源码方式引入

    * 1、拷贝 [import_paging_rv_lib.groovy](http://image.liujian1988.top/doc/import_paging_rv_lib.groovy) 到项目根目录

    * 2、在`setting.gradle`末尾添加下面代码：

        ```groovy
        setBinding(new Binding([gradle: this, path: rootProject.projectDir.path + "\\"]))
        def projectPagingRvPath = rootProject.projectDir.path + '\\' + 'import_paging_rv_lib.groovy'
        evaluate(new File(projectPagingRvPath))
        ```
    * 3、在使用该库的module中引入库：
        
        ```groovy
        implementation project(':paging-rv')
        ```

### 1.2、使用指南
* 1、xml加入控件
    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <com.lj.paging.PagingRvView
            android:id="@+id/rv"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

    </FrameLayout>
    ```
  * 2、继承 `PagingAdapter` 实现抽象方法
      ```java
      /**
      * @author liujian
      * @date 2023/3/9
      */
      public class LoadMoreSimpleAdapter extends PagingAdapter {
          private int count = 20;
          private boolean isLoadFinish;
    
          @Override
          protected void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
              if (holder.getItemViewType() == CONTENT_ID) {
                  ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
                  contentViewHolder.tv.setText(String.valueOf(position));
              }
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
          protected RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
              View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
              itemView.getLayoutParams().height += Math.random() * 100;
              return new ContentViewHolder(itemView);
          }
    
          /**
           * 开发者需要提供 footer显示view，框架中有一些简单内置样式。不过满足不了，开发者可以自己定义。
           *
           * @param parent
           * @return
           */
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
    
          /**
           * 全部数据加载完成。此时需要将 footer中的文案改为 “数据全部加载完成”等字样
           */
          @Override
          public void onLoadFinish() {
              isLoadFinish = true;
              notifyItemChanged(getMyItemCount());
          }
      }
      ```
* 2、简单使用
    ```java
        mRv.setOnPagingCallBack(new PagingRvView.OnPagingCallBack() {
            @Override
            public void loadMore() {
                mRv.getHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        simpleAdapter.newData();
                        if (mPageNum < 5) {
                            mRv.currentPageLoadOkPerNextPage();
                        } else {
                            mRv.loadFinish();
                        }
                        mPageNum++;
                    }
                }, 1000);
            }
        });
    ```

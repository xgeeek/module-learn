package module.learn.common.base;

import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import module.learn.common.R;
import module.learn.common.R2;
import module.learn.common.base.mvp.BasePresenter;
import module.learn.common.listener.OnListItemClickListener;
import module.learn.common.widget.pulltorefresh.OnPullRefreshListener;
import module.learn.common.widget.pulltorefresh.PullToRefreshLayout;

/**
 * Describe：带下拉刷新 上拉加载更多的Activity
 * 内部实现为刷新控件 PullToRefreshLayout + 列表控件 RecyclerView
 * Created by 吴天强 on 2018/10/23.
 */
public abstract class RefreshListActivity<P extends BasePresenter> extends ActionBarActivity<P> implements OnPullRefreshListener, OnListItemClickListener {

    @BindView(R2.id.ptrl_list)
    PullToRefreshLayout refreshLayout;

    @BindView(R2.id.recycle_view)
    RecyclerView recyclerView;

    protected RecyclerView.Adapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.layout_refresh;
    }

    @CallSuper
    @Override
    protected void initView() {
        refreshLayout.setOnPullRefreshListener(this);
        recyclerView.setLayoutManager(getLayoutManager());
        adapter = createAdapter();
        recyclerView.setAdapter(adapter);
    }

    @CallSuper
    @Override
    public void dismissLoading() {
        super.dismissLoading();
        stopRefresh();
    }


    @CallSuper
    @Override
    public void showLoading() {
        super.showLoading();
        hideEmptyView();
    }

    /**
     * 停止刷新
     */
    protected void stopRefresh() {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
    }

    protected PullToRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    protected RecyclerView getRecyclerView() {
        return recyclerView;
    }

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract RecyclerView.Adapter createAdapter();
}

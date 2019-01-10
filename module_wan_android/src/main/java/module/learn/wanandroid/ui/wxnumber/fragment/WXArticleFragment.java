package module.learn.wanandroid.ui.wxnumber.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import module.learn.common.base.RefreshListFragment;
import module.learn.common.bean.HorizontalTabTitle;
import module.learn.common.utils.ActivityToActivity;
import module.learn.wanandroid.R;
import module.learn.wanandroid.bean.Article;
import module.learn.wanandroid.bean.WXNumber;
import module.learn.wanandroid.ui.wxnumber.adapter.WXArticleAdapter;
import module.learn.wanandroid.ui.wxnumber.mvp.WXArticlePresenter;
import module.learn.wanandroid.ui.wxnumber.mvp.contract.WXNumberContract;

/**
 * Describe：公众号文章列表
 * Created by 吴天强 on 2018/11/15.
 */

public class WXArticleFragment extends RefreshListFragment<WXArticlePresenter> implements WXNumberContract.View {


    private List<Article> wxArticles = new ArrayList<>();
    private WXNumber wxNumber;
    private int page = 1;

    @Override
    protected void initView() {
        super.initView();
        onRefresh();
    }

    @Override
    public void onRefresh() {
        page = 1;
        wxArticles.clear();
        presenter.start();
    }

    @Override
    public void onLoadMore() {
        page++;
        presenter.start();
    }

    @Override
    public void onItemClick(View view, int position) {
        ActivityToActivity.toWebView(mContext, wxArticles.get(position).getLink());
    }

    @Override
    protected WXArticlePresenter createPresenter() {
        return new WXArticlePresenter();
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    @Override
    protected RecyclerView.Adapter createAdapter() {
        return new WXArticleAdapter(mContext, wxArticles, R.layout.wan_item_of_wx_article_list, this);
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public void setFragmentData(HorizontalTabTitle data) {
        super.setFragmentData(data);
        wxNumber = (WXNumber) data.getData();
    }

    @Override
    public int getWXNumberId() {
        return wxNumber.getId();
    }

    @Override
    public void wxArticleList(List<Article> wxArticles) {
        this.wxArticles.addAll(wxArticles);
        adapter.notifyDataSetChanged();
    }
}

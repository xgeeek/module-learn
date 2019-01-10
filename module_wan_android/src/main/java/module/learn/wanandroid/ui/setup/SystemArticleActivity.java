package module.learn.wanandroid.ui.setup;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import module.learn.common.base.RefreshListActivity;
import module.learn.common.utils.ActivityToActivity;
import module.learn.common.utils.ToastUtils;
import module.learn.wanandroid.R;
import module.learn.wanandroid.bean.Article;
import module.learn.wanandroid.bean.ClassificationChild;
import module.learn.wanandroid.ui.main.adapter.ArticleAdapter;
import module.learn.wanandroid.ui.setup.mvp.SystemArticlePresenter;
import module.learn.wanandroid.ui.setup.mvp.contract.SystemArticleContract;

/**
 * Describe：体系文章
 * Created by 吴天强 on 2018/11/15.
 */

public class SystemArticleActivity extends RefreshListActivity<SystemArticlePresenter> implements
        SystemArticleContract.View {


    private List<Article> articleList = new ArrayList<>();

    private int page;

    private ClassificationChild children;//二级菜单

    @Override
    protected void initView() {
        super.initView();
        children = (ClassificationChild) getIntent().getSerializableExtra("ClassificationChild");
        if (children == null) {
            children = new ClassificationChild();
        }
        setTitleText(children.getName());
        onRefresh();
    }

    @Override
    public void onRefresh() {
        page = 0;
        articleList.clear();
        presenter.getArticle();
    }

    @Override
    public void onLoadMore() {
        page++;
        presenter.getArticle();
    }

    @Override
    public void onItemClick(View view, int position) {
        ActivityToActivity.toWebView(mContext, articleList.get(position).getLink());
    }

    @Override
    protected SystemArticlePresenter createPresenter() {
        return new SystemArticlePresenter();
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    @Override
    protected RecyclerView.Adapter createAdapter() {
        return new ArticleAdapter(mContext, articleList, R.layout.wan_item_of_article_list, this);

    }

    @Override
    public String getSetupId() {
        return String.valueOf(children.getId());
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public void articleList(List<Article> articles) {
        this.articleList.addAll(articles);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Object tag, String errorMsg) {
        super.onError(tag, errorMsg);
        if (page == 0) {
            showErrorView(errorMsg);
        } else {
            ToastUtils.showToast(mContext, errorMsg);
        }
    }

    @Override
    public void onEmpty(Object tag) {
        super.onEmpty(tag);
        if (page == 0) {
            showEmptyView();
        } else {
            ToastUtils.showToast(mContext, "暂无更多数据");
        }
    }

    @Override
    protected void onPageClick() {
        super.onPageClick();
        onRefresh();
    }

}

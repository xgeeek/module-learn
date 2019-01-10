package module.learn.wanandroid.ui.search;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import module.learn.common.base.RefreshListActivity;
import module.learn.common.utils.ActivityToActivity;
import module.learn.common.utils.KeyboardUtils;
import module.learn.common.utils.ToastUtils;
import module.learn.common.widget.ObserverButton;
import module.learn.wanandroid.R;
import module.learn.wanandroid.bean.Article;
import module.learn.wanandroid.ui.main.adapter.ArticleAdapter;
import module.learn.wanandroid.ui.search.mvp.SearchPresenter;
import module.learn.wanandroid.ui.search.mvp.contract.SearchContract;

/**
 * Describe：搜索页面
 * Created by 吴天强 on 2018/11/15.
 */

public class SearchActivity extends RefreshListActivity<SearchPresenter> implements SearchContract.View {


    private EditText editText;
    private List<Article> data = new ArrayList<>();
    private int page = 0;

    @Override
    protected void initView() {
        super.initView();
        View actionBarView = View.inflate(mContext, R.layout.wan_action_bar_of_search, null);
        editText = actionBarView.findViewById(R.id.edt_search);
        ObserverButton oButton = actionBarView.findViewById(R.id.obt_search);
        oButton.observer(editText);
        actionBar.setActionBarView(actionBarView);
        KeyboardUtils.showKeyboard(actionBarView);
    }

    @Override
    public void onRefresh() {
        page = 0;
        data.clear();
        presenter.search();
    }

    @Override
    public void onLoadMore() {
        page++;
        presenter.search();
    }

    @Override
    public void onItemClick(View view, int position) {
        ActivityToActivity.toWebView(mContext, data.get(position).getLink());
    }

    @Override
    protected SearchPresenter createPresenter() {
        return new SearchPresenter();
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    @Override
    protected RecyclerView.Adapter createAdapter() {
        return new ArticleAdapter(mContext, data, R.layout.wan_item_of_article_list, this);
    }


    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.ll_back) {
            finish();
        } else if (i == R.id.obt_search) {
            onRefresh();
        }
    }

    @Override
    public String getWord() {
        return editText.getText().toString().trim();
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public void searchData(List<Article> searchs) {
        this.data.addAll(searchs);
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
            showEmptyView("木有搜到你想要的");
        } else {
            ToastUtils.showToast(mContext, "没有更多啦~");
        }
    }
}

package module.learn.wanandroid.ui.project;

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
import module.learn.wanandroid.bean.Classification;
import module.learn.wanandroid.ui.project.adapter.ProjectListAdapter;
import module.learn.wanandroid.ui.project.mvp.ProjectPresenter;
import module.learn.wanandroid.ui.project.mvp.contract.ProjectContract;

/**
 * Describe：项目
 * Created by 吴天强 on 2018/11/15.
 */

public class ProjectActivity extends RefreshListActivity<ProjectPresenter> implements ProjectContract.View,
        TypePopupWindow.OnProjectTypeClickListener {

    private List<Classification> types = new ArrayList<>();
    private List<Article> projects = new ArrayList<>();

    private Classification currentClassification;//当前显示的项目分类
    private int page = 1;

    @Override
    protected void initView() {
        super.initView();
        actionBar.setRightText("项目", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TypePopupWindow(mContext)
                        .setData(types)
                        .setCurrent(currentClassification)
                        .setListener(ProjectActivity.this)
                        .show(v);
            }
        });
        presenter.getProjectType();
    }

    @Override
    public void onRefresh() {
        page = 1;
        projects.clear();
        presenter.getProject();
    }

    @Override
    public void onLoadMore() {
        page++;
        presenter.getProject();
    }

    @Override
    public void onItemClick(View view, int position) {
        ActivityToActivity.toWebView(mContext, projects.get(position).getLink());
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public int getTypeId() {
        return currentClassification.getId();
    }

    @Override
    public void projectTypeList(List<Classification> types) {
        this.types.addAll(types);
        currentClassification = types.get(0);
        if (currentClassification != null) {
            setTitleText(currentClassification.getName());
            onRefresh();
        } else {
            showEmptyView("暂无项目数据");
        }
    }

    @Override
    public void projectList(List<Article> projects) {
        this.projects.addAll(projects);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onProjectError(String message) {
        if (page == 1) {
            showEmptyView(message);
        } else {
            ToastUtils.showToast(mContext, message);
        }
    }

    @Override
    public void onProjectEmpty() {
        if (page == 1) {
            showEmptyView("暂无项目数据");
        } else {
            ToastUtils.showToast(mContext, "暂无更多项目数据");
        }
    }

    @Override
    protected ProjectPresenter createPresenter() {
        return new ProjectPresenter();
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    @Override
    public void onEmpty(Object tag) {
        super.onEmpty(tag);
        showEmptyView("暂无项目");

    }

    @Override
    public void onError(Object tag, String errorMsg) {
        super.onError(tag, errorMsg);
        showEmptyView(errorMsg);
    }

    @Override
    protected RecyclerView.Adapter createAdapter() {
        return new ProjectListAdapter(mContext, projects, R.layout.wan_item_of_project_list, this);
    }

    @Override
    public void onProjectTypeClick(Classification classification) {
        //选择了一个分类
        if (classification != null) {
            this.currentClassification = classification;
            setTitleText(currentClassification.getName());
            onRefresh();
        }
    }
}

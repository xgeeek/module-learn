package module.learn.wanandroid.ui.project.mvp;

import com.alibaba.fastjson.JSON;

import java.util.List;

import module.learn.common.base.mvp.BasePresenter;
import module.learn.common.constants.Constants;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.bean.Article;
import module.learn.wanandroid.bean.Classification;
import module.learn.wanandroid.ui.project.mvp.contract.ProjectContract;

/**
 * Describe：
 * Created by 吴天强 on 2018/11/15.
 */

public class ProjectPresenter extends BasePresenter<ProjectContract.Model, ProjectContract.View>
        implements ProjectContract.Presenter {

    @Override
    protected ProjectModel createModule() {
        return new ProjectModel();
    }

    @Override
    public void start() {
        getProjectType();
    }

    @Override
    public void getProjectType() {
        if (isViewAttached()) {
            getView().showLoading();
            getModule().getProjectType(new OnResultCallBack<List<Classification>>() {
                @Override
                public void onSuccess(boolean success, int code, String msg, Object tag, List<Classification> response) {
                    if (code == Constants.SUCCESS_CODE) {
                        if (response != null && response.size() > 0) {
                            getView().projectTypeList(response);
                        } else {
                            getView().onEmpty(tag);
                        }

                    } else {
                        getView().onError(tag, msg);
                    }
                }

                @Override
                public void onFailure(Object tag, Exception e) {
                    getView().onError(tag, Constants.ERROR_MESSAGE);
                }

                @Override
                public void onCompleted() {
                    getView().dismissLoading();
                }
            });
        }
    }

    @Override
    public void getProject() {
        if (isViewAttached()) {
            getView().showLoading();
            getModule().getProject(getView().getPage(), getView().getTypeId(), new OnResultCallBack<String>() {
                @Override
                public void onSuccess(boolean success, int code, String msg, Object tag, String response) {
                    if (code == Constants.SUCCESS_CODE) {
                        final List<Article> articleList = JSON.parseArray(JSON.parseObject(response).getString("datas"), Article.class);
                        if (articleList == null || articleList.size() < 1) {
                            getView().onProjectEmpty();
                        } else {
                            getView().projectList(articleList);
                        }

                    } else {
                        getView().onProjectError(msg);
                    }
                }

                @Override
                public void onFailure(Object tag, Exception e) {
                    getView().onProjectError(Constants.ERROR_MESSAGE);
                }

                @Override
                public void onCompleted() {
                    getView().dismissLoading();
                }
            });
        }
    }
}
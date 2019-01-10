package module.learn.wanandroid.ui.main.mvp;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

import module.learn.common.base.mvp.BasePresenter;
import module.learn.common.bean.Template;
import module.learn.common.constants.Constants;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.R;
import module.learn.wanandroid.bean.Article;
import module.learn.wanandroid.bean.BannerInfo;
import module.learn.wanandroid.bean.WXNumber;
import module.learn.wanandroid.ui.main.mvp.contract.HomeContract;
import module.learn.wanandroid.ui.project.ProjectActivity;
import module.learn.wanandroid.ui.search.SearchActivity;
import module.learn.wanandroid.ui.setup.SystemActivity;
import module.learn.wanandroid.ui.wxnumber.WXNumberActivity;

/**
 * Describe：首页Presenter
 * Created by 吴天强 on 2018/10/17.
 */

public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View> implements
        HomeContract.Presenter {


    @Override
    public void getBanner() {
        if (isViewAttached()) {
            showLoading();
            getModule().getBanner(new OnResultCallBack<List<BannerInfo>>() {
                @Override
                public void onSuccess(boolean success, int code, String msg, Object tag, List<BannerInfo> response) {
                    if (code == 0) {
                        if (response != null && response.size() > 0) {
                            getView().bannerList(response);
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
                }
            });

        }
    }

    @Override
    public void getBlockList() {
        if (isViewAttached()) {
            getView().showLoading();
            List<Template> list = new ArrayList<>();
            list.add(new Template("体系", R.drawable.wan_icon_1, SystemActivity.class));
            list.add(new Template("项目", R.drawable.wan_icon_2, ProjectActivity.class));
            list.add(new Template("公众号", R.drawable.wan_icon_3, WXNumberActivity.class));
            list.add(new Template("搜索", R.drawable.wan_icon_4, SearchActivity.class));

            getView().blockList(list);

        }
    }

    @Override
    public void getWXNumber() {
        if (isViewAttached()) {
            getModule().getWXNumber(new OnResultCallBack<List<WXNumber>>() {
                @Override
                public void onSuccess(boolean success, int code, String msg, Object tag, List<WXNumber> response) {
                    if (code == Constants.SUCCESS_CODE && response != null && response.size() > 0) {
                        getView().wxNumber(response);
                    }
                }

                @Override
                public void onFailure(Object tag, Exception e) {
                }

                @Override
                public void onCompleted() {
                }
            });
        }
    }


    @Override
    public void getArticleList() {
        if (isViewAttached()) {
            getView().showLoading();
            getModule().getArticleList(getView().getPage(), new OnResultCallBack<String>() {


                @Override
                public void onSuccess(boolean success, int code, String msg, Object tag, String response) {
                    if (code == Constants.SUCCESS_CODE) {
                        final List<Article> articleList = JSON.parseArray(
                                JSON.parseObject(response).getString("datas"), Article.class);
                        if (articleList == null || articleList.size() < 1) {
                            getView().onEmpty(tag);
                        } else {
                            getView().articleList(articleList);
                        }

                    } else {
                        getView().onError(tag, msg);
                    }
                }

                @Override
                public void onFailure(Object tag, Exception e) {
                }

                @Override
                public void onCompleted() {
                    dismissLoading();
                }
            });
        }
    }


    @Override
    protected HomeModel createModule() {
        return new HomeModel();
    }

    @Override
    public void start() {
        getBanner();
        getBlockList();
        getWXNumber();
        getArticleList();
    }
}

package module.learn.wanandroid.ui.setup.mvp;

import com.alibaba.fastjson.JSON;

import java.util.List;

import module.learn.common.base.mvp.BasePresenter;
import module.learn.common.constants.Constants;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.bean.Article;
import module.learn.wanandroid.ui.setup.mvp.contract.SystemArticleContract;

/**
 * Describe：体系文章Presenter
 * Created by 吴天强 on 2018/11/15.
 */

public class SystemArticlePresenter extends BasePresenter<SystemArticleContract.Model, SystemArticleContract.View>
        implements SystemArticleContract.Presenter {


    @Override
    public void getArticle() {
        if (isViewAttached()) {
            getView().showLoading();
            getModule().getArticle(getView().getPage(), getView().getSetupId(), new OnResultCallBack<String>() {
                @Override
                public void onSuccess(boolean success, int code, String msg, Object tag, String response) {
                    if (code == Constants.SUCCESS_CODE) {
                        List<Article> articleList = JSON.parseArray(JSON.parseObject(response).getString("datas"), Article.class);
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
    protected SystemArticleModel createModule() {
        return new SystemArticleModel();
    }

    @Override
    public void start() {
        getArticle();
    }
}

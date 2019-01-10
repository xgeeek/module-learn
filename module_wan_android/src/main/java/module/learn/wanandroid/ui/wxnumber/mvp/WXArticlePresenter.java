package module.learn.wanandroid.ui.wxnumber.mvp;

import com.alibaba.fastjson.JSON;

import java.util.List;

import module.learn.common.base.mvp.BasePresenter;
import module.learn.common.constants.Constants;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.bean.Article;
import module.learn.wanandroid.ui.wxnumber.mvp.contract.WXNumberContract;

/**
 * Describe：公众号Presenter
 * Created by 吴天强 on 2018/11/15.
 */

public class WXArticlePresenter extends BasePresenter<WXNumberContract.Model, WXNumberContract.View>
        implements WXNumberContract.Presenter {


    @Override
    public void getWXArticle() {
        if (isViewAttached()) {
            getView().showLoading();
            getModule().getWXArticle(getView().getWXNumberId(), getView().getPage(), new OnResultCallBack<String>() {
                @Override
                public void onSuccess(boolean success, int code, String msg, Object tag, String
                        response) {
                    if (code == Constants.SUCCESS_CODE) {
                        final List<Article> articleList = JSON.parseArray(JSON.parseObject(response).getString("datas"), Article.class);
                        if (articleList == null || articleList.size() < 1) {
                            getView().onEmpty(tag);
                        } else {
                            getView().wxArticleList(articleList);
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
    protected WXArticleModel createModule() {
        return new WXArticleModel();
    }

    @Override
    public void start() {
        getWXArticle();
    }
}

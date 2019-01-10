package module.learn.wanandroid.ui.main.mvp;


import module.learn.common.net.Api;
import module.learn.common.net.HttpUtils;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.ui.main.mvp.contract.HomeContract;

/**
 * Describe：首页Module
 * Created by 吴天强 on 2018/10/17.
 */

public class HomeModel implements HomeContract.Model {
    @Override
    public void getBanner(OnResultCallBack callback) {
        HttpUtils.getInstance()
                .getRequest(Api.GET_BANNER_LIST, callback);
    }

    @Override
    public void getArticleList(int page, OnResultCallBack callback) {
        HttpUtils.getInstance()
                .getRequest(String.format(Api.GET_ARTICLE_LIST, page), callback);
    }

    @Override
    public void getWXNumber(OnResultCallBack callback) {
        HttpUtils.getInstance()
                .getRequest(Api.WX_NUMBER, callback);
    }

}

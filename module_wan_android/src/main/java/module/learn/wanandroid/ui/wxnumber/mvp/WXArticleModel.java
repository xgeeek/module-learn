package module.learn.wanandroid.ui.wxnumber.mvp;


import module.learn.common.net.Api;
import module.learn.common.net.HttpUtils;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.ui.wxnumber.mvp.contract.WXNumberContract;

/**
 * Describe：公众号文章Module
 * Created by 吴天强 on 2018/11/15.
 */

public class WXArticleModel implements WXNumberContract.Model {


    @Override
    public void getWXArticle(int id, int page, OnResultCallBack callback) {
        HttpUtils.getInstance()
                .getRequest(String.format(Api.WX_ARTICLE_LIST, id, page), callback);
    }
}

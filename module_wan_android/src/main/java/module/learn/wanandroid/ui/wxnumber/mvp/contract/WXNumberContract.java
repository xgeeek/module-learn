package module.learn.wanandroid.ui.wxnumber.mvp.contract;


import java.util.List;

import module.learn.common.base.mvp.IBaseModel;
import module.learn.common.base.mvp.IBaseView;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.bean.Article;

/**
 * Describe：微信公众号 契约类
 * Created by 吴天强 on 2018/11/21.
 */

public interface WXNumberContract {


    interface Model extends IBaseModel {
        /**
         * 获取公众号文章列表
         *
         * @param id       公众号ID
         * @param page     页码
         * @param callback 回调
         */
        void getWXArticle(int id, int page, OnResultCallBack callback);

    }

    interface View extends IBaseView {
        /**
         * 返回页码
         */
        int getPage();

        /**
         * 公众号ID
         */
        int getWXNumberId();

        /**
         * 公众号文章类表
         */
        void wxArticleList(List<Article> wxArticles);
    }

    interface Presenter {
        /**
         * 获取公众号文章
         */
        void getWXArticle();
    }
}

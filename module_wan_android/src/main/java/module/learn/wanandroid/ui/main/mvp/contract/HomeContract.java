package module.learn.wanandroid.ui.main.mvp.contract;


import java.util.List;

import module.learn.common.base.mvp.IBaseModel;
import module.learn.common.base.mvp.IBaseView;
import module.learn.common.bean.Template;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.bean.Article;
import module.learn.wanandroid.bean.BannerInfo;
import module.learn.wanandroid.bean.WXNumber;

/**
 * Describe：wanAndroid首页契约类
 * Created by 吴天强 on 2018/11/21.
 */

public interface HomeContract {

    interface Model extends IBaseModel {

        /**
         * 获取Banner
         *
         * @param callback 回调
         */
        void getBanner(OnResultCallBack callback);

        /**
         * 获取文章列表
         *
         * @param callback 回调
         */
        void getArticleList(int page, OnResultCallBack callback);

        /**
         * 获取微信公众号
         *
         * @param callback 回调
         */
        void getWXNumber(OnResultCallBack callback);
    }

    interface View extends IBaseView {
        /**
         * banner列表
         */
        void bannerList(List<BannerInfo> banners);

        /**
         * 模块列表
         */
        void blockList(List<Template> blockList);

        /**
         * 返回分页
         */
        int getPage();

        /**
         * 文章列表
         */
        void articleList(List<Article> articles);

        /**
         * 公众号列表
         */
        void wxNumber(List<WXNumber> wxNumbers);
    }

    interface Presenter {
        /**
         * 获取Banner
         */
        void getBanner();

        /**
         * 获取文章列表
         */
        void getArticleList();

        /**
         * 获取微信公众号
         */
        void getWXNumber();

        /**
         * 豆腐块
         */
        void getBlockList();
    }


}

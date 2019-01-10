package module.learn.wanandroid.ui.setup.mvp.contract;


import java.util.List;

import module.learn.common.base.mvp.IBaseModel;
import module.learn.common.base.mvp.IBaseView;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.bean.Article;

/**
 * Describe：体系文章契约类
 * Created by 吴天强 on 2018/11/21.
 */

public interface SystemArticleContract {

    interface Model extends IBaseModel {

        /**
         * 获取体系文章
         *
         * @param page     页码
         * @param id       体系二级分类ID
         * @param callback 回调
         */
        void getArticle(int page, String id, OnResultCallBack callback);
    }

    interface View extends IBaseView {
        /**
         * 返回二级菜单ID
         */
        String getSetupId();

        /**
         * 返回页码
         */
        int getPage();

        /**
         * 体系文章
         */
        void articleList(List<Article> articles);
    }

    interface Presenter {
        /**
         * 获取体系文章
         */
        void getArticle();
    }


}

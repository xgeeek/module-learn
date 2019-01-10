package module.learn.wanandroid.ui.search.mvp.contract;


import java.util.List;

import module.learn.common.base.mvp.IBaseModel;
import module.learn.common.base.mvp.IBaseView;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.bean.Article;

/**
 * Describe：搜索契类
 * Created by 吴天强 on 2018/11/21.
 */

public interface SearchContract {

    interface Module extends IBaseModel {

        /**
         * 搜索
         *
         * @param page     页码
         * @param word     关键字
         * @param callback 回调
         */
        void searchData(int page, String word, OnResultCallBack callback);
    }

    interface View extends IBaseView {
        /**
         * 返回搜索关键字
         */
        String getWord();

        /**
         * 返回分页页码
         */
        int getPage();

        /**
         * 搜索数据列表
         */
        void searchData(List<Article> searchs);
    }

    interface Presenter {

        /**
         * 搜索
         */
        void search();
    }

}

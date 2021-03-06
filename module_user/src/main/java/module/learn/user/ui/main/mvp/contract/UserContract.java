package module.learn.user.ui.main.mvp.contract;


import module.learn.common.base.mvp.IBaseModel;
import module.learn.common.base.mvp.IBaseView;
import module.learn.common.bean.AppInfo;
import module.learn.common.net.callback.OnResultCallBack;

/**
 * Describe：契约类
 * Created by 吴天强 on 2018/11/21.
 */

public interface UserContract {

    interface Model extends IBaseModel {
        /**
         * 检查更新
         *
         * @param callback 回调函数
         */
        void checkUpdate(OnResultCallBack callback);
    }

    interface View extends IBaseView {

        /**
         * 需要更新
         *
         * @param appInfo appInfo
         */
        void needUpdate(AppInfo appInfo);

        /**
         * 已经是最新版本
         */
        void isLastVersion();
    }

    interface Presenter {

        /**
         * 检查更新
         */
        void checkUpdate();
    }

}

package module.learn.user.ui.account.mvp.contract;


import module.learn.common.base.mvp.IBaseModel;
import module.learn.common.base.mvp.IBaseView;
import module.learn.common.bean.User;
import module.learn.common.net.callback.OnResultCallBack;

/**
 * Describe：注册契约类
 * Created by 吴天强 on 2018/11/21.
 */

public interface RegisterContract {

    interface Model extends IBaseModel {
        /**
         * 注册
         *
         * @param user     用户信息
         * @param callback 回调
         */
        void register(User user, OnResultCallBack callback);
    }

    interface View extends IBaseView {

        /**
         * 返回用户信息
         */
        User getUserInfo();


        /**
         * 注册成功
         */
        void registerSuccess(User user);

    }

    interface Presenter {

        /**
         * 注册
         */
        void register();
    }
}

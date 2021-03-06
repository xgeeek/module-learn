package module.learn.user.ui.account.mvp.contract;


import module.learn.common.base.mvp.IBaseModel;
import module.learn.common.base.mvp.IBaseView;
import module.learn.common.bean.User;
import module.learn.common.net.callback.OnResultCallBack;

/**
 * Describe：登录契约类
 * Created by 吴天强 on 2018/11/21.
 */

public interface LoginContract {

    interface Model extends IBaseModel {

        /**
         * 登录
         *
         * @param user     用户信息
         * @param callback 回调
         */
        void login(User user, OnResultCallBack callback);
    }

    interface View extends IBaseView {


        /**
         * 返回用户信息
         */
        User getUserInfo();

        /**
         * 登录成功
         */
        void loginSuccess(User user);


    }

    interface Presenter {

        /**
         * 登录
         */
        void login();
    }
}

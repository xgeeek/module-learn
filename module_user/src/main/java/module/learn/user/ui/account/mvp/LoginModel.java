package module.learn.user.ui.account.mvp;

import com.tamic.novate.Throwable;

import module.learn.common.bean.User;
import module.learn.common.net.Api;
import module.learn.common.net.HttpUtils;
import module.learn.common.net.RequestParam;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.user.ui.account.mvp.contract.LoginContract;


/**
 * Describe：登录Module
 * Created by 吴天强 on 2018/11/13.
 */

public class LoginModel implements LoginContract.Model {

    @Override
    public void login(User user, OnResultCallBack callback) {
        if (user == null) {
            callback.onError("", (Throwable) new Exception("用户信息为空"));
        }
        RequestParam param = new RequestParam();
        param.addParameter("username", user.getUsername());
        param.addParameter("password", user.getPassword());
        HttpUtils.getInstance()
                .postRequest(Api.LOGIN, param, callback);
    }
}

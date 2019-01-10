package module.learn.user.ui.account.mvp;


import module.learn.common.bean.User;
import module.learn.common.net.Api;
import module.learn.common.net.HttpUtils;
import module.learn.common.net.RequestParam;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.user.ui.account.mvp.contract.RegisterContract;

/**
 * Describe：注册Module
 * Created by 吴天强 on 2018/11/13.
 */

public class RegisterModel implements RegisterContract.Model {


    @Override
    public void register(User user, OnResultCallBack callback) {
        if (user == null)
            callback.onError("",null);
        RequestParam param = new RequestParam();
        param.addParameter("username", user.getUsername());
        param.addParameter("password", user.getPassword());
        param.addParameter("repassword", user.getPassword());
        HttpUtils.getInstance()
                .postRequest(Api.REGISTER, param, callback);
    }
}

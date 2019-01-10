package module.learn.user.ui.main.mvp;


import module.learn.common.net.Api;
import module.learn.common.net.HttpUtils;
import module.learn.common.net.NetConfig;
import module.learn.common.net.RequestParam;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.common.utils.Utils;
import module.learn.user.ui.main.mvp.contract.UserContract;

/**
 * Describe：我的Module
 * Created by 吴天强 on 2018/11/21.
 */

public class UserModel implements UserContract.Model {

    @Override
    public void checkUpdate(OnResultCallBack callback) {
        RequestParam param = new RequestParam();
        param.addParameter("versionCode", Utils.getVersionCode());
        HttpUtils.getInstance()
                .setBaseUrl(NetConfig.Url.MY_SERVICE_URL)
                .getRequest(Api.CHECK_UPDATE, param, callback);
    }
}

package module.learn.wanandroid.ui.setup.mvp;


import module.learn.common.net.Api;
import module.learn.common.net.HttpUtils;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.ui.setup.mvp.contract.SystemContract;

/**
 * Describe：体系Module
 * Created by 吴天强 on 2018/11/21.
 */

public class SystemModel implements SystemContract.Model {

    @Override
    public void getSystem(OnResultCallBack callback) {
        HttpUtils.getInstance()
                .getRequest(Api.TREE, callback);
    }
}

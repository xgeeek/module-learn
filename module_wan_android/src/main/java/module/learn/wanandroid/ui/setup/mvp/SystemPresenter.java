package module.learn.wanandroid.ui.setup.mvp;


import java.util.List;

import module.learn.common.base.mvp.BasePresenter;
import module.learn.common.constants.Constants;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.bean.Classification;
import module.learn.wanandroid.ui.setup.mvp.contract.SystemContract;

/**
 * Describe：体系Presenter
 * Created by 吴天强 on 2018/11/21.
 */

public class SystemPresenter extends BasePresenter<SystemContract.Model, SystemContract.View>
        implements SystemContract.Presenter {

    @Override
    public void getSystem() {
        getView().showLoading();
        getModule().getSystem(new OnResultCallBack<List<Classification>>() {
            @Override
            public void onSuccess(boolean success, int code, String msg, Object tag, List<Classification> response) {
                if (code == 0) {
                    if (response == null || response.size() < 1) {
                        getView().onEmpty(tag);
                    } else {
                        getView().systemList(response);
                    }
                } else {
                    getView().onError(tag, msg);
                }
            }

            @Override
            public void onFailure(Object tag, Exception e) {
                getView().onError(tag, Constants.ERROR_MESSAGE);
            }

            @Override
            public void onCompleted() {
                getView().dismissLoading();
            }
        });
    }

    @Override
    protected SystemContract.Model createModule() {
        return new SystemModel();
    }

    @Override
    public void start() {
        getSystem();
    }
}

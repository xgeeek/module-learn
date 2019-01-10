package module.learn.wanandroid.ui.project.mvp;


import module.learn.common.net.Api;
import module.learn.common.net.HttpUtils;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.ui.project.mvp.contract.ProjectContract;

/**
 * Describe：项目Module
 * Created by 吴天强 on 2018/11/15.
 */

public class ProjectModel implements ProjectContract.Model {


    @Override
    public void getProjectType(OnResultCallBack callback) {
        HttpUtils.getInstance()
                .getRequest(Api.PROJECT, callback);
    }

    @Override
    public void getProject(int page, int id, OnResultCallBack callback) {
        HttpUtils.getInstance()
                .getRequest(String.format(Api.PROJECT_LIST, page, id), callback);
    }
}

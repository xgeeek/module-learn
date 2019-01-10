package module.learn.wanandroid.ui.search.mvp;


import module.learn.common.net.Api;
import module.learn.common.net.HttpUtils;
import module.learn.common.net.callback.OnResultCallBack;
import module.learn.wanandroid.ui.search.mvp.contract.SearchContract;

/**
 * Describe：搜索Module
 * Created by 吴天强 on 2018/11/15.
 */

public class SearchModule implements SearchContract.Module {

    @Override
    public void searchData(int page, String word, OnResultCallBack callback) {
        HttpUtils.getInstance()
                .postRequest(String.format(Api.SEARCH_LIST, page, word), callback);
    }
}

package module.learn.wanandroid.ui.main;

import module.learn.common.base.BaseActivity;
import module.learn.wanandroid.R;

/**
 * 该类主要用于组件模式下作为程序入口类使用，集成模式下无需考虑
 * @author xugang on 2018/12/5
 */

public class WanMainActivity extends BaseActivity{

    @Override
    protected int getLayoutId() {
        return R.layout.wan_activity_wan_main;
    }

    @Override
    protected void initView() {
    }
}

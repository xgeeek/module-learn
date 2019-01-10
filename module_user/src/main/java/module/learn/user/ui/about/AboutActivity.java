package module.learn.user.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import module.learn.common.base.ActionBarActivity;
import module.learn.common.base.mvp.BasePresenter;
import module.learn.common.utils.Utils;
import module.learn.user.R;
import module.learn.user.R2;

/**
 * Describe：关于
 * Created by 吴天强 on 2018/11/13.
 */

public class AboutActivity extends ActionBarActivity {
    @BindView(R2.id.tv_version)
    TextView tvVersion;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_activity_about;
    }

    @Override
    protected void initView() {
        setTitleText("关于");
        tvVersion.setText(String.format("当前版本：%s", Utils.getVersionName()));
    }


    @OnClick(R2.id.tv_wan)
    public void onViewClicked() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse("http://www.wanandroid.com");
        intent.setData(content_url);
        startActivity(intent);
    }
}

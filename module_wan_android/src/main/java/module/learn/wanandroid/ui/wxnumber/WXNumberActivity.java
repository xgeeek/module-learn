package module.learn.wanandroid.ui.wxnumber;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import module.learn.common.base.BaseFragment;
import module.learn.common.base.HorizontalTabActivity;
import module.learn.common.base.mvp.BasePresenter;
import module.learn.common.bean.HorizontalTabTitle;
import module.learn.wanandroid.bean.WXNumber;
import module.learn.wanandroid.ui.wxnumber.fragment.WXArticleFragment;

/**
 * Describe：微信公众号
 * Created by 吴天强 on 2018/11/15.
 */

@SuppressWarnings("unchecked")
public class WXNumberActivity extends HorizontalTabActivity {

    private ArrayList<WXNumber> wxNumbers = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() == null) {
            finish();
        }
        setTitleText("公众号");
        wxNumbers.addAll((Collection<? extends WXNumber>) getIntent().getSerializableExtra("WXNumbers"));
    }

    @Override
    protected List<HorizontalTabTitle> getTabTitles() {
        if (wxNumbers.size() < 1) {
            finish();
        }
        List<HorizontalTabTitle> tabTitleList = new ArrayList<>();
        for (WXNumber wx : wxNumbers) {
            tabTitleList.add(new HorizontalTabTitle<>(wx.getName(), wx));
        }
        return tabTitleList;
    }

    @Override
    protected BaseFragment getTabFragment() {
        return new WXArticleFragment();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}

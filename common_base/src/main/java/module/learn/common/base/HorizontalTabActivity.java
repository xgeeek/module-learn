package module.learn.common.base;

import android.support.annotation.CallSuper;
import android.support.v4.view.ViewPager;

import java.util.List;

import butterknife.BindView;
import module.learn.common.R;
import module.learn.common.R2;
import module.learn.common.adapter.FragmentPagerAdapter;
import module.learn.common.base.mvp.BasePresenter;
import module.learn.common.bean.HorizontalTabTitle;
import module.learn.common.widget.PagerSlidingTabStrip;

/**
 * Describe：带水平选项卡的Activity
 * Created by 吴天强 on 2018/10/22.
 */

public abstract class HorizontalTabActivity<P extends BasePresenter> extends ActionBarActivity<P> {


    @BindView(R2.id.pst_tab)
    PagerSlidingTabStrip tabStrip;

    @BindView(R2.id.vp_list)
    ViewPager viewPager;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_horizontal_tab;
    }

    @CallSuper
    @Override
    protected void initView() {
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), getTabTitles()) {
            @Override
            public BaseFragment getTabFragment() {
                return HorizontalTabActivity.this.getTabFragment();
            }
        });
        tabStrip.setViewPager(viewPager);
    }

    protected abstract List<HorizontalTabTitle> getTabTitles();

    protected abstract BaseFragment getTabFragment();


}

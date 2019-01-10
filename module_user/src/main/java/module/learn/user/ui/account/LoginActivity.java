package module.learn.user.ui.account;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.OnClick;
import module.learn.common.base.ActionBarActivity;
import module.learn.common.bean.Event;
import module.learn.common.bean.User;
import module.learn.common.constants.ARouterConfig;
import module.learn.common.constants.EventAction;
import module.learn.common.utils.ActivityToActivity;
import module.learn.common.utils.EventBusUtils;
import module.learn.common.utils.ToastUtils;
import module.learn.common.utils.UserInfoUtils;
import module.learn.common.widget.ObserverButton;
import module.learn.user.R;
import module.learn.user.R2;
import module.learn.user.ui.account.mvp.LoginPresenter;
import module.learn.user.ui.account.mvp.contract.LoginContract;

/**
 * Describe：登录
 * Created by 吴天强 on 2018/11/13.
 */
@Route(path = ARouterConfig.USER_LOGIN)
public class LoginActivity extends ActionBarActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R2.id.edt_name)
    EditText edtName;

    @BindView(R2.id.edt_pwd)
    EditText edtPwd;

    @BindView(R2.id.ob_login)
    ObserverButton obLogin;

    @BindView(R2.id.ob_register)
    TextView obRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.user_activity_login;
    }

    @Override
    protected void initView() {
        setTitleText("登录");
        obLogin.observer(edtName, edtPwd);
    }


    @OnClick({R2.id.ob_login, R2.id.ob_register})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.ob_login) {
            presenter.login();
        } else if (i == R.id.ob_register) {
            ActivityToActivity.toActivity(mContext, RegisterActivity.class);
        }
    }

    @Override
    public void loginSuccess(User user) {
        UserInfoUtils.saveUser(user);
        EventBusUtils.sendEvent(new Event(EventAction.EVENT_LOGIN_SUCCESS));
        finish();
    }


    @Override
    public void onError(Object tag, String errorMsg) {
        super.onError(tag, errorMsg);
        ToastUtils.showToast(mContext, errorMsg);
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void onEventBus(Event event) {
        super.onEventBus(event);
        if (TextUtils.equals(event.getAction(), EventAction.EVENT_REGISTER_SUCCESS)) {
            finish();
        }
    }

    @Override
    protected boolean regEvent() {
        return true;
    }

    @Override
    public User getUserInfo() {
        return new User(edtName.getText().toString().trim(), edtPwd.getText().toString().trim());
    }
}

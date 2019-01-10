package module.learn.user.ui.account;

import android.text.TextUtils;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import module.learn.common.base.ActionBarActivity;
import module.learn.common.bean.Event;
import module.learn.common.bean.User;
import module.learn.common.constants.EventAction;
import module.learn.common.utils.EventBusUtils;
import module.learn.common.utils.ToastUtils;
import module.learn.common.utils.UserInfoUtils;
import module.learn.common.widget.ObserverButton;
import module.learn.user.R;
import module.learn.user.R2;
import module.learn.user.ui.account.mvp.RegisterPresenter;
import module.learn.user.ui.account.mvp.contract.RegisterContract;

/**
 * Describe：注册
 * Created by 吴天强 on 2018/11/13.
 */

public class RegisterActivity extends ActionBarActivity<RegisterPresenter> implements RegisterContract.View {


    @BindView(R2.id.edt_name)
    EditText edtName;
    @BindView(R2.id.edt_pwd)
    EditText edtPwd;
    @BindView(R2.id.edt_confirm)
    EditText edtConfirm;
    @BindView(R2.id.ob_register)
    ObserverButton obRegister;


    @Override
    protected int getLayoutId() {
        return R.layout.user_activity_register;
    }

    @Override
    protected void initView() {
        setTitleText("注册");
        obRegister.observer(edtName, edtPwd, edtConfirm);
    }


    @OnClick(R2.id.ob_register)
    public void viewClick() {
        if (edtName.getText().toString().trim().length() < 6 ||
                edtPwd.getText().toString().trim().length() < 6 ||
                edtConfirm.getText().toString().trim().length() < 6) {
            ToastUtils.showToast(mContext, "用户名或密码长度至少6位！");
            return;
        }
        if (!TextUtils.equals(edtPwd.getText().toString().trim(),
                edtConfirm.getText().toString().trim())) {
            ToastUtils.showToast(mContext, "两次输入密码不一致！");
            edtPwd.setText("");
            edtConfirm.setText("");
            return;
        }
        presenter.register();
    }

    @Override
    public void onError(Object tag, String errorMsg) {
        super.onError(tag, errorMsg);
        ToastUtils.showToast(mContext, errorMsg);
    }

    @Override
    public User getUserInfo() {
        return new User(edtName.getText().toString().trim(), edtPwd.getText().toString().trim());
    }

    @Override
    public void registerSuccess(User user) {
        //注册成功 已经默认登录了
        UserInfoUtils.saveUser(user);
        EventBusUtils.sendEvent(new Event(EventAction.EVENT_REGISTER_SUCCESS));
        EventBusUtils.sendEvent(new Event(EventAction.EVENT_LOGIN_SUCCESS));
        finish();
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }
}
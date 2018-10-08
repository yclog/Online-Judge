package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.bean.LoginData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;
import com.graduation.appletree.onlinejudge.utils.NetRequestUtil;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Subscriber;

/**
 * Login
 *
 * @author lucas
 * @date 2018/3/21
 */
public class LoginActivity extends BaseActivity{

    @BindView(R.id.login_account)
    protected EditText editText_login_account;
    @BindView(R.id.login_password)
    protected EditText editText_login_password;
    @BindView(R.id.login_button)
    protected Button login_button;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViewAndEvent() {
        initView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    protected Context getContext() {
        return this;
    }

    /**
     * Instance Method
     * */

    private void initView(){}

    @OnClick(R.id.login_button)
    public void login(){
        String account = editText_login_account.getText().toString();
        String password = editText_login_password.getText().toString();

        if (account.isEmpty()){
            Toast.makeText(getContext(), "Account is Empty", Toast.LENGTH_SHORT).show();
            return;
        } else if (password.isEmpty()){
            Toast.makeText(getContext(), "Password is Empty", Toast.LENGTH_SHORT).show();
            return;
        }

        LoginData mRequestBean = new LoginData();
        mRequestBean.setAccount(account);
        mRequestBean.setPassword(password);
    }
}

package com.bldj.lexiang.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.bldj.lexiang.R;
import com.bldj.lexiang.api.ApiUserUtils;
import com.bldj.lexiang.api.vo.ParseModel;
import com.bldj.lexiang.api.vo.User;
import com.bldj.lexiang.constant.api.ApiConstants;
import com.bldj.lexiang.utils.HttpConnectionUtil;
import com.bldj.lexiang.utils.PatternUtils;
import com.bldj.lexiang.utils.StringUtils;
import com.bldj.lexiang.utils.ToastUtils;
import com.bldj.lexiang.view.ActionBar;
import com.bldj.lexiang.view.LoadingDialog;

/**
 * 申请认证
 * 
 * @author will
 * 
 */
public class ApplyAuthentActivity extends BaseActivity {

	ActionBar mActionBar;
	
	private EditText et_real_name;
	private EditText et_email;
	private EditText et_phone;
	private Button btn_auth;
	
	InputMethodManager manager;
	LoadingDialog loading;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.apply_authent);
		super.onCreate(savedInstanceState);
		mActionBar = (ActionBar)findViewById(R.id.actionBar);
		onConfigureActionBar(mActionBar);
		manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); 
	}

	// 设置activity的导航条
	protected void onConfigureActionBar(ActionBar actionBar) {
		actionBar.setTitle("我要认证");
		actionBar.setLeftActionButton(R.drawable.btn_back,
				new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		actionBar.hideRightActionButton();
	}

	@Override
	public void initView() {
		et_real_name = (EditText)findViewById(R.id.real_name);
		et_email = (EditText)findViewById(R.id.common_email);
		et_phone = (EditText)findViewById(R.id.phone);
		btn_auth = (Button)findViewById(R.id.confirm);
	}

	@Override
	public void initListener() {
		btn_auth.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String realName = et_real_name.getText().toString().trim();
				if(StringUtils.isEmpty(realName)){
					et_real_name.requestFocus();
					ToastUtils.showToast(ApplyAuthentActivity.this, "请输入您的真实姓名");
					return ;
				}
				String email = et_email.getText().toString().trim();
				if(StringUtils.isEmpty(email)){
					et_email.requestFocus();
					ToastUtils.showToast(ApplyAuthentActivity.this, "请输入邮箱");
					return ;
				}
				if(!PatternUtils.checkEmail(email)){
					et_email.requestFocus();
					ToastUtils.showToast(ApplyAuthentActivity.this, "请输入正确的邮箱");
					return;
				}
				String mobile = et_phone.getText().toString().trim();
				if(StringUtils.isEmpty(mobile)){
					et_phone.requestFocus();
					ToastUtils.showToast(ApplyAuthentActivity.this, "请输入手机号");
					return;
				}
				if(!PatternUtils.checkPhoneNum(mobile)){
					et_phone.requestFocus();
					ToastUtils.showToast(ApplyAuthentActivity.this, "请输入正确的手机号");
					return;
				}
				Long phone = Long.parseLong(et_phone.getText().toString().trim());
				String emial = et_email.getText().toString().trim();
				loading = new LoadingDialog(mContext);
				loading.show();
				ApiUserUtils.unifor(ApplyAuthentActivity.this, phone, "", 1, realName, emial, 
						"", "", "", 0, 0, new HttpConnectionUtil.RequestCallback(){

							@Override
							public void execute(ParseModel parseModel) {
								loading.cancel();
								if (!ApiConstants.RESULT_SUCCESS.equals(parseModel
										.getStatus())) {
									ToastUtils.showToast(ApplyAuthentActivity.this, parseModel.getMsg());
								}else{
									ToastUtils.showToast(ApplyAuthentActivity.this, "申请认证已通知到后台，静候佳音");
								}
							}
					
					
				});
			}
		});
	}
	
	 public boolean onTouchEvent(MotionEvent event) {  
		  // TODO Auto-generated method stub  
		  if(event.getAction() == MotionEvent.ACTION_DOWN){  
		     if(getCurrentFocus()!=null && getCurrentFocus().getWindowToken()!=null){  
		       manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);  
		     }  
		  }  
		  return super.onTouchEvent(event);  
		 } 

}

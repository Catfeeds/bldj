package com.bldj.lexiang.ui;

import com.bldj.lexiang.R;
import com.bldj.lexiang.view.ActionBar;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * 企业专区
 * 
 * @author will
 * 
 */
public class CompanyZoneActivity extends BaseActivity {

	ActionBar mActionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.company_zone);
		mActionBar = (ActionBar)findViewById(R.id.actionBar);
		onConfigureActionBar(mActionBar);
	}

	// 设置activity的导航条
	protected void onConfigureActionBar(ActionBar actionBar) {
		actionBar.setTitle("企业专区");
		actionBar.setLeftActionButton(R.drawable.ic_menu_back,
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
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

}
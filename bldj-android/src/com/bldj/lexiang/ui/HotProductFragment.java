package com.bldj.lexiang.ui;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.bldj.gson.reflect.TypeToken;
import com.bldj.lexiang.R;
import com.bldj.lexiang.adapter.CategoryAdapter;
import com.bldj.lexiang.api.ApiProductUtils;
import com.bldj.lexiang.api.vo.Category;
import com.bldj.lexiang.api.vo.ParseModel;
import com.bldj.lexiang.constant.api.ApiConstants;
import com.bldj.lexiang.utils.HttpConnectionUtil;
import com.bldj.lexiang.utils.JsonUtils;
import com.bldj.lexiang.utils.ToastUtils;
import com.bldj.lexiang.view.ActionBar;
import com.bldj.lexiang.view.XListView;
import com.bldj.lexiang.view.XListView.IXListViewListener;
import com.nhaarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.nhaarman.listviewanimations.swinginadapters.prepared.AlphaInAnimationAdapter;
/**
 * 热门推荐（分类）
 * @author will
 *
 */
public class HotProductFragment extends BaseFragment implements IXListViewListener{
	private View infoView;
	private ActionBar mActionBar;
	
	private ProgressBar progressBar;
	private XListView mListView;
	private CategoryAdapter listAdapter;
	private List<Category> categorys;
	
	private int pageNumber = 0;
	
	RelativeLayout rl_loading;//进度条
	ImageView loading_ImageView;//加载动画
	RelativeLayout rl_loadingFail;//加载失败
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		infoView = inflater.inflate(R.layout.hot_fragment, container, false);
		
		initView();

		initListener();

		return infoView;
	}

	// 设置activity的导航条
	protected void onConfigureActionBar(ActionBar actionBar) {
		actionBar.setTitle("分类");
		infoView.findViewById(R.id.actionBarLayout).setBackgroundColor(getResources().getColor(R.color.app_bg_color));
		actionBar.setTitleTextColor(R.color.white);
		actionBar.hideLeftActionButton();
		actionBar.hideRightActionButton();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		categorys = new ArrayList<Category>();
		listAdapter = new CategoryAdapter(mActivity, categorys);
//		mListView.setAdapter(listAdapter);
		setAlphaAdapter();
		mListView.setPullLoadEnable(true);
		mListView.setXListViewListener(this);
		
		getCategory();
	}
	private void setAlphaAdapter() {
		AnimationAdapter animAdapter = new AlphaInAnimationAdapter(listAdapter);
		animAdapter.setAbsListView(mListView);
		mListView.setAdapter(animAdapter);
	}
	/**
	 * 初始化控件
	 */
	private void initView(){
		mActionBar = (ActionBar) infoView.findViewById(R.id.actionBar);
		onConfigureActionBar(mActionBar);
		rl_loading = (RelativeLayout) infoView.findViewById(R.id.progress_listView);
		rl_loadingFail = (RelativeLayout) infoView.findViewById(R.id.loading_fail);
		loading_ImageView = (ImageView)infoView.findViewById(R.id.loading_imageView);
		mListView = (XListView)infoView.findViewById(R.id.listview);
		
		
	}
	/**
	 * 事件初始化
	 */
	private void initListener(){
		//点击重试
		rl_loadingFail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				pageNumber = 0;
				getCategory();
			}
		});
		
	}
	
	private void showLoading(){
		rl_loadingFail.setVisibility(View.GONE);
		if(pageNumber == 0){
			rl_loading.setVisibility(View.VISIBLE);
			AnimationDrawable animationDrawable = (AnimationDrawable) loading_ImageView.getBackground();
        	animationDrawable.start();
		}else{
			rl_loading.setVisibility(View.GONE);
		}
	}
	/**
	 * 获取数据
	 */
	private void getCategory() {
		showLoading();
		ApiProductUtils.getCategory(mActivity, pageNumber, ApiConstants.LIMIT, new HttpConnectionUtil.RequestCallback() {
			@Override
			public void execute(ParseModel parseModel) {
				rl_loading.setVisibility(View.GONE);
				if (!ApiConstants.RESULT_SUCCESS.equals(parseModel
						.getStatus())) {
					 mListView.setVisibility(View.GONE);
					 rl_loadingFail.setVisibility(View.VISIBLE);
					 return;

				} else {
					mListView.setVisibility(View.VISIBLE);
					List<Category> categoryList = JsonUtils.fromJson(
							parseModel.getData().toString(),
							new TypeToken<List<Category>>() {
							});
					if(pageNumber==0){
						categorys.clear();
					}
					categorys.addAll(categoryList);

					listAdapter.notifyDataSetChanged();
					mListView.onLoadFinish(pageNumber,listAdapter.getCount(),"加载完毕");
				}

			}
		});
	}

	@Override
	public void onRefresh() {
		pageNumber=0;
		getCategory();
	}

	@Override
	public void onLoadMore() {
		pageNumber++;
		getCategory();
	}

	
}

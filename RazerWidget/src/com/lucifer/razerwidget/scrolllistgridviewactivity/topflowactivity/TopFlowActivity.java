package com.lucifer.razerwidget.scrolllistgridviewactivity.topflowactivity;

import java.util.ArrayList;

import com.lucifer.razerlib.scrolllistgridview.TopFlowScrollView;
import com.lucifer.razerwidget.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;



public class TopFlowActivity extends Activity
{
	private TopFlowScrollView mScrollView;
	private ImageView mImageView;
	private LinearLayout mFlowLayout;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty_topflow);
		initView();
	}

	
	
	private void initView()
	{
		mScrollView = (TopFlowScrollView) findViewById(R.id.scroll_view);
		mImageView = (ImageView) findViewById(R.id.image_view);
		mFlowLayout = (LinearLayout) findViewById(R.id.flow_llay);
		ListView listview = (ListView) findViewById(R.id.list_view);
		listview.setAdapter(new ListViewAdapter(getData(), this));
		listview.setFocusable(false);
		listview.setOnItemClickListener(onItemClickListener);

		setListViewHeightBasedOnChildren(listview);
		// 监听浮动view的滚动状态
		mScrollView.listenerFlowViewScrollState(mImageView, mFlowLayout);
		// 将ScrollView滚动到起始位置
		mScrollView.scrollTo(0, 0);
	}

	
	
	OnItemClickListener onItemClickListener = new OnItemClickListener()
	{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3)
		{
			Toast.makeText(TopFlowActivity.this, "菜单" + (arg2 + 1),
					Toast.LENGTH_SHORT).show();
		}
	};

	
	
	private ArrayList<String> getData()
	{
		ArrayList<String> data = new ArrayList<String>();
		for (int i = 1; i < 30; i++)
		{
			data.add("菜单" + i);
		}
		return data;
	}

	
	
	/**
	 * 用于解决ScrollView嵌套listview时，出现listview只能显示一行的问题
	 * 
	 * @param listView
	 */
	public void setListViewHeightBasedOnChildren(ListView listView)
	{
		// 获取ListView对应的Adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null)
		{
			return;
		}

		int totalHeight = 0;
		for (int i = 0, len = listAdapter.getCount(); i < len; i++)
		{
			// listAdapter.getCount()返回数据项的数目
			View listItem = listAdapter.getView(i, null, listView);
			// 计算子项View 的宽高
			listItem.measure(0, 0);
			// 统计所有子项的总高度
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		// listView.getDividerHeight()获取子项间分隔符占用的高度
		// params.height最后得到整个ListView完整显示需要的高度
		listView.setLayoutParams(params);
	}

	
	
}

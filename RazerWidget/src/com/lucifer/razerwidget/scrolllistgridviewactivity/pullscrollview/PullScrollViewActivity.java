package com.lucifer.razerwidget.scrolllistgridviewactivity.pullscrollview;

import java.util.ArrayList;
import java.util.List;
import org.kymjs.kjframe.KJBitmap;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.lucifer.razerlib.scrolllistgridview.PullScrollView;
import com.lucifer.razerlib.scrolllistgridview.PullScrollView.OnTurnListener;
import com.lucifer.razerlib.scrolllistgridview.pullscrolllistgrid.GridViewForScrollView;
import com.lucifer.razerlib.scrolllistgridview.pullscrolllistgrid.ListViewForScrollView;
import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.common.Constants;




//下滑回弹，上滑到顶部停留。
public class PullScrollViewActivity extends Activity implements OnTurnListener, OnClickListener
{
	ImageView iv_background_pullscrollview;
	
	PullScrollView psv_pullscrollview;
	
	LinearLayout ll_top_pullscrollview;
	
	LinearLayout ll_pullscrollview;
	Button btn_photowall_pullscrollview, btn_listview_pullscrollview, btn_gridview_pullscrollview;
	
	ListViewForScrollView lvfsv_pullscrollview;
	private ScrollViewAdapter adapter;
	private ArrayList<DataBean> datas;
	String imageUrl = "http://d.hiphotos.baidu.com/image/pic/item/0df431adcbef760958fcf3e12cdda3cc7dd99edc.jpg";
	KJBitmap kjBitmap = KJBitmap.create();
	
	GridViewForScrollView gvfsv_pullscrollview;
	ListView lv_pullscrollview;
	
	ContentLoadingProgressBar ctpb_pullscrollview;
	
	
	LinearLayout ll_flow_pullscrollview;
	Button btn_photowall_flow_pullscrollview, btn_listview_flow_pullscrollview, btn_gridview_flow_pullscrollview;
	
	private boolean isScrolling = false;
	private boolean isloading = false;
	
	
	
	private Handler handler = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{
			case 1:
				adapter.notifyDataSetChanged();
				ctpb_pullscrollview.setVisibility(View.GONE);
				isloading = false;
				break;
				
			default:
				break;
			}

		}

	};
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_pullscrollview);
		
		initView();
		
	}
	
	
	
	private void initView()
	{
		iv_background_pullscrollview = (ImageView) findViewById(R.id.iv_background_pullscrollview);
		
		psv_pullscrollview = (PullScrollView) findViewById(R.id.psv_pullscrollview);
		
		ll_top_pullscrollview = (LinearLayout) findViewById(R.id.ll_top_pullscrollview);
		
		ll_pullscrollview = (LinearLayout) findViewById(R.id.ll_pullscrollview);
		btn_listview_pullscrollview = (Button) findViewById(R.id.btn_listview_pullscrollview); 
		btn_gridview_pullscrollview = (Button) findViewById(R.id.btn_gridview_pullscrollview);
		btn_photowall_pullscrollview = (Button) findViewById(R.id.btn_photowall_pullscrollview);
		
		lvfsv_pullscrollview = (ListViewForScrollView) findViewById(R.id.lvfsv_pullscrollview);
		gvfsv_pullscrollview = (GridViewForScrollView) findViewById(R.id.gvfsv_pullscrollview);
		lv_pullscrollview = (ListView) findViewById(R.id.lv_pullscrollview);
		
		ctpb_pullscrollview = (ContentLoadingProgressBar) findViewById(R.id.ctpb_pullscrollview);
		
		ll_flow_pullscrollview = (LinearLayout) findViewById(R.id.ll_flow_pullscrollview);
		btn_listview_flow_pullscrollview = (Button) findViewById(R.id.btn_listview_flow_pullscrollview); 
		btn_gridview_flow_pullscrollview = (Button) findViewById(R.id.btn_gridview_flow_pullscrollview);
		btn_photowall_flow_pullscrollview = (Button) findViewById(R.id.btn_photowall_flow_pullscrollview); 
		
		
		psv_pullscrollview.setHeader(iv_background_pullscrollview);
		psv_pullscrollview.setOnTurnListener(this);
		setListViewHeightBasedOnChildren(lvfsv_pullscrollview);
		psv_pullscrollview.setTopFlowView(ll_top_pullscrollview, ll_flow_pullscrollview);
		// 将ScrollView滚动到起始位置
		psv_pullscrollview.scrollTo(0, 0);
		
		lvfsv_pullscrollview.setVisibility(View.VISIBLE);
		datas = new ArrayList<DataBean>();
		adapter = new ScrollViewAdapter(PullScrollViewActivity.this, datas);
		lvfsv_pullscrollview.setAdapter(adapter);
		lvfsv_pullscrollview.setFocusable(false);
		
		gvfsv_pullscrollview.setAdapter(adapter);
		gvfsv_pullscrollview.setFocusable(false);
		
		lv_pullscrollview.setAdapter(adapter);
		lv_pullscrollview.setFocusable(false);
		lv_pullscrollview.setOnScrollListener(new OnScrollListener()
		{
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState)
			{
				// TODO Auto-generated method stub
				switch (scrollState)
				{
				case OnScrollListener.SCROLL_STATE_FLING:
					isScrolling = true;
					break;
					
				case OnScrollListener.SCROLL_STATE_IDLE:
					isScrolling = false;
					int startindex = lvfsv_pullscrollview.getFirstVisiblePosition();
					int count = lvfsv_pullscrollview.getChildCount();
					
					break;
					
				case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
					isScrolling = true;
					break;
					
				}
			}
			
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount)
			{
				// TODO Auto-generated method stub
				if (totalItemCount <= 0)
				{
					return;
				}
				
				if (firstVisibleItem + visibleItemCount == totalItemCount)
				{
					if (isloading)
					{
						return;
					}
					
					addList();
					adapter.notifyDataSetChanged();
				}
				
			}
		});
		
		addList();
		adapter.notifyDataSetChanged();
		
		btn_listview_pullscrollview.setOnClickListener(this);
		btn_gridview_pullscrollview.setOnClickListener(this);
		btn_photowall_pullscrollview.setOnClickListener(this);
		btn_listview_flow_pullscrollview.setOnClickListener(this);
		btn_gridview_flow_pullscrollview.setOnClickListener(this);
		btn_photowall_flow_pullscrollview.setOnClickListener(this);
	
	}
	
	
	
	
	

	@Override
	public void onTurn()
	{
		// TODO Auto-generated method stub
		if(datas != null)
		{
			datas.clear();
			
			for(int i=0;i<20;i++)
			{
				DataBean itemBean = new DataBean();
				itemBean.name = "lawliet";
				itemBean.url = imageUrl;
				datas.add(itemBean);
			}
			
			lvfsv_pullscrollview.setAdapter(adapter);
			lvfsv_pullscrollview.setFocusable(false);
			
			gvfsv_pullscrollview.setAdapter(adapter);
			gvfsv_pullscrollview.setFocusable(false);
			
			lv_pullscrollview.setAdapter(adapter);
			lv_pullscrollview.setFocusable(false);
		}
		
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


	

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.btn_listview_pullscrollview:
			lvfsv_pullscrollview.setVisibility(View.VISIBLE);
			gvfsv_pullscrollview.setVisibility(View.GONE);
			lv_pullscrollview.setVisibility(View.GONE);
			break;
			
			
		case R.id.btn_gridview_pullscrollview:
			lvfsv_pullscrollview.setVisibility(View.GONE);
			gvfsv_pullscrollview.setVisibility(View.VISIBLE);
			lv_pullscrollview.setVisibility(View.GONE);
			break;
			
			
		case R.id.btn_photowall_pullscrollview:
			lvfsv_pullscrollview.setVisibility(View.GONE);
			gvfsv_pullscrollview.setVisibility(View.GONE);
			lv_pullscrollview.setVisibility(View.VISIBLE);
			break;
			
			
			
		case R.id.btn_listview_flow_pullscrollview:
			lvfsv_pullscrollview.setVisibility(View.VISIBLE);
			gvfsv_pullscrollview.setVisibility(View.GONE);
			lv_pullscrollview.setVisibility(View.GONE);
			break;
			
			
		case R.id.btn_gridview_flow_pullscrollview:
			lvfsv_pullscrollview.setVisibility(View.GONE);
			gvfsv_pullscrollview.setVisibility(View.VISIBLE);
			lv_pullscrollview.setVisibility(View.GONE);
			break;
			
			
		case R.id.btn_photowall_flow_pullscrollview:
			lvfsv_pullscrollview.setVisibility(View.GONE);
			gvfsv_pullscrollview.setVisibility(View.GONE);
			lv_pullscrollview.setVisibility(View.VISIBLE);
			break;

		default:
			break;
		}
	}
	
	
	
	
	private void addList()
	{
		for(int i=0;i<20;i++)
		{
			DataBean itemBean = new DataBean();
			itemBean.name = "lucifer";
			itemBean.url = imageUrl;
			datas.add(itemBean);
		}
	}
	

}

package com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.kymjs.kjframe.KJHttp;
import org.kymjs.kjframe.http.HttpCallBack;
import org.kymjs.kjframe.http.HttpParams;

import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.common.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Toast;



@SuppressLint("InflateParams")
public class ListViewRecyclerFragment extends Fragment
{
	View view;
	
	SwipeRefreshLayout srl_fragmentexample;
	RecyclerView rclv_listviewrecycler;
	public RecyclerViewAdapter adapter;
	ArrayList<String> imageArrayList = new ArrayList<String>();
	LinearLayoutManager mLayoutManager;
	
	ContentLoadingProgressBar ctpb_listviewrecycler;
	
	private int lastVisibleItem;
	
	int begin = 0;
	int step = 10;
	
	
	
	private Handler handler = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{
			case 1:
				srl_fragmentexample.setRefreshing(false);
				adapter.notifyDataSetChanged();
				ctpb_listviewrecycler.setVisibility(View.GONE);
				break;
				
			default:
				break;
			}

		}

	};
	
	
	
	
	
	
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_listviewrecycler, null);
		
		srl_fragmentexample = (SwipeRefreshLayout) view.findViewById(R.id.srl_fragmentexample);
		
		ctpb_listviewrecycler = (ContentLoadingProgressBar) view.findViewById(R.id.ctpb_listviewrecycler);
		
		rclv_listviewrecycler = (RecyclerView) view.findViewById(R.id.rclv_listviewrecycler);
		rclv_listviewrecycler.setHasFixedSize(true);
		rclv_listviewrecycler.setItemAnimator(new DefaultItemAnimator());
		
		
		srl_fragmentexample.setColorSchemeColors(R.color.black, R.color.green, R.color.yellow_deep, R.color.red_deep);
		srl_fragmentexample.setOnRefreshListener(new OnRefreshListener()
		{
			@Override
			public void onRefresh()
			{
				// TODO Auto-generated method stub
				imageArrayList.clear();
				addList();
				handler.sendEmptyMessageDelayed(1, 3000);
			}
		});
		
		mLayoutManager = new LinearLayoutManager(getActivity());
		rclv_listviewrecycler.setLayoutManager(mLayoutManager);
		adapter = new RecyclerViewAdapter(getActivity(), imageArrayList);
		rclv_listviewrecycler.setAdapter(adapter);

		rclv_listviewrecycler.setOnScrollListener(new RecyclerView.OnScrollListener()
		{
			@Override
			public void onScrollStateChanged(RecyclerView recyclerView,
					int newState)
			{
				super.onScrollStateChanged(recyclerView, newState);
				
				if (newState == RecyclerView.SCROLL_STATE_IDLE
						&& lastVisibleItem + 1 == adapter.getItemCount())
				{
					ctpb_listviewrecycler.setVisibility(View.VISIBLE);
					addList();
					handler.sendEmptyMessageDelayed(1, 3000);
				}
			}

			
			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy)
			{
				super.onScrolled(recyclerView, dx, dy);

				lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
			}
			
		});

		
		addList();
		
		
		return view;
	}

	
	
	
	private void addList()
	{
		
		for(int i = 0;i<10;i++)
		{
			imageArrayList.add(Constants.imagePath);
		}
	}



}

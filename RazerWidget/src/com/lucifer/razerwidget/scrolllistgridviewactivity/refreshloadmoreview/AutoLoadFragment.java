package com.lucifer.razerwidget.scrolllistgridviewactivity.refreshloadmoreview;

import java.util.ArrayList;
import java.util.List;
import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.common.Constants;
import com.lucifer.razerwidget.scrolllistgridviewactivity.pullscrollview.DataBean;
import com.lucifer.razerwidget.scrolllistgridviewactivity.pullscrollview.ScrollViewAdapter;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;



public class AutoLoadFragment extends Fragment
{
	
	View view;
	ListView lv_autoload;
	ScrollViewAdapter scrollViewAdapter;
	ArrayList<DataBean> arrayList;
	private boolean isScrolling = false;
	private boolean isloading = false;
	

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_autoload, null);
		lv_autoload = (ListView) view.findViewById(R.id.lv_autoload);
		arrayList = new ArrayList<>();
		scrollViewAdapter = new ScrollViewAdapter(getActivity(), arrayList);
		lv_autoload.setAdapter(scrollViewAdapter);
		
		lv_autoload.setOnScrollListener(new OnScrollListener()
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
					int startindex = lv_autoload.getFirstVisiblePosition();
					int count = lv_autoload.getChildCount();
					
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
					scrollViewAdapter.notifyDataSetChanged();
				}
			}
		});
		
		
		
		addList();
		scrollViewAdapter.notifyDataSetChanged();
		
		return view;
	}
	
	
	
	private void addList()
	{
		for(int i=0;i<20;i++)
		{
			DataBean dataBean = new DataBean();
			dataBean.name = "lucifer";
			dataBean.url = Constants.imagePath;
			arrayList.add(dataBean);
		}
		
	}
	
	
	
}

package com.lucifer.razerwidget.scrolllistgridviewactivity.refreshloadmoreview;

import java.util.ArrayList;

import com.lucifer.razerlib.scrolllistgridview.RefreshLoadListView;
import com.lucifer.razerlib.scrolllistgridview.RefreshLoadListView.OnLoadMoreListener;
import com.lucifer.razerlib.scrolllistgridview.RefreshLoadListView.OnRefreshListener;
import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.common.Constants;
import com.lucifer.razerwidget.scrolllistgridviewactivity.pullscrollview.DataBean;
import com.lucifer.razerwidget.scrolllistgridviewactivity.pullscrollview.ScrollViewAdapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class RefreshLoadListViewFragment extends Fragment
{
	View view;
	RefreshLoadListView rfllv_refreshload;
	ScrollViewAdapter scrollViewAdapter;
	ArrayList<DataBean> dataBeans;
	

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_refreshloadlistview, null);
		rfllv_refreshload = (RefreshLoadListView) view.findViewById(R.id.rfllv_refreshload);
		dataBeans = new ArrayList<>();
		scrollViewAdapter = new ScrollViewAdapter(getActivity(), dataBeans);
		rfllv_refreshload.setAdapter(scrollViewAdapter);
		rfllv_refreshload.setCanLoadMore(true);
		rfllv_refreshload.setCanRefresh(true);
		rfllv_refreshload.setAutoLoadMore(true);
		
		//下拉刷新
		rfllv_refreshload.setOnRefreshListener(new OnRefreshListener()
		{
			
			@Override
			public void onRefresh()
			{
				// TODO Auto-generated method stub
				dataBeans.clear();
				addList();
				scrollViewAdapter.notifyDataSetChanged();
				rfllv_refreshload.onRefreshComplete();
			}
		});
		
		//上拉加载更多
		rfllv_refreshload.setOnLoadListener(new OnLoadMoreListener()
		{
			
			@Override
			public void onLoadMore()
			{
				// TODO Auto-generated method stub
				addList();
				scrollViewAdapter.notifyDataSetChanged();
				rfllv_refreshload.onLoadMoreComplete();
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
			dataBeans.add(dataBean);
		}
	}
	
	
	
}

package com.lucifer.razerwidget.scrolllistgridviewactivity.refreshloadmoreview;

import java.util.ArrayList;
import org.kymjs.kjframe.KJBitmap;
import com.lucifer.razerlib.scrolllistgridview.pullscrolllistgrid.ListViewForScrollView;
import com.lucifer.razerlib.scrolllistgridview.pullscrolllistgrid.ListViewForScrollView.OnPositionChangedListener;
import com.lucifer.razerlib.scrolllistgridview.pullscrolllistgrid.PullToRefreshView;
import com.lucifer.razerlib.scrolllistgridview.pullscrolllistgrid.PullToRefreshView.OnFooterRefreshListener;
import com.lucifer.razerlib.scrolllistgridview.pullscrolllistgrid.PullToRefreshView.OnHeaderRefreshListener;
import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.scrolllistgridviewactivity.pullscrollview.DataBean;
import com.lucifer.razerwidget.scrolllistgridviewactivity.pullscrollview.ScrollViewAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.TextView;



public class ListScrollViewFragment extends Fragment implements OnHeaderRefreshListener, OnFooterRefreshListener, OnPositionChangedListener
{
	View view;
	PullToRefreshView pullrefreshview_scroll_listview;
	private ListViewForScrollView lv_pullscrolllist;
	private ScrollViewAdapter adapter;
	private ArrayList<DataBean> datas;
	
	String imageUrl = "http://d.hiphotos.baidu.com/image/pic/item/0df431adcbef760958fcf3e12cdda3cc7dd99edc.jpg";
	KJBitmap kjBitmap = KJBitmap.create();
	
	private RotateAnimation progressbar_rotate;
	

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.aty_pullscrolllist, null);
		progressbar_rotate = (RotateAnimation) AnimationUtils.loadAnimation(
				getActivity(), R.anim.rotate_imageview);
		
		pullrefreshview_scroll_listview = (PullToRefreshView) view.findViewById(R.id.pullrefreshview_scroll_listview);
		lv_pullscrolllist = (ListViewForScrollView) view.findViewById(R.id.lv_pullscrolllist);
		
		pullrefreshview_scroll_listview.setOnHeaderRefreshListener(this);
		pullrefreshview_scroll_listview.setOnFooterRefreshListener(this);

		
		datas = new ArrayList<DataBean>();
		for(int i=0;i<20;i++)
		{
			DataBean itemBean = new DataBean();
			itemBean.name = "lucifer";
			itemBean.url = imageUrl;
			datas.add(itemBean);
		}
		adapter = new ScrollViewAdapter(getActivity(), datas);
		lv_pullscrolllist.setAdapter(adapter);
		lv_pullscrolllist.setOnPositionChangedListener(this);
		
		return view;
	}
	
	
	
	
	@Override
	public void onHeaderRefresh(PullToRefreshView view)
	{
		// TODO Auto-generated method stub
		datas.clear();
		for(int i=0;i<20;i++)
		{
			DataBean itemBean = new DataBean();
			itemBean.name = "lucifer";
			itemBean.url = imageUrl;
			datas.add(itemBean);
		}
		adapter.notifyDataSetChanged();
		pullrefreshview_scroll_listview.onHeaderRefreshComplete();
	}
	
	
	
	
	@Override
	public void onFooterRefresh(PullToRefreshView view)
	{
		// TODO Auto-generated method stub
		datas.clear();
		for(int i=0;i<10;i++)
		{
			DataBean itemBean = new DataBean();
			itemBean.name = "lucifer";
			itemBean.url = imageUrl;
			datas.add(itemBean);
		}
		adapter.notifyDataSetChanged();
		pullrefreshview_scroll_listview.onFooterRefreshComplete();
	}




	@Override
	public void onPositionChanged(ListViewForScrollView listView, int position,
			View scrollBarPanel)
	{
		// TODO Auto-generated method stub
		((TextView) scrollBarPanel).setText("Position " + position);
	}
	
	
	
}

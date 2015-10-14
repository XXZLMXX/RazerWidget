package com.lucifer.razerwidget.scrolllistgridviewactivity.refreshloadmoreview;

import java.util.ArrayList;

import org.kymjs.kjframe.KJBitmap;

import com.lucifer.razerlib.scrolllistgridview.pullscrolllistgrid.GridViewForScrollView;
import com.lucifer.razerlib.scrolllistgridview.pullscrolllistgrid.PullToRefreshView;
import com.lucifer.razerlib.scrolllistgridview.pullscrolllistgrid.PullToRefreshView.OnFooterRefreshListener;
import com.lucifer.razerlib.scrolllistgridview.pullscrolllistgrid.PullToRefreshView.OnHeaderRefreshListener;
import com.lucifer.razerwidget.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;



public class GridScrollViewFragment extends Fragment implements OnHeaderRefreshListener,OnFooterRefreshListener
{
	View view;
	PullToRefreshView pullrefreshview_scroll_gridview;
	private GridViewForScrollView gv_pullscrollgrid;
	private GridAdapter adapter;
	private ArrayList<GridDataBean> datas;
	
	String imageUrl = "http://d.hiphotos.baidu.com/image/pic/item/0df431adcbef760958fcf3e12cdda3cc7dd99edc.jpg";
	KJBitmap kjBitmap = KJBitmap.create();


	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.aty_pullscrollgrid, null);
		pullrefreshview_scroll_gridview = (PullToRefreshView) view.findViewById(R.id.pullrefreshview_scroll_gridview);
		gv_pullscrollgrid = (GridViewForScrollView) view.findViewById(R.id.gv_pullscrollgrid);
		
		pullrefreshview_scroll_gridview.setOnHeaderRefreshListener(this);
		pullrefreshview_scroll_gridview.setOnFooterRefreshListener(this);
		
		
		datas = new ArrayList<GridDataBean>();
		for(int i=0;i<20;i++)
		{
			GridDataBean itemBean = new GridDataBean();
			itemBean.url = imageUrl;
			datas.add(itemBean);
		}
		adapter = new GridAdapter(datas);
		gv_pullscrollgrid.setAdapter(adapter);
		
		
		
		return view;
	}
	
	
	
	
	class GridDataBean
	{
		String url;
	}

	
	static class ViewHolderPullScrollGrid
	{
		ImageView img;
	}

	
	class GridAdapter extends BaseAdapter
	{
		private ArrayList<GridDataBean> list;
		
		public GridAdapter(ArrayList<GridDataBean> gdbs)
		{
			this.list = gdbs;
		}
		
		@Override
		public int getCount()
		{
			return list.size();
		}

		@Override
		public Object getItem(int position)
		{
			return list.get(position);
		}

		@Override
		public long getItemId(int position)
		{
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			ViewHolderPullScrollGrid holder = null;
			if (convertView == null)
			{
				holder = new ViewHolderPullScrollGrid();
				convertView = View.inflate(getActivity(), R.layout.item_grid_image, null);
				holder.img = (ImageView) convertView.findViewById(R.id.item_img);
				convertView.setTag(holder);
			} 
			else
			{
				holder = (ViewHolderPullScrollGrid) convertView.getTag();
			}
			
			GridDataBean currentDataBean = list.get(position);
//			kjBitmap.display(holder.img, imageUrl);
			holder.img.setImageResource(R.drawable.ic_launcher);
			
			return convertView;
		}
	}




	@Override
	public void onHeaderRefresh(PullToRefreshView view)
	{
		// TODO Auto-generated method stub
		datas.clear();
		for(int i=0;i<20;i++)
		{
			GridDataBean itemBean = new GridDataBean();
			itemBean.url = imageUrl;
			datas.add(itemBean);
		}
		adapter.notifyDataSetChanged();
		pullrefreshview_scroll_gridview.onHeaderRefreshComplete();
	}
	
	
	
	@Override
	public void onFooterRefresh(PullToRefreshView view)
	{
		// TODO Auto-generated method stub
		datas.clear();
		for(int i=0;i<10;i++)
		{
			GridDataBean itemBean = new GridDataBean();
			itemBean.url = imageUrl;
			datas.add(itemBean);
		}
		adapter.notifyDataSetChanged();
		pullrefreshview_scroll_gridview.onFooterRefreshComplete();
	}
	
	
}

package com.lucifer.razerwidget.scrolllistgridviewactivity.pullscrollview;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lucifer.razerwidget.R;



public class ScrollViewAdapter extends BaseAdapter
{
	private Context context;
	private ArrayList<DataBean> list;
	
	public ScrollViewAdapter(Context c, ArrayList<DataBean> dbs)
	{
		this.context = c;
		this.list = dbs;
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
		ViewHolderPullScrollList holder = null;
		if (convertView == null)
		{
			holder = new ViewHolderPullScrollList();
			convertView = View.inflate(context, R.layout.item_list, null);
			holder.img = (ImageView) convertView.findViewById(R.id.item_iv);
			holder.tv = (TextView) convertView.findViewById(R.id.item_tv);
			convertView.setTag(holder);
		} 
		else
		{
			holder = (ViewHolderPullScrollList) convertView.getTag();
		}
		
		DataBean currentDataBean = list.get(position);
//		kjBitmap.display(holder.img, imageUrl);
		holder.img.setImageResource(R.drawable.ic_launcher);
		holder.tv.setText(currentDataBean.name);
		
		
		return convertView;
	}
}

package com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments;

import java.util.ArrayList;
import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.common.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;



public class RecyclerViewAdapter extends Adapter<ItemViewHolder>
{
	Context context;
	private ArrayList<String> list;
	
	ImageLoader imageLoader = ImageLoader.getInstance();
	
	

	public RecyclerViewAdapter(Context c, ArrayList<String> als)
	{
		// TODO Auto-generated constructor stub
		this.context = c;
		this.list = als;
		
	}
	
	
	@Override
	public int getItemCount()
	{
		return list.size();
	}

	
	
	@Override
	public int getItemViewType(int position)
	{
		return position;
	}
	

	
	@Override
	public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View view = LayoutInflater.from(parent.getContext()).inflate(
				R.layout.item_image, null);
		view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		return new ItemViewHolder(view);
	}

	
	
	@Override
	public void onBindViewHolder(ItemViewHolder holder, int position)
	{
		String string = list.get(position);
			
	    imageLoader.displayImage(string, holder.iv_item_image);
	    
	    final int num = position;
	    
	    holder.itemView.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				addData(num);
			}
		});
	    
	    
	    
	    holder.itemView.setOnLongClickListener(new OnLongClickListener()
		{
			
			@Override
			public boolean onLongClick(View v)
			{
				// TODO Auto-generated method stub
				removeData(num);
				
				return false;
			}
		});
	
	}
	
	
	
	public void addData(int position)
	{
		list.add(position, Constants.imagePath);
		notifyItemInserted(position);
	}

	
	public void removeData(int position)
	{
		list.remove(position);
		notifyItemRemoved(position);
	}
	
	
	
}

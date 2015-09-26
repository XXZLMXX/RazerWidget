package com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.kymjs.kjframe.KJHttp;
import org.kymjs.kjframe.http.HttpCallBack;
import org.kymjs.kjframe.http.HttpParams;

import com.lucifer.razerlib.recyclerview.itemanimator.ScaleInOutItemAnimator;
import com.lucifer.razerlib.recyclerview.itemanimator.SlideInOutBottomItemAnimator;
import com.lucifer.razerlib.recyclerview.itemanimator.SlideInOutLeftItemAnimator;
import com.lucifer.razerlib.recyclerview.itemanimator.SlideInOutRightItemAnimator;
import com.lucifer.razerlib.recyclerview.itemanimator.SlideInOutTopItemAnimator;
import com.lucifer.razerlib.recyclerview.itemanimator.SlideScaleInOutRightItemAnimator;
import com.lucifer.razerlib.recyclerview.itemdecoration.DividerItemDecoration;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



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
	
	
	
	@SuppressLint("HandlerLeak")
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
		
		
		rclv_listviewrecycler.setHasFixedSize(true);
		//添加分割线
		rclv_listviewrecycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
		// 设置item添加删除动画
//		rclv_listviewrecycler.setItemAnimator(new DefaultItemAnimator());
//		rclv_listviewrecycler.setItemAnimator(new ScaleInOutItemAnimator(rclv_listviewrecycler));
//		rclv_listviewrecycler.setItemAnimator(new SlideScaleInOutRightItemAnimator(rclv_listviewrecycler));
//		rclv_listviewrecycler.setItemAnimator(new SlideInOutBottomItemAnimator(rclv_listviewrecycler));
//		rclv_listviewrecycler.setItemAnimator(new SlideInOutLeftItemAnimator(rclv_listviewrecycler));
//		rclv_listviewrecycler.setItemAnimator(new SlideInOutRightItemAnimator(rclv_listviewrecycler));
		rclv_listviewrecycler.setItemAnimator(new SlideInOutTopItemAnimator(rclv_listviewrecycler));
		
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

		
		
		/*// 0则不执行拖动或者滑动
		ItemTouchHelper.Callback mCallback = new ItemTouchHelper.SimpleCallback(
				ItemTouchHelper.UP | ItemTouchHelper.DOWN,
				ItemTouchHelper.RIGHT)
		{
			*//**
			 * @param recyclerView
			 * @param viewHolder
			 *            拖动的ViewHolder
			 * @param target
			 *            目标位置的ViewHolder
			 * @return
			 *//*
			@Override
			public boolean onMove(RecyclerView recyclerView,
					RecyclerView.ViewHolder viewHolder,
					RecyclerView.ViewHolder target)
			{
				int fromPosition = viewHolder.getAdapterPosition();// 得到拖动ViewHolder的position
				int toPosition = target.getAdapterPosition();// 得到目标ViewHolder的position
				if (fromPosition < toPosition)
				{
					// 分别把中间所有的item的位置重新交换
					for (int i = fromPosition; i < toPosition; i++)
					{
						Collections.swap(datas, i, i + 1);
					}
				} else
				{
					for (int i = fromPosition; i > toPosition; i--)
					{
						Collections.swap(datas, i, i - 1);
					}
				}
				mAdapter.notifyItemMoved(fromPosition, toPosition);
				// 返回true表示执行拖动
				return true;
			}

			@Override
			public void onSwiped(RecyclerView.ViewHolder viewHolder,
					int direction)
			{
				int position = viewHolder.getAdapterPosition();
				datas.remove(position);
				mAdapter.notifyItemRemoved(position);
			}

			@Override
			public void onChildDraw(Canvas c, RecyclerView recyclerView,
					RecyclerView.ViewHolder viewHolder, float dX, float dY,
					int actionState, boolean isCurrentlyActive)
			{
				super.onChildDraw(c, recyclerView, viewHolder, dX, dY,
						actionState, isCurrentlyActive);
				if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE)
				{
					// 左右滑动时改变Item的透明度
					final float alpha = 1 - Math.abs(dX)
							/ (float) viewHolder.itemView.getWidth();
					viewHolder.itemView.setAlpha(alpha);
					viewHolder.itemView.setTranslationX(dX);
				}
			}

			@Override
			public void onSelectedChanged(RecyclerView.ViewHolder viewHolder,
					int actionState)
			{
				super.onSelectedChanged(viewHolder, actionState);
				// 当选中Item时候会调用该方法，重写此方法可以实现选中时候的一些动画逻辑
				Log.v("zxy", "onSelectedChanged");
			}

			@Override
			public void clearView(RecyclerView recyclerView,
					RecyclerView.ViewHolder viewHolder)
			{
				super.clearView(recyclerView, viewHolder);
				// 当动画已经结束的时候调用该方法，重写此方法可以实现恢复Item的初始状态
				Log.v("zxy", "clearView");
			}
		};
		ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
		itemTouchHelper.attachToRecyclerView(mRecyclerView);*/
		
		
		
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

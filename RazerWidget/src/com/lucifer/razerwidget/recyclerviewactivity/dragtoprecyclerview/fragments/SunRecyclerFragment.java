package com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments;

import java.util.ArrayList;

import com.lucifer.razerlib.recyclerview.pullrefreshrecyclerview.PullToRefreshView;
import com.lucifer.razerlib.recyclerview.pullrefreshrecyclerview.PullToRefreshView.OnRefreshListener;
import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.common.Constants;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.RecyclerViewAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SunRecyclerFragment extends Fragment
{
	ViewGroup viewGroup;
	PullToRefreshView ptrfv_sunrecycler;
	
	RecyclerView rcv_sunrecycler;
	RecyclerViewAdapter recyclerViewAdapter;
	ArrayList<String> imagePaths = new ArrayList<>();
	

	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_sunrecycler, null);
		
		ptrfv_sunrecycler = (PullToRefreshView) viewGroup.findViewById(R.id.ptrfv_sunrecycler);
		rcv_sunrecycler = (RecyclerView) viewGroup.findViewById(R.id.rcv_sunrecycler);
		
		
		ptrfv_sunrecycler.setOnRefreshListener(new OnRefreshListener()
		{
			@Override
			public void onRefresh()
			{
				// TODO Auto-generated method stub
				ptrfv_sunrecycler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                    	ptrfv_sunrecycler.setRefreshing(false);
                    }
                }, 2000);
			}
		});
		
		rcv_sunrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
		for(int i=0;i<5;i++)
		{
			imagePaths.add(Constants.imagePath);
		}
		recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), imagePaths);
		rcv_sunrecycler.setAdapter(recyclerViewAdapter);
		
		
		return viewGroup;
	}
	
	
	
	
	
	
	
	
	
	

}

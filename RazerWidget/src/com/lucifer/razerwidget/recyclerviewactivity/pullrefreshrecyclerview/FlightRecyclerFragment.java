package com.lucifer.razerwidget.recyclerviewactivity.pullrefreshrecyclerview;

import java.util.ArrayList;

import com.lucifer.razerlib.recyclerview.pullrefreshrecyclerview.PullToRefreshFlight;
import com.lucifer.razerlib.recyclerview.pullrefreshrecyclerview.PullToRefreshFlight.OnRefreshListener;
import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.common.Constants;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.RecyclerViewAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class FlightRecyclerFragment extends Fragment
{
	ViewGroup viewGroup;
	PullToRefreshFlight ptrfv_flightrecycler;
	
	RecyclerView rcv_flightrecycler;
	RecyclerViewAdapter recyclerViewAdapter;
	ArrayList<String> imagePaths = new ArrayList<>();

	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_flightrecycler, null);
		
		ptrfv_flightrecycler = (PullToRefreshFlight) viewGroup.findViewById(R.id.ptrfv_flightrecycler);
		rcv_flightrecycler = (RecyclerView) viewGroup.findViewById(R.id.rcv_flightrecycler);
		
		
		ptrfv_flightrecycler.setOnRefreshListener(new OnRefreshListener()
		{
			@Override
			public void onRefresh()
			{
				// TODO Auto-generated method stub
				ptrfv_flightrecycler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                    	ptrfv_flightrecycler.setRefreshing(false);
                    }
                }, 2000);
			}
		});
		
		
		rcv_flightrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
		for(int i=0;i<5;i++)
		{
			imagePaths.add(Constants.imagePath);
		}
		recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), imagePaths);
		rcv_flightrecycler.setAdapter(recyclerViewAdapter);
		
		
		return viewGroup;
	}
	
}
